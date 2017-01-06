package br.com.i9.marata.transfer;

import br.com.easynet.annotation.Conversion;

public class Gnfe_cliente_fornecedorT { 
	 private String codigo;
	 private String razao;
	 private String status;
	 private String num_cgc_cpf;
	 private String tipo;
	 public void setCodigo(String codigo) {
		 this.codigo=codigo;
	}
 
	 public String getCodigo() {
		 return codigo;
 	} 
 	 public void setRazao(String razao) {
		 this.razao=razao;
	}
 
	 public String getRazao() {
		 return razao;
 	} 
 	 public void setStatus(String status) {
		 this.status=status;
	}
 
	 public String getStatus() {
		 return status;
 	} 
 	 public void setTipo(String tipo) {
		 this.tipo=tipo;
	}
 
	 public String getTipo() {
		 return tipo;
 	}

    /**
     * @return the num_cgc_cpf
     */
    public String getNum_cgc_cpf() {
        return num_cgc_cpf;
    }

    /**
     * @param num_cgc_cpf the num_cgc_cpf to set
     */
    public void setNum_cgc_cpf(String num_cgc_cpf) {
        this.num_cgc_cpf = num_cgc_cpf;
    }
 }