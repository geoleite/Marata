
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
public class Gj_gnfe_empresaTGWT extends BaseModel {
  public Gj_gnfe_empresaTGWT() {
  }

  public String getCod_empresa() {
    return  get("cod_empresa");
  }

  public void setCod_empresa(String cod_empresa) {
    set("cod_empresa", cod_empresa);
  }

  public String getCnpj_empresa() {
    return  get("cnpj_empresa");
  }

  public void setCnpj_empresa(String cnpj_empresa) {
    set("cnpj_empresa", cnpj_empresa);
  }

  public String getDen_empresa() {
    return  get("den_empresa");
  }

  public void setDen_empresa(String den_empresa) {
    set("den_empresa", den_empresa);
  }

  public String getId_ent() {
    return  get("id_ent");
  }

  public void setId_ent(String id_ent) {
    set("id_ent", id_ent);
  }



}

