package br.com.easynet.nfegen.transfer;

import br.com.easynet.annotation.Conversion;
import java.util.Date;

public class Not_notaT {

    private int emp_nr_id;
    private int not_nr_id;
    private byte[] not_bt_arquivo={};
    private String not_tx_identificador;
    private String not_tx_tipo;
    private int not_tx_numero;
    private String not_tx_cnpjcliente;
    private int dis_nr_id;
    private Date not_dt_emissao;
    private String dis_tx_nome="";
    private String emp_tx_nome="";
    private boolean not_bln_cancelada;

    public String toString() {
        return emp_nr_id +  " " + getDis_nr_id() + " " + not_nr_id +  " " + not_tx_identificador +  " " + not_tx_tipo +  " " + not_tx_cnpjcliente +  " " + not_dt_emissao;
    }
    public void setEmp_nr_id(int emp_nr_id) {
        this.emp_nr_id = emp_nr_id;
    }

    public int getEmp_nr_id() {
        return emp_nr_id;
    }

    public void setNot_nr_id(int not_nr_id) {
        this.not_nr_id = not_nr_id;
    }

    public int getNot_nr_id() {
        return not_nr_id;
    }

    public void setNot_bt_arquivo(byte[] not_bt_arquivo) {
        this.not_bt_arquivo = not_bt_arquivo;
    }

    public byte[] getNot_bt_arquivo() {
        return not_bt_arquivo;
    }

    public void setNot_tx_identificador(String not_tx_identificador) {
        this.not_tx_identificador = not_tx_identificador;
    }

    public String getNot_tx_identificador() {
        return not_tx_identificador;
    }

    public void setNot_tx_tipo(String not_tx_tipo) {
        this.not_tx_tipo = not_tx_tipo;
    }

    public String getNot_tx_tipo() {
        return not_tx_tipo;
    }

    public void setNot_tx_cnpjcliente(String not_tx_cnpjcliente) {
        this.not_tx_cnpjcliente = not_tx_cnpjcliente;
    }

    public String getNot_tx_cnpjcliente() {
        return not_tx_cnpjcliente;
    }


    public Date getNot_dt_emissao() {
        return not_dt_emissao;
    }

    public void setNot_dt_emissao(Date not_dt_emissao) {
        this.not_dt_emissao = not_dt_emissao;
    }

    /**
     * @return the not_tx_numero
     */
    public int getNot_tx_numero() {
        return not_tx_numero;
    }

    /**
     * @param not_tx_numero the not_tx_numero to set
     */
    public void setNot_tx_numero(int not_tx_numero) {
        this.not_tx_numero = not_tx_numero;
    }

    /**
     * @return the dis_tx_nome
     */
    public String getDis_tx_nome() {
        return dis_tx_nome;
    }

    /**
     * @param dis_tx_nome the dis_tx_nome to set
     */
    public void setDis_tx_nome(String dis_tx_nome) {
        this.dis_tx_nome = dis_tx_nome;
    }

    /**
     * @return the emp_tx_nome
     */
    public String getEmp_tx_nome() {
        return emp_tx_nome;
    }

    /**
     * @param emp_tx_nome the emp_tx_nome to set
     */
    public void setEmp_tx_nome(String emp_tx_nome) {
        this.emp_tx_nome = emp_tx_nome;
    }

    /**
     * @return the not_bln_cancelada
     */
    public boolean isNot_bln_cancelada() {
        return not_bln_cancelada;
    }

    /**
     * @param not_bln_cancelada the not_bln_cancelada to set
     */
    public void setNot_bln_cancelada(boolean not_bln_cancelada) {
        this.not_bln_cancelada = not_bln_cancelada;
    }

    /**
     * @return the dis_nr_id
     */
    public int getDis_nr_id() {
        return dis_nr_id;
    }

    /**
     * @param dis_nr_id the dis_nr_id to set
     */
    public void setDis_nr_id(int dis_nr_id) {
        this.dis_nr_id = dis_nr_id;
    }
}