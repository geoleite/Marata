/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.nfegen.thread;

import javax.mail.Message;
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
public class ReadXMLNFE {

    private SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
    private String pathBase = "/tmp";
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
    //private Emp_empresaT emp_empresaT = new Emp_empresaT();
    private EmpresaT empresaT = new EmpresaT();
    private EmpresaT fornecedorT = new EmpresaT();
    private NotaFiscalT notaFiscal = new NotaFiscalT();
    private String cnpjDestino = "";
    private String cnpjEmissor = "";
    private String nomeEmissor = "";
    private DAOFactory dao;

    public static void main(String[] param) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("exemplo.xml"));
            StringBuffer sb = new StringBuffer();
            while (br.ready()) {
                sb.append(br.readLine());
            }
            ReadXMLNFE readXml = new ReadXMLNFE();
            readXml.readXML(sb.toString().getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
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
                id = id.substring(3, id.length());
                notaFiscal.setNfeId(id);
                //not_notaT.setNot_tx_identificador(id);
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
                String data = element1.getValue();
                //SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
                //Date dt = sdf.parse(data);
                //2008-07-02

                Date dt = sdf1.parse(data);
                //data = sdf2.format(dt);
                //data = data.replaceAll("-", "");
                notaFiscal.setDateProt(dt);
                //System.out.println("Data emissao: " + dt);
            } else if (TPNF.equalsIgnoreCase(element1.getName())) {
                readTpNF(element1);
                //readNatOp(element1);
            } else if (NNF.equalsIgnoreCase(element1.getName())) {
                readNNF(element1);
            }
        }
    }

    public void readNNF(Element element) throws Exception {
        //notaFiscal.setNot_tx_numero(Integer.parseInt(element.getValue()));
        //System.out.println("CNPJ tpNF: " + not_notaT.getNot_tx_tipo());
    }

    public void readNatOp(Element element) throws Exception {
        //not_notaT.setNot_tx_cnpjcliente(USER_PRINCIPAL)
        //not_notaT.setNot_tx_tipo(element.getValue());
        //notaFiscal.set
        //System.out.println("CNPJ tpNF: " + not_notaT.getNot_tx_tipo());
    }

    public void readTpNF(Element element) throws Exception {
        try {
            notaFiscal.setOrigem(Integer.parseInt(element.getValue()));
        } catch (Exception e) {
            System.out.println("Tipo Nota Inválido: " + element.getValue());
//            if ("VENDA".equalsIgnoreCase(element.getValue())) {
//                notaFiscal.setOrigem(1);
//            } else {
//                notaFiscal.setOrigem(2);
//            }
        }
//        not_notaT.setNot_tx_cnpjcliente(USER_PRINCIPAL)
//        not_notaT.setNot_tx_tipo("1".equals(element.getValue()) ? "S" : "E");
//        System.out.println("CNPJ tpNF: " + not_notaT.getNot_tx_tipo());
    }

    public void readEmit(Element element) {
        List<Element> listE = element.getChildren();
        //not_notaT.setNot_tx_cnpjcliente(USER_PRINCIPAL)
        cnpjEmissor = listE.get(0).getValue();
        if (cnpjEmissor.trim().length() > 11) {
            cnpjEmissor = "0" + cnpjEmissor;
        } else {
            cnpjEmissor = cnpjEmissor.replaceAll("(\\d{9})(\\d{2})", "$10000$2");
        }
        nomeEmissor = listE.get(1).getValue();
        empresaT.setCnpjEmpresa(cnpjEmissor);
        empresaT.setDenEmpresa(nomeEmissor);
    }

    /**
     * Ler os dados de endereco do destinatario da nota
     * @param element
     */
    public void readEndereco(Element element) {
//        List<Element> listE = element.getChildren();
//        for (Element element1 : listE) {
//            if ("xBairro".equalsIgnoreCase(element1.getName())) {
//                emp_empresaT.setEmp_tx_bairro(element1.getValue());
//            } else if ("xMun".equalsIgnoreCase(element1.getName())) {
//                emp_empresaT.setEmp_tx_cidade(element1.getValue());
//            } else if ("CEP".equalsIgnoreCase(element1.getName())) {
//                emp_empresaT.setEmp_tx_cep(element1.getValue());
//            } else if ("UF".equalsIgnoreCase(element1.getName())) {
//                emp_empresaT.setEmp_tx_estado(element1.getValue());
//            } else if ("xLgr".equalsIgnoreCase(element1.getName())) {
//                emp_empresaT.setEmp_tx_endereco(element1.getValue());
//            }
//
//            //emp_empresaT.setEmp_tx_ie( "" );
//        }
    }

    /**
     * Ler os dados do destinatario da nota
     * @param element
     * @throws java.lang.Exception
     */
    public void readDest(Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            if ("CPF".equalsIgnoreCase(element1.getName())) {
                String cpf = element1.getValue();
                //999999999000099
                cpf = cpf.replaceAll("(\\d{9})(\\d{2})", "$10000$2");
                fornecedorT.setCnpjEmpresa(cpf);
            }
            if ("CNPJ".equalsIgnoreCase(element1.getName())) {
                String cnpj = element1.getValue();
                cnpj = "0" + cnpj;
                fornecedorT.setCnpjEmpresa(cnpj);
            }
            cnpjDestino = fornecedorT.getCnpjEmpresa();
            //System.out.println("CNPJ dest " + fornecedorT.getCnpjEmpresa());
            //emp_empresaT.setEmp_tx_ie( "" );
        }

        //not_notaT.setNot_tx_cnpjcliente(emp_empresaT.getEmp_tx_cnpj());
        //System.out.println("Empresa: " + emp_empresaT);

    }

    private EmpresaT getEmpCnpj() {
        try {
            //empresaT.setCnpjEmpresa(cnpjEmissor);
            EmpresaDAO empDao = new EmpresaDAO(getDao());
            List<EmpresaT> listEmp = empDao.getByCNPJ(empresaT);
            EmpresaT empT = listEmp.size() > 0 ? listEmp.get(0) : null;
            return empT;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private EmpresaT getFornecedorCnpj() {
        try {
            //empresaT.setCnpjEmpresa(cnpjEmissor);
            EmpresaDAO empDao = new EmpresaDAO(getDao());
            List<EmpresaT> listEmp = empDao.getByCNPJ(fornecedorT);
            EmpresaT empT = listEmp.size() > 0 ? listEmp.get(0) : null;
            return empT;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void inserirNota() throws Exception {
        try {
            System.out.println("inserindo nota " + empresaT.getCnpjEmpresa() + " : " + fornecedorT.getCnpjEmpresa());
            EmpresaT empT = getEmpCnpj();
            if (empT == null) {
                //notaFiscal.setNUM_CGC_CPF(empresaT.getCnpjEmpresa());
                empT = getFornecedorCnpj();
            } else {
                //notaFiscal.setNUM_CGC_CPF(fornecedorT.getCnpjEmpresa());
            }
            if (notaFiscal.getOrigem() == 1) {
                notaFiscal.setNUM_CGC_CPF(cnpjDestino);
            } else {
                notaFiscal.setNUM_CGC_CPF(cnpjEmissor);
            }

            // Se o emissor da nota não for o usuário selecionada
            NotaFiscalDAO notaFiscalDAO = new NotaFiscalDAO(getDao());
            notaFiscal.setIdEnt(empT.getIdEnt());
            //System.out.println(new String(notaFiscal.getXmlSigMail()));
            if (!existeNota(notaFiscalDAO)) {
                try {
                    //System.out.println("arq \n" + notaFiscal.getXmlSigMail());

                    notaFiscalDAO.insertJava(notaFiscal);
                    System.out.println("inserindo nota " + notaFiscal.getNfeId());
                    ThreadMail.sbAcerto.append("Inserindo nfe ").append(notaFiscal.getNfeId());
                } catch (Exception e) {
                    ThreadMail.writeException(e);
                    //ThreadMail.sbErro.append("erro ao inserir nfe: ").append(notaFiscal.getNfeId()).append(". ").append(e.getMessage());
//                    e.printStackTrace();
//                    System.out.println("alterando nota " + notaFiscal.getNfeId());
//                    notaFiscalDAO.udpateJava(notaFiscal);
//                    ThreadMail.sbAcerto.append("Alterando nfe ").append(notaFiscal.getNfeId());
                }
            } else {
                System.out.println("alterando nota " + notaFiscal.getNfeId());
                notaFiscalDAO.udpateJava(notaFiscal);
                ThreadMail.sbAcerto.append("Alterando nfe ").append(notaFiscal.getNfeId());
            }
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            //System
            //e.printStackTrace();
            //ThreadMail.sbErro.append("erro ao geral nfe: ").append(notaFiscal.getNfeId()).append(". ").append(e.getMessage());
            //ThreadMail.writeException(e);
            throw e;
        }
    }

    private boolean existeNota(NotaFiscalDAO notaFiscalDAO) throws Exception {
        try {
            return notaFiscalDAO.existeNota(notaFiscal);
        } catch (Exception e) {
            throw e;
        }
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
            String dir = pathBase;
            for (Object object : list) {
                //ContentList cl = (ContentList) object
                Element elemento = (Element) object;
                List<Element> list2 = elemento.getChildren();
                int i = 0;
                for (Element element : list2) {
                    if (NFE.equals(element.getName())) {
                        //not_notaT = new Not_notaT();
                        readNFE(element);
                        XMLOutputter xmlOut = new XMLOutputter();
                        StringBuffer idFile = new StringBuffer(dir);
                        idFile.append("/").append(String.valueOf(System.currentTimeMillis())).append(".xml");

                        FileOutputStream fos = new FileOutputStream(idFile.toString());

                        Document d = new Document();

                        d.setRootElement((Element) element.clone());
                        xmlOut.output(d, fos);
                        fos.flush();
                        fos.close();

                        //not_notaT.setNot_bt_arquivo(readXmlFile(idFile.toString()));
                        try {
                            inserirNota();
                        } catch (Exception e) {
                            throw e;
                        } finally {
                            try {
                                File file = new File(idFile.toString());
                                if (file.exists() && file.isFile()) {
                                    file.delete();
                                }
                            } catch (Exception e) {
                            }
                        }
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

    /**
     * Le arquivo xml
     * @param arq
     */
    public void readXML(byte[] arq) throws Exception {
        SAXBuilder builder = new SAXBuilder();
        StringBuffer txtXml = new StringBuffer();
        ByteArrayInputStream bais = new ByteArrayInputStream(arq);
        //CharSet
        Document doc = null;
        try {
            doc = builder.build(bais);
        } catch (Exception e) {
            bais = new ByteArrayInputStream(arq);
            //BufferedReader br = new BufferedReader(new InputStreamReader(bais, "ISO-8859-1"));
            BufferedReader br = new BufferedReader(new InputStreamReader(bais, "UTF-8"));
            while (br.ready()) {
                txtXml.append(br.readLine());
            }
            String strXml = txtXml.toString();
            //strXml = strXml.replaceAll("UTF-8", "ISO-8859-1");
            //strXml = strXml.replaceAll("utf-8", "ISO-8859-1");
            try {
                StringReader sw = new StringReader(strXml);
                doc = builder.build(sw);
            } catch (Exception ex) {
                //ThreadMail.writeError(strXml);
                strXml = strXml.replaceAll("UTF-8", "ISO-8859-1");
                strXml = strXml.replaceAll("utf-8", "ISO-8859-1");
                StringReader sw = new StringReader(strXml);
                doc = builder.build(sw);
            }
        }
        notaFiscal.setStatusJava(1);
        notaFiscal.setXmlSigMail(arq);

        readDocument(doc);
    }

    /**
     *
     * Verifica se a nota fiscal já foi cadastrada pelo número identificador
     * @return
     */
    private boolean existNota(Not_notaDAO notDao) {
        // Verificar se a nota já existe
        try {
//            List<Not_notaT> listTemp = notDao.getByNot_tx_numero(not_notaT);
//            return listTemp.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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

    /**
     * @return the dao
     */
    public DAOFactory getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(DAOFactory dao) {
        this.dao = dao;
    }
}
