package br.com.easynet.nfegen.transfer;

import br.com.easynet.annotation.Conversion;

public class Dis_distribuidoraT {

    private int dis_nr_id;
    private String dis_tx_nome;
    private String dis_tx_cnpj;
    private int dis_nr_id_super=-1;
    private String dis_tx_status="A";


    public void setDis_tx_nome(String dis_tx_nome) {
        this.dis_tx_nome = dis_tx_nome;
    }

    public String getDis_tx_nome() {
        return dis_tx_nome;
    }

    public void setDis_tx_cnpj(String dis_tx_cnpj) {
        this.dis_tx_cnpj = dis_tx_cnpj;
    }

    public String getDis_tx_cnpj() {
        return dis_tx_cnpj;
    }

    /**
     * @return the dis_nr_id_super
     */
    public int getDis_nr_id_super() {
        return dis_nr_id_super;
    }

    /**
     * @param dis_nr_id_super the dis_nr_id_super to set
     */
    public void setDis_nr_id_super(int dis_nr_id_super) {
        this.dis_nr_id_super = dis_nr_id_super;
    }

    /**
     * @return the dis_tx_status
     */
    public String getDis_tx_status() {
        return dis_tx_status;
    }

    /**
     * @param dis_tx_status the dis_tx_status to set
     */
    public void setDis_tx_status(String dis_tx_status) {
        this.dis_tx_status = dis_tx_status;
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