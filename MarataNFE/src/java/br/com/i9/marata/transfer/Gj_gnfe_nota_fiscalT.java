package br.com.i9.marata.transfer;

import br.com.easynet.annotation.Conversion;
import java.util.Date;

public class Gj_gnfe_nota_fiscalT {

    private String id_ent;
    private String nfe_id;
    private int reg_nfe;
    private String des_reg;
    private String modelo;
    private int ambiente;
    private int modalidade;
    private int status;
    private String cstatus_sefr;
    private String xmot_sefr;
    private byte[] xml_sig;
    private byte[] xml_sig_mail;
    private String prot;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private Date date_prot;
    private byte[] xml_prot;
    private byte[] xml_prot_mail;
    private int origem;
    private int status_java;
    private int status_totvs;
    private String totvs_cod_empresa;
    private int totvs_num_ar;
    private int totvs_num_nfe;
    private String totvs_ser_nfe;
    private int totvs_ssr_nfe;
    private String totvs_emi_nfe;
    private String totvs_des_nfe;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private java.util.Date totvs_dat_nfe;
    private double totvs_val_nfe;
    private String num_cgc_cpf;
    private String xml;

    public void setId_ent(String id_ent) {
        this.id_ent = id_ent;
    }

    public String getId_ent() {
        return id_ent;
    }

    public void setNfe_id(String nfe_id) {
        this.nfe_id = nfe_id;
    }

    public String getNfe_id() {
        return nfe_id;
    }

    public void setReg_nfe(int reg_nfe) {
        this.reg_nfe = reg_nfe;
    }

    public int getReg_nfe() {
        return reg_nfe;
    }

    public void setDes_reg(String des_reg) {
        this.des_reg = des_reg;
    }

    public String getDes_reg() {
        return des_reg;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setAmbiente(int ambiente) {
        this.ambiente = ambiente;
    }

    public int getAmbiente() {
        return ambiente;
    }

    public void setModalidade(int modalidade) {
        this.modalidade = modalidade;
    }

    public int getModalidade() {
        return modalidade;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setCstatus_sefr(String cstatus_sefr) {
        this.cstatus_sefr = cstatus_sefr;
    }

    public String getCstatus_sefr() {
        return cstatus_sefr;
    }

    public void setXmot_sefr(String xmot_sefr) {
        this.xmot_sefr = xmot_sefr;
    }

    public String getXmot_sefr() {
        return xmot_sefr;
    }

    public void setXml_sig(byte[] xml_sig) {
        this.xml_sig = xml_sig;
    }

    public byte[] getXml_sig() {
        return xml_sig;
    }

    public void setXml_sig_mail(byte[] xml_sig_mail) {
        this.xml_sig_mail = xml_sig_mail;
    }

    public byte[] getXml_sig_mail() {
        return xml_sig_mail;
    }

    public void setProt(String prot) {
        this.prot = prot;
    }

    public String getProt() {
        return prot;
    }

    public void setDate_prot(Date date_prot) {
        this.date_prot = date_prot;
    }

    public Date getDate_prot() {
        return date_prot;
    }

    public void setXml_prot(byte[] xml_prot) {
        this.xml_prot = xml_prot;
    }

    public byte[] getXml_prot() {
        return xml_prot;
    }

    public void setXml_prot_mail(byte[] xml_prot_mail) {
        this.xml_prot_mail = xml_prot_mail;
    }

    public byte[] getXml_prot_mail() {
        return xml_prot_mail;
    }

    public void setOrigem(int origem) {
        this.origem = origem;
    }

    public int getOrigem() {
        return origem;
    }

    public void setStatus_java(int status_java) {
        this.status_java = status_java;
    }

    public int getStatus_java() {
        return status_java;
    }

    public void setStatus_totvs(int status_totvs) {
        this.status_totvs = status_totvs;
    }

    public int getStatus_totvs() {
        return status_totvs;
    }

    public void setTotvs_cod_empresa(String totvs_cod_empresa) {
        this.totvs_cod_empresa = totvs_cod_empresa;
    }

    public String getTotvs_cod_empresa() {
        return totvs_cod_empresa;
    }

    public void setTotvs_num_ar(int totvs_num_ar) {
        this.totvs_num_ar = totvs_num_ar;
    }

    public int getTotvs_num_ar() {
        return totvs_num_ar;
    }

    public void setTotvs_num_nfe(int totvs_num_nfe) {
        this.totvs_num_nfe = totvs_num_nfe;
    }

    public int getTotvs_num_nfe() {
        return totvs_num_nfe;
    }

    public void setTotvs_ser_nfe(String totvs_ser_nfe) {
        this.totvs_ser_nfe = totvs_ser_nfe;
    }

    public String getTotvs_ser_nfe() {
        return totvs_ser_nfe;
    }

    public void setTotvs_ssr_nfe(int totvs_ssr_nfe) {
        this.totvs_ssr_nfe = totvs_ssr_nfe;
    }

    public int getTotvs_ssr_nfe() {
        return totvs_ssr_nfe;
    }

    public void setTotvs_emi_nfe(String totvs_emi_nfe) {
        this.totvs_emi_nfe = totvs_emi_nfe;
    }

    public String getTotvs_emi_nfe() {
        return totvs_emi_nfe;
    }

    public void setTotvs_des_nfe(String totvs_des_nfe) {
        this.totvs_des_nfe = totvs_des_nfe;
    }

    public String getTotvs_des_nfe() {
        return totvs_des_nfe;
    }

    public void setTotvs_dat_nfe(java.util.Date totvs_dat_nfe) {
        this.totvs_dat_nfe = totvs_dat_nfe;
    }

    public java.util.Date getTotvs_dat_nfe() {
        return totvs_dat_nfe;
    }

    public void setTotvs_val_nfe(double totvs_val_nfe) {
        this.totvs_val_nfe = totvs_val_nfe;
    }

    public double getTotvs_val_nfe() {
        return totvs_val_nfe;
    }

    public void setNum_cgc_cpf(String num_cgc_cpf) {
        this.num_cgc_cpf = num_cgc_cpf;
    }

    public String getNum_cgc_cpf() {
        return num_cgc_cpf;
    }

    /**
     * @return the xml
     */
    public String getXml() {
        return xml;
    }

    /**
     * @param xml the xml to set
     */
    public void setXml(String xml) {
        this.xml = xml;
    }
}
