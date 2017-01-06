package br.com.easynet.nfegen.transfer;

import br.com.easynet.annotation.Conversion;

public class Emp_empresaT {

    private int emp_nr_id;
    private String emp_tx_nome;
    private String emp_tx_cnpj;
    private String emp_tx_ie;
    private String emp_tx_cep;
    private String emp_tx_endereco;
    private String emp_tx_bairro;
    private String emp_tx_cidade;
    private String emp_tx_estado;
    private int emp_nr_id_super=-1;


    public void setEmp_nr_id(int emp_nr_id) {
        this.emp_nr_id = emp_nr_id;
    }

    public int getEmp_nr_id() {
        return emp_nr_id;
    }

    public void setEmp_tx_nome(String emp_tx_nome) {
        this.emp_tx_nome = emp_tx_nome;
    }

    public String getEmp_tx_nome() {
        return emp_tx_nome;
    }

    public String getEmp_tx_cnpj() {
        return emp_tx_cnpj;
    }

    public void setEmp_tx_cnpj(String emp_tx_cnpj) {
        this.emp_tx_cnpj = emp_tx_cnpj;
    }

    /**
     * @return the emp_tx_ie
     */
    public String getEmp_tx_ie() {
        return emp_tx_ie;
    }

    /**
     * @param emp_tx_ie the emp_tx_ie to set
     */
    public void setEmp_tx_ie(String emp_tx_ie) {
        this.emp_tx_ie = emp_tx_ie;
    }

    /**
     * @return the emp_tx_cep
     */
    public String getEmp_tx_cep() {
        return emp_tx_cep;
    }

    /**
     * @param emp_tx_cep the emp_tx_cep to set
     */
    public void setEmp_tx_cep(String emp_tx_cep) {
        this.emp_tx_cep = emp_tx_cep;
    }

    /**
     * @return the emp_tx_endereco
     */
    public String getEmp_tx_endereco() {
        return emp_tx_endereco;
    }

    /**
     * @param emp_tx_endereco the emp_tx_endereco to set
     */
    public void setEmp_tx_endereco(String emp_tx_endereco) {
        this.emp_tx_endereco = emp_tx_endereco;
    }

    /**
     * @return the emp_tx_bairro
     */
    public String getEmp_tx_bairro() {
        return emp_tx_bairro;
    }

    /**
     * @param emp_tx_bairro the emp_tx_bairro to set
     */
    public void setEmp_tx_bairro(String emp_tx_bairro) {
        this.emp_tx_bairro = emp_tx_bairro;
    }

    /**
     * @return the emp_tx_cidade
     */
    public String getEmp_tx_cidade() {
        return emp_tx_cidade;
    }

    /**
     * @param emp_tx_cidade the emp_tx_cidade to set
     */
    public void setEmp_tx_cidade(String emp_tx_cidade) {
        this.emp_tx_cidade = emp_tx_cidade;
    }

    /**
     * @return the emp_tx_estado
     */
    public String getEmp_tx_estado() {
        return emp_tx_estado;
    }

    /**
     * @param emp_tx_estado the emp_tx_estado to set
     */
    public void setEmp_tx_estado(String emp_tx_estado) {
        this.emp_tx_estado = emp_tx_estado;
    }

    public String toString() {
        return emp_tx_cnpj + "-" + emp_tx_nome + "-" + emp_tx_ie + "-" +
               emp_tx_estado + "-" + emp_tx_cidade + "-" + emp_tx_bairro + "-" +
               emp_tx_endereco + "-" + emp_tx_cep;
    }

    /**
     * @return the emp_nr_id_super
     */
    public int getEmp_nr_id_super() {
        return emp_nr_id_super;
    }

    /**
     * @param emp_nr_id_super the emp_nr_id_super to set
     */
    public void setEmp_nr_id_super(int emp_nr_id_super) {
        this.emp_nr_id_super = emp_nr_id_super;
    }

    /**
     * @return the emp_tx_municipio
     */
}