/*
 * EasyNet JDragon
 */
package br.com.i9.marata.client.nfe.GJAV.gj_gnfe_nota_fiscal;

import br.com.i9.marata.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;


import br.com.i9.marata.client.nfe.GJAV.transfer.*;
import br.com.i9.marata.client.nfe.GJAV.dao.*;
import br.com.easynet.gwt.client.ConsultarBaseGWT;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.Listener;

import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import java.util.Date;
import com.google.gwt.user.client.Timer;
/**
 *
 * @author geoleite
 */
public class Gj_gnfe_nota_fiscalConsultGWT extends ConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Gj_gnfe_nota_fiscalDAOGWT gj_gnfe_nota_fiscalDao = new Gj_gnfe_nota_fiscalDAOGWT();
    public Gj_gnfe_nota_fiscalConsultGWT() {
        
            this.setSize("500", "400");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Gj_gnfe_nota_fiscalTGWT>> numberRenderer = new NumberCellRenderer<Grid<Gj_gnfe_nota_fiscalTGWT>>(currency);
            /*
            GridCellRenderer<Stock> change = new GridCellRenderer<Stock>() {
            public String render(Stock model, String property, ColumnData config, int rowIndex,
            int colIndex, ListStore<Stock> store) {
            double val = (Double) model.get(property);
            String style = val < 0 ? "red" : "green";
            return "<span style='color:" + style + "'>" + number.format(val) + "</span>";
            }
            };
            GridCellRenderer<Stock> gridNumber = new GridCellRenderer<Stock>() {
            public String render(Stock model, String property, ColumnData config, int rowIndex,
            int colIndex, ListStore<Stock> store) {
            return numberRenderer.render(null, property, model.get(property));
            }
            };
             */
            ColumnConfig column = null;

	    column = new ColumnConfig();
            column.setId("id_ent");
            column.setHeader("Id_ent");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("nfe_id");
            column.setHeader("Nfe_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("reg_nfe");
            column.setHeader("Reg_nfe");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("des_reg");
            column.setHeader("Des_reg");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("modelo");
            column.setHeader("Modelo");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("ambiente");
            column.setHeader("Ambiente");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("modalidade");
            column.setHeader("Modalidade");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("status");
            column.setHeader("Status");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("cstatus_sefr");
            column.setHeader("Cstatus_sefr");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("xmot_sefr");
            column.setHeader("Xmot_sefr");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("xml_sig");
            column.setHeader("Xml_sig");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("xml_sig_mail");
            column.setHeader("Xml_sig_mail");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("prot");
            column.setHeader("Prot");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("date_prot");
            column.setHeader("Date_prot");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("xml_prot");
            column.setHeader("Xml_prot");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("xml_prot_mail");
            column.setHeader("Xml_prot_mail");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("origem");
            column.setHeader("Origem");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("status_java");
            column.setHeader("Status_java");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("status_totvs");
            column.setHeader("Status_totvs");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("totvs_cod_empresa");
            column.setHeader("Totvs_cod_empresa");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("totvs_num_ar");
            column.setHeader("Totvs_num_ar");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("totvs_num_nfe");
            column.setHeader("Totvs_num_nfe");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("totvs_ser_nfe");
            column.setHeader("Totvs_ser_nfe");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("totvs_ssr_nfe");
            column.setHeader("Totvs_ssr_nfe");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("totvs_emi_nfe");
            column.setHeader("Totvs_emi_nfe");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("totvs_des_nfe");
            column.setHeader("Totvs_des_nfe");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("totvs_dat_nfe");
            column.setHeader("Totvs_dat_nfe");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("totvs_val_nfe");
            column.setHeader("Totvs_val_nfe");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("num_cgc_cpf");
            column.setHeader("Num_cgc_cpf");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);



	    column = new ColumnConfig();
            column.setId("colEditar");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.CENTER);
            column.setRenderer(getEditarRender());
            configs.add(column);

	load();
    }

    public void btnAtualizarAction(ButtonEvent be){
        super.btnAtualizarAction(be);
    }

    public void btnNovoAction(ButtonEvent be) {
        Gj_gnfe_nota_fiscalInsertGWT gj_gnfe_nota_fiscalInsertGWT = new Gj_gnfe_nota_fiscalInsertGWT();
        gj_gnfe_nota_fiscalInsertGWT.setGj_gnfe_nota_fiscalConsult(this);
        gj_gnfe_nota_fiscalInsertGWT.setModal(true);
        gj_gnfe_nota_fiscalInsertGWT.show();

    }
    private GridCellRenderer<Gj_gnfe_nota_fiscalTGWT> getEditarRender() {
        return new GridCellRenderer<Gj_gnfe_nota_fiscalTGWT>() {


            public Object render(final Gj_gnfe_nota_fiscalTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Gj_gnfe_nota_fiscalTGWT> store, Grid<Gj_gnfe_nota_fiscalTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Gj_gnfe_nota_fiscalUpdateDeleteGWT gj_gnfe_nota_fiscalUpdateDeleteGWT = new Gj_gnfe_nota_fiscalUpdateDeleteGWT();
                        gj_gnfe_nota_fiscalUpdateDeleteGWT.setGj_gnfe_nota_fiscalConsult(Gj_gnfe_nota_fiscalConsultGWT.this);
                        gj_gnfe_nota_fiscalUpdateDeleteGWT.load(model);
                        gj_gnfe_nota_fiscalUpdateDeleteGWT.setVisible(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar dados.");
                b.setIcon(ICONS.edit());
		b.setId("btnEditar");

                return b;
            }
        };
    }

  public void load() {
    gj_gnfe_nota_fiscalDao.consultarTodos();
    Timer timer = new Timer() {
            public void run() {
                ListStore<Gj_gnfe_nota_fiscalTGWT> list = gj_gnfe_nota_fiscalDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configs);

        	    PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                    PagingLoader<PagingLoadResult<Gj_gnfe_nota_fiscalTGWT>> loader = new BasePagingLoader<PagingLoadResult<Gj_gnfe_nota_fiscalTGWT>>(proxy);
        	    loader.setRemoteSort(true);

        	    ListStore<Gj_gnfe_nota_fiscalTGWT> store = new ListStore<Gj_gnfe_nota_fiscalTGWT>(loader);
        	    store.add(list.getModels());

        	    getToolBarPage().setPageSize(20);
        	    getToolBarPage().bind(loader);
        	    loader.load(0, 20);


                    Grid<Gj_gnfe_nota_fiscalTGWT> grid = new Grid<Gj_gnfe_nota_fiscalTGWT>(store, cm);
		    grid.setId("grid");
                    grid.setLoadMask(true);

                    grid.setStyleAttribute("borderTop", "none");
                    grid.setBorders(true);
                    grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                    getCpMaster().add(grid);
                    getCpMaster().layout();
                }
            }
    };
    timer.schedule(500);
  }
}

