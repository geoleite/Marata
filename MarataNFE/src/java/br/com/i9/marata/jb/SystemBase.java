package br.com.i9.marata.jb;

import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.*;
import br.com.i9.marata.dao.*;
import br.com.i9.marata.transfer.*;
import java.util.List;
import br.com.easynet.easyportal.jb.EasySecurityJB;
import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.easyportal.transfer.Par_parametroT;

public class SystemBase extends EasySecurityJB implements INotSecurity {

    private int typeDatabase = DAOFactory.ORACLE;
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String user = "gjav";
    private String pass = "gjav";
    private DAOFactory dao;
    private String datasourceName = "java:comp/env/jdbc/maratads";
    public static final String NOME_SISTEMA = "MARATA";

    public DAOFactory getDAO() throws Exception {
        if (dao != null) {
            return dao;
        }
        dao = DAOFactory.getDAOFactory(DAOFactory.ORACLE, getDataSource(datasourceName).getConnection());
        return dao;
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

    public String getParametro(String nomeParam) throws Exception {
        Par_parametroT parT = super.getParametro(NOME_SISTEMA, nomeParam);
        return parT == null ? null : parT.getPar_tx_valor();
    }

    public Gj_gnfe_empresaDAO getGj_gnfe_empresaDAO() throws Exception {
        dao = getDAO();
        return new Gj_gnfe_empresaDAO(dao);
    }

    public Gj_gnfe_nota_fiscalDAO getGj_gnfe_nota_fiscalDAO() throws Exception {
        dao = getDAO();
        return new Gj_gnfe_nota_fiscalDAO(dao);
    }

    public Gnfe_cliente_fornecedorDAO getGnfe_cliente_fornecedorDAO() throws Exception {
        dao = getDAO();
        return new Gnfe_cliente_fornecedorDAO(dao);
    }

    public Gnfe_cliente_fornecedorT findbyIdGnfe_cliente_fornecedor(Gnfe_cliente_fornecedorT gnfe_cliente_fornecedorT) throws Exception {
        try {
            Gnfe_cliente_fornecedorDAO gnfe_cliente_fornecedorDAO = getGnfe_cliente_fornecedorDAO();

            List<Gnfe_cliente_fornecedorT> listTemp = gnfe_cliente_fornecedorDAO.getByPK(gnfe_cliente_fornecedorT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
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
