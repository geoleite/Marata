package br.com.i9.marata.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.marata.transfer.*;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class Gj_gnfe_nota_fiscalDAO extends ObjectDAO {

    public Gj_gnfe_nota_fiscalDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into GJAV.GJ_GNFE_NOTA_FISCAL  ( ID_ENT, NFE_ID, REG_NFE, DES_REG, MODELO, AMBIENTE, MODALIDADE, STATUS, CSTATUS_SEFR, XMOT_SEFR, XML_SIG, XML_SIG_MAIL, PROT, DATE_PROT, XML_PROT, XML_PROT_MAIL, ORIGEM, STATUS_JAVA, STATUS_TOTVS, TOTVS_COD_EMPRESA, TOTVS_NUM_AR, TOTVS_NUM_NFE, TOTVS_SER_NFE, TOTVS_SSR_NFE, TOTVS_EMI_NFE, TOTVS_DES_NFE, TOTVS_DAT_NFE, TOTVS_VAL_NFE, NUM_CGC_CPF) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getId_ent());
            pStmt.setObject(2, gj_gnfe_nota_fiscalT.getNfe_id());
            pStmt.setObject(3, gj_gnfe_nota_fiscalT.getReg_nfe());
            pStmt.setObject(4, gj_gnfe_nota_fiscalT.getDes_reg());
            pStmt.setObject(5, gj_gnfe_nota_fiscalT.getModelo());
            pStmt.setObject(6, gj_gnfe_nota_fiscalT.getAmbiente());
            pStmt.setObject(7, gj_gnfe_nota_fiscalT.getModalidade());
            pStmt.setObject(8, gj_gnfe_nota_fiscalT.getStatus());
            pStmt.setObject(9, gj_gnfe_nota_fiscalT.getCstatus_sefr());
            pStmt.setObject(10, gj_gnfe_nota_fiscalT.getXmot_sefr());
            pStmt.setObject(11, gj_gnfe_nota_fiscalT.getXml_sig());
            pStmt.setObject(12, gj_gnfe_nota_fiscalT.getXml_sig_mail());
            pStmt.setObject(13, gj_gnfe_nota_fiscalT.getProt());
            java.sql.Date dt = new java.sql.Date(gj_gnfe_nota_fiscalT.getDate_prot().getTime());
            pStmt.setObject(14, dt);
            pStmt.setObject(15, gj_gnfe_nota_fiscalT.getXml_prot());
            pStmt.setObject(16, gj_gnfe_nota_fiscalT.getXml_prot_mail());
            pStmt.setObject(17, gj_gnfe_nota_fiscalT.getOrigem());
            pStmt.setObject(18, gj_gnfe_nota_fiscalT.getStatus_java());
            pStmt.setObject(19, gj_gnfe_nota_fiscalT.getStatus_totvs());
            pStmt.setObject(20, gj_gnfe_nota_fiscalT.getTotvs_cod_empresa());
            pStmt.setObject(21, gj_gnfe_nota_fiscalT.getTotvs_num_ar());
            pStmt.setObject(22, gj_gnfe_nota_fiscalT.getTotvs_num_nfe());
            pStmt.setObject(23, gj_gnfe_nota_fiscalT.getTotvs_ser_nfe());
            pStmt.setObject(24, gj_gnfe_nota_fiscalT.getTotvs_ssr_nfe());
            pStmt.setObject(25, gj_gnfe_nota_fiscalT.getTotvs_emi_nfe());
            pStmt.setObject(26, gj_gnfe_nota_fiscalT.getTotvs_des_nfe());
            java.sql.Date dt27 = new java.sql.Date(gj_gnfe_nota_fiscalT.getTotvs_dat_nfe().getTime());
            pStmt.setObject(27, dt27);
            pStmt.setObject(28, gj_gnfe_nota_fiscalT.getTotvs_val_nfe());
            pStmt.setObject(29, gj_gnfe_nota_fiscalT.getNum_cgc_cpf());
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

    public void update(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update GJAV.GJ_GNFE_NOTA_FISCAL set  ID_ENT=?, NFE_ID=?, REG_NFE=?, DES_REG=?, MODELO=?, AMBIENTE=?, MODALIDADE=?, STATUS=?, CSTATUS_SEFR=?, XMOT_SEFR=?, XML_SIG=?, XML_SIG_MAIL=?, PROT=?, DATE_PROT=?, XML_PROT=?, XML_PROT_MAIL=?, ORIGEM=?, STATUS_JAVA=?, STATUS_TOTVS=?, TOTVS_COD_EMPRESA=?, TOTVS_NUM_AR=?, TOTVS_NUM_NFE=?, TOTVS_SER_NFE=?, TOTVS_SSR_NFE=?, TOTVS_EMI_NFE=?, TOTVS_DES_NFE=?, TOTVS_DAT_NFE=?, TOTVS_VAL_NFE=?, NUM_CGC_CPF=?  where -";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getId_ent());
            pStmt.setObject(2, gj_gnfe_nota_fiscalT.getNfe_id());
            pStmt.setObject(3, gj_gnfe_nota_fiscalT.getReg_nfe());
            pStmt.setObject(4, gj_gnfe_nota_fiscalT.getDes_reg());
            pStmt.setObject(5, gj_gnfe_nota_fiscalT.getModelo());
            pStmt.setObject(6, gj_gnfe_nota_fiscalT.getAmbiente());
            pStmt.setObject(7, gj_gnfe_nota_fiscalT.getModalidade());
            pStmt.setObject(8, gj_gnfe_nota_fiscalT.getStatus());
            pStmt.setObject(9, gj_gnfe_nota_fiscalT.getCstatus_sefr());
            pStmt.setObject(10, gj_gnfe_nota_fiscalT.getXmot_sefr());
            pStmt.setObject(11, gj_gnfe_nota_fiscalT.getXml_sig());
            pStmt.setObject(12, gj_gnfe_nota_fiscalT.getXml_sig_mail());
            pStmt.setObject(13, gj_gnfe_nota_fiscalT.getProt());
            java.sql.Date dt = new java.sql.Date(gj_gnfe_nota_fiscalT.getDate_prot().getTime());
            pStmt.setObject(14, dt);
            pStmt.setObject(15, gj_gnfe_nota_fiscalT.getXml_prot());
            pStmt.setObject(16, gj_gnfe_nota_fiscalT.getXml_prot_mail());
            pStmt.setObject(17, gj_gnfe_nota_fiscalT.getOrigem());
            pStmt.setObject(18, gj_gnfe_nota_fiscalT.getStatus_java());
            pStmt.setObject(19, gj_gnfe_nota_fiscalT.getStatus_totvs());
            pStmt.setObject(20, gj_gnfe_nota_fiscalT.getTotvs_cod_empresa());
            pStmt.setObject(21, gj_gnfe_nota_fiscalT.getTotvs_num_ar());
            pStmt.setObject(22, gj_gnfe_nota_fiscalT.getTotvs_num_nfe());
            pStmt.setObject(23, gj_gnfe_nota_fiscalT.getTotvs_ser_nfe());
            pStmt.setObject(24, gj_gnfe_nota_fiscalT.getTotvs_ssr_nfe());
            pStmt.setObject(25, gj_gnfe_nota_fiscalT.getTotvs_emi_nfe());
            pStmt.setObject(26, gj_gnfe_nota_fiscalT.getTotvs_des_nfe());
            java.sql.Date dt27 = new java.sql.Date(gj_gnfe_nota_fiscalT.getTotvs_dat_nfe().getTime());
            pStmt.setObject(27, dt27);
            pStmt.setObject(28, gj_gnfe_nota_fiscalT.getTotvs_val_nfe());
            pStmt.setObject(29, gj_gnfe_nota_fiscalT.getNum_cgc_cpf());
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

    public void delete(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from GJAV.GJ_GNFE_NOTA_FISCAL where -";
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

    private List<Gj_gnfe_nota_fiscalT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Gj_gnfe_nota_fiscalT> objs = new Vector();
        while (rs.next()) {
//ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF
            Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT = new Gj_gnfe_nota_fiscalT();
            gj_gnfe_nota_fiscalT.setId_ent(rs.getString("ID_ENT"));
            gj_gnfe_nota_fiscalT.setNfe_id(rs.getString("NFE_ID"));
            gj_gnfe_nota_fiscalT.setReg_nfe(rs.getInt("reg_nfe"));
            gj_gnfe_nota_fiscalT.setDes_reg(rs.getString("DES_REG"));
            gj_gnfe_nota_fiscalT.setModelo(rs.getString("MODELO"));
            gj_gnfe_nota_fiscalT.setAmbiente(rs.getInt("AMBIENTE"));
            gj_gnfe_nota_fiscalT.setModalidade(rs.getInt("MODALIDADE"));
            gj_gnfe_nota_fiscalT.setStatus(rs.getInt("STATUS"));
            gj_gnfe_nota_fiscalT.setCstatus_sefr(rs.getString("CSTATUS_SEFR"));
            gj_gnfe_nota_fiscalT.setXmot_sefr(rs.getString("XMOT_SEFR"));
            //gj_gnfe_nota_fiscalT.setXml_sig(rs.getBytes("XML_SIG"));
            //gj_gnfe_nota_fiscalT.setXml_sig_mail(rs.getBytes("XML_SIG_MAIL"));
            gj_gnfe_nota_fiscalT.setProt(rs.getString("PROT"));
            gj_gnfe_nota_fiscalT.setDate_prot(rs.getDate("DATE_PROT"));
            //gj_gnfe_nota_fiscalT.setXml_prot(rs.getBytes("XML_PROT"));
            //gj_gnfe_nota_fiscalT.setXml_prot_mail(rs.getBytes("XML_PROT_MAIL"));
            gj_gnfe_nota_fiscalT.setOrigem(rs.getInt("ORIGEM"));
            gj_gnfe_nota_fiscalT.setStatus_java(rs.getInt("STATUS_JAVA"));
            gj_gnfe_nota_fiscalT.setStatus_totvs(rs.getInt("STATUS_TOTVS"));
            gj_gnfe_nota_fiscalT.setTotvs_cod_empresa(rs.getString("TOTVS_COD_EMPRESA"));
            gj_gnfe_nota_fiscalT.setTotvs_num_ar(rs.getInt("TOTVS_NUM_AR"));
            Object objTotvsNumNfe = rs.getInt("TOTVS_NUM_NFE");
            gj_gnfe_nota_fiscalT.setTotvs_num_nfe(objTotvsNumNfe == null ? 0 : (Integer) objTotvsNumNfe);
            gj_gnfe_nota_fiscalT.setTotvs_ser_nfe(rs.getString("TOTVS_SER_NFE"));
            gj_gnfe_nota_fiscalT.setTotvs_ssr_nfe(rs.getInt("TOTVS_SSR_NFE"));
            gj_gnfe_nota_fiscalT.setTotvs_emi_nfe(rs.getString("TOTVS_EMI_NFE"));
            gj_gnfe_nota_fiscalT.setTotvs_des_nfe(rs.getString("TOTVS_DES_NFE"));
            gj_gnfe_nota_fiscalT.setTotvs_dat_nfe(rs.getDate("TOTVS_DAT_NFE"));
            gj_gnfe_nota_fiscalT.setTotvs_val_nfe(rs.getDouble("TOTVS_VAL_NFE"));
            gj_gnfe_nota_fiscalT.setNum_cgc_cpf(rs.getString("NUM_CGC_CPF"));
            objs.add(gj_gnfe_nota_fiscalT);
        }
        return objs;
    }

    private byte[] getBytesFromInputStream(InputStream is) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (is != null) {
            byte[] buffer = new byte[1024];
            int control = -1;
            while ((control = is.read(buffer)) != -1) {
                byte[] temp = new byte[control];
                System.arraycopy(buffer, 0, temp, 0, control);
                baos.write(temp);
            }
            return baos.toByteArray();
        }
        return null;
    }

    private List<Gj_gnfe_nota_fiscalT> resultSetToObjectTransferArquivo(ResultSet rs) throws Exception {
        List<Gj_gnfe_nota_fiscalT> objs = new Vector();
        while (rs.next()) {
            Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT = new Gj_gnfe_nota_fiscalT();
            gj_gnfe_nota_fiscalT.setId_ent(rs.getString("ID_ENT"));
            gj_gnfe_nota_fiscalT.setNfe_id(rs.getString("NFE_ID"));
//            gj_gnfe_nota_fiscalT.setXml_sig_mail(rs.getBytes("XML_SIG_MAIL"));
            try {
                Blob b = rs.getBlob("XML_SIG_MAIL");
                byte[] bytes = getBytesFromInputStream(b.getBinaryStream());
                gj_gnfe_nota_fiscalT.setXml_sig_mail(bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }

            gj_gnfe_nota_fiscalT.setNum_cgc_cpf(rs.getString("NUM_CGC_CPF"));
            gj_gnfe_nota_fiscalT.setXml(rs.getString("xml"));
            objs.add(gj_gnfe_nota_fiscalT);
        }
        return objs;
    }

    public List<Gj_gnfe_nota_fiscalT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Gj_gnfe_nota_fiscalT> list = resultSetToObjectTransfer(rs);
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

    public List<Gj_gnfe_nota_fiscalT> getByPK(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where -";
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

    public List<Gj_gnfe_nota_fiscalT> getById_ent(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  Upper(ID_ENT) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + gj_gnfe_nota_fiscalT.getId_ent() + '%');
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

    public List<Gj_gnfe_nota_fiscalT> getByNfe(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  NFE_ID = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getNfe_id());
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

    public List<Gj_gnfe_nota_fiscalT> getByReg_nfe(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  REG_NFE = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getReg_nfe());
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

    public List<Gj_gnfe_nota_fiscalT> getByDes_reg(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  Upper(DES_REG) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + gj_gnfe_nota_fiscalT.getDes_reg() + '%');
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

    public List<Gj_gnfe_nota_fiscalT> getByModelo(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  Upper(MODELO) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + gj_gnfe_nota_fiscalT.getModelo() + '%');
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

    public List<Gj_gnfe_nota_fiscalT> getByAmbiente(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  AMBIENTE = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getAmbiente());
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

    public List<Gj_gnfe_nota_fiscalT> getByModalidade(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  MODALIDADE = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getModalidade());
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

    public List<Gj_gnfe_nota_fiscalT> getByStatus(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  STATUS = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getStatus());
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

    public List<Gj_gnfe_nota_fiscalT> getByCstatus_sefr(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  Upper(CSTATUS_SEFR) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + gj_gnfe_nota_fiscalT.getCstatus_sefr() + '%');
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

    public List<Gj_gnfe_nota_fiscalT> getByXmot_sefr(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  Upper(XMOT_SEFR) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + gj_gnfe_nota_fiscalT.getXmot_sefr() + '%');
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

    public List<Gj_gnfe_nota_fiscalT> getByXml_sig(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from GJAV.GJ_GNFE_NOTA_FISCAL where  XML_SIG = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getXml_sig());
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

    public Gj_gnfe_nota_fiscalT getByXml_sig_mailNfeId(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select id_ent, nfe_id, xml_sig_mail, num_cgc_cpf, f(xml_sig_mail) as xml from GJAV.GJ_GNFE_NOTA_FISCAL where  nfe_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getNfe_id());
            rs = pStmt.executeQuery();
            List<Gj_gnfe_nota_fiscalT> list = resultSetToObjectTransferArquivo(rs);
            return list.size() > 0 ? list.get(0) : null;
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

    public List<Gj_gnfe_nota_fiscalT> getByProt(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  Upper(PROT) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + gj_gnfe_nota_fiscalT.getProt() + '%');
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

    public List<Gj_gnfe_nota_fiscalT> getByDate_prot(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  DATE_PROT = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getDate_prot());
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

    public List<Gj_gnfe_nota_fiscalT> getByXml_prot(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  XML_PROT = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getXml_prot());
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

    public List<Gj_gnfe_nota_fiscalT> getByXml_prot_mail(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from GJAV.GJ_GNFE_NOTA_FISCAL where  XML_PROT_MAIL = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getXml_prot_mail());
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

    public List<Gj_gnfe_nota_fiscalT> getByOrigem(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  ORIGEM = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getOrigem());
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

    public List<Gj_gnfe_nota_fiscalT> getByStatus_java(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  STATUS_JAVA = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getStatus_java());
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

    public List<Gj_gnfe_nota_fiscalT> getByStatus_totvs(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  STATUS_TOTVS = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getStatus_totvs());
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

    public List<Gj_gnfe_nota_fiscalT> getByTotvs_cod_empresa(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  Upper(TOTVS_COD_EMPRESA) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + gj_gnfe_nota_fiscalT.getTotvs_cod_empresa() + '%');
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

    public List<Gj_gnfe_nota_fiscalT> getByTotvs_num_ar(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  TOTVS_NUM_AR = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getTotvs_num_ar());
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

    public List<Gj_gnfe_nota_fiscalT> getByTotvs_num_nfe(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  TOTVS_NUM_NFE = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getTotvs_num_nfe());
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

    public List<Gj_gnfe_nota_fiscalT> getByTotvs_ser_nfe(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  Upper(TOTVS_SER_NFE) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + gj_gnfe_nota_fiscalT.getTotvs_ser_nfe() + '%');
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

    public List<Gj_gnfe_nota_fiscalT> getByTotvs_ssr_nfe(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  TOTVS_SSR_NFE = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getTotvs_ssr_nfe());
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

    public List<Gj_gnfe_nota_fiscalT> getByTotvs_emi_nfe(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  Upper(TOTVS_EMI_NFE) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + gj_gnfe_nota_fiscalT.getTotvs_emi_nfe() + '%');
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

    public List<Gj_gnfe_nota_fiscalT> getByTotvs_emi_nfeOrigem(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where TOTVS_EMI_NFE=? and origem=1 order by DATE_PROT desc ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getTotvs_emi_nfe() );
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

    public List<Gj_gnfe_nota_fiscalT> getByTotvs_des_nfeOrigem(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  (TOTVS_EMI_NFE=? or TOTVS_DES_NFE=?) and origem=0 order by DATE_PROT desc ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getNum_cgc_cpf());
            pStmt.setObject(2, gj_gnfe_nota_fiscalT.getNum_cgc_cpf());
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

    public List<Gj_gnfe_nota_fiscalT> getByTotvs_des_nfe(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  Upper(TOTVS_DES_NFE) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + gj_gnfe_nota_fiscalT.getTotvs_des_nfe() + '%');
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

    public List<Gj_gnfe_nota_fiscalT> getByTotvs_dat_nfe(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  TOTVS_DAT_NFE = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(gj_gnfe_nota_fiscalT.getTotvs_dat_nfe().getTime());
            pStmt.setObject(1, dt1);
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

    public List<Gj_gnfe_nota_fiscalT> getByTotvs_val_nfe(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  TOTVS_VAL_NFE = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getTotvs_val_nfe());
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

    public List<Gj_gnfe_nota_fiscalT> getBySomenteTotvs() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  STATUS_JAVA <> 1 ";
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

    public List<Gj_gnfe_nota_fiscalT> getBySomenteEmail() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where  STATUS_TOTVS = 0 or status_totvs is null order by DATE_PROT desc";
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

    /**
     * Independente se é de entrada ou saída
     * @param gj_gnfe_nota_fiscalT
     * @return
     * @throws Exception
     */
    public List<Gj_gnfe_nota_fiscalT> getByNum_cgc_cpf(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {//"127795500097"011219018000103 011190800103
            String sql = "select ID_ENT,  NFE_ID,REG_NFE, DES_REG,MODELO, AMBIENTE ,MODALIDADE,STATUS,CSTATUS_SEFR, XMOT_SEFR, PROT, DATE_PROT, ORIGEM ,STATUS_JAVA,STATUS_TOTVS, TOTVS_COD_EMPRESA, TOTVS_NUM_AR, TOTVS_NUM_NFE, TOTVS_SER_NFE, TOTVS_SSR_NFE, TOTVS_EMI_NFE, TOTVS_DES_NFE,  TOTVS_DAT_NFE, TOTVS_VAL_NFE, NUM_CGC_CPF  from GJAV.GJ_GNFE_NOTA_FISCAL where  TOTVS_EMI_NFE=? or TOTVS_DES_NFE =? order by DATE_PROT desc";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getNum_cgc_cpf());
            pStmt.setObject(2, gj_gnfe_nota_fiscalT.getNum_cgc_cpf());
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

    public List<Gj_gnfe_nota_fiscalT> getByNum_cgc_cpfTipoNota(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {//"127795500097"011219018000103 011190800103
            String sql = "select ID_ENT,  NFE_ID,REG_NFE, DES_REG,MODELO, AMBIENTE ,MODALIDADE,STATUS,CSTATUS_SEFR, XMOT_SEFR, PROT, DATE_PROT, ORIGEM ,STATUS_JAVA,STATUS_TOTVS, TOTVS_COD_EMPRESA, TOTVS_NUM_AR, TOTVS_NUM_NFE, TOTVS_SER_NFE, TOTVS_SSR_NFE, TOTVS_EMI_NFE, TOTVS_DES_NFE,  TOTVS_DAT_NFE, TOTVS_VAL_NFE, NUM_CGC_CPF  from GJAV.GJ_GNFE_NOTA_FISCAL where  NUM_CGC_CPF =? and origem=? order by DATE_PROT desc";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getNum_cgc_cpf());
            pStmt.setObject(2, gj_gnfe_nota_fiscalT.getOrigem());
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

    public List<Gj_gnfe_nota_fiscalT> getByNfePeriodo(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT, java.util.Date dataInicial, java.util.Date dataFinal) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where ID_ENT = ? and DATE_PROT between ? and ? order by DATE_PROT desc";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getId_ent());
            //pStmt.setObject(2, gj_gnfe_nota_fiscalT.getNum_cgc_cpf());
            java.sql.Date dtIni = new java.sql.Date(dataInicial.getTime());
            pStmt.setObject(2, dtIni);
            java.sql.Date dtFim = new java.sql.Date(dataFinal.getTime());
            pStmt.setObject(3, dtFim);
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

    public List<Gj_gnfe_nota_fiscalT> getByNfeEmpresaOuClientePeriodo(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT, java.util.Date dataInicial, java.util.Date dataFinal) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where (TOTVS_EMI_NFE=? or TOTVS_DES_NFE = ?) and DATE_PROT between ? and ? order by DATE_PROT desc";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getNum_cgc_cpf());
            pStmt.setObject(2, gj_gnfe_nota_fiscalT.getNum_cgc_cpf());
            //pStmt.setObject(2, gj_gnfe_nota_fiscalT.getNum_cgc_cpf());
            java.sql.Date dtIni = new java.sql.Date(dataInicial.getTime());
            pStmt.setObject(3, dtIni);
            java.sql.Date dtFim = new java.sql.Date(dataFinal.getTime());
            pStmt.setObject(4, dtFim);
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

    public List<Gj_gnfe_nota_fiscalT> getByNfePeriodoTipoNota(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT, java.util.Date dataInicial, java.util.Date dataFinal) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where ID_ENT = ? and DATE_PROT between ? and ? and origem=? order by DATE_PROT desc";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getId_ent());
            //pStmt.setObject(2, gj_gnfe_nota_fiscalT.getNum_cgc_cpf());
            java.sql.Date dtIni = new java.sql.Date(dataInicial.getTime());
            pStmt.setObject(2, dtIni);
            java.sql.Date dtFim = new java.sql.Date(dataFinal.getTime());
            pStmt.setObject(3, dtFim);
            pStmt.setObject(4, gj_gnfe_nota_fiscalT.getOrigem());
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
/*
    public List<Gj_gnfe_nota_fiscalT> getByNfeEmpresaOuClientePeriodoTipoNota(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT, java.util.Date dataInicial, java.util.Date dataFinal) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where (TOTVS_EMI_NFE=? or TOTVS_DES_NFE=?) and DATE_PROT between ? and ? and origem=? order by DATE_PROT desc";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getNum_cgc_cpf());
            pStmt.setObject(2, gj_gnfe_nota_fiscalT.getNum_cgc_cpf());
            java.sql.Date dtIni = new java.sql.Date(dataInicial.getTime());
            pStmt.setObject(3, dtIni);
            java.sql.Date dtFim = new java.sql.Date(dataFinal.getTime());
            pStmt.setObject(4, dtFim);
            pStmt.setObject(5, gj_gnfe_nota_fiscalT.getOrigem());
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
 */

    /**
     * Consulta consisedrando os campos TOTVS_EMI_NFE,TOTVS_DES_NFE através do cnpj
     * @param gj_gnfe_nota_fiscalT
     * @param dataInicial
     * @param dataFinal
     * @return
     * @throws Exception
     */
    public List<Gj_gnfe_nota_fiscalT> getByNfeEmpresaOuClientePeriodoTipoNota(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT, java.util.Date dataInicial, java.util.Date dataFinal) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select ID_ENT,NFE_ID,reg_nfe,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,PROT,DATE_PROT,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE,NUM_CGC_CPF from GJAV.GJ_GNFE_NOTA_FISCAL where (TOTVS_EMI_NFE =? or TOTVS_DES_NFE = ?) and DATE_PROT between ? and ? and origem=? order by DATE_PROT desc";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, gj_gnfe_nota_fiscalT.getNum_cgc_cpf());
            pStmt.setObject(2, gj_gnfe_nota_fiscalT.getNum_cgc_cpf());
            //pStmt.setObject(2, gj_gnfe_nota_fiscalT.getNum_cgc_cpf());
            java.sql.Date dtIni = new java.sql.Date(dataInicial.getTime());
            pStmt.setObject(3, dtIni);
            java.sql.Date dtFim = new java.sql.Date(dataFinal.getTime());
            pStmt.setObject(4, dtFim);
            pStmt.setObject(5, gj_gnfe_nota_fiscalT.getOrigem());
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
