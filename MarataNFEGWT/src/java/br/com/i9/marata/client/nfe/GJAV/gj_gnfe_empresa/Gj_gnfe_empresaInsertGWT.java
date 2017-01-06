/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.marata.client.nfe.GJAV.gj_gnfe_empresa;

import br.com.i9.marata.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.marata.client.nfe.GJAV.transfer.*;
import br.com.i9.marata.client.nfe.GJAV.dao.*;
import br.com.easynet.gwt.client.CadastrarBaseGWT;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Gj_gnfe_empresaInsertGWT extends CadastrarBaseGWT  {
    private Gj_gnfe_empresaConsultGWT gj_gnfe_empresaConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

	private Gj_gnfe_empresaDAOGWT gj_gnfe_empresaDao = new Gj_gnfe_empresaDAOGWT();
    private EasyTextField<String> cod_empresa = new EasyTextField<String>();
    private EasyTextField<String> cnpj_empresa = new EasyTextField<String>();
    private EasyTextField<String> den_empresa = new EasyTextField<String>();
    private EasyTextField<String> id_ent = new EasyTextField<String>();


    public Gj_gnfe_empresaInsertGWT() {
	setHeading("Cadastrar Gj_gnfe_empresa");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);

	LabelField lfcod_empresa = new LabelField("cod_empresa:");
        lfcod_empresa.setId("lfcod_empresa");
	getCpMaster().add(lfcod_empresa);
        cod_empresa.setId("cod_empresa");
        cod_empresa.setMaxLength(2);
        getCpMaster().add(cod_empresa);

	LabelField lfcnpj_empresa = new LabelField("cnpj_empresa:");
        lfcnpj_empresa.setId("lfcnpj_empresa");
	getCpMaster().add(lfcnpj_empresa);
        cnpj_empresa.setId("cnpj_empresa");
        cnpj_empresa.setMaxLength(14);
        getCpMaster().add(cnpj_empresa);

	LabelField lfden_empresa = new LabelField("den_empresa:");
        lfden_empresa.setId("lfden_empresa");
	getCpMaster().add(lfden_empresa);
        den_empresa.setId("den_empresa");
        den_empresa.setMaxLength(36);
        getCpMaster().add(den_empresa);

	LabelField lfid_ent = new LabelField("id_ent:");
        lfid_ent.setId("lfid_ent");
	getCpMaster().add(lfid_ent);
        id_ent.setId("id_ent");
        id_ent.setMaxLength(6);
        getCpMaster().add(id_ent);


    }

    public void btnInsertAction(ButtonEvent ce){
	Gj_gnfe_empresaTGWT gj_gnfe_empresaT = new Gj_gnfe_empresaTGWT();
			gj_gnfe_empresaT.setCod_empresa(cod_empresa.getValue());
		gj_gnfe_empresaT.setCnpj_empresa(cnpj_empresa.getValue());
		gj_gnfe_empresaT.setDen_empresa(den_empresa.getValue());
		gj_gnfe_empresaT.setId_ent(id_ent.getValue());

        gj_gnfe_empresaDao.inserir(gj_gnfe_empresaT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = gj_gnfe_empresaDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  btnLimpartAction(null);
		  gj_gnfe_empresaConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }
    public void btnLimpartAction(ButtonEvent ce){
			cod_empresa.setValue("");
		cnpj_empresa.setValue("");
		den_empresa.setValue("");
		id_ent.setValue("");

    }

   /**
     * @return the gj_gnfe_empresaConsult
     */
    public Gj_gnfe_empresaConsultGWT getGj_gnfe_empresaConsult() {
        return gj_gnfe_empresaConsult;
    }

    /**
     * @param gj_gnfe_empresaConsult the gj_gnfe_empresaConsult to set
     */
    public void setGj_gnfe_empresaConsult(Gj_gnfe_empresaConsultGWT gj_gnfe_empresaConsult) {
        this.gj_gnfe_empresaConsult = gj_gnfe_empresaConsult;
    }
}

