/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.nfegen.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author geoleite
 */
public class Teste {

    static int cont = 0;
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static StringBuffer notasInvalidas = new StringBuffer();

    /**
     * Verificar os zips zerados
     * @param param
     */
    public static void main1(String[] param) {

        try {

            File[] zips = new File("zip").listFiles();
            //Zipper zip = new Zipper();
            //File destino = new File("zip/notas");
            Connection con = null;
            String driver = "org.postgresql.Driver";
            String url = "jdbc:postgresql://postgresql01.mcconsultoriaesistemas.com.br";
            String pass = "mc190174";
            String user = "mcconsultoriae";
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            for (File file : zips) {

                try {
                    if (file.isFile() && file.length() == 0) {
                        String nomeArq = file.getName();
                        nomeArq = nomeArq.substring(0, nomeArq.length() - 4);
                        System.out.println(nomeArq);
                        dadosNotasInvalidas(con, Integer.parseInt(nomeArq));
                    }
                } catch (Exception e) {
                    System.err.println(file.getName() + " corrompido.");
                    e.printStackTrace();
                //e.printStackTrace();
                }

            }
            FileWriter fw = new FileWriter("notasInvalidas.txt");
            fw.write(notasInvalidas.toString());
            fw.flush();
            fw.close();
            System.out.println("Total de Notas substituidas: " + cont);
        } catch (Exception ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void dadosNotasInvalidas(Connection con, int notaId) throws Exception {
        String sql = "select n.not_dt_emissao, n.not_tx_numero, dis.dis_tx_nome from easynfe.not_nota n, easynfe.dis_distribuidora dis where n.not_nr_id=? and n.dis_nr_id=dis.dis_nr_id";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, notaId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String emissao = sdf.format(rs.getDate("not_dt_emissao"));
            String numero = rs.getString("not_tx_numero");
            String distribuidora = rs.getString("dis_tx_nome");
            notasInvalidas.append("Distribuidora: ").append(distribuidora).append(" Emissao: ").append(emissao).append(" Nota: ").append(numero).append("\n");
        } else {
            System.err.println("Falha ao consultar nota " + notaId);
        }
        rs.close();
        ps.close();
    }

    public static void extrair() {

        try {

            File[] zips = new File("zip").listFiles();
            Zipper zip = new Zipper();
            File destino = new File("zip/notas");
            Connection con = null;
            String driver = "org.postgresql.Driver";
            String url = "jdbc:postgresql://postgresql01.mcconsultoriaesistemas.com.br";
            String user = "mcconsultoriae";
            String pass = "mc190174";
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            for (File file : zips) {

                try {
                    if (file.isFile()) {
                        String nomeArq = file.getName();
                        nomeArq = nomeArq.substring(0, nomeArq.length() - 4);
                        System.out.println(nomeArq);
                        //trocarNota(con, Integer.parseInt(nomeArq));
                        zip.extrairZip(file, destino);
                    }
                } catch (Exception e) {
                    System.err.println(file.getName() + " nota(xml) não encontrada.");
                //e.printStackTrace();
                }

            }
            System.out.println("Total de Notas substituidas: " + cont);
        } catch (Exception ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Substituir arquvios
     * @param param
     */
    public static void substituir() {

        try {

            File[] zips = new File("zip").listFiles();
            Zipper zip = new Zipper();
            File destino = new File("zip/notas");
            Connection con = null;
            String driver = "org.postgresql.Driver";
            String url = "jdbc:postgresql://postgresql01.mcconsultoriaesistemas.com.br";
            String user = "mcconsultoriae";
            String pass = "mc190174";
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            for (File file : zips) {

                try {
                    if (file.isFile()) {
                        String nomeArq = file.getName();
                        nomeArq = nomeArq.substring(0, nomeArq.length() - 4);
                        System.out.println(nomeArq);
                        trocarNota(con, Integer.parseInt(nomeArq));
                        //zip.extrairZip(file, destino);
                    }
                } catch (Exception e) {
                    System.err.println(file.getName() + " nota(xml) não encontrada.");
                //e.printStackTrace();
                }

            }
            System.out.println("Total de Notas substituidas: " + cont);
        } catch (Exception ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void trocarNota(Connection con, int notaId) throws Exception {
        String sql = "select not_tx_identificador from easynfe.not_nota where not_nr_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, notaId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String chave = rs.getString("not_tx_identificador");
            //26090404169581000140550010001286500001286508-pro
            if (chave.indexOf("NFe") >= 0) {
                chave = chave.substring(3, chave.length());
            }
            chave = chave + "-pro.xml";
            substituirNota(con, notaId, chave);
        } else {
            System.err.println("Falha ao consultar nota " + notaId);
        }
        rs.close();
        ps.close();
    }

    public static byte[] readNota(String nomeArq) throws Exception {
        FileInputStream fis = new FileInputStream("zip/notas/" + nomeArq);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        StringBuilder sb = new StringBuilder();
        while (br.ready()) {
            sb.append(br.readLine());
        }
        //System.out.println(sb.toString());
        fis.close();
        return sb.toString().getBytes();
    }

    public static void substituirNota(Connection con, int notaId, String nomeArq) throws Exception {
        String sql = "update easynfe.not_nota set not_bt_arquivo=?  where not_nr_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setBytes(1, readNota(nomeArq));
        ps.setInt(2, notaId);
        ps.execute();
        System.out.println("Nota Substituida: " + notaId);
        cont++;
        ps.close();
    }

    public static void detectarZip() {
        Connection con = null;
        try {
            String driver = "org.postgresql.Driver";
            String url = "jdbc:postgresql://postgresql01.mcconsultoriaesistemas.com.br";
            String pass = "mc190174";
            String user = "mcconsultoriae";
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            java.sql.Date dtIni = new java.sql.Date(sdf.parse("01/01/2008").getTime());
            java.sql.Date dtFim = new java.sql.Date(sdf.parse("30/04/2009").getTime());


            int total = getTotalNotas(con, dtIni, dtFim);
            verificaNota(con, total, dtIni, dtFim);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void verificaNota(Connection con, int total, java.sql.Date dtIni, java.sql.Date dtFim) {
        try {
            int qntConsulta = 1;
            int parcial = total / qntConsulta;
            if (total % qntConsulta != 0) {
                parcial++;
            }

            int limite = qntConsulta;
            int offset = 0;
            int c = 0;
//            String sql = "select not_nr_id, not_bt_arquivo from easynfe.not_nota  order by not_nr_id limit ? OFFSET ?";
            String sql = "select not_nr_id, not_bt_arquivo from easynfe.not_nota";// where  pg_column_size(not_bt_arquivo) > (1024*10) order by not_nr_id limit ? OFFSET ?";
            PreparedStatement ps = con.prepareStatement(sql);
            for (int i = 1; i < parcial; i++) {

//                ps.setObject(1, dtIni);
//                ps.setObject(2, dtFim);
                ps.setObject(1, limite);
                ps.setObject(2, offset);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    c++;
                    int codigo = rs.getInt("not_nr_id");
                    byte[] arq = rs.getBytes("not_bt_arquivo");
                    if (!readXML(arq)) {
                        System.out.println("Nota Zip: " + codigo + " " + c);
                        saveZip(codigo, arq);
                    } else {
                        System.out.println("Nota XML: " + codigo + " " + c);

                    }
                }
                rs.close();
                offset += qntConsulta;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getTotalNotas(Connection con, java.sql.Date dtIni, java.sql.Date dtFim) {
        try {
            //String sql = "select count(*) from easynfe.not_nota where  not_dt_emissao between ? and ?";
            String sql = "select count(*) from easynfe.not_nota";// where pg_column_size(not_bt_arquivo) > (1024*10)";
            PreparedStatement ps = con.prepareStatement(sql);
            //ps.setObject(1, dtIni);
            //ps.setObject(2, dtFim);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void saveZip(int codigo, byte[] arq) {
        try {
            FileOutputStream fos = new FileOutputStream("zip/" + codigo + ".zip");
            fos.write(arq);
            fos.flush();
            fos.close();
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
            //System.out.println(strXml);
            StringReader sw = new StringReader(strXml);
            Document doc = builder.build(sw);
            return true;
        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
//    public static void main(String[] param) {
//        try {
//            Calendar cal = Calendar.getInstance();
//            int mes = cal.get(Calendar.MONTH) + 1;
//            int ano = cal.get(Calendar.YEAR);
//            System.out.println(mes);
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            cal.setTime(sdf.parse("1/" + mes + "/" + ano));
//            long timeinicio = cal.getTimeInMillis();
//            System.out.println(sdf.format(cal.getTime()));
//            cal.add(Calendar.DAY_OF_MONTH, 60);
//            System.out.println(sdf.format(cal.getTime()));
//            long timefim = cal.getTimeInMillis();
//            long time = timefim - timeinicio;
//            long dia = time / (1000 * 60 * 60 * 24);
//            System.out.println(dia);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
