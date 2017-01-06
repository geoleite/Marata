package br.com.easynet.nfegen.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.nfegen.transfer.*;

public class Not_notaDAO extends ObjectDAO {

    private PreparedStatement pStmt = null;
    private ResultSet rs = null;

    public Not_notaDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Not_notaT not_notaT) throws Exception {
        try {
            String sql = "insert into easynfe.not_nota  ( emp_nr_id, not_bt_arquivo, not_tx_identificador, not_tx_tipo, not_tx_cnpjcliente, dis_nr_id, not_dt_emissao, not_tx_numero) values ( ? , ? , ? , ? , ? , ?, ?, ? )";
//        String sql = "insert into easynfe.not_nota  ( emp_nr_id, not_tx_identificador, not_tx_tipo, not_tx_cnpjcliente, dis_nr_id, not_dt_emissao) values ( ? , ? , ? , ? , ? , ?)";
            PreparedStatement pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, not_notaT.getEmp_nr_id());
            pStmt.setObject(2, not_notaT.getNot_bt_arquivo());
            pStmt.setObject(3, not_notaT.getNot_tx_identificador());
            pStmt.setObject(4, not_notaT.getNot_tx_tipo());
            pStmt.setObject(5, not_notaT.getNot_tx_cnpjcliente());
            pStmt.setObject(6, not_notaT.getDis_nr_id());
            java.sql.Date dt = new java.sql.Date(not_notaT.getNot_dt_emissao().getTime());
            pStmt.setObject(7, dt);
            pStmt.setObject(8, not_notaT.getNot_tx_numero());

//        pStmt.setObject(1, not_notaT.getEmp_nr_id());
//        pStmt.setObject(2, not_notaT.getNot_tx_identificador());
//        pStmt.setObject(3, not_notaT.getNot_tx_tipo());
//        pStmt.setObject(4, not_notaT.getNot_tx_cnpjcliente());
//        pStmt.setObject(5, not_notaT.getDis_nr_id());
//        java.sql.Date dt = new java.sql.Date(not_notaT.getNot_dt_emissao().getTime());
//        pStmt.setObject(6, dt);
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

    public void update(Not_notaT not_notaT) throws Exception {
        try {
            String sql = "update easynfe.not_nota set  not_bt_arquivo=?, not_tx_identificador=?, not_tx_tipo=?, not_tx_cnpjcliente=?  where  emp_nr_id=? and not_nr_id=? and dis_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, not_notaT.getNot_bt_arquivo());
            pStmt.setObject(2, not_notaT.getNot_tx_identificador());
            pStmt.setObject(3, not_notaT.getNot_tx_tipo());
            pStmt.setObject(4, not_notaT.getNot_tx_cnpjcliente());
            pStmt.setObject(5, not_notaT.getEmp_nr_id());
            pStmt.setObject(6, not_notaT.getNot_nr_id());
            pStmt.setObject(7, not_notaT.getDis_nr_id());
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

    public void delete(Not_notaT not_notaT) throws Exception {
        try {
            String sql = "delete from easynfe.not_nota where  emp_nr_id=? and not_nr_id=? and dis_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, not_notaT.getEmp_nr_id());
            pStmt.setObject(2, not_notaT.getNot_nr_id());
            pStmt.setObject(3, not_notaT.getDis_nr_id());
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

    private List<Not_notaT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Not_notaT> objs = new Vector();
        while (rs.next()) {
            Not_notaT not_notaT = new Not_notaT();
            not_notaT.setEmp_nr_id(rs.getInt("emp_nr_id"));
            not_notaT.setNot_nr_id(rs.getInt("not_nr_id"));
            not_notaT.setNot_tx_identificador(rs.getString("not_tx_identificador"));
            not_notaT.setNot_tx_tipo(rs.getString("not_tx_tipo"));
            not_notaT.setNot_tx_cnpjcliente(rs.getString("not_tx_cnpjcliente"));
            not_notaT.setDis_nr_id(rs.getInt("dis_nr_id"));
            not_notaT.setNot_tx_numero(rs.getInt("not_tx_numero"));
            not_notaT.setNot_dt_emissao(rs.getDate("not_dt_emissao"));
            not_notaT.setNot_bln_cancelada(rs.getBoolean("not_bln_cancelada"));
            try {
                not_notaT.setEmp_tx_nome(rs.getString("emp_tx_nome"));
            } catch (Exception e) {
            }
            try {
                not_notaT.setDis_tx_nome(rs.getString("dis_tx_nome"));
            } catch (Exception e) {
            }
            objs.add(not_notaT);
        }
        return objs;
    }

    private List<Not_notaT> resultSetToObjectTransferArquivo(ResultSet rs) throws Exception {
        List<Not_notaT> objs = new Vector();
        while (rs.next()) {
            Not_notaT not_notaT = new Not_notaT();
            not_notaT.setNot_tx_identificador(rs.getString("not_tx_identificador"));
            not_notaT.setNot_bt_arquivo(rs.getBytes("not_bt_arquivo"));
            objs.add(not_notaT);
        }
        return objs;
    }

    private List<String> resultSetToObjectTransferNumeroNota(ResultSet rs) throws Exception {
        List<String> objs = new Vector();
        while (rs.next()) {
            objs.add(rs.getString("not_tx_numero"));
        }
        return objs;
    }

    public List<String> getNrNotasQuery(String sql) throws Exception {
        try {
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransferNumeroNota(rs);
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

    public List<Not_notaT> getAll() throws Exception {
        try {
            /*
not_notaT.setEmp_nr_id(rs.getInt("emp_nr_id"));
            not_notaT.setNot_nr_id(rs.getInt("not_nr_id"));
            not_notaT.setNot_tx_identificador(rs.getString("not_tx_identificador"));
            not_notaT.setNot_tx_tipo(rs.getString("not_tx_tipo"));
            not_notaT.setNot_tx_cnpjcliente(rs.getString("not_tx_cnpjcliente"));
            not_notaT.setDis_nr_id(rs.getInt("dis_nr_id"));
            not_notaT.setNot_tx_numero(rs.getInt("not_tx_numero"));
            not_notaT.setNot_dt_emissao(rs.getDate("not_dt_emissao"));
            not_notaT.setNot_bln_cancelada(rs.getBoolean("not_bln_cancelada"));
            try {
                not_notaT.setEmp_tx_nome(rs.getString("emp_tx_nome"));
            } catch (Exception e) {
            }
            try {
                not_notaT.setDis_tx_nome(rs.getString("dis_tx_nome"));
            } catch (Exception e) {
            }
             */
            String sql = "select not_nr_id, not_tx_numero, emp_nr_id, not_bln_cancelada, not_tx_identificador, not_tx_tipo, not_tx_cnpjcliente, dis_nr_id, not_dt_emissao from easynfe.not_nota";
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
     * Obtem o numero total de notas de uma distribuidora
     * @param notT
     * @return
     * @throws java.lang.Exception
     */
    public int getTotalNotasDistribuidora(Not_notaT notT) throws Exception {
        try {
            String sql = "select count(*) from easynfe.not_nota where dis_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, notT.getDis_nr_id());
            rs = pStmt.executeQuery();
            return rs.next() ? rs.getInt(1) : -1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
        return 0;

    }

    public List<Not_notaT> getById(Not_notaT not_notaT) throws Exception {
        try {
            String sql = "select not_nr_id, not_bln_cancelada, emp_nr_id, not_bln_cancelada, not_tx_identificador,not_tx_numero, not_tx_tipo, not_tx_cnpjcliente, dis_nr_id, not_dt_emissao from easynfe.not_nota where  emp_nr_id=? and not_nr_id=? and dis_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, not_notaT.getEmp_nr_id());
            pStmt.setObject(2, not_notaT.getNot_nr_id());
            pStmt.setObject(3, not_notaT.getDis_nr_id());
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

    public List<Not_notaT> getByEmp_nr_id(Not_notaT not_notaT) throws Exception {
        try {
            String sql = "select nt_nr_id, emp_nr_id, not_bln_cancelada, not_tx_identificador, not_tx_tipo, not_tx_cnpjcliente, dis_nr_id, not_dt_emissao from easynfe.not_nota where  emp_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, not_notaT.getEmp_nr_id());
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

    public List<Not_notaT> getByNot_nr_id(Not_notaT not_notaT) throws Exception {
        try {
            String sql = "select not_nr_id,not_tx_numero, emp_nr_id, not_bln_cancelada, not_tx_identificador, not_tx_tipo, not_tx_cnpjcliente, dis_nr_id, not_dt_emissao from easynfe.not_nota where  not_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, not_notaT.getNot_nr_id());
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

    public List<Not_notaT> getByNot_tx_identificador(Not_notaT not_notaT) throws Exception {
        try {
            String sql = "select not_nr_id, not_tx_numero not_bln_cancelada,, emp_nr_id, not_tx_identificador, not_tx_tipo, not_tx_cnpjcliente, dis_nr_id, not_dt_emissao from easynfe.not_nota where not_tx_identificador = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, not_notaT.getNot_tx_identificador());
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
     * Consulta as notas
     * @param cnpj CNPJ da empresa
     * @param not_notaT
     * @return
     * @throws java.lang.Exception
     */
    public List<Not_notaT> getByNot_tx_identificadorDownloadNota(String cnpj, Not_notaT not_notaT) throws Exception {
        try {
            String sql = "select not_tx_identificador, not_bln_cancelada, not_bt_arquivo from easynfe.not_nota nota, easynfe.emp_empresa emp where emp.emp_tx_cnpj like ? and emp.emp_nr_id=nota.emp_nr_id and not_tx_identificador = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cnpj + "%");
            pStmt.setObject(2, not_notaT.getNot_tx_identificador());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransferArquivo(rs);
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
     * COnsulta as notas
     * @param cnpj Cnpj da empresa
     * @param nrNfes
     * @return
     * @throws java.lang.Exception
     */
    public List<Not_notaT> getByNot_tx_identificadorDownloadNotas(String cnpj, String[] nrNfes) throws Exception {
        try {
            StringBuffer param = new StringBuffer();

            if (nrNfes != null && nrNfes.length > 0) {

                param.append("'").append(nrNfes[0]).append("'");
                for (int i = 1; i < nrNfes.length; i++) {
                    param.append(", '").append(nrNfes[i]).append("'");
                }
                String sql = "select not_tx_identificador, not_bt_arquivo from easynfe.not_nota nota, easynfe.emp_empresa emp where emp.emp_tx_cnpj like ? and emp.emp_nr_id=nota.emp_nr_id and not_tx_identificador  in (" + param.toString() + ")";
                pStmt = con.prepareStatement(sql);
                pStmt.setObject(1, cnpj + "%");
                rs = pStmt.executeQuery();
                return resultSetToObjectTransferArquivo(rs);
            }
            return new Vector<Not_notaT>();
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

    public List<Not_notaT> getByNot_tx_identificadorDownloadNota(Not_notaT not_notaT) throws Exception {
        try {
            String sql = "select not_tx_identificador, not_bt_arquivo from easynfe.not_nota where  not_tx_identificador = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, not_notaT.getNot_tx_identificador());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransferArquivo(rs);
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

    public List<Not_notaT> getByNot_tx_numero(Not_notaT not_notaT) throws Exception {
        try {
            String sql = "select not_tx_numero, not_nr_id, not_bln_cancelada, emp_nr_id, not_tx_identificador, not_tx_tipo, not_tx_cnpjcliente, dis_nr_id, not_dt_emissao from easynfe.not_nota where dis_nr_id=? and not_tx_numero = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, not_notaT.getDis_nr_id());
            pStmt.setObject(2, not_notaT.getNot_tx_numero());
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

    public List<Not_notaT> getByNot_tx_tipo(Not_notaT not_notaT) throws Exception {
        try {
            String sql = "select not_nr_id, emp_nr_id,not_bln_cancelada, not_tx_identificador, not_tx_tipo, not_tx_cnpjcliente, dis_nr_id, not_dt_emissao from easynfe.not_nota where  Upper(not_tx_tipo) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + not_notaT.getNot_tx_tipo() + '%');
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

    public List<Not_notaT> getByNot_tx_cnpjcliente(Not_notaT not_notaT) throws Exception {
        try {
            String sql = "select not_nr_id, emp_nr_id,not_bln_cancelada, not_tx_identificador, not_tx_tipo, not_tx_cnpjcliente, dis_nr_id, not_dt_emissao from easynfe.not_nota where  Upper(not_tx_cnpjcliente) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + not_notaT.getNot_tx_cnpjcliente() + '%');
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

    public List<Not_notaT> getByDis_nr_id(Not_notaT not_notaT) throws Exception {
        try {
            String sql = "select nt_nr_id, emp_nr_id,not_bln_cancelada, not_tx_identificador, not_tx_tipo, not_tx_cnpjcliente, dis_nr_id, not_dt_emissao from easynfe.not_nota where  dis_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, not_notaT.getDis_nr_id());
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

    public List<Not_notaT> getNotaEntrada(Not_notaT notT) throws Exception {
        try {
            String sql = "select not_tx_identificador, not_bt_arquivo from easynfe.not_nota where  not_nr_id=? ";
            pStmt = con.prepareStatement(sql);
            //pStmt.setObject(1, notT.getEmp_nr_id());
            pStmt.setObject(1, notT.getNot_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransferArquivo(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            pStmt.close();
        }
        return null;
    }
    public List<Not_notaT> getByIdArquivo(Not_notaT not_notaT) throws Exception {
        try {
            String sql = "select not_tx_identificador, not_bt_arquivo from easynfe.not_nota where  emp_nr_id=? and not_nr_id=? and dis_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, not_notaT.getEmp_nr_id());
            pStmt.setObject(2, not_notaT.getNot_nr_id());
            pStmt.setObject(3, not_notaT.getDis_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransferArquivo(rs);
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

    /** Many to One */
    public Emp_empresaT getByEmp_empresaT(Not_notaT not_notaT) throws Exception {
        Emp_empresaDAO dao = new Emp_empresaDAO(getDAOFactory());
        Emp_empresaT emp_empresaT = new Emp_empresaT();
        emp_empresaT.setEmp_nr_id(not_notaT.getEmp_nr_id());
        List<Emp_empresaT> list = dao.getById(emp_empresaT);
        return list.size() > 0 ? list.get(0) : null;
    }

    /** M�todos FK */
    public List<Not_notaT> getByEmp_empresa(Not_notaT not_notaT) throws Exception {
        try {
            String sql = "select not_nr_id, emp_nr_id, not_bln_cancelada, not_tx_identificador, not_tx_tipo, not_tx_cnpjcliente, dis_nr_id, not_dt_emissao from easynfe.not_nota where emp_empresa.emp_nr_id=? and emp_empresa.dis_nr_id=?  order by not_dt_emissao desc";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, not_notaT.getEmp_nr_id());
            pStmt.setObject(2, not_notaT.getDis_nr_id());
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

    public List<Not_notaT> executeQuery(String sql, List param) throws Exception {
        try {
            pStmt = con.prepareStatement(sql);
            for (int i = 0; i < param.size(); i++) {
                pStmt.setObject(i + 1, param.get(i));
            }
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
     * Preenche WEBSERVICE
     * @param cnpj CNPJ Cliente
     * @param dtInicio
     * @param dtFim
     * @return
     * @throws java.lang.Exception
     */
    public List<Not_notaT> getByCnpj_dtInicio_dtFim_DownloadNota(String cnpj, String cnpjDistribuidora, java.sql.Date dtInicio, java.sql.Date dtFim) throws Exception {
        try {


            //String sql = "select nota.not_bt_arquivo, nota.not_tx_identificador from easynfe.not_nota as nota, easynfe.dis_distribuidora as dist where nota.dis_nr_id = dist.dis_nr_id and not_dt_emissao between ? and ? and dist.dis_tx_cnpj =?";
            String sql = "select not_tx_numero, not_nr_id, not_bln_cancelada, nota.emp_nr_id, not_tx_identificador, not_tx_tipo, not_tx_cnpjcliente, nota.dis_nr_id, not_dt_emissao from easynfe.not_nota as nota, easynfe.dis_distribuidora dis, easynfe.emp_empresa emp where nota.emp_nr_id = emp.emp_nr_id and emp.emp_nr_id=nota.emp_nr_id and emp.emp_tx_cnpj like ? and not_dt_emissao between ? and ? and dis.dis_tx_cnpj = ? and dis.dis_nr_id=nota.dis_nr_id order by not_tx_identificador";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cnpj + "%");
            pStmt.setObject(2, dtInicio);
            pStmt.setObject(3, dtFim);
            pStmt.setObject(4, cnpjDistribuidora);

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
     * Obtem notas atraves do identificar para ser usado no ws
     * @param not_notaT
     * @param cnpj
     * @return
     * @throws java.lang.Exception
     */
    public List<Not_notaT> getByNot_tx_identificadorDownloadNotaWs(Not_notaT not_notaT, String cnpj) throws Exception {
        try {
            String sql = "select not_tx_identificador, not_bt_arquivo from easynfe.not_nota nota, easynfe.dis_distribuidora dis where  not_tx_identificador = ? and nota.dis_nr_id = dis.dis_nr_id and dis_tx_cnpj = ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, not_notaT.getNot_tx_identificador());
            pStmt.setObject(2, not_notaT.getNot_tx_cnpjcliente());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransferArquivo(rs);
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