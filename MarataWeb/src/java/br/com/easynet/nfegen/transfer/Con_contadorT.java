package br.com.easynet.nfegen.transfer;

import br.com.easynet.annotation.Conversion;

public class Con_contadorT { 
	 private int con_nr_id;
	 private String con_tx_cpf;
	 private String con_tx_nome;
     
	 public void setCon_nr_id(int con_nr_id) {
		 this.con_nr_id=con_nr_id;
	}
 
	 public int getCon_nr_id() {
		 return con_nr_id;
 	} 
 	 public void setCon_tx_cpf(String con_tx_cpf) {
		 this.con_tx_cpf=con_tx_cpf;
	}
 
	 public String getCon_tx_cpf() {
		 return con_tx_cpf;
 	}

    /**
     * @return the con_tx_nome
     */
    public String getCon_tx_nome() {
        return con_tx_nome;
    }

    /**
     * @param con_tx_nome the con_tx_nome to set
     */
    public void setCon_tx_nome(String con_tx_nome) {
        this.con_tx_nome = con_tx_nome;
    }
 }