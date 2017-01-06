/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.nfegen.transfer;

import java.util.Date;

/**
 *
 * @author geoleite
 */
public class NotaFiscalT {
    private String idEnt;
    private String nfeId;
    private int regNfe;
    private String desReg;
    private String modelo;
    private int ambiente;
    private int modalidade;
    private int status ;
    private String cStatusSfr;
    private String xMotSefr;
    private byte[] xmlSig;
    private byte[] xmlSigMail;
    private String prot;
    private Date dateProt;
    private byte[] xmlProt;
    private byte[] xmlProtMail;
    private int origem;
    private int statusJava;
    private int statusTotVs;
    private String totVsCodEmpresa;
    private long totVsNumAr;
    private long totVsNumNfe;
    private String totVsSerNfe;
    private long totVsSsrNfe;
    private String TotVsEmiNfe;
    private String totVsDesNfe;
    private Date totVsDatNfe;
    private double totVsValNfe;
    private String NUM_CGC_CPF;

    /**
     * @return the idEnt
     */
    public String getIdEnt() {
        return idEnt;
    }

    /**
     * @param idEnt the idEnt to set
     */
    public void setIdEnt(String idEnt) {
        this.idEnt = idEnt;
    }

    /**
     * @return the nfeId
     */
    public String getNfeId() {
        return nfeId;
    }

    /**
     * @param nfeId the nfeId to set
     */
    public void setNfeId(String nfeId) {
        this.nfeId = nfeId;
    }

    /**
     * @return the regNfe
     */
    public int getRegNfe() {
        return regNfe;
    }

    /**
     * @param regNfe the regNfe to set
     */
    public void setRegNfe(int regNfe) {
        this.regNfe = regNfe;
    }

    /**
     * @return the desReg
     */
    public String getDesReg() {
        return desReg;
    }

    /**
     * @param desReg the desReg to set
     */
    public void setDesReg(String desReg) {
        this.desReg = desReg;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the ambiente
     */
    public int getAmbiente() {
        return ambiente;
    }

    /**
     * @param ambiente the ambiente to set
     */
    public void setAmbiente(int ambiente) {
        this.ambiente = ambiente;
    }

    /**
     * @return the modalidade
     */
    public int getModalidade() {
        return modalidade;
    }

    /**
     * @param modalidade the modalidade to set
     */
    public void setModalidade(int modalidade) {
        this.modalidade = modalidade;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the cStatusSfr
     */
    public String getcStatusSfr() {
        return cStatusSfr;
    }

    /**
     * @param cStatusSfr the cStatusSfr to set
     */
    public void setcStatusSfr(String cStatusSfr) {
        this.cStatusSfr = cStatusSfr;
    }

    /**
     * @return the xMotSefr
     */
    public String getxMotSefr() {
        return xMotSefr;
    }

    /**
     * @param xMotSefr the xMotSefr to set
     */
    public void setxMotSefr(String xMotSefr) {
        this.xMotSefr = xMotSefr;
    }

    /**
     * @return the xmlSig
     */
    public byte[] getXmlSig() {
        return xmlSig;
    }

    /**
     * @param xmlSig the xmlSig to set
     */
    public void setXmlSig(byte[] xmlSig) {
        this.xmlSig = xmlSig;
    }

    /**
     * @return the xmlSigMail
     */
    public byte[] getXmlSigMail() {
        return xmlSigMail;
    }

    /**
     * @param xmlSigMail the xmlSigMail to set
     */
    public void setXmlSigMail(byte[] xmlSigMail) {
        this.xmlSigMail = xmlSigMail;
    }

    /**
     * @return the prot
     */
    public String getProt() {
        return prot;
    }

    /**
     * @param prot the prot to set
     */
    public void setProt(String prot) {
        this.prot = prot;
    }

    /**
     * @return the dateProt
     */
    public Date getDateProt() {
        return dateProt;
    }

    /**
     * @param dateProt the dateProt to set
     */
    public void setDateProt(Date dateProt) {
        this.dateProt = dateProt;
    }

    /**
     * @return the xmlProt
     */
    public byte[] getXmlProt() {
        return xmlProt;
    }

    /**
     * @param xmlProt the xmlProt to set
     */
    public void setXmlProt(byte[] xmlProt) {
        this.xmlProt = xmlProt;
    }

    /**
     * @return the xmlProtMail
     */
    public byte[] getXmlProtMail() {
        return xmlProtMail;
    }

    /**
     * @param xmlProtMail the xmlProtMail to set
     */
    public void setXmlProtMail(byte[] xmlProtMail) {
        this.xmlProtMail = xmlProtMail;
    }

    /**
     * @return the origem
     */
    public int getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(int origem) {
        this.origem = origem;
    }

    /**
     * @return the statusJava
     */
    public int getStatusJava() {
        return statusJava;
    }

    /**
     * @param statusJava the statusJava to set
     */
    public void setStatusJava(int statusJava) {
        this.statusJava = statusJava;
    }

    /**
     * @return the statusTotVs
     */
    public int getStatusTotVs() {
        return statusTotVs;
    }

    /**
     * @param statusTotVs the statusTotVs to set
     */
    public void setStatusTotVs(int statusTotVs) {
        this.statusTotVs = statusTotVs;
    }

    /**
     * @return the totVsCodEmpresa
     */
    public String getTotVsCodEmpresa() {
        return totVsCodEmpresa;
    }

    /**
     * @param totVsCodEmpresa the totVsCodEmpresa to set
     */
    public void setTotVsCodEmpresa(String totVsCodEmpresa) {
        this.totVsCodEmpresa = totVsCodEmpresa;
    }

    /**
     * @return the totVsNumAr
     */
    public long getTotVsNumAr() {
        return totVsNumAr;
    }

    /**
     * @param totVsNumAr the totVsNumAr to set
     */
    public void setTotVsNumAr(long totVsNumAr) {
        this.totVsNumAr = totVsNumAr;
    }

    /**
     * @return the totVsNumNfe
     */
    public long getTotVsNumNfe() {
        return totVsNumNfe;
    }

    /**
     * @param totVsNumNfe the totVsNumNfe to set
     */
    public void setTotVsNumNfe(long totVsNumNfe) {
        this.totVsNumNfe = totVsNumNfe;
    }

    /**
     * @return the totVsSerNfe
     */
    public String getTotVsSerNfe() {
        return totVsSerNfe;
    }

    /**
     * @param totVsSerNfe the totVsSerNfe to set
     */
    public void setTotVsSerNfe(String totVsSerNfe) {
        this.totVsSerNfe = totVsSerNfe;
    }

    /**
     * @return the totVsSsrNfe
     */
    public long getTotVsSsrNfe() {
        return totVsSsrNfe;
    }

    /**
     * @param totVsSsrNfe the totVsSsrNfe to set
     */
    public void setTotVsSsrNfe(long totVsSsrNfe) {
        this.totVsSsrNfe = totVsSsrNfe;
    }

    /**
     * @return the TotVsEmiNfe
     */
    public String getTotVsEmiNfe() {
        return TotVsEmiNfe;
    }

    /**
     * @param TotVsEmiNfe the TotVsEmiNfe to set
     */
    public void setTotVsEmiNfe(String TotVsEmiNfe) {
        this.TotVsEmiNfe = TotVsEmiNfe;
    }

    /**
     * @return the totVsDesNfe
     */
    public String getTotVsDesNfe() {
        return totVsDesNfe;
    }

    /**
     * @param totVsDesNfe the totVsDesNfe to set
     */
    public void setTotVsDesNfe(String totVsDesNfe) {
        this.totVsDesNfe = totVsDesNfe;
    }

    /**
     * @return the totVsDatNfe
     */
    public Date getTotVsDatNfe() {
        return totVsDatNfe;
    }

    /**
     * @param totVsDatNfe the totVsDatNfe to set
     */
    public void setTotVsDatNfe(Date totVsDatNfe) {
        this.totVsDatNfe = totVsDatNfe;
    }

    /**
     * @return the totVsValNfe
     */
    public double getTotVsValNfe() {
        return totVsValNfe;
    }

    /**
     * @param totVsValNfe the totVsValNfe to set
     */
    public void setTotVsValNfe(double totVsValNfe) {
        this.totVsValNfe = totVsValNfe;
    }

    /**
     * @return the NUM_CGC_CPF
     */
    public String getNUM_CGC_CPF() {
        return NUM_CGC_CPF;
    }

    /**
     * @param NUM_CGC_CPF the NUM_CGC_CPF to set
     */
    public void setNUM_CGC_CPF(String NUM_CGC_CPF) {
        this.NUM_CGC_CPF = NUM_CGC_CPF;
    }

  
}
