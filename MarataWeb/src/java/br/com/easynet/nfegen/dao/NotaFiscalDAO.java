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
public class NotaFiscalDAO extends ObjectDAO {

    public NotaFiscalDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }


    public void insertJava(NotaFiscalT notaFiscalT) throws Exception {
        PreparedStatement pStmt = null;
        try {

            String sql = "insert into gjav.GJ_GNFE_NOTA_FISCAL  (ID_ENT,NFE_ID, REG_NFE, DES_REG, XML_SIG_MAIL, ORIGEM, STATUS_JAVA, NUM_CGC_CPF, DATE_PROT) values (?, ?, ?, ?, ?, ?, 1, ?, ?)";

            pStmt = con.prepareStatement(sql);
            pStmt.setString(1, notaFiscalT.getIdEnt());
            pStmt.setString(2, notaFiscalT.getNfeId());
            pStmt.setInt(3, notaFiscalT.getRegNfe());
            pStmt.setString(4, notaFiscalT.getDesReg());
            pStmt.setBytes(5, notaFiscalT.getXmlSigMail());
            pStmt.setInt(6, notaFiscalT.getOrigem());
            pStmt.setObject(7, notaFiscalT.getNUM_CGC_CPF());
            java.sql.Date dt = new java.sql.Date(notaFiscalT.getDateProt().getTime());
            pStmt.setObject(8, dt);
            pStmt.execute();

        } catch (Exception e) {
            //e.printStackTrace();
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void udpateJava(NotaFiscalT notaFiscalT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update gjav.GJ_GNFE_NOTA_FISCAL  set ID_ENT=?,REG_NFE=?, DES_REG=?, XML_SIG_MAIL=?, ORIGEM=?, STATUS_JAVA=1, NUM_CGC_CPF=?, DATE_PROT=? where NFE_ID=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setString(1, notaFiscalT.getIdEnt());
            pStmt.setInt(2, notaFiscalT.getRegNfe());
            pStmt.setString(3, notaFiscalT.getDesReg());
            pStmt.setBytes(4, notaFiscalT.getXmlSigMail());
            pStmt.setInt(5, notaFiscalT.getOrigem());
            pStmt.setString(6, notaFiscalT.getNUM_CGC_CPF());
            java.sql.Date dt = new java.sql.Date(notaFiscalT.getDateProt().getTime());
            pStmt.setObject(7, dt);
            pStmt.setString(8, notaFiscalT.getNfeId());
            pStmt.execute();
        } catch (Exception e) {
            //e.printStackTrace();
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void insert(NotaFiscalT notaFiscalT) {
        PreparedStatement pStmt = null;
        try {

            String sql = "insert into gjav.GJ_GNFE_NOTA_FISCAL (ID_ENT,NFE_ID,REG_NFE,DES_REG,MODELO,AMBIENTE,MODALIDADE,STATUS,CSTATUS_SEFR,XMOT_SEFR,XML_SIG,XML_SIG_MAIL,PROT,DATE_PROT,XML_PROT,XML_PROT_MAIL,ORIGEM,STATUS_JAVA,STATUS_TOTVS,TOTVS_COD_EMPRESA,TOTVS_NUM_AR,TOTVS_NUM_NFE,TOTVS_SER_NFE,TOTVS_SSR_NFE,TOTVS_EMI_NFE,TOTVS_DES_NFE,TOTVS_DAT_NFE,TOTVS_VAL_NFE) values (?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, notaFiscalT.getIdEnt());
            pStmt.setObject(2, notaFiscalT.getNfeId());
            pStmt.setObject(3, notaFiscalT.getRegNfe());
            pStmt.setObject(4, notaFiscalT.getDesReg());
            pStmt.setObject(5, notaFiscalT.getModelo());
            pStmt.setObject(6, notaFiscalT.getAmbiente());
            pStmt.setObject(7, notaFiscalT.getModalidade());
            pStmt.setObject(8, notaFiscalT.getStatus());
            pStmt.setObject(9, notaFiscalT.getcStatusSfr());
            pStmt.setObject(10, notaFiscalT.getxMotSefr());
            pStmt.setObject(11, notaFiscalT.getXmlSig());
            pStmt.setObject(12, notaFiscalT.getXmlSigMail());
            pStmt.setObject(13, notaFiscalT.getProt());
            pStmt.setObject(14, notaFiscalT.getDateProt());
            pStmt.setObject(15, notaFiscalT.getXmlProt());
            pStmt.setObject(16, notaFiscalT.getXmlProtMail());
            pStmt.setObject(17, notaFiscalT.getOrigem());
            pStmt.setObject(18, notaFiscalT.getStatusJava());
            pStmt.setObject(19, notaFiscalT.getStatusTotVs());
            pStmt.setObject(20, notaFiscalT.getTotVsCodEmpresa());
            pStmt.setObject(21, notaFiscalT.getTotVsNumAr());
            pStmt.setObject(22, notaFiscalT.getTotVsNumNfe());
            pStmt.setObject(23, notaFiscalT.getTotVsSerNfe());
            pStmt.setObject(24, notaFiscalT.getTotVsSsrNfe());
            pStmt.setObject(25, notaFiscalT.getTotVsEmiNfe());
            pStmt.setObject(26, notaFiscalT.getTotVsDesNfe());
            pStmt.setObject(27, notaFiscalT.getTotVsDatNfe());
            pStmt.setObject(28, notaFiscalT.getTotVsValNfe());
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


public boolean existeNota(NotaFiscalT notaFiscalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select id_ent from gjav.GJ_GNFE_NOTA_FISCAL where NFE_ID=? ";
//notaFiscalT.getNfeId()
            pStmt = con.prepareStatement(sql);
            System.out.println("NFE-ID : " + notaFiscalT.getNfeId());
            pStmt.setObject(1, notaFiscalT.getNfeId());
            rs = pStmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            //e.printStackTrace();
            throw e;
        } finally {
            try {
                rs.close();

            } catch (Exception e) {
            }
            try {
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }
}
