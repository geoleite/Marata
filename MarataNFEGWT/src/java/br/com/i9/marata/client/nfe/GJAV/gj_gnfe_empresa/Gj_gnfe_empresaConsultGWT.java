/*
 * EasyNet JDragon
 */
package br.com.i9.marata.client.nfe.GJAV.gj_gnfe_empresa;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
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
public class Gj_gnfe_empresaConsultGWT extends CPConsultarBaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Gj_gnfe_empresaDAOGWT gj_gnfe_empresaDao = new Gj_gnfe_empresaDAOGWT();

    public Gj_gnfe_empresaConsultGWT() {
        setHeaderVisible(false);
        getBtnNovoSuper().setVisible(false);
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Gj_gnfe_empresaTGWT>> numberRenderer = new NumberCellRenderer<Grid<Gj_gnfe_empresaTGWT>>(currency);
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
        column.setId("cnpj_empresa");
        column.setHeader("Cnpj");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("den_empresa");
        column.setHeader("Empresa");
        column.setWidth(300);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);
//
//        column = new ColumnConfig();
//        column.setId("colEditar");
//        column.setWidth(30);
//        column.setAlignment(HorizontalAlignment.CENTER);
//        column.setRenderer(getEditarRender());
//        configs.add(column);

        load();
    }

    public void btnAtualizarAction(ButtonEvent be) {
        super.btnAtualizarAction(be);
    }

    public void btnNovoAction(ButtonEvent be) {
        Gj_gnfe_empresaInsertGWT gj_gnfe_empresaInsertGWT = new Gj_gnfe_empresaInsertGWT();
        gj_gnfe_empresaInsertGWT.setGj_gnfe_empresaConsult(this);
        gj_gnfe_empresaInsertGWT.setModal(true);
        gj_gnfe_empresaInsertGWT.show();

    }

    private GridCellRenderer<Gj_gnfe_empresaTGWT> getEditarRender() {
        return new GridCellRenderer<Gj_gnfe_empresaTGWT>() {

            public Object render(final Gj_gnfe_empresaTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Gj_gnfe_empresaTGWT> store, Grid<Gj_gnfe_empresaTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Gj_gnfe_empresaUpdateDeleteGWT gj_gnfe_empresaUpdateDeleteGWT = new Gj_gnfe_empresaUpdateDeleteGWT();
                        gj_gnfe_empresaUpdateDeleteGWT.setGj_gnfe_empresaConsult(Gj_gnfe_empresaConsultGWT.this);
                        gj_gnfe_empresaUpdateDeleteGWT.load(model);
                        gj_gnfe_empresaUpdateDeleteGWT.setVisible(true);
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
        gj_gnfe_empresaDao.consultarTodos();
        Timer timer = new Timer() {

            public void run() {
                ListStore<Gj_gnfe_empresaTGWT> list = gj_gnfe_empresaDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configs);

                    PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                    PagingLoader<PagingLoadResult<Gj_gnfe_empresaTGWT>> loader = new BasePagingLoader<PagingLoadResult<Gj_gnfe_empresaTGWT>>(proxy);
                    loader.setRemoteSort(true);

                    ListStore<Gj_gnfe_empresaTGWT> store = new ListStore<Gj_gnfe_empresaTGWT>(loader);
                    store.add(list.getModels());

                    getToolBarPage().setPageSize(20);
                    getToolBarPage().bind(loader);
                    loader.load(0, 20);


                    Grid<Gj_gnfe_empresaTGWT> grid = new Grid<Gj_gnfe_empresaTGWT>(store, cm);
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
