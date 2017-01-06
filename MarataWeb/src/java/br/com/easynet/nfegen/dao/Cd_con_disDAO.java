package br.com.easynet.nfegen.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.nfegen.transfer.*;

public class Cd_con_disDAO extends ObjectDAO {

    public Cd_con_disDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Cd_con_disT cd_con_disT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easynfe.cd_con_dis  ( con_nr_id, dis_nr_id) values ( ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cd_con_disT.getCon_nr_id());
            pStmt.setObject(2, cd_con_disT.getDis_nr_id());
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

    public void update(Cd_con_disT cd_con_disT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easynfe.cd_con_dis set - where  con_nr_id=? and dis_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cd_con_disT.getCon_nr_id());
            pStmt.setObject(2, cd_con_disT.getDis_nr_id());
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

    public void delete(Cd_con_disT cd_con_disT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easynfe.cd_con_dis where  con_nr_id=? and dis_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cd_con_disT.getCon_nr_id());
            pStmt.setObject(2, cd_con_disT.getDis_nr_id());
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

    public void deleteContadorDistribuidora(Cd_con_disT cd_con_disT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easynfe.cd_con_dis where  dis_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cd_con_disT.getDis_nr_id());
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

    private List<Cd_con_disT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Cd_con_disT> objs = new Vector();
        while (rs.next()) {
            Cd_con_disT cd_con_disT = new Cd_con_disT();
            cd_con_disT.setCon_nr_id(rs.getInt("con_nr_id"));
            cd_con_disT.setDis_nr_id(rs.getInt("dis_nr_id"));
            objs.add(cd_con_disT);
        }
        return objs;
    }

    public List<Cd_con_disT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.cd_con_dis";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Cd_con_disT> list = resultSetToObjectTransfer(rs);
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

    public List<Cd_con_disT> getByPK(Cd_con_disT cd_con_disT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.cd_con_dis where  con_nr_id=? and dis_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cd_con_disT.getCon_nr_id());
            pStmt.setObject(2, cd_con_disT.getDis_nr_id());
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

    public List<Cd_con_disT> getByCon_nr_id(Cd_con_disT cd_con_disT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.cd_con_dis where  con_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cd_con_disT.getCon_nr_id());
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

    public List<Cd_con_disT> getByDis_nr_id(Cd_con_disT cd_con_disT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.cd_con_dis where  dis_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cd_con_disT.getDis_nr_id());
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

    /** M�todos FK */
    public List<Cd_con_disT> getByCon_contador(Cd_con_disT cd_con_disT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.cd_con_dis where con_contador.con_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cd_con_disT.getCon_nr_id());
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
