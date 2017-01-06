
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
public class Gnfe_cliente_fornecedorTGWT extends BaseModel {
  public Gnfe_cliente_fornecedorTGWT() {
  }

  public String getCodigo() {
    return  get("codigo");
  }

  public void setCodigo(String codigo) {
    set("codigo", codigo);
  }

  public String getNum_cgc_cpf() {
    return  get("num_cgc_cpf");
  }

  public void setNum_cgc_cpf(String num_cgc_cpf) {
    set("num_cgc_cpf", num_cgc_cpf);
  }

  public String getRazao() {
    return  get("razao");
  }

  public void setRazao(String razao) {
    set("razao", razao);
  }

  public String getStatus() {
    return  get("status");
  }

  public void setStatus(String status) {
    set("status", status);
  }

  public String getTipo() {
    return  get("tipo");
  }

  public void setTipo(String tipo) {
    set("tipo", tipo);
  }



}

