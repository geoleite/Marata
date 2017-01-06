package br.com.easynet.nfegen.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.nfegen.transfer.*;

public class De_dis_empDAO extends ObjectDAO {

    public De_dis_empDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(De_dis_empT de_dis_empT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easynfe.de_dis_emp  ( dis_nr_id, emp_nr_id) values ( ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, de_dis_empT.getDis_nr_id());
            pStmt.setObject(2, de_dis_empT.getEmp_nr_id());
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

    public void update(De_dis_empT de_dis_empT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easynfe.de_dis_emp set - where  dis_nr_id=? and emp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, de_dis_empT.getDis_nr_id());
            pStmt.setObject(2, de_dis_empT.getEmp_nr_id());
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

    public void delete(De_dis_empT de_dis_empT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easynfe.de_dis_emp where  dis_nr_id=? and emp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, de_dis_empT.getDis_nr_id());
            pStmt.setObject(2, de_dis_empT.getEmp_nr_id());
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

    private List<De_dis_empT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<De_dis_empT> objs = new Vector();
        while (rs.next()) {
            De_dis_empT de_dis_empT = new De_dis_empT();
            de_dis_empT.setDis_nr_id(rs.getInt("dis_nr_id"));
            de_dis_empT.setEmp_nr_id(rs.getInt("emp_nr_id"));
            objs.add(de_dis_empT);
        }
        return objs;
    }

    public List<De_dis_empT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.de_dis_emp";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<De_dis_empT> list = resultSetToObjectTransfer(rs);
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

    public List<De_dis_empT> getById(De_dis_empT de_dis_empT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.de_dis_emp where  dis_nr_id=? and emp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, de_dis_empT.getDis_nr_id());
            pStmt.setObject(2, de_dis_empT.getEmp_nr_id());
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

    public List<De_dis_empT> getByDis_nr_id(De_dis_empT de_dis_empT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.de_dis_emp where  dis_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, de_dis_empT.getDis_nr_id());
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

    public List<De_dis_empT> getByEmp_nr_id(De_dis_empT de_dis_empT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.de_dis_emp where  emp_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, de_dis_empT.getEmp_nr_id());
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
