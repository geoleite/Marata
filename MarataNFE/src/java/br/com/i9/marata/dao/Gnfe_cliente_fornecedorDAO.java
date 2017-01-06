package br.com.i9.marata.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.marata.transfer.*;

public class Gnfe_cliente_fornecedorDAO extends ObjectDAO {

    public Gnfe_cliente_fornecedorDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Gnfe_cliente_fornecedorT gnfe_cliente_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into GJAV.GNFE_CLIENTE_FORNECEDOR  ( CODIGO, RAZAO, STATUS, TIPO) values ( ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gnfe_cliente_fornecedorT.getCodigo());
            pStmt.setObject(2, gnfe_cliente_fornecedorT.getRazao());
            pStmt.setObject(3, gnfe_cliente_fornecedorT.getStatus());
            pStmt.setObject(4, gnfe_cliente_fornecedorT.getTipo());
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

    public void update(Gnfe_cliente_fornecedorT gnfe_cliente_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update GJAV.GNFE_CLIENTE_FORNECEDOR set  CODIGO=?, RAZAO=?, STATUS=?, TIPO=?  where -";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gnfe_cliente_fornecedorT.getCodigo());
            pStmt.setObject(2, gnfe_cliente_fornecedorT.getRazao());
            pStmt.setObject(3, gnfe_cliente_fornecedorT.getStatus());
            pStmt.setObject(4, gnfe_cliente_fornecedorT.getTipo());
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

    public void delete(Gnfe_cliente_fornecedorT gnfe_cliente_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from GJAV.GNFE_CLIENTE_FORNECEDOR where -";
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

    private List<Gnfe_cliente_fornecedorT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Gnfe_cliente_fornecedorT> objs = new Vector();
        while (rs.next()) {
            Gnfe_cliente_fornecedorT gnfe_cliente_fornecedorT = new Gnfe_cliente_fornecedorT();
            gnfe_cliente_fornecedorT.setCodigo(rs.getString("CODIGO"));
            gnfe_cliente_fornecedorT.setRazao(rs.getString("RAZAO"));
            gnfe_cliente_fornecedorT.setNum_cgc_cpf(rs.getString("NUM_CGC_CPF"));
            gnfe_cliente_fornecedorT.setStatus(rs.getString("STATUS"));
            gnfe_cliente_fornecedorT.setTipo(rs.getString("TIPO"));
            objs.add(gnfe_cliente_fornecedorT);
        }
        return objs;
    }

    public List<Gnfe_cliente_fornecedorT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from GJAV.GNFE_CLIENTE_FORNECEDOR";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Gnfe_cliente_fornecedorT> list = resultSetToObjectTransfer(rs);
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

    public List<Gnfe_cliente_fornecedorT> getByPK(Gnfe_cliente_fornecedorT gnfe_cliente_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from GJAV.GNFE_CLIENTE_FORNECEDOR where -";
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

    public List<Gnfe_cliente_fornecedorT> getByCodigo(Gnfe_cliente_fornecedorT gnfe_cliente_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from GJAV.GNFE_CLIENTE_FORNECEDOR where  CODIGO=? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gnfe_cliente_fornecedorT.getCodigo());
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

    public List<Gnfe_cliente_fornecedorT> getByNumCgcCpf(Gnfe_cliente_fornecedorT gnfe_cliente_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from GJAV.GNFE_CLIENTE_FORNECEDOR where  num_cgc_cpf = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gnfe_cliente_fornecedorT.getNum_cgc_cpf());
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

    public List<Gnfe_cliente_fornecedorT> getByRazao(Gnfe_cliente_fornecedorT gnfe_cliente_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from GJAV.GNFE_CLIENTE_FORNECEDOR where  Upper(RAZAO) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + gnfe_cliente_fornecedorT.getRazao() + '%');
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

    public List<Gnfe_cliente_fornecedorT> getByStatus(Gnfe_cliente_fornecedorT gnfe_cliente_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from GJAV.GNFE_CLIENTE_FORNECEDOR where  Upper(STATUS) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + gnfe_cliente_fornecedorT.getStatus() + '%');
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

    public List<Gnfe_cliente_fornecedorT> getByTipo(Gnfe_cliente_fornecedorT gnfe_cliente_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from GJAV.GNFE_CLIENTE_FORNECEDOR where  Upper(TIPO) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + gnfe_cliente_fornecedorT.getTipo() + '%');
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
