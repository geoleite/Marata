package br.com.i9.marata.client.nfe.GJAV.gnfe_cliente_fornecedor;

import br.com.i9.marata.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.marata.client.nfe.GJAV.transfer.*;
import br.com.i9.marata.client.nfe.GJAV.dao.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;

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
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.widget.Dialog;

/**
 *
 * @author geoleite
 */
public class Gnfe_cliente_fornecedorUpdateDeleteGWT extends AlterarExcluirBaseGWT {
    private Gnfe_cliente_fornecedorConsultGWT gnfe_cliente_fornecedorConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Gnfe_cliente_fornecedorDAOGWT gnfe_cliente_fornecedorDao = new Gnfe_cliente_fornecedorDAOGWT();
    private Gnfe_cliente_fornecedorTGWT gnfe_cliente_fornecedorT;

    private EasyTextField<String> codigo = new EasyTextField<String>();
    private EasyTextField<String> razao = new EasyTextField<String>();
    private EasyTextField<String> status = new EasyTextField<String>();
    private EasyTextField<String> tipo = new EasyTextField<String>();


    public Gnfe_cliente_fornecedorUpdateDeleteGWT() {
        setHeading("Alterar Gnfe_cliente_fornecedor");
        this.setSize("500", "400");
	TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);
	LabelField lfcodigo = new LabelField("codigo:");
        lfcodigo.setId("lfcodigo");
	getCpMaster().add(lfcodigo);
        codigo.setId("codigo");
        codigo.setMaxLength(20);
        getCpMaster().add(codigo);

	LabelField lfrazao = new LabelField("razao:");
        lfrazao.setId("lfrazao");
	getCpMaster().add(lfrazao);
        razao.setId("razao");
        razao.setMaxLength(20);
        getCpMaster().add(razao);

	LabelField lfstatus = new LabelField("status:");
        lfstatus.setId("lfstatus");
	getCpMaster().add(lfstatus);
        status.setId("status");
        status.setMaxLength(20);
        getCpMaster().add(status);

	LabelField lftipo = new LabelField("tipo:");
        lftipo.setId("lftipo");
	getCpMaster().add(lftipo);
        tipo.setId("tipo");
        tipo.setMaxLength(20);
        getCpMaster().add(tipo);


    }

    public void load(Gnfe_cliente_fornecedorTGWT gnfe_cliente_fornecedorT) {
	this.gnfe_cliente_fornecedorT = gnfe_cliente_fornecedorT;
		codigo.setValue(gnfe_cliente_fornecedorT.getCodigo());
		razao.setValue(gnfe_cliente_fornecedorT.getRazao());
		status.setValue(gnfe_cliente_fornecedorT.getStatus());
		tipo.setValue(gnfe_cliente_fornecedorT.getTipo());

    }
    public void btnUpdateAction(ButtonEvent ce) {
		gnfe_cliente_fornecedorT.setCodigo(codigo.getValue());
		gnfe_cliente_fornecedorT.setRazao(razao.getValue());
		gnfe_cliente_fornecedorT.setStatus(status.getValue());
		gnfe_cliente_fornecedorT.setTipo(tipo.getValue());

	gnfe_cliente_fornecedorDao.alterar(gnfe_cliente_fornecedorT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = gnfe_cliente_fornecedorDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  gnfe_cliente_fornecedorConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

        MessageBox.confirm("Aviso", "Tem certeza que deseja excluir registro?", new Listener<MessageBoxEvent>() {

            public void handleEvent(MessageBoxEvent be) {

                if (new Dialog().yesText.equalsIgnoreCase(be.getButtonClicked().getText())) {
		  gnfe_cliente_fornecedorDao.excluir(gnfe_cliente_fornecedorT);
		  Timer timer = new Timer() {
	   	    public void run() {
 	     		String msg = gnfe_cliente_fornecedorDao.getMsg();
 	     		if (msg == null) {
			  schedule(500);
	     		} else {
			  if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  		MessageBox.alert("Problemas", msg, null);
			  } else {
		  		Info.display("Resultado", msg);
		  		gnfe_cliente_fornecedorConsult.load();
		  		setVisible(false);
			  }
	     		}
	   	  }
        	};
		timer.schedule(500);                    
                }
            }
        });
    }


   /**
     * @return the gnfe_cliente_fornecedorConsult
     */
    public Gnfe_cliente_fornecedorConsultGWT getGnfe_cliente_fornecedorConsult() {
        return gnfe_cliente_fornecedorConsult;
    }

    /**
     * @param gnfe_cliente_fornecedorConsult the gnfe_cliente_fornecedorConsult to set
     */
    public void setGnfe_cliente_fornecedorConsult(Gnfe_cliente_fornecedorConsultGWT gnfe_cliente_fornecedorConsult) {
        this.gnfe_cliente_fornecedorConsult = gnfe_cliente_fornecedorConsult;
    }

}

