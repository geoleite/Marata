package br.com.i9.marata.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.marata.transfer.*;

public class Gj_gnfe_empresaDAO extends ObjectDAO {

    public Gj_gnfe_empresaDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Gj_gnfe_empresaT gj_gnfe_empresaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into GJAV.GJ_GNFE_EMPRESA  ( COD_EMPRESA, CNPJ_EMPRESA, DEN_EMPRESA, ID_ENT) values ( ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_empresaT.getCod_empresa());
            pStmt.setObject(2, gj_gnfe_empresaT.getCnpj_empresa());
            pStmt.setObject(3, gj_gnfe_empresaT.getDen_empresa());
            pStmt.setObject(4, gj_gnfe_empresaT.getId_ent());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void update(Gj_gnfe_empresaT gj_gnfe_empresaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update GJAV.GJ_GNFE_EMPRESA set  COD_EMPRESA=?, CNPJ_EMPRESA=?, DEN_EMPRESA=?, ID_ENT=?  where -";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_empresaT.getCod_empresa());
            pStmt.setObject(2, gj_gnfe_empresaT.getCnpj_empresa());
            pStmt.setObject(3, gj_gnfe_empresaT.getDen_empresa());
            pStmt.setObject(4, gj_gnfe_empresaT.getId_ent());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void delete(Gj_gnfe_empresaT gj_gnfe_empresaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from GJAV.GJ_GNFE_EMPRESA where -";
            pStmt = con.prepareStatement(sql);
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    private List<Gj_gnfe_empresaT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Gj_gnfe_empresaT> objs = new Vector();
        while (rs.next()) {
            Gj_gnfe_empresaT gj_gnfe_empresaT = new Gj_gnfe_empresaT();
            gj_gnfe_empresaT.setCod_empresa(rs.getString("COD_EMPRESA"));
            gj_gnfe_empresaT.setCnpj_empresa(rs.getString("CNPJ_EMPRESA"));
            gj_gnfe_empresaT.setDen_empresa(rs.getString("DEN_EMPRESA"));
            gj_gnfe_empresaT.setId_ent(rs.getString("ID_ENT"));
            objs.add(gj_gnfe_empresaT);
        }
        return objs;
    }

    public List<Gj_gnfe_empresaT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from GJAV.GJ_GNFE_EMPRESA";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Gj_gnfe_empresaT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Gj_gnfe_empresaT> getByPK(Gj_gnfe_empresaT gj_gnfe_empresaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from GJAV.GJ_GNFE_EMPRESA where ";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Gj_gnfe_empresaT> getByCod_empresa(Gj_gnfe_empresaT gj_gnfe_empresaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from GJAV.GJ_GNFE_EMPRESA where  Upper(COD_EMPRESA) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + gj_gnfe_empresaT.getCod_empresa() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Gj_gnfe_empresaT> getByCnpj_empresa(Gj_gnfe_empresaT gj_gnfe_empresaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from GJAV.GJ_GNFE_EMPRESA where  Upper(CNPJ_EMPRESA) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + gj_gnfe_empresaT.getCnpj_empresa() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Gj_gnfe_empresaT> getByDen_empresa(Gj_gnfe_empresaT gj_gnfe_empresaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from GJAV.GJ_GNFE_EMPRESA where  Upper(DEN_EMPRESA) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + gj_gnfe_empresaT.getDen_empresa() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Gj_gnfe_empresaT> getById_ent(Gj_gnfe_empresaT gj_gnfe_empresaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from GJAV.GJ_GNFE_EMPRESA where  ID_ENT=? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_empresaT.getId_ent());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }
}
