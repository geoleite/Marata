/*
 * EasyNet JDragon
 */
package br.com.i9.marata.client.nfe.GJAV.gnfe_cliente_fornecedor;

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
public class Gnfe_cliente_fornecedorConsultGWT extends CPConsultarBaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Gnfe_cliente_fornecedorDAOGWT gnfe_cliente_fornecedorDao = new Gnfe_cliente_fornecedorDAOGWT();
    private EasyTextField<String> etfNomeCNPJ = new EasyTextField<String>();
    private Button btnFind = new Button("", ICONS.find());

    public Gnfe_cliente_fornecedorConsultGWT() {
        setHeaderVisible(false);
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Gnfe_cliente_fornecedorTGWT>> numberRenderer = new NumberCellRenderer<Grid<Gnfe_cliente_fornecedorTGWT>>(currency);
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
        getBtnNovoSuper().setVisible(false);
        etfNomeCNPJ.setEmptyText("Nome ou CNPJ/CPF");
        getToolBarMaster().add(etfNomeCNPJ);
        getToolBarMaster().add(btnFind);
        GridCellRenderer<Gnfe_cliente_fornecedorTGWT> tipoGrid = new GridCellRenderer<Gnfe_cliente_fornecedorTGWT>() {

            public Object render(Gnfe_cliente_fornecedorTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Gnfe_cliente_fornecedorTGWT> store, Grid<Gnfe_cliente_fornecedorTGWT> grid) {
                return "1".equals(model.getTipo()) ? "Fornecedor" : "Cliente";
            }
        };

        GridCellRenderer<Gnfe_cliente_fornecedorTGWT> statusGrid = new GridCellRenderer<Gnfe_cliente_fornecedorTGWT>() {

            public Object render(Gnfe_cliente_fornecedorTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Gnfe_cliente_fornecedorTGWT> store, Grid<Gnfe_cliente_fornecedorTGWT> grid) {
                String txt = "<div style='color:cor'>valor</div>";
                String cor = "green";
                String valor = "Ativo";
                if ("S".equals(model.getStatus())) {
                    cor = "blue";
                    valor = "Suspenso";
                } else if ("C".equals(model.getStatus())) {
                    cor = "red";
                    valor = "Cancelado";
                } else if ("R".equals(model.getStatus())) {
                    cor = "yellow";
                    valor = "R";
                }
                txt = txt.replaceAll("cor", cor);
                txt = txt.replaceAll("valor", valor);
                return txt;
            }
        };

        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("num_cgc_cpf");
        column.setHeader("CGC/CPF");
        column.setWidth(120);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("razao");
        column.setHeader("Razao Social");
        column.setWidth(300);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);


        column = new ColumnConfig();
        column.setId("tipo");
        column.setHeader("Tipo");
        column.setWidth(100);
        column.setRenderer(tipoGrid);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("status");
        column.setHeader("Situação");
        column.setWidth(100);
        column.setRenderer(statusGrid);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);




//        column = new ColumnConfig();
//        column.setId("colEditar");
//        column.setWidth(30);
//        column.setAlignment(HorizontalAlignment.CENTER);
//        column.setRenderer(getEditarRender());
//        configs.add(column);

        btnFind.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                load();
            }
        });

    }

    public void btnAtualizarAction(ButtonEvent be) {
        super.btnAtualizarAction(be);
    }

    public void btnNovoAction(ButtonEvent be) {
        Gnfe_cliente_fornecedorInsertGWT gnfe_cliente_fornecedorInsertGWT = new Gnfe_cliente_fornecedorInsertGWT();
        gnfe_cliente_fornecedorInsertGWT.setGnfe_cliente_fornecedorConsult(this);
        gnfe_cliente_fornecedorInsertGWT.setModal(true);
        gnfe_cliente_fornecedorInsertGWT.show();

    }

    private GridCellRenderer<Gnfe_cliente_fornecedorTGWT> getEditarRender() {
        return new GridCellRenderer<Gnfe_cliente_fornecedorTGWT>() {

            public Object render(final Gnfe_cliente_fornecedorTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Gnfe_cliente_fornecedorTGWT> store, Grid<Gnfe_cliente_fornecedorTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Gnfe_cliente_fornecedorUpdateDeleteGWT gnfe_cliente_fornecedorUpdateDeleteGWT = new Gnfe_cliente_fornecedorUpdateDeleteGWT();
                        gnfe_cliente_fornecedorUpdateDeleteGWT.setGnfe_cliente_fornecedorConsult(Gnfe_cliente_fornecedorConsultGWT.this);
                        gnfe_cliente_fornecedorUpdateDeleteGWT.load(model);
                        gnfe_cliente_fornecedorUpdateDeleteGWT.setVisible(true);
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
        if (etfNomeCNPJ.getValue() == null) {
            MessageBox.alert("ATENÇÃO", "É necessário informar o nome, cpf ou cnpj do cliente/fornecedor.", null);
            return;
        }
        Gnfe_cliente_fornecedorTGWT cliForT = new Gnfe_cliente_fornecedorTGWT();
        cliForT.setRazao(etfNomeCNPJ.getValue());
        gnfe_cliente_fornecedorDao.consultByNomeCpfCnpj(cliForT);
        Timer timer = new Timer() {

            public void run() {
                ListStore<Gnfe_cliente_fornecedorTGWT> list = gnfe_cliente_fornecedorDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configs);

                    PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                    PagingLoader<PagingLoadResult<Gnfe_cliente_fornecedorTGWT>> loader = new BasePagingLoader<PagingLoadResult<Gnfe_cliente_fornecedorTGWT>>(proxy);
                    loader.setRemoteSort(true);

                    ListStore<Gnfe_cliente_fornecedorTGWT> store = new ListStore<Gnfe_cliente_fornecedorTGWT>(loader);
                    store.add(list.getModels());

                    getToolBarPage().setPageSize(20);
                    getToolBarPage().bind(loader);
                    loader.load(0, 20);


                    Grid<Gnfe_cliente_fornecedorTGWT> grid = new Grid<Gnfe_cliente_fornecedorTGWT>(store, cm);
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
