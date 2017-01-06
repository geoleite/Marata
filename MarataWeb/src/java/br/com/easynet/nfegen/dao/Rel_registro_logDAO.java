package br.com.easynet.nfegen.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.nfegen.transfer.*;

public class Rel_registro_logDAO extends ObjectDAO {

    public Rel_registro_logDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Rel_registro_logT rel_registro_logT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easynfe.rel_registro_log  ( rel_tx_numeronota, rel_dt_datahora, dis_nr_id, rel_tx_ip, rel_tx_usuario) values (  ? , ?, ?, ?, ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, rel_registro_logT.getRel_tx_numeronota());
            pStmt.setObject(2, rel_registro_logT.getRel_dt_datahora());
            pStmt.setObject(3, rel_registro_logT.getDis_nr_id());
            pStmt.setObject(4, rel_registro_logT.getRel_tx_ip());
            pStmt.setObject(5, rel_registro_logT.getRel_tx_usuario());
            pStmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void update(Rel_registro_logT rel_registro_logT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easynfe.rel_registro_log set  rel_tx_numeronota=?, rel_dt_datahora=?  where  rel_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, rel_registro_logT.getRel_tx_numeronota());
            pStmt.setObject(2, rel_registro_logT.getRel_dt_datahora());
            pStmt.setObject(3, rel_registro_logT.getRel_nr_id());
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

    public void delete(Rel_registro_logT rel_registro_logT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easynfe.rel_registro_log where  rel_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, rel_registro_logT.getRel_nr_id());
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

    private List<Rel_registro_logT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Rel_registro_logT> objs = new Vector();
        while (rs.next()) {
            Rel_registro_logT rel_registro_logT = new Rel_registro_logT();
            rel_registro_logT.setRel_nr_id(rs.getLong("rel_nr_id"));
            rel_registro_logT.setRel_tx_numeronota(rs.getInt("rel_tx_numeronota"));
            rel_registro_logT.setRel_dt_datahora(rs.getTimestamp("rel_dt_datahora"));
            rel_registro_logT.setRel_tx_ip(rs.getString("rel_tx_ip"));
            rel_registro_logT.setRel_tx_usuario(rs.getString("rel_tx_usuario"));
            rel_registro_logT.setDis_nr_id(rs.getInt("dis_nr_id"));
            objs.add(rel_registro_logT);
        }
        return objs;
    }

    public List<Rel_registro_logT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.rel_registro_log";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Rel_registro_logT> list = resultSetToObjectTransfer(rs);
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

    public List<Rel_registro_logT> getAllDistribuidora(Dis_distribuidoraT disT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.rel_registro_log where dis_nr_id=? order by rel_dt_datahora desc";
            pStmt = con.prepareStatement(sql);
            pStmt.setInt(1, disT.getDis_nr_id());
            rs = pStmt.executeQuery();
            List<Rel_registro_logT> list = resultSetToObjectTransfer(rs);
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

    /**
     * Consulta o log das notas inseridas pela data
     * @param dtInicio
     * @param dtFim
     * @return
     * @throws java.lang.Exception
     */
    public List<Rel_registro_logT> getByData(Dis_distribuidoraT disT, java.sql.Date dtInicio, java.sql.Date dtFim) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.rel_registro_log where dis_nr_id=? and  rel_dt_datahora between ? and ? order by rel_dt_datahora desc";
            pStmt = con.prepareStatement(sql);
            pStmt.setInt(1, disT.getDis_nr_id());
            pStmt.setDate(2, dtInicio);
            pStmt.setDate(3, dtFim);
            rs = pStmt.executeQuery();
            List<Rel_registro_logT> list = resultSetToObjectTransfer(rs);
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

    public List<Rel_registro_logT> getByPK(Rel_registro_logT rel_registro_logT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.rel_registro_log where  rel_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, rel_registro_logT.getRel_nr_id());
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

    public List<Rel_registro_logT> getByRel_nr_id(Rel_registro_logT rel_registro_logT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.rel_registro_log where  rel_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, rel_registro_logT.getRel_nr_id());
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

    public List<Rel_registro_logT> getByRel_tx_numeronota(Rel_registro_logT rel_registro_logT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.rel_registro_log where  Upper(rel_tx_numeronota) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + rel_registro_logT.getRel_tx_numeronota() + '%');
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

    public List<Rel_registro_logT> getByRel_dt_datahora(Rel_registro_logT rel_registro_logT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easynfe.rel_registro_log where  rel_dt_datahora = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, rel_registro_logT.getRel_dt_datahora());
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
