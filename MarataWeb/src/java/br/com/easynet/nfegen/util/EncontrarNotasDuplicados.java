/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.nfegen.util;

/**
 *
 * @author geoleite
 */
public class EncontrarNotasDuplicados {

    private static String driver = "org.postgresql.Driver";
    private static String url = "jdbc:postgresql://banco.nfeinbox.com.br";
    private static String user = "mcconsultoriae";
    private static String pass = "mc190174";

    public static void main() {
        try {
            Class.forName(driver);
            String sql = "select * from ";
        } catch (Exception e) {
        }
    }
}
