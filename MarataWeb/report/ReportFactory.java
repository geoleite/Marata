/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.nfegen.report;

import br.com.easynet.nfegen.dao.Not_notaDAO;
import br.com.easynet.nfegen.transfer.Not_notaT;
import br.com.jdragon.dao.DAOFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class ReportFactory {

    public static List<Not_notaT> getDados() {
        try {
            String url = "jdbc:postgresql://127.0.0.1:5432/mcconsultoriae";
            String user = "postgres";
            String pass = "postgres";
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(url, user, pass);
            DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL, con);
            Not_notaDAO notDao = new Not_notaDAO(dao);
            List<Not_notaT> listNot = notDao.getAll();
            return listNot;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
