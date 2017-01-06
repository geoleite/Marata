package br.com.easynet.nfegen.transfer;

import br.com.easynet.annotation.Conversion;

public class Rel_registro_logT {

    private long rel_nr_id;
    private long dis_nr_id;
    private String rel_tx_ip;
    private int rel_tx_numeronota;
    private String rel_tx_usuario;
    @Conversion(classe = "br.com.easynet.convesion.ConvertTimestamp", format = "dd/MM/yyyy HH:mm")
    private java.sql.Timestamp rel_dt_datahora;

    public void setRel_nr_id(long rel_nr_id) {
        this.rel_nr_id = rel_nr_id;
    }

    public long getRel_nr_id() {
        return rel_nr_id;
    }

    public void setRel_tx_numeronota(int rel_tx_numeronota) {
        this.rel_tx_numeronota = rel_tx_numeronota;
    }

    public int getRel_tx_numeronota() {
        return rel_tx_numeronota;
    }

    public void setRel_dt_datahora(java.sql.Timestamp rel_dt_datahora) {
        this.rel_dt_datahora = rel_dt_datahora;
    }

    public java.sql.Timestamp getRel_dt_datahora() {
        return rel_dt_datahora;
    }

    /**
     * @return the rel_tx_ip
     */
    public String getRel_tx_ip() {
        return rel_tx_ip;
    }

    /**
     * @param rel_tx_ip the rel_tx_ip to set
     */
    public void setRel_tx_ip(String rel_tx_ip) {
        this.rel_tx_ip = rel_tx_ip;
    }

    /**
     * @return the rel_tx_usuario
     */
    public String getRel_tx_usuario() {
        return rel_tx_usuario;
    }

    /**
     * @param rel_tx_usuario the rel_tx_usuario to set
     */
    public void setRel_tx_usuario(String rel_tx_usuario) {
        this.rel_tx_usuario = rel_tx_usuario;
    }

    /**
     * @return the dis_nr_id
     */
    public long getDis_nr_id() {
        return dis_nr_id;
    }

    /**
     * @param dis_nr_id the dis_nr_id to set
     */
    public void setDis_nr_id(long dis_nr_id) {
        this.dis_nr_id = dis_nr_id;
    }
}
