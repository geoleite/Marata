package br.com.easynet.nfegen.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author geoleite
 */
public class DetectarNotasEmpresaErrada {
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

    static FileWriter fw;
    static int cont = 0;
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static String cnpjEmissor, cnpj="06093118000198";

    public static void mainUpdate() {

       Connection con = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("notasInvalidas.txt"));
            
            String driver = "org.postgresql.Driver";
//            String url = "jdbc:postgresql://localhost:5432/mcconsultoriae";
//            String pass = "postgres";
//            String user = "postgres";
            String url = "jdbc:postgresql://postgresql01.mcconsultoriaesistemas.com.br";
            String pass = "mc190174";
            String user = "mcconsultoriae";
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            String sql = "update easynfe.not_nota set dis_nr_id=? where not_nr_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            while (br.ready()) {
                String line = br.readLine();
                String[] parametros = line.split(";");
                int notNrId = Integer.parseInt(parametros[0]);
                String cnpjDis = parametros[1];
                String cnpjEmi = parametros[2];
                int disNrId = getCodigoDistribuidora(con, cnpjEmi);
                ps.setInt(1, disNrId);
                ps.setInt(2, notNrId);
                ps.execute();
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static int getCodigoDistribuidora(Connection con, String cnpj) throws Exception {
        ResultSet rs = null;
        try {
        String sql = "select dis_nr_id from easynfe.dis_distribuidora where dis_tx_cnpj=?" ;
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, cnpj);
        rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("dis_nr_id");
        }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
        }
        return 0;
    }

    public static void main() {

       Connection con = null;
        try {
            fw = new FileWriter("notasInvalidas.txt");
            String driver = "org.postgresql.Driver";
            String url = "jdbc:postgresql://postgresql01.mcconsultoriaesistemas.com.br";
            String pass = "mc190174";
            String user = "mcconsultoriae";

//            String url = "jdbc:postgresql://localhost:5432/mcconsultoriae";
//            String pass = "postgres";
//            String user = "postgres";

            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            java.sql.Date dtIni = new java.sql.Date(sdf.parse("01/05/2008").getTime());
            java.sql.Date dtFim = new java.sql.Date(sdf.parse("31/05/2009").getTime());


            int total = getTotalNotas(con, dtIni, dtFim);
            verificaNota(con, total, dtIni, dtFim);
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static int getTotalNotas(Connection con, java.sql.Date dtIni, java.sql.Date dtFim) {
        try {
            String sql = "select count(*) from easynfe.not_nota nota, easynfe.dis_distribuidora dis where nota.dis_nr_id=dis.dis_nr_id and not_dt_emissao between ? and ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, dtIni);
            ps.setObject(2, dtFim);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    public static void verificaNota(Connection con, int total, java.sql.Date dtIni, java.sql.Date dtFim) {
        try {
            int qntConsulta = 50;
            int parcial = total / qntConsulta;
            if (total % qntConsulta != 0) {
                parcial++;
            }

            int limite = qntConsulta;
            int offset = 0;
            int c = 0;
            String sql = "select dis_tx_cnpj, not_nr_id, not_bt_arquivo from easynfe.not_nota nota, easynfe.dis_distribuidora dis where not_dt_emissao between ? and ? and nota.dis_nr_id=dis.dis_nr_id  order by not_nr_id limit ? OFFSET ?";
//            String sql = "select not_nr_id, not_bt_arquivo from easynfe.not_nota";// where  pg_column_size(not_bt_arquivo) > (1024*10) order by not_nr_id limit ? OFFSET ?";
            PreparedStatement ps = con.prepareStatement(sql);
            for (int i = 1; i < parcial; i++) {

                ps.setObject(1, dtIni);
                ps.setObject(2, dtFim);
                ps.setObject(3, limite);
                ps.setObject(4, offset);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    c++;
                    cnpj = rs.getString("dis_tx_cnpj");
                    int codigo = rs.getInt("not_nr_id");
                    byte[] arq = rs.getBytes("not_bt_arquivo");
                    if (readXML(arq)) {
                        fw.write(codigo + ";" + cnpj+";" + cnpjEmissor + "\n");
                        fw.flush();
                    }
                }
                rs.close();
                
                offset += qntConsulta;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean readXML(byte[] arq) {
        try {
            SAXBuilder builder = new SAXBuilder();
            StringBuffer txtXml = new StringBuffer();
            ByteArrayInputStream bais = new ByteArrayInputStream(arq);
            //CharSet
            BufferedReader br = new BufferedReader(new InputStreamReader(bais, "ISO-8859-1"));
            while (br.ready()) {
                txtXml.append(br.readLine());
            }
            String strXml = txtXml.toString();
            strXml = strXml.replaceAll("UTF-8", "ISO-8859-1");
            StringReader sw = new StringReader(strXml);
            Document doc = builder.build(sw);
            return readDocument(doc);
            //return true;
        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }

    private static boolean readDocument(Document doc) throws Exception {

        List list = doc.getContent();
        if (NFE.equals(doc.getRootElement().getName())) {
            return readNFE(doc.getRootElement());
//            inserirNota();
        }
        return false;
    }

 public static boolean readNFE(Element element) throws Exception {
        List<Element> list = element.getChildren();
        for (Element element1 : list) {
            if (INFNFE.equals(element1.getName())) {
                return readInfNFe(element1);
            }
        }
        return false;
    }
    public static boolean readEmit(Element element) {
        List<Element> listE = element.getChildren();
        //not_notaT.setNot_tx_cnpjcliente(USER_PRINCIPAL)
        cnpjEmissor = listE.get(0).getValue();
        if (!cnpj.equals(cnpjEmissor)) {
            return true;
        }
        return false;

    }

    public static boolean readInfNFe(Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            if (EMIT.equalsIgnoreCase(element1.getName())) {
                return readEmit(element1);
            }
        }
        return false;
    }

}
