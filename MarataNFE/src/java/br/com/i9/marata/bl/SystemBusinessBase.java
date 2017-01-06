package br.com.i9.marata.bl;
import br.com.easynet.bl.BusinessBase;
import br.com.jdragon.dao.*;
import br.com.i9.marata.dao.*;
import br.com.i9.marata.transfer.*;
import java.util.List;
import javax.sql.DataSource;



public class SystemBusinessBase extends BusinessBase {


  private int typeDatabase = DAOFactory.ORACLE;
  private String url  = "jdbc:oracle:thin:@localhost:1521:xe";
  private String user = "gjav";
  private String pass = "gjav";

  private DAOFactory dao;

  private String datasourceName = "java:comp/env/jdbc/NOME_CONEXAO";

  public DAOFactory getDAO() throws Exception {
    if (dao != null) {
      return dao;
    }
    return getDAO(typeDatabase, url, user, pass);
  }	 

  public DAOFactory getDAODataSource() throws Exception {

    DataSource ds = getDataSource(datasourceName);
    return DAOFactory.getDAOFactory(typeDatabase, ds.getConnection());
  }

  public DAOFactory getDAO(int typeDatabase, String url, String user, String pass) throws Exception {
    if (dao != null) {
      return dao;
    }
    return DAOFactory.getDAOFactory(typeDatabase, url, user, pass);	
  }

  public void close() {
    try {
	dao.close();
      dao = null;
    } catch (Exception e) {
      
    }
  }

/**
 * Metodo para validar a seguranca
 */
    public boolean valide(String metodo) throws Exception {
        // Logica da seguranca
        return true;
    }


    public Gj_gnfe_empresaDAO getGj_gnfe_empresaDAO() throws Exception {
    dao = getDAO();
    return new Gj_gnfe_empresaDAO(dao); 
  }


  public Gj_gnfe_nota_fiscalDAO getGj_gnfe_nota_fiscalDAO() throws Exception {
    dao = getDAO();
    return new Gj_gnfe_nota_fiscalDAO(dao); 
  }


	 

   
    public Gj_gnfe_empresaT findbyIdGj_gnfe_empresa(Gj_gnfe_empresaT gj_gnfe_empresaT) throws Exception {
        try {
            Gj_gnfe_empresaDAO gj_gnfe_empresaDAO = getGj_gnfe_empresaDAO();

            List<Gj_gnfe_empresaT> listTemp = gj_gnfe_empresaDAO.getByPK(gj_gnfe_empresaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }
 
 
 
    public Gj_gnfe_nota_fiscalT findbyIdGj_gnfe_nota_fiscal(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        try {
            Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO = getGj_gnfe_nota_fiscalDAO();

            List<Gj_gnfe_nota_fiscalT> listTemp = gj_gnfe_nota_fiscalDAO.getByPK(gj_gnfe_nota_fiscalT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }
 
 
	 

}
