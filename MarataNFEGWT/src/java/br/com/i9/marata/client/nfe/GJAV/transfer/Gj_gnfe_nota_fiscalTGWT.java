
/*
 * EasyNet JDragon
 */
package br.com.i9.marata.client.nfe.GJAV.transfer;

import com.extjs.gxt.ui.client.data.BaseModel;
import java.util.Date;

/**
 *
 * @author geoleite
 */
public class Gj_gnfe_nota_fiscalTGWT extends BaseModel {

    public Gj_gnfe_nota_fiscalTGWT() {
    }

    public String getId_ent() {
        return get("id_ent");
    }

    public void setId_ent(String id_ent) {
        set("id_ent", id_ent);
    }

    public String getNfe_id() {
        return get("nfe_id");
    }

    public void setNfe_id(String nfe_id) {
        set("nfe_id", nfe_id);
    }

    public int getReg_nfe() {
        return ((Integer) get("reg_nfe")).intValue();
    }

    public void setReg_nfe(int reg_nfe) {
        set("reg_nfe", reg_nfe);
    }

    public String getDes_reg() {
        return get("des_reg");
    }

    public void setDes_reg(String des_reg) {
        set("des_reg", des_reg);
    }

    public String getModelo() {
        return get("modelo");
    }

    public void setModelo(String modelo) {
        set("modelo", modelo);
    }

    public int getAmbiente() {
        return ((Integer) get("ambiente")).intValue();
    }

    public void setAmbiente(int ambiente) {
        set("ambiente", ambiente);
    }

    public int getModalidade() {
        return ((Integer) get("modalidade")).intValue();
    }

    public void setModalidade(int modalidade) {
        set("modalidade", modalidade);
    }

    public int getStatus() {
        return ((Integer) get("status")).intValue();
    }

    public void setStatus(int status) {
        set("status", status);
    }

    public String getCstatus_sefr() {
        return get("cstatus_sefr");
    }

    public void setCstatus_sefr(String cstatus_sefr) {
        set("cstatus_sefr", cstatus_sefr);
    }

    public String getXmot_sefr() {
        return get("xmot_sefr");
    }

    public void setXmot_sefr(String xmot_sefr) {
        set("xmot_sefr", xmot_sefr);
    }

    public String getProt() {
        return get("prot");
    }

    public void setProt(String prot) {
        set("prot", prot);
    }

    public Date getDate_prot() {
        return (Date)get("date_prot");
    }

    public void setDate_prot(Date date_prot) {
        set("date_prot", date_prot);
    }

    public int getOrigem() {
        return ((Integer) get("origem")).intValue();
    }

    public void setOrigem(int origem) {
        set("origem", origem);
    }

    public int getStatus_java() {
        return ((Integer) get("status_java")).intValue();
    }

    public void setStatus_java(int status_java) {
        set("status_java", status_java);
    }

    public int getStatus_totvs() {
        return ((Integer) get("status_totvs")).intValue();
    }

    public void setStatus_totvs(int status_totvs) {
        set("status_totvs", status_totvs);
    }

    public String getTotvs_cod_empresa() {
        return get("totvs_cod_empresa");
    }

    public void setTotvs_cod_empresa(String totvs_cod_empresa) {
        set("totvs_cod_empresa", totvs_cod_empresa);
    }

    public int getTotvs_num_ar() {
        return ((Integer) get("totvs_num_ar")).intValue();
    }

    public void setTotvs_num_ar(int totvs_num_ar) {
        set("totvs_num_ar", totvs_num_ar);
    }

    public int getTotvs_num_nfe() {
        return ((Integer) get("totvs_num_nfe")).intValue();
    }

    public void setTotvs_num_nfe(int totvs_num_nfe) {
        set("totvs_num_nfe", totvs_num_nfe);
    }

    public String getTotvs_ser_nfe() {
        return get("totvs_ser_nfe");
    }

    public void setTotvs_ser_nfe(String totvs_ser_nfe) {
        set("totvs_ser_nfe", totvs_ser_nfe);
    }

    public int getTotvs_ssr_nfe() {
        return ((Integer) get("totvs_ssr_nfe")).intValue();
    }

    public void setTotvs_ssr_nfe(int totvs_ssr_nfe) {
        set("totvs_ssr_nfe", totvs_ssr_nfe);
    }

    public String getTotvs_emi_nfe() {
        return get("totvs_emi_nfe");
    }

    public void setTotvs_emi_nfe(String totvs_emi_nfe) {
        set("totvs_emi_nfe", totvs_emi_nfe);
    }

    public String getTotvs_des_nfe() {
        return get("totvs_des_nfe");
    }

    public void setTotvs_des_nfe(String totvs_des_nfe) {
        set("totvs_des_nfe", totvs_des_nfe);
    }

    public Date getTotvs_dat_nfe() {
        return (Date) get("totvs_dat_nfe");
    }

    public void setTotvs_dat_nfe(Date totvs_dat_nfe) {
        set("totvs_dat_nfe", totvs_dat_nfe);
    }

    public double getTotvs_val_nfe() {
        return ((Double) get("totvs_val_nfe")).doubleValue();
    }

    public void setTotvs_val_nfe(double totvs_val_nfe) {
        set("totvs_val_nfe", totvs_val_nfe);
    }

    public String getNum_cgc_cpf() {
        return get("num_cgc_cpf");
    }

    public void setNum_cgc_cpf(String num_cgc_cpf) {
        set("num_cgc_cpf", num_cgc_cpf);
    }
}
