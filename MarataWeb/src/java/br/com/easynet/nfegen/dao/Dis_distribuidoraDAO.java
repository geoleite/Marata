package br.com.easynet.nfegen.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.nfegen.transfer.*;

public class Dis_distribuidoraDAO extends ObjectDAO {

    private static String sinal = "sinal";

    public Dis_distribuidoraDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    private void getAutoIncremento(Dis_distribuidoraT dis_distribuidoraT) throws Exception {
        String sql = "select max(dis_nr_id) as codigo from easynfe.dis_distribuidora";
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            if (rs.next()) {
                dis_distribuidoraT.setDis_nr_id(rs.getInt("codigo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            pStmt.close();
        }
    }

    public void insert(Dis_distribuidoraT dis_distribuidoraT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easynfe.dis_distribuidora  (dis_nr_id, dis_tx_nome, dis_tx_cnpj, dis_nr_id_super, dis_tx_status) values (?, ? , ?, ?, ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, dis_distribuidoraT.getDis_nr_id());
            pStmt.setObject(2, dis_distribuidoraT.getDis_tx_nome());
            pStmt.setObject(3, dis_distribuidoraT.getDis_tx_cnpj());
            pStmt.setObject(4, dis_distribuidoraT.getDis_nr_id_super());
            pStmt.setObject(5, dis_distribuidoraT.getDis_tx_status());
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

    public void update(Dis_distribuidoraT dis_distribuidoraT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easynfe.dis_distribuidora set  dis_tx_nome=?, dis_tx_cnpj=?, dis_nr_id_super=?  where  dis_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, dis_distribuidoraT.getDis_tx_nome());
            pStmt.setObject(2, dis_distribuidoraT.getDis_tx_cnpj());
            pStmt.setObject(3, dis_distribuidoraT.getDis_nr_id_super());
            pStmt.setObject(4, dis_distribuidoraT.getDis_nr_id());
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

    public void delete(Dis_distribuidoraT dis_distribuidoraT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easynfe.dis_distribuidora where  dis_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, dis_distribuidoraT.getDis_nr_id());
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

    private List<Dis_distribuidoraT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Dis_distribuidoraT> objs = new Vector();
        while (rs.next()) {
            Dis_distribuidoraT dis_distribuidoraT = new Dis_distribuidoraT();
            dis_distribuidoraT.setDis_nr_id(rs.getInt("dis_nr_id"));
            dis_distribuidoraT.setDis_tx_nome(rs.getString("dis_tx_nome"));
            dis_distribuidoraT.setDis_tx_cnpj(rs.getString("dis_tx_cnpj"));
            dis_distribuidoraT.setDis_nr_id_super(rs.getInt("dis_nr_id_super"));
            dis_distribuidoraT.setDis_tx_status(rs.getString("dis_tx_status"));
            objs.add(dis_distribuidoraT);
        }
        return objs;
    }

    public List<Dis_distribuidoraT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.dis_distribuidora where dis_tx_status='A' order by dis_tx_nome, dis_tx_cnpj";
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

    /**
     * Obtém as distribuidoras associadas
     * @return
     * @throws Exception
     */
    public List<Dis_distribuidoraT> getAllDistribuidorasAssociadas(Dis_distribuidoraT disT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.dis_distribuidora where dis_tx_status='A' and dis_nr_id=? or dis_nr_id_super=? order by dis_tx_nome, dis_tx_cnpj";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, disT.getDis_nr_id());
            pStmt.setObject(2, disT.getDis_nr_id());
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
     * Consulta distribuidoras de uma empresa
     * @param empT
     * @return
     * @throws java.lang.Exception
     */
    public List<Dis_distribuidoraT> getDistribuidorasEmpresa(Emp_empresaT empT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select dis.* from easynfe.dis_distribuidora dis, easynfe.de_dis_emp de where dis_tx_status='A' and de.emp_nr_id=? and de.dis_nr_id=dis.dis_nr_id";
            pStmt = con.prepareStatement(sql);
            pStmt.setInt(1, empT.getEmp_nr_id());
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
     * Obtem as distribuidoras de um contador
     * @param conT
     * @return
     * @throws java.lang.Exception
     */
    public List<Dis_distribuidoraT> getDistribuidorasContador(Con_contadorT conT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select dis.* from easynfe.dis_distribuidora dis, easynfe.cd_con_dis cd where dis_tx_status='A' and cd.con_nr_id=? and cd.dis_nr_id=dis.dis_nr_id";
            pStmt = con.prepareStatement(sql);
            pStmt.setInt(1, conT.getCon_nr_id());
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

    public List<Dis_distribuidoraT> getById(Dis_distribuidoraT dis_distribuidoraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.dis_distribuidora where  dis_nr_id=?";
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

    public List<Dis_distribuidoraT> getByDis_nr_id(Dis_distribuidoraT dis_distribuidoraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.dis_distribuidora where  dis_nr_id = ? ";
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

    public List<Dis_distribuidoraT> getByDis_tx_nome(Dis_distribuidoraT dis_distribuidoraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {

            String sql = "select * from easynfe.dis_distribuidora where  Upper(dis_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + dis_distribuidoraT.getDis_tx_nome() + '%');
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

    public List<Dis_distribuidoraT> getByDis_tx_cnpj(Dis_distribuidoraT dis_distribuidoraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.dis_distribuidora where  Upper(dis_tx_cnpj) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + dis_distribuidoraT.getDis_tx_cnpj() + '%');
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
