package br.com.easynet.nfegen.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.nfegen.transfer.*;

public class Con_contadorDAO extends ObjectDAO {

    public Con_contadorDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Con_contadorT con_contadorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easynfe.con_contador  ( con_nr_id, con_tx_cpf, con_tx_nome) values ( ? , ?, ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, con_contadorT.getCon_nr_id());
            pStmt.setObject(2, con_contadorT.getCon_tx_cpf());
            pStmt.setObject(3, con_contadorT.getCon_tx_nome());
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

    public void update(Con_contadorT con_contadorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easynfe.con_contador set  con_tx_cpf=?, con_tx_nome=?  where  con_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, con_contadorT.getCon_tx_cpf());
            pStmt.setObject(2, con_contadorT.getCon_tx_nome());
            pStmt.setObject(3, con_contadorT.getCon_nr_id());
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

    public void delete(Con_contadorT con_contadorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easynfe.con_contador where  con_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, con_contadorT.getCon_nr_id());
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

    private List<Con_contadorT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Con_contadorT> objs = new Vector();
        while (rs.next()) {
            Con_contadorT con_contadorT = new Con_contadorT();
            con_contadorT.setCon_nr_id(rs.getInt("con_nr_id"));
            con_contadorT.setCon_tx_cpf(rs.getString("con_tx_cpf"));
            con_contadorT.setCon_tx_nome(rs.getString("con_tx_nome"));
            objs.add(con_contadorT);
        }
        return objs;
    }

    public List<Con_contadorT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.con_contador";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Con_contadorT> list = resultSetToObjectTransfer(rs);
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

    public Con_contadorT getByDistribuidora(Dis_distribuidoraT dis_distribuidoraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select con.* from easynfe.con_contador con, easynfe.cd_con_dis cd where cd.dis_nr_id=? and cd.con_nr_id=con.con_nr_id";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, dis_distribuidoraT.getDis_nr_id());
            rs = pStmt.executeQuery();
            List<Con_contadorT> list = resultSetToObjectTransfer(rs);
            return list.size() > 0?list.get(0):null;
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

    public List<Con_contadorT> getByPK(Con_contadorT con_contadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.con_contador where  con_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, con_contadorT.getCon_nr_id());
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

    public List<Con_contadorT> getByCon_nr_id(Con_contadorT con_contadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.con_contador where  con_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, con_contadorT.getCon_nr_id());
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

    public List<Con_contadorT> getByCon_tx_cpf(Con_contadorT con_contadorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.con_contador where  Upper(con_tx_cpf) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + con_contadorT.getCon_tx_cpf() + '%');
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