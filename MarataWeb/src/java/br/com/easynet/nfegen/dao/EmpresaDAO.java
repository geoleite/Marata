/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.nfegen.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.nfegen.transfer.*;

/**
 *
 * @author geoleite
 */
public class EmpresaDAO extends ObjectDAO {

    public EmpresaDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(EmpresaT empresaT) {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into gjav.GJ_GNFE_EMPRESA  (cod_empresa, cnpj_empresa, den_empresa, id_ent) values (?, ?, ?, ?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, empresaT.getCodEmpresa());
            pStmt.setObject(2, empresaT.getCnpjEmpresa());
            pStmt.setObject(3, empresaT.getDenEmpresa());
            pStmt.setObject(4, empresaT.getIdEnt());
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

    private List<EmpresaT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<EmpresaT> objs = new Vector();
        while (rs.next()) {
            EmpresaT emp_empresaT = new EmpresaT();
            emp_empresaT.setCodEmpresa(rs.getString("cod_empresa"));
            emp_empresaT.setCnpjEmpresa(rs.getString("cnpj_empresa"));
            emp_empresaT.setDenEmpresa(rs.getString("den_empresa"));
            emp_empresaT.setIdEnt(rs.getString("id_ent"));
            objs.add(emp_empresaT);
        }
        return objs;
    }

    public List<EmpresaT> getByCNPJ(EmpresaT empresaT ) {
        ResultSet rs = null;
        PreparedStatement pStmt = null;
        try {
            String sql = "select * from gjav.GJ_gnfe_empresa where cnpj_empresa=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, empresaT.getCnpjEmpresa());
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

}
