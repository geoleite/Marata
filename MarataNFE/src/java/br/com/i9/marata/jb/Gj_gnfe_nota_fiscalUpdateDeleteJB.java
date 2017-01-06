package br.com.i9.marata.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.marata.dao.*;
import br.com.i9.marata.transfer.*;
import br.com.i9.marata.util.NFEDataSource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Gj_gnfe_nota_fiscalUpdateDeleteJB extends SystemBase {

    private String[] ids;
    private String destinatario;
    private String dataInicial = new String();
    private String dataFinal = new String();
    private String tipoNota = "";
    // Atributos e propriedades
    private Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT = new Gj_gnfe_nota_fiscalT();

    public void setGj_gnfe_nota_fiscalT(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) {
        this.gj_gnfe_nota_fiscalT = gj_gnfe_nota_fiscalT;
    }

    public Gj_gnfe_nota_fiscalT getGj_gnfe_nota_fiscalT() {
        return gj_gnfe_nota_fiscalT;
    }
    private List<Gj_gnfe_nota_fiscalT> list;

    public List<Gj_gnfe_nota_fiscalT> getList() {
        return list;
    }

    public void setList(List<Gj_gnfe_nota_fiscalT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
    }

    public void clear() throws Exception {

        gj_gnfe_nota_fiscalT = new Gj_gnfe_nota_fiscalT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO = getGj_gnfe_nota_fiscalDAO();
                gj_gnfe_nota_fiscalDAO.delete(gj_gnfe_nota_fiscalT);
                setMsg("Exclusao efetuada com sucesso!");
                clear();
            } else {
                setMsg(ERROR, "Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar exclusao!");
        } finally {
            close();
        }
    }

    public boolean exist() throws Exception {
        try {
            Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO = getGj_gnfe_nota_fiscalDAO();
            List<Gj_gnfe_nota_fiscalT> listTemp = gj_gnfe_nota_fiscalDAO.getByPK(gj_gnfe_nota_fiscalT);

            return listTemp.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
        return false;

    }

    public void update() throws Exception {
        try {
            if (exist()) {
                Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO = getGj_gnfe_nota_fiscalDAO();
                gj_gnfe_nota_fiscalDAO.update(gj_gnfe_nota_fiscalT);
                setMsg("Alteracao efetuada com sucesso!");
            } else {
                setMsg(ERROR, "Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar alteracao!");
        } finally {
            close();
        }
    }

    public void downloadTodas() {
        try {
            Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO = getGj_gnfe_nota_fiscalDAO();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dtInicial = new Date(format.parse(getDataInicial()).getTime());
            Date dtFinal = new Date(format.parse(getDataFinal()).getTime());
            if (getTipoNota() != null && getTipoNota().trim().length() > 0) {
                gj_gnfe_nota_fiscalT.setOrigem(Integer.parseInt(getTipoNota()));
                list = gj_gnfe_nota_fiscalDAO.getByNfePeriodoTipoNota(gj_gnfe_nota_fiscalT, dtInicial, dtFinal);
            } else {
                list = gj_gnfe_nota_fiscalDAO.getByNfePeriodo(gj_gnfe_nota_fiscalT, dtInicial, dtFinal);
            }
            if (list.size() > 0) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ZipOutputStream zip = new ZipOutputStream(baos);

                Gj_gnfe_nota_fiscalT notaT = new Gj_gnfe_nota_fiscalT();
                for (int i = 0; i < list.size(); i++) {
                    try {
                        notaT.setNfe_id(list.get(i).getId_ent());
                        Gj_gnfe_nota_fiscalT notaTTemp = getGj_gnfe_nota_fiscalDAO().getByXml_sig_mailNfeId(notaT);
                        if (notaTTemp != null) {
                            //zipOut.write(notaTTemp.getXml_sig_mail());
                            zip.putNextEntry(new ZipEntry(notaTTemp.getNfe_id() + ".xml"));
                            zip.write(notaTTemp.getXml_sig_mail());
                            zip.closeEntry();
                        }
                    } catch (Exception e) {
                    }

                }
                zip.close();
                getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "doc/nfe.zip");
                getRequest().setAttribute(EasyDownloadJB.FILE_NAME, "download_nfe_marata.zip");
                getRequest().setAttribute(EasyDownloadJB.DATA, baos.toByteArray());
                getPage().forward("/portal/easydownload.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

// Method de lookup
// 
    //Method Download Image e montando se houver algum campo do tipo binario
    //
    /**
     * Download de Imagem caso existe sen?o pode remover
     */
    public void downloadImage() throws Exception {

        try {
            gj_gnfe_nota_fiscalT = getGj_gnfe_nota_fiscalDAO().getByXml_sig_mailNfeId(gj_gnfe_nota_fiscalT);
            if (gj_gnfe_nota_fiscalT != null) {
                getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "doc/nfe");
                getRequest().setAttribute(EasyDownloadJB.FILE_NAME, gj_gnfe_nota_fiscalT.getNfe_id() + ".xml");
                getRequest().setAttribute(EasyDownloadJB.DATA, gj_gnfe_nota_fiscalT.getXml_sig_mail());
                getPage().forward("/portal/easydownload.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    /**
     * Download de Várias Notas Fiscais retornando um arquivo zip
     * @throws Exception
     */
    public void downloadsImage() throws Exception {
        try {

            if (ids != null && ids.length > 0) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ZipOutputStream zip = new ZipOutputStream(baos);

                Gj_gnfe_nota_fiscalT notaT = new Gj_gnfe_nota_fiscalT();
                for (int i = 0; i < ids.length; i++) {
                    notaT.setNfe_id(ids[i]);
                    Gj_gnfe_nota_fiscalT notaTTemp = getGj_gnfe_nota_fiscalDAO().getByXml_sig_mailNfeId(notaT);
                    if (notaTTemp != null) {
                        //zipOut.write(notaTTemp.getXml_sig_mail());
                        zip.putNextEntry(new ZipEntry(notaTTemp.getNfe_id() + ".xml"));
                        zip.write(notaTTemp.getXml_sig_mail());
                        zip.closeEntry();
                    }
                }
                zip.close();
                getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "doc/nfe.zip");
                getRequest().setAttribute(EasyDownloadJB.FILE_NAME, "download_nfe_marata.zip");
                getRequest().setAttribute(EasyDownloadJB.DATA, baos.toByteArray());
                getPage().forward("/portal/easydownload.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public static void main(String[] p) {
        try {
            Gj_gnfe_nota_fiscalUpdateDeleteJB gj = new Gj_gnfe_nota_fiscalUpdateDeleteJB();
            gj.enviarEmail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enviarEmail() {
        try {//465
            if (ids != null && ids.length > 0) {
//                String server = "email.marata.com.br";
//                String email = "teste.nfe@marata.com.br";
//                String pass = "NFE.sis2012";

                String server = getParametro("email_server");
                String email = getParametro("email");
                String pass = getParametro("senha_email");
                String assunto = getParametro("assunto_email");
                String texto = getParametro("texto_email");

                String to = getDestinatario();
                Properties props = new Properties();
                Authenticator auth = new EasyAuthenticator(email, pass);
                props.put("mail.smtp.host", server);
                Session session = Session.getInstance(props, auth);
                session.setDebug(true);
                MimeMessage msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress(email));
                InternetAddress[] address = {new InternetAddress(to)};
                msg.setRecipients(Message.RecipientType.TO, address);
                msg.setSubject(assunto);


                Gj_gnfe_nota_fiscalT notaT = new Gj_gnfe_nota_fiscalT();
                for (int i = 0; i < ids.length; i++) {
                    notaT.setNfe_id(ids[i]);
                    Gj_gnfe_nota_fiscalT notaTTemp = getGj_gnfe_nota_fiscalDAO().getByXml_sig_mailNfeId(notaT);
                    if (notaTTemp != null) {
                        MimeBodyPart mbp1 = new MimeBodyPart();
                        mbp1.setText(texto + (i + 1));
                        MimeBodyPart mbp2 = new MimeBodyPart();

                        // anexa o arquivo na mensagem

                        NFEDataSource nfeDS = new NFEDataSource(notaTTemp.getNfe_id() + ".xml", notaTTemp.getXml_sig_mail());
                        mbp2.setDataHandler(new DataHandler(nfeDS));
                        mbp2.setFileName(nfeDS.getName());

                        // cria a Multipart
                        Multipart mp = new MimeMultipart();
                        mp.addBodyPart(mbp1);
                        mp.addBodyPart(mbp2);

                        // adiciona a Multipart na mensagem
                        msg.setContent(mp);
                        msg.setSentDate(new Date());
                    }
                }
                // envia a mensagem
                Transport.send(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void findbyid() throws Exception {
        try {
            Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO = getGj_gnfe_nota_fiscalDAO();
            List<Gj_gnfe_nota_fiscalT> listTemp = gj_gnfe_nota_fiscalDAO.getByPK(gj_gnfe_nota_fiscalT);

            gj_gnfe_nota_fiscalT = listTemp.size() > 0 ? listTemp.get(0) : new Gj_gnfe_nota_fiscalT();

        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    /**
     * Volta para a p?gina de consulta
     */
    public void consult() throws Exception {
        // TODO Consult
        try {
            String page = "gj_gnfe_nota_fiscalConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "gj_gnfe_nota_fiscalConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the ids
     */
    public String[] getIds() {
        return ids;
    }

    /**
     * @param ids the ids to set
     */
    public void setIds(String[] ids) {
        this.ids = ids;
    }

    /**
     * @return the destinatario
     */
    public String getDestinatario() {
        return destinatario;
    }

    /**
     * @param destinatario the destinatario to set
     */
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * @return the dataInicial
     */
    public String getDataInicial() {
        return dataInicial;
    }

    /**
     * @param dataInicial the dataInicial to set
     */
    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    /**
     * @return the dataFinal
     */
    public String getDataFinal() {
        return dataFinal;
    }

    /**
     * @param dataFinal the dataFinal to set
     */
    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    /**
     * @return the tipoNota
     */
    public String getTipoNota() {
        return tipoNota;
    }

    /**
     * @param tipoNota the tipoNota to set
     */
    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
    }
}

class EasyAuthenticator extends Authenticator {

    private String fromEmail, fromPassword;

    public EasyAuthenticator(String fromEmail, String fromPassword) {
        setFromEmail(fromEmail);
        setFromPassword(fromPassword);
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(getFromEmail(), getFromPassword());
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getFromPassword() {
        return fromPassword;
    }

    public void setFromPassword(String fromPassword) {
        this.fromPassword = fromPassword;
    }
}
