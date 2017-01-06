package br.com.easynet.nfegen.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.nfegen.transfer.*;

public class Emp_empresaDAO extends ObjectDAO {

    public Emp_empresaDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Emp_empresaT emp_empresaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
/*
emp_tx_estado character varying(50) NOT NULL DEFAULT 'SE'::character varying,
  emp_tx_cidade character varying(50) NOT NULL DEFAULT 'Aracaju'::character varying,
  emp_tx_bairro character varying(100) NOT NULL DEFAULT ' '::character varying,
  emp_tx_endereco character varying(100) NOT NULL DEFAULT ' '::character varying,
  emp_tx_cep character varying(10) NOT NULL DEFAULT '49000000'::character varying,
  emp_tx_ie
 */
            String sql = "insert into easynfe.emp_empresa  (emp_tx_nome, emp_tx_cnpj, emp_tx_estado, emp_tx_cidade, emp_tx_bairro, emp_tx_endereco, emp_tx_cep, emp_tx_ie, emp_nr_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_empresaT.getEmp_tx_nome());
            pStmt.setObject(2, emp_empresaT.getEmp_tx_cnpj());
            pStmt.setObject(3, emp_empresaT.getEmp_tx_estado());
            pStmt.setObject(4, emp_empresaT.getEmp_tx_cidade());
            pStmt.setObject(5, emp_empresaT.getEmp_tx_bairro());
            pStmt.setObject(6, emp_empresaT.getEmp_tx_endereco());
            pStmt.setObject(7, emp_empresaT.getEmp_tx_cep());
            pStmt.setObject(8, emp_empresaT.getEmp_tx_ie());
            pStmt.setObject(9, emp_empresaT.getEmp_nr_id());
            pStmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void update(Emp_empresaT emp_empresaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easynfe.emp_empresa set  emp_tx_nome=?, emp_tx_cnpj=?  where  emp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_empresaT.getEmp_tx_nome());
            pStmt.setObject(2, emp_empresaT.getEmp_tx_cnpj());
            pStmt.setObject(3, emp_empresaT.getEmp_nr_id());
            pStmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }
    public void updateGeral(Emp_empresaT emp_empresaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easynfe.emp_empresa set  emp_nr_id_super=? where  emp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_empresaT.getEmp_nr_id_super());
            pStmt.setObject(2, emp_empresaT.getEmp_nr_id());
            pStmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }
        }

    }



    public void delete(Emp_empresaT emp_empresaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easynfe.emp_empresa where  emp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_empresaT.getEmp_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    private List<Emp_empresaT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Emp_empresaT> objs = new Vector();
/*
emp_tx_estado character varying(50) NOT NULL DEFAULT 'SE'::character varying,
  emp_tx_cidade character varying(50) NOT NULL DEFAULT 'Aracaju'::character varying,
  emp_tx_bairro character varying(100) NOT NULL DEFAULT ' '::character varying,
  emp_tx_endereco character varying(100) NOT NULL DEFAULT ' '::character varying,
  emp_tx_cep character varying(10) NOT NULL DEFAULT '49000000'::character varying,
  emp_tx_ie

 */
        while (rs.next()) {
            Emp_empresaT emp_empresaT = new Emp_empresaT();
            emp_empresaT.setEmp_nr_id(rs.getInt("emp_nr_id"));
            emp_empresaT.setEmp_tx_nome(rs.getString("emp_tx_nome"));
            emp_empresaT.setEmp_tx_estado(rs.getString("emp_tx_estado"));
            emp_empresaT.setEmp_tx_cidade(rs.getString("emp_tx_cidade"));
            emp_empresaT.setEmp_tx_bairro(rs.getString("emp_tx_bairro"));
            emp_empresaT.setEmp_tx_endereco(rs.getString("emp_tx_endereco"));
            emp_empresaT.setEmp_tx_cep(rs.getString("emp_tx_cep"));
            emp_empresaT.setEmp_tx_ie(rs.getString("emp_tx_ie"));
            emp_empresaT.setEmp_tx_cnpj(rs.getString("emp_tx_cnpj"));
            emp_empresaT.setEmp_nr_id_super(rs.getInt("emp_nr_id_super"));
            objs.add(emp_empresaT);
        }
        return objs;
    }

    public List<Emp_empresaT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.emp_empresa order by emp_tx_nome, emp_tx_cnpj";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
        return null;

    }

    public List<Emp_empresaT> getById(Emp_empresaT emp_empresaT) throws Exception {
        ResultSet rs = null;
        PreparedStatement pStmt = null;
        try {
            String sql = "select * from easynfe.emp_empresa where emp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_empresaT.getEmp_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
        return null;

    }

    /**
     * Obtém a lista das empresas associadas
     * @param emp_empresaT
     * @return
     * @throws Exception
     */
    public List<Emp_empresaT> getEmpresasAssociadas(Emp_empresaT emp_empresaT) throws Exception {
        ResultSet rs = null;
        PreparedStatement pStmt = null;
        try {
            String sql = "select * from easynfe.emp_empresa where emp_nr_id_super=? or emp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_empresaT.getEmp_nr_id());
            pStmt.setObject(2, emp_empresaT.getEmp_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
        return null;

    }
    /**
     * Obtém a empresa pelo cnpj
     * @param emp_empresaT
     * @return
     * @throws java.lang.Exception
     */
    public List<Emp_empresaT> getByCnpj(Emp_empresaT emp_empresaT) throws Exception {
        ResultSet rs = null;
        PreparedStatement pStmt = null;
        try {
            String sql = "select * from easynfe.emp_empresa where emp_tx_cnpj=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_empresaT.getEmp_tx_cnpj());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public List<Emp_empresaT> getByEmp_nr_id(Emp_empresaT emp_empresaT) throws Exception {
        ResultSet rs = null;
        PreparedStatement pStmt = null;
        try {
            String sql = "select * from easynfe.emp_empresa where  emp_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_empresaT.getEmp_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public List<Emp_empresaT> getByEmp_tx_nome(Emp_empresaT emp_empresaT) throws Exception {
        ResultSet rs = null;
        PreparedStatement pStmt = null;
        try {
            String sql = "select * from easynfe.emp_empresa where  upper(emp_tx_nome) like upper(?) order by emp_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, "%" + emp_empresaT.getEmp_tx_nome() + "%");
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    /**
     * Pesquisa todos os clientes de uma distribuidora
     * @param emp_empresaT
     * @return
     * @throws java.lang.Exception
     */
    public List<Emp_empresaT> getByDis_distribuidora(Dis_distribuidoraT dis_distribuidoraT) throws Exception {
        ResultSet rs = null;
        PreparedStatement pStmt = null;
        try {
            String sql = "select emp.* from easynfe.emp_empresa emp, easynfe.de_dis_emp de where de.dis_nr_id=? and de.emp_nr_id=emp.emp_nr_id order by emp_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, dis_distribuidoraT.getDis_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    /** One To Many */
    public List<Not_notaT> getByNot_notaTs(Emp_empresaT emp_empresaT) throws Exception {
        Not_notaDAO dao = new Not_notaDAO(getDAOFactory());
        Not_notaT not_notaT = new Not_notaT();
        not_notaT.setEmp_nr_id(emp_empresaT.getEmp_nr_id());
        List<Not_notaT> list = dao.getByEmp_empresa(not_notaT);
        return list;
    }
}