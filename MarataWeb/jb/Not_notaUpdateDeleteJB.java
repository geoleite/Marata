package br.com.easynet.nfegen.jb;

import java.io.IOException;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;
import br.com.easynet.nfegen.util.Zipper;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Not_notaUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Not_notaT not_notaT = new Not_notaT();
    private String[] download;
    private String tipoNota = "S";

    public void setNot_notaT(Not_notaT not_notaT) {
        this.not_notaT = not_notaT;
    }

    public Not_notaT getNot_notaT() {
        return not_notaT;
    }
    private List<Not_notaT> list;

    public List<Not_notaT> getList() {
        return list;
    }

    public void setList(List<Not_notaT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
        //       consultEmp_empresa();

    }

    public void clear() throws Exception {

        not_notaT = new Not_notaT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Not_notaDAO not_notaDAO = getNot_notaDAO();
                not_notaDAO.delete(not_notaT);
                setMsg("Exclusão efetuada com sucesso!");
                clear();
            } else {
                setMsg("Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclusão!");
        } finally {
            close();
        }
    }

    public boolean exist() throws Exception {
        try {
            Not_notaDAO not_notaDAO = getNot_notaDAO();
            List<Not_notaT> listTemp = not_notaDAO.getById(not_notaT);

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
                Not_notaDAO not_notaDAO = getNot_notaDAO();
                not_notaDAO.update(not_notaT);
                setMsg("Alteracão efetuada com sucesso!");
            } else {
                setMsg("Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar alteracão!");
        } finally {
            close();
        }
    }
// Method de lookup
// 
    private List<Emp_empresaT> listemp_empresa;

    public List<Emp_empresaT> getListemp_empresa() {
        return listemp_empresa;
    }

    public void setListemp_empresa(List<Emp_empresaT> list) {
        this.listemp_empresa = list;
    }

    public void consultEmp_empresa() throws Exception {
        try {
            Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
            listemp_empresa = emp_empresaDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private byte[] unzipNota(byte[] dados) throws Exception {
        //ByteArrayInputStream bais = new ByteArrayInputStream(dados);
        ByteArrayInputStream bais = new ByteArrayInputStream(dados);

        GZIPInputStream gzip = new GZIPInputStream(bais);
        gzip.read(dados);

        return dados;
    }

    public void downloadNotas() {
        //GZIPOutputStream zip = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            File dir = new File(getPastaBase() + "/" + getSession().getId());
            dir.mkdirs();
            Zipper zip = new Zipper();
            File[] files = new File[download.length];
            for (int i = 0; i < download.length; i++) {
                try {
                    String notIdent = download[i];
                    String[] dados = notIdent.split(";");
                    not_notaT.setDis_nr_id(Integer.parseInt(dados[0]));
                    not_notaT.setEmp_nr_id(Integer.parseInt(dados[1]));
                    not_notaT.setNot_nr_id(Integer.parseInt(dados[2]));
                    System.out.println("tipo " + tipoNota);
                    List<Not_notaT> listNot = null;
                    if ("E".equals(tipoNota)) {
                        listNot = getNot_notaDAO().getNotaEntrada(not_notaT);
                    } else {

                        listNot = getNot_notaDAO().getByIdArquivo(not_notaT);
                    }
                    Not_notaT notT = listNot.size() > 0 ? listNot.get(0) : null;
                    if (notT != null) {
                        // Gravando a nota no disco temporario
//                        System.out.println(dir.getAbsolutePath());
                        try {
                            File file = new File(dir.getAbsolutePath() + "/" + notT.getNot_tx_identificador() + ".xml");
                            files[i] = file;
                            FileOutputStream fos = new FileOutputStream(file);

                            fos.write(notT.getNot_bt_arquivo());
                            fos.flush();
                            fos.close();

                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    close();
                }
            }
            zip.criarZip(baos, files);

            zip.fecharZip();
            byte[] arqZip = baos.toByteArray();
            deleteTemp(dir);
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "text/xml");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, "downloadNotas.zip");
            getRequest().setAttribute(EasyDownloadJB.DATA, arqZip);
            getPage().forward("/portal/easydownload.jsp");


        } catch (Exception ex) {
            Logger.getLogger(Not_notaUpdateDeleteJB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
    }
    /*
    private void deleteTemp (File file) {
    File[] files = file.listFiles();
    if (files != null) {
    for (File file1 : files) {
    deleteTemp(file1);
    }
    }
    file.delete();
    }
     */
    //Method Download Image ? montando se houver algum campo do tipo bin?rio
    //

    /**
     * Download de Imagem caso existe sen?o pode remover
     */
    public void downloadImage() throws Exception {

        try {
            findbyid();
            List<Not_notaT> listNot = getNot_notaDAO().getByIdArquivo(not_notaT);
            Not_notaT notT = listNot.size() > 0 ? listNot.get(0) : null;
            if (notT != null) {
                //notT.setNot_bt_arquivo(unzipNota(notT.getNot_bt_arquivo()));
                getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "text/xml");
                getRequest().setAttribute(EasyDownloadJB.FILE_NAME, not_notaT.getNot_tx_identificador() + ".xml");
                getRequest().setAttribute(EasyDownloadJB.DATA, notT.getNot_bt_arquivo());
                getPage().forward("/portal/easydownload.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }

    }

    public void findbyid() throws Exception {
        try {
            Not_notaDAO not_notaDAO = getNot_notaDAO();
            List<Not_notaT> listTemp = not_notaDAO.getById(not_notaT);

            not_notaT = listTemp.size() > 0 ? listTemp.get(0) : new Not_notaT();

        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
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
            String page = "not_notaConsult.jsp";// defina aqui a p?gina que deve ser chamada  

            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "not_notaConsult.jsp";// defina aqui a p?gina que deve ser chamada  

            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the download
     */
    public String[] getDownload() {
        return download;
    }

    /**
     * @param download the download to set
     */
    public void setDownload(String[] download) {
        this.download = download;
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
