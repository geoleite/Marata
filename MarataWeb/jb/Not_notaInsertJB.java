package br.com.easynet.nfegen.jb;

import br.com.easynet.criptografia.MD5;
import br.com.easynet.easyportal.dao.Usu_usuarioDAO;
import br.com.easynet.easyportal.transfer.Per_perfilT;
import br.com.easynet.easyportal.transfer.Pu_per_usuT;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;
import br.com.easynet.email.SendMail;
import java.text.ParseException;
import java.util.List;
import br.com.easynet.jb.EasyFileUpload;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;
import br.com.easynet.nfegen.util.Zipper;
import br.com.easynet.portal.transfer.Por_usuT;
import br.com.easynet.portal.transfer.Usu_por_canT;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;
import org.jdom.input.SAXBuilder;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Not_notaInsertJB extends SystemBase {

    public final static String NATOP = "natOp";
    public final static String NFE = "NFe";
    public final static String INFNFE = "infNFe";
    public final static String IDE = "ide";
    public final static String DEMI = "dEmi";
    public final static String EMIT = "emit";
    public final static String DEST = "dest";
    public final static String TPNF = "tpNF";
    public final static String NNF = "nNF";
    public static String sinal = "sinal";
    // Atributos e propriedades
    private Dis_distribuidoraT dis_distribuidoraT = new Dis_distribuidoraT();
    private Emp_empresaT emp_empresaT = new Emp_empresaT();
    private Not_notaT not_notaT = new Not_notaT();
    private NotaZipT notaZipT;
    private Usu_usuarioT usu_usuarioT = new Usu_usuarioT();
    private List<NotaZipT> listNotasInseridas = new Vector<NotaZipT>();
    private List<NotaZipT> listNotasNaoInseridas = new Vector<NotaZipT>();
    private StringBuffer reciboEntrega = new StringBuffer();
    private String cnpjEmissor = "";
    private String nomeEmissor = "";
    private DAOFactory dao;
    private int contInseridas = 0, contProblemas = 0;

    public void setNot_notaT(Not_notaT not_notaT) {
        this.not_notaT = not_notaT;
    }

    public Not_notaT getNot_notaT() {
        return not_notaT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        dis_distribuidoraT = findbyIdDis_distribuidora(dis_distribuidoraT);
        //emp_empresaT.setDis_nr_id(emp_empresaT.getDis_nr_id());
        emp_empresaT.setEmp_nr_id(emp_empresaT.getEmp_nr_id());
        emp_empresaT = findbyIdEmp_empresa(emp_empresaT);
        consultEmp_empresa();
    }

    public void readNFE(Element element) throws Exception {
        List<Element> list = element.getChildren();
        for (Element element1 : list) {
            if (INFNFE.equals(element1.getName())) {
                //System.out.println(element1.getAttribute("version"));
                readInfNFe(element1);
            }
        }
    }

    public void readInfNFe(Element element) throws Exception {
        List<Attribute> list = element.getAttributes();
        for (Attribute attribute : list) {
            if ("Id".equalsIgnoreCase(attribute.getName())) {
                String id = attribute.getValue();
                not_notaT.setNot_tx_identificador(id);
                //System.out.println("id " + id);
            }
        }
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            if (IDE.equalsIgnoreCase(element1.getName())) {
                readIde(element1);
            } else if (EMIT.equalsIgnoreCase(element1.getName())) {
                readEmit(element1);
            } else if (DEST.equalsIgnoreCase(element1.getName())) {
                readDest(element1);
            }
        }
    }

    public void readIde(Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            if (DEMI.equalsIgnoreCase(element1.getName())) {
                try {
                    String data = element1.getValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
                    Date dt = sdf.parse(data);
                    //2008-07-02
                    not_notaT.setNot_dt_emissao(dt);
                    //System.out.println("Data emissao: " + dt);
                } catch (ParseException ex) {
                    Logger.getLogger(Not_notaInsertJB.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (NATOP.equalsIgnoreCase(element1.getName())) {
                //readTpNF(element1);
                readNatOp(element1);
            } else if (NNF.equalsIgnoreCase(element1.getName())) {
                readNNF(element1);
            }
        }
    }

    public void readNNF(Element element) throws Exception {

        not_notaT.setNot_tx_numero(Integer.parseInt(element.getValue()));

        //System.out.println("CNPJ tpNF: " + not_notaT.getNot_tx_tipo());
    }

    public void readNatOp(Element element) throws Exception {
        //not_notaT.setNot_tx_cnpjcliente(USER_PRINCIPAL)
        not_notaT.setNot_tx_tipo(element.getValue());

        //System.out.println("CNPJ tpNF: " + not_notaT.getNot_tx_tipo());
    }

    public void readTpNF(Element element) throws Exception {
        //not_notaT.setNot_tx_cnpjcliente(USER_PRINCIPAL)
        not_notaT.setNot_tx_tipo("1".equals(element.getValue()) ? "S" : "E");
        //System.out.println("CNPJ tpNF: " + not_notaT.getNot_tx_tipo());
    }

    public void readEmit(Element element) {
        List<Element> listE = element.getChildren();
        //not_notaT.setNot_tx_cnpjcliente(USER_PRINCIPAL)
        cnpjEmissor = listE.get(0).getValue();
        nomeEmissor = listE.get(1).getValue();

    }

    /**
     * Ler os dados de endereco do destinatario da nota
     * @param element
     */
    public void readEndereco(Element element) {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            if ("xBairro".equalsIgnoreCase(element1.getName())) {
                emp_empresaT.setEmp_tx_bairro(element1.getValue());
            } else if ("xMun".equalsIgnoreCase(element1.getName())) {
                emp_empresaT.setEmp_tx_cidade(element1.getValue());
            } else if ("CEP".equalsIgnoreCase(element1.getName())) {
                emp_empresaT.setEmp_tx_cep(element1.getValue());
            } else if ("UF".equalsIgnoreCase(element1.getName())) {
                emp_empresaT.setEmp_tx_estado(element1.getValue());
            } else if ("xLgr".equalsIgnoreCase(element1.getName())) {
                emp_empresaT.setEmp_tx_endereco(element1.getValue());
            }

            //emp_empresaT.setEmp_tx_ie( "" );
        }
    }

    /**
     * Ler os dados do destinatario da nota
     * @param element
     * @throws java.lang.Exception
     */
    public void readDest(Element element) throws Exception {
        List<Element> listE = element.getChildren();
        if (emp_empresaT == null) {
            emp_empresaT = new Emp_empresaT();
        }
        for (Element element1 : listE) {
            if ("CPF".equalsIgnoreCase(element1.getName())) {
                emp_empresaT.setEmp_tx_cnpj(element1.getValue());
            }
            if ("CNPJ".equalsIgnoreCase(element1.getName())) {
                emp_empresaT.setEmp_tx_cnpj(element1.getValue());
//                  emp_empresaT.setEmp_tx_cnpj(listE.get(0).getValue());
            } else if ("xNome".equalsIgnoreCase(element1.getName())) {
                emp_empresaT.setEmp_tx_nome(element1.getValue());
//                emp_empresaT.setEmp_tx_nome(listE.get(1).getValue());
            } else if ("IE".equalsIgnoreCase(element1.getName())) {
                emp_empresaT.setEmp_tx_ie(element1.getValue());
            } else if ("enderDest".equalsIgnoreCase(element1.getName())) {
                readEndereco(element1);
            }

            //emp_empresaT.setEmp_tx_ie( "" );
        }

        not_notaT.setNot_tx_cnpjcliente(emp_empresaT.getEmp_tx_cnpj());
        //System.out.println("Empresa: " + emp_empresaT);

    }

    /**
     * LER O documento xml
     * @param doc
     * @throws java.lang.Exception
     */
    private void readDocument(Document doc) throws Exception {

        List list = doc.getContent();
        if (NFE.equals(doc.getRootElement().getName())) {
            readNFE(doc.getRootElement());
            inserirNota();
        } else {
            String dir = getPastaBase();
            for (Object object : list) {
                //ContentList cl = (ContentList) object
                Element elemento = (Element) object;
                List<Element> list2 = elemento.getChildren();
                int i = 0;
                for (Element element : list2) {
                    if (NFE.equals(element.getName())) {
                        not_notaT = new Not_notaT();
                        readNFE(element);
                        XMLOutputter xmlOut = new XMLOutputter();
                        StringBuffer idFile = new StringBuffer(dir);
                        idFile.append("/").append(String.valueOf(getSession().getId())).append(".xml");

                        FileOutputStream fos = new FileOutputStream(idFile.toString());

                        Document d = new Document();

                        d.setRootElement((Element) element.clone());
                        xmlOut.output(d, fos);
                        fos.flush();
                        fos.close();

                        not_notaT.setNot_bt_arquivo(readXmlFile(idFile.toString()));

                        inserirNota();

                    }
                }
            }
        }
    }

    /**
     * Ler o arquivo temporario e apaga após a leitura
     * @param idFile
     * @return
     * @throws java.lang.Exception
     */
    private byte[] readXmlFile(String idFile) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        File file = new File(idFile);
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int controle = -1;
        while ((controle = fis.read(buffer)) != -1) {
            byte[] buf = new byte[controle];
            System.arraycopy(buffer, 0, buf, 0, controle);
            baos.write(buf);
        }
        file.delete();
        return baos.toByteArray();
    }

    private void inserirNota() {
        try {
            emp_empresaT = getEmpCnpj();
            notaZipT = new NotaZipT();
            // Se o emissor da nota não for o usuário selecionada

            if (!dis_distribuidoraT.getDis_tx_cnpj().equals(cnpjEmissor)) {
                Dis_distribuidoraT disT = new Dis_distribuidoraT();
                disT.setDis_tx_cnpj(cnpjEmissor);
                Dis_distribuidoraDAO disDao = new Dis_distribuidoraDAO(dao);
                //List<Dis_distribuidoraT> listDis = getDis_distribuidoraDAO().getByDis_tx_cnpj(disT);
                List<Dis_distribuidoraT> listDis = disDao.getByDis_tx_cnpj(disT);
                if (listDis.size() > 0) {
                    not_notaT.setDis_nr_id(listDis.get(0).getDis_nr_id());
                } else {
                    Dis_distribuidoraInsertJB disInsertJB = new Dis_distribuidoraInsertJB();
                    disInsertJB.setPage(page);
                    try {
                        disInsertJB.getUsu_usuarioT().setUsu_tx_senha(String.valueOf(System.currentTimeMillis()));
                        disT.setDis_tx_nome(nomeEmissor);
                        disInsertJB.setStatusUsuario("I");
                        disT.setDis_tx_status("I");
                        disInsertJB.setDis_distribuidoraT(disT);

                        disInsertJB.insert();
                        not_notaT.setDis_nr_id(disT.getDis_nr_id());
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        disInsertJB.close();
                    }
                    //disDao.insert(disT);
                    //not_notaT.setDis_nr_id(disT.getDis_nr_id());
                    /*
                    notaZipT.setNot_notaT(not_notaT);
                    notaZipT.setMsg("Nota fiscal nao pertence a esta distribuidora!");
                    listNotasNaoInseridas.add(notaZipT);
                    return;
                     */
                }
            } else {
                not_notaT.setDis_nr_id(dis_distribuidoraT.getDis_nr_id());
            }
            if (emp_empresaT == null) {
                System.err.println("CNPJ " + cnpjEmissor);
            }
            not_notaT.setEmp_nr_id(emp_empresaT.getEmp_nr_id());
            Not_notaDAO not_notaDAO = new Not_notaDAO(dao);
            if (!existNota(not_notaDAO)) {


                //Connection con = dao.getConnection();
                //con.setAutoCommit(false);
                try {

                    //not_notaT.setNot_bt_arquivo(zipNota(not_notaT.getNot_bt_arquivo()));
                    not_notaDAO.insert(not_notaT);
                    contInseridas++;
                    setMsg("Cadastro efetuado com sucesso!");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    reciboEntrega.append("IP Origem: ").append(request.getRemoteHost());
                    reciboEntrega.append(" NR: ").append(not_notaT.getNot_tx_numero()).append(" Cliente: ").append(not_notaT.getNot_tx_cnpjcliente()).append(" Data Emissao: ").append(sdf.format(new Date(System.currentTimeMillis())));
                    Rel_registro_logDAO relDAO = new Rel_registro_logDAO(dao);
                    Rel_registro_logT relT = new Rel_registro_logT();
                    relT.setDis_nr_id(not_notaT.getDis_nr_id());
                    relT.setRel_tx_ip(request.getRemoteHost());
                    relT.setRel_dt_datahora(new Timestamp(System.currentTimeMillis()));
                    relT.setRel_tx_numeronota(not_notaT.getNot_tx_numero());
                    relT.setRel_tx_usuario(getUsuarioLogado().getUsu_tx_nome());
                    relDAO.insert(relT);
                    //enviarEmail();
                    //con.commit();
                    // COntrole de mensagens das notas cadastradas

                    notaZipT.setNot_notaT(not_notaT);
                    notaZipT.setMsg("Nota fiscal inserida com sucesso!");
                    listNotasInseridas.add(notaZipT);


                } catch (Exception e) {
                    //con.rollback();
                    contProblemas++;
                    notaZipT.setMsg("Nota fiscal inserida com sucesso!");
                }

            } else {
                // COntrole de mensagens das notas não cadastradas
                contProblemas++;
                notaZipT.setNot_notaT(not_notaT);
                notaZipT.setMsg("Nota fiscal ja cadastrada!");
                listNotasNaoInseridas.add(notaZipT);

//                setMsg("Nota fiscal já informada:" + not_notaT.getNot_tx_numero());
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    /**
     * Le arquivo xml
     * @param arq
     */
    private void readXML(byte[] arq) throws Exception {
        SAXBuilder builder = new SAXBuilder();
        StringBuffer txtXml = new StringBuffer();
        ByteArrayInputStream bais = new ByteArrayInputStream(arq);
        //CharSet
        Document doc = null;
        try {
            doc = builder.build(bais);
        } catch (Exception e) {
            bais = new ByteArrayInputStream(arq);
            BufferedReader br = new BufferedReader(new InputStreamReader(bais, "ISO-8859-1"));
            while (br.ready()) {
                txtXml.append(br.readLine());
            }
            String strXml = txtXml.toString();
            strXml = strXml.replaceAll("UTF-8", "ISO-8859-1");
            strXml = strXml.replaceAll("utf-8", "ISO-8859-1");

            StringReader sw = new StringReader(strXml);
            doc = builder.build(sw);
        }

        readDocument(doc);

        if (getListNotasInseridas().size() == 0) {
            setListNotasInseridas(null);
        } else {
            //Enviar Email
            enviarEmail();
        }
        if (getListNotasNaoInseridas().size() == 0) {
            setListNotasNaoInseridas(null);
        } else {
            StringBuffer sb = new StringBuffer();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            for (NotaZipT nzt : listNotasNaoInseridas) {
                sb.append("Numero Nota: ").append(nzt.getNot_notaT().getNot_tx_numero()).append(" Cliente: ").append(nzt.getNot_notaT().getNot_tx_cnpjcliente()).append(" Data Emissao: ").append(sdf.format(nzt.getNot_notaT().getNot_dt_emissao())).append("\n");

            }
            enviarEmailSuporte("Falha ao Anexar Notas Fiscais!", sb.toString());
        }

    }

    /**
     * Definindo a disribuidora no perfil
     */
    private void insertUsuarioPerfil() {
        br.com.easynet.easyportal.jb.SystemBase sb = new br.com.easynet.easyportal.jb.SystemBase();
        try {
            sb.setPage(page);
            //Obtendo o código do perfil
            Per_perfilT perT = new Per_perfilT();
            perT.setPer_tx_nome("Cliente NFE");
            List<Per_perfilT> listPer = sb.getPer_perfilDAO().getByPer_tx_nome(perT);
            perT = listPer.size() > 0 ? listPer.get(0) : null;

            // Inserindo o usuário no perfil
            Pu_per_usuT puT = new Pu_per_usuT();
            puT.setPer_nr_id(perT.getPer_nr_id());
            puT.setUsu_nr_id(usu_usuarioT.getUsu_nr_id());
            sb.getPu_per_usuDAO().insert(puT);

//      Inserindo no perfil padrao
            perT = new Per_perfilT();
            perT.setPer_tx_nome("Padrao");
            listPer = sb.getPer_perfilDAO().getByPer_tx_nome(perT);
            perT = listPer.size() > 0 ? listPer.get(0) : null;

            // Inserindo o usuário no perfil
//            puT = new Pu_per_usuT();
//            puT.setPer_nr_id(perT.getPer_nr_id());
//            puT.setUsu_nr_id(usu_usuarioT.getUsu_nr_id());
//            sb.getPu_per_usuDAO().insert(puT);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sb.close();
        }
    }

    /**
     * Define o portal do usuário
     */
    private void insertPortalUsuario() {
        br.com.easynet.portal.jb.SystemBase sb = new br.com.easynet.portal.jb.SystemBase();
        try {
            sb.setPage(page);
            Por_usuT puT = new Por_usuT();
            puT.setPor_nr_id(1);// Código um representa o portal padrão
            puT.setUsu_nr_id(usu_usuarioT.getUsu_nr_id());
            sb.getPor_usuDAO().insert(puT);

            Usu_por_canT upcT = new Usu_por_canT();
            upcT.setPor_nr_id(puT.getPor_nr_id());
            upcT.setUsu_nr_id(puT.getUsu_nr_id());
            upcT.setUpc_nr_ordem(1);
            upcT.setUpc_tx_status("A");
            upcT.setCan_nr_id(1);

            sb.getUsu_por_canDAO().insert(upcT);
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            sb.close();
        }
    }

    /**
     * Insere a distribuidora na tabela de usuário do portal e define o código da distribuidora
     */
    private int insertUsuario(Emp_empresaT empT) {
        br.com.easynet.easyportal.jb.SystemBase sb = new br.com.easynet.easyportal.jb.SystemBase();
        try {
            usu_usuarioT.setUsu_tx_nome(empT.getEmp_tx_nome());
            usu_usuarioT.setUsu_tx_login(empT.getEmp_tx_cnpj());
            usu_usuarioT.setUsu_tx_status("A");
            String senhaGerada = String.valueOf(System.currentTimeMillis());
            usu_usuarioT.setUsu_tx_senha(MD5.criptografar(senhaGerada));

            sb.setPage(page);
            Usu_usuarioDAO usuDao = sb.getUsu_usuarioDAO();
            List<Usu_usuarioT> listUsu = usuDao.getByUsu_tx_login(usu_usuarioT);
            if (listUsu.size() == 0) {
                synchronized (sinal) {
                    usuDao.insert(usu_usuarioT);
                    usu_usuarioT = usuDao.getUltimoUsuarioInserido();
                    empT.setEmp_nr_id(usu_usuarioT.getUsu_nr_id());
                    insertUsuarioPerfil();
                    insertPortalUsuario();
                }
            } else {
                usu_usuarioT = listUsu.get(0);
                empT.setEmp_nr_id(usu_usuarioT.getUsu_nr_id());
            }
            return usu_usuarioT.getUsu_nr_id();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sb.close();
        }
        return -1;
    }

    /**
     * Verifica se a empresa é cliente da distribuidora se nao for insere como cliente 
     * @return
     */
    private Emp_empresaT getEmpCnpj() {
        try {
            Emp_empresaDAO empDao = new Emp_empresaDAO(dao);
            List<Emp_empresaT> listEmp = empDao.getByCnpj(emp_empresaT);
            Emp_empresaT empT = listEmp.size() > 0 ? listEmp.get(0) : null;
            if (empT == null) {
                synchronized (sinal) {
                    //emp_empresaT.setDis_nr_id(dis_distribuidoraT.getDis_nr_id());
                    int codigo = insertUsuario(emp_empresaT);
                    emp_empresaT.setEmp_nr_id(codigo);
                    empDao.insert(emp_empresaT);
                    List<Emp_empresaT> listTemp = getEmp_empresaDAO().getByCnpj(emp_empresaT);
                    empT = listTemp.size() > 0 ? listTemp.get(0) : null;
                }
            }

            if (empT == null) {
                //System.out.println("\n\n\n" + empT);
            }
            // Verificando se deve cadastrar a empresa como cliente da distribuidora
            De_dis_empT deT = new De_dis_empT();
            deT.setDis_nr_id(dis_distribuidoraT.getDis_nr_id());
            deT.setEmp_nr_id(empT.getEmp_nr_id());
            De_dis_empDAO deDao = new De_dis_empDAO(dao);
            List<De_dis_empT> listDe = deDao.getById(deT);
            // Se nao existir na tabela de_dis_emp deve ser inserido como cliente da distribuidora
            if (listDe.size() == 0) {
                De_dis_empDAO deDisDao = new De_dis_empDAO(dao);
                deDisDao.insert(deT);
            }

            return empT;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    /**
     * 
     * Verifica se a nota fiscal já foi cadastrada pelo número identificador
     * @return
     */
    private boolean existNota(Not_notaDAO notDao) {
        // Verificar se a nota já existe
        try {

            List<Not_notaT> listTemp = notDao.getByNot_tx_numero(not_notaT);
            return listTemp.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Compactando o arquivo da Nota Fiscal
     * @param dados
     * @return
     */
    private byte[] zipNota(byte[] dados) throws Exception {
        //ByteArrayInputStream bais = new ByteArrayInputStream(dados);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(baos);
        gzip.write(dados);
        gzip.flush();
        gzip.finish();
        gzip.close();
        return baos.toByteArray();
    }

    private boolean getTipoArquivoZip() {

        EasyFileUpload efu = (EasyFileUpload) request.getAttribute("not_notaT.not_bt_arquivo");

        //System.out.println(efu.getType());
        return "zip".equals(efu.getType());
    }

    /**
     * Ler os bytes da nota que esta no arquivo
     * @return
     */
    private byte[] readByteArq(File file) throws Exception {
        ByteArrayOutputStream notaBytes = new ByteArrayOutputStream();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        int controle = -1;
        while ((controle = (bis.read())) != -1) {
            notaBytes.write(controle);
        }
        return notaBytes.toByteArray();
    }

    private void salvarZip() throws Exception {
        File dir = new File(getPastaBase() + "/" + getSession().getId());
        try {

            dir.mkdirs();
            //System.out.println("SAlvando zip " + dir.getAbsolutePath());
            File arq = new File(dir.getAbsolutePath() + "/notas.zip");
            FileOutputStream fos = new FileOutputStream(arq);
            fos.write(not_notaT.getNot_bt_arquivo());
            fos.close();
            Zipper zip = new Zipper();
            try {
                zip.extrairZip(arq, dir);
            } catch (Exception e) {
                setMsg("O arquivo da nota deve ser compactado com o formato ZIP.");
                enviarEmailSuporte("Falha ao Descompactar o arquivo!", "Falha ao descompactar o arquivo das notas fiscais.");
            }
            List listArq = zip.listarEntradasZip(arq);
            //setListNotasInseridas(new Vector<NotaZipT>());
            //setListNotasNaoInseridas(new Vector<NotaZipT>());
            for (Object nota : listArq) {
//            System.out.println(nota);

                //not_notaT = new Not_notaT();
                try {
                    System.out.println("\n\n\n" + dir.getAbsolutePath() + "/" + nota + "\n\n\n");
                    File arqNota = new File(dir.getAbsolutePath() + "/" + nota);

                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(arqNota));


//                    SAXBuilder builder = new SAXBuilder();
//                    Document doc = builder.build(bis);
//                    readDocument(doc);

                    SAXBuilder builder = new SAXBuilder();
                    StringBuffer txtXml = new StringBuffer();
                    //CharSet
                    BufferedReader br = new BufferedReader(new InputStreamReader(bis, "ISO-8859-1"));
                    while (br.ready()) {
                        txtXml.append(br.readLine());
                    }
                    String strXml = txtXml.toString();
                    strXml = strXml.replaceAll("UTF-8", "ISO-8859-1");
                    StringReader sw = new StringReader(strXml);
                    Document doc = builder.build(sw);
                    not_notaT = new Not_notaT();
                    not_notaT.setNot_bt_arquivo(txtXml.toString().getBytes());
                    readDocument(doc);


                    /*

                    emp_empresaT = getEmpCnpj();


                    not_notaT.setDis_nr_id(dis_distribuidoraT.getDis_nr_id());
                    not_notaT.setEmp_nr_id(emp_empresaT.getEmp_nr_id());
                    not_notaT.setNot_bt_arquivo(readByteArq(arqNota));
                    //              System.out.println(not_notaT);
                    if (!existNota()) {
                    //not_notaT.setNot_bt_arquivo(zipNota(not_notaT.getNot_bt_arquivo()));
                    Not_notaDAO not_notaDAO = getNot_notaDAO();
                    not_notaDAO.insert(not_notaT);
                    notaZipT.setNot_notaT(not_notaT);
                    notaZipT.setMsg("Nota fiscal inserida com sucesso!");
                    getListNotasInseridas().add(notaZipT);

                    reciboEntrega.append("IP Origem: ").append(request.getRemoteHost());
                    reciboEntrega.append(" NR: ").append(not_notaT.getNot_tx_numero()).append(" Cliente: ").append(not_notaT.getNot_tx_cnpjcliente()).append(" Data Emissao: ").append(sdf.format(new Date(System.currentTimeMillis()))).append("\n");
                    Rel_registro_logT relT = new Rel_registro_logT();
                    relT.setRel_dt_datahora(new Timestamp(System.currentTimeMillis()));
                    relT.setRel_tx_numeronota(not_notaT.getNot_tx_numero());
                    relT.setDis_nr_id(not_notaT.getDis_nr_id());
                    relT.setRel_tx_ip(request.getRemoteHost());
                    relT.setRel_tx_usuario(getUsuarioLogado().getUsu_tx_nome());

                    Rel_registro_logDAO relDAO = getRel_registro_logDAO();
                    relDAO.insert(relT);
                    //setMsg("Cadastro efetuado com sucesso!");
                    } else {
                    notaZipT.setNot_notaT(not_notaT);
                    notaZipT.setMsg("Nota fiscal ja cadastrada!");
                    getListNotasNaoInseridas().add(notaZipT);
                    //setMsg("Nota fiscal já informada!");

                    }
                     */
                } catch (Exception e) {
                    e.printStackTrace();
                    notaZipT.setNot_notaT(not_notaT);
                    notaZipT.setMsg("Falha ao inserir nota fiscal!");
                    getListNotasNaoInseridas().add(notaZipT);
                    e.printStackTrace();
                }
            }
            if (getListNotasInseridas().size() == 0) {
                setListNotasInseridas(null);
            } else {
                //Enviar Email
                enviarEmail();
            }
            if (getListNotasNaoInseridas().size() == 0) {
                setListNotasNaoInseridas(null);
            } else {
                StringBuffer sb = new StringBuffer();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                for (NotaZipT nzt : listNotasNaoInseridas) {
                    sb.append("Numero Nota: ").append(nzt.getNot_notaT().getNot_tx_numero()).append(" Cliente: ").append(nzt.getNot_notaT().getNot_tx_cnpjcliente()).append(" Data Emissao: ").append(sdf.format(nzt.getNot_notaT().getNot_dt_emissao())).append("\n");

                }
                enviarEmailSuporte("Falha ao Anexar Notas Fiscais!", sb.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            deleteTemp(dir);
        }
        /*
        readXML(not_notaT.getNot_bt_arquivo());
        emp_empresaT = getEmpCnpj();
        not_notaT.setDis_nr_id(dis_distribuidoraT.getDis_nr_id());
        not_notaT.setEmp_nr_id(emp_empresaT.getEmp_nr_id());
        //              System.out.println(not_notaT);
        if (!existNota()) {
        Not_notaDAO not_notaDAO = getNot_notaDAO();
        //not_notaT.setNot_bt_arquivo(zipNota(not_notaT.getNot_bt_arquivo()));

        not_notaDAO.insert(not_notaT);
        setMsg("Cadastro efetuado com sucesso!");
        } else {
        setMsg("Nota fiscal já informada!");
        return;
        }

         */

    }

    private String getEmailDistribuidora() throws Exception {

        Usu_usuarioT usuT = new Usu_usuarioT();
        usuT.setUsu_nr_id(dis_distribuidoraT.getDis_nr_id());
        List<Usu_usuarioT> list = getUsu_usuarioDAO().getById(usuT);
        usuT = list.get(0);
        return usuT.getUsu_tx_email();
    }

    public static void main(String[] param) {
        try {
            /*
            //            SendMail sm = new SendMail("smtp.mcconsultoriaesistemas.com.br");
            SendMail sm = new SendMail("smtp.gmail.com");
            String fromName = "NFEInbox";
            String fromEmail = "suportenfe@nfeinbox.com.br";
            String fromPassword = "suporte";
            String toName = "teste";
            String toEmail = "georgeleitejunior@gmail.com";
            String subject = "Recibo de Entrega de nota fiscal ao NFEInbox!";
            String msg = "mensagem de teste";
            String contentType = "text/plain";
            String port = "465";
            sm.enviarEmailGmail(fromName, fromEmail, fromPassword, toName, toEmail, subject, msg, contentType, port);
             */
            SAXBuilder builder = new SAXBuilder();
            StringBuffer txtXml = new StringBuffer();
            FileReader fr = new FileReader("/home/geoleite/Desktop/29090706265830000127550010000401670000401672-pro.xml");
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                txtXml.append(br.readLine());
            }
            //FileInputStream bais = new FileInputStream("/home/geoleite/Desktop/079288504_V1.10-procNFePROT.signed.xml");

            ByteArrayInputStream bais = new ByteArrayInputStream(txtXml.toString().getBytes());


            Document doc = builder.build(bais);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void enviarEmail() throws Exception {
        // Recibo
        //smtp.google.com
//        SendMail sm = new SendMail("smtp.mcconsultoriaesistemas.com.br");
        SendMail sm = new SendMail("smtp.google.com");
        String fromName = "NFEInbox";
        String fromEmail = "suportenfe@nfeinbox.com.br";
        String fromPassword = "suporte";
        String toName = dis_distribuidoraT.getDis_tx_nome();
        String toEmail = getEmailDistribuidora();
        String subject = "Recibo de Entrega de nota fiscal ao NFEInbox!";
        String msg = reciboEntrega.toString();
        String contentType = "text/plain";
        String port = "465";
//        sm.enviarEmailGmail(fromName, fromEmail, fromPassword, toName, toEmail, subject, msg, contentType, port);

        StringBuffer sb = new StringBuffer(subject);
        sb.append(" pela ").append(toName);
        enviarEmailSuporte(sb.toString(), msg);


    }

    public void insert() throws Exception {
        try {
            dao = getDAO();
            if (getTipoArquivoZip()) {
                salvarZip();
            } else {
                readXML(not_notaT.getNot_bt_arquivo());
            }
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar cadastro de nota fiscal! Provavelmente erro na nota");
        } finally {
            dao.close();
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

    public void clear() throws Exception {

        not_notaT = new Not_notaT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "not_notaConsult.jsp";// defina aqui a p?gina que deve ser chamada  

            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public Dis_distribuidoraT getDis_distribuidoraT() {
        return dis_distribuidoraT;
    }

    public void setDis_distribuidoraT(Dis_distribuidoraT dis_distribuidoraT) {
        this.dis_distribuidoraT = dis_distribuidoraT;
    }

    public Emp_empresaT getEmp_empresaT() {
        return emp_empresaT;
    }

    public void setEmp_empresaT(Emp_empresaT emp_empresaT) {
        this.emp_empresaT = emp_empresaT;
    }

    /**
     * @return the listNotasInseridas
     */
    public List<NotaZipT> getListNotasInseridas() {
        return listNotasInseridas;
    }

    /**
     * @param listNotasInseridas the listNotasInseridas to set
     */
    public void setListNotasInseridas(List<NotaZipT> listNotasInseridas) {
        this.listNotasInseridas = listNotasInseridas;
    }

    /**
     * @return the listNotasNaoInseridas
     */
    public List<NotaZipT> getListNotasNaoInseridas() {
        return listNotasNaoInseridas;
    }

    /**
     * @param listNotasNaoInseridas the listNotasNaoInseridas to set
     */
    public void setListNotasNaoInseridas(List<NotaZipT> listNotasNaoInseridas) {
        this.listNotasNaoInseridas = listNotasNaoInseridas;
    }

    /**
     * @return the reciboEntrega
     */
    public StringBuffer getReciboEntrega() {
        return reciboEntrega;
    }

    /**
     * @param reciboEntrega the reciboEntrega to set
     */
    public void setReciboEntrega(StringBuffer reciboEntrega) {
        this.reciboEntrega = reciboEntrega;
    }

    /**
     * @return the contInseridas
     */
    public int getContInseridas() {
        return contInseridas;
    }

    /**
     * @param contInseridas the contInseridas to set
     */
    public void setContInseridas(int contInseridas) {
        this.contInseridas = contInseridas;
    }

    /**
     * @return the contProblemas
     */
    public int getContProblemas() {
        return contProblemas;
    }

    /**
     * @param contProblemas the contProblemas to set
     */
    public void setContProblemas(int contProblemas) {
        this.contProblemas = contProblemas;
    }
}
