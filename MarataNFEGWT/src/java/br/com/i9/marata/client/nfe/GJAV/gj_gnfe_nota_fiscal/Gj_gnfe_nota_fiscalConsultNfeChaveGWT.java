/*
 * EasyNet JDragon
 */
package br.com.i9.marata.client.nfe.GJAV.gj_gnfe_nota_fiscal;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.i9.marata.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;


import br.com.i9.marata.client.nfe.GJAV.transfer.*;
import br.com.i9.marata.client.nfe.GJAV.dao.*;
import br.com.easynet.gwt.client.ConsultarBaseGWT;

import br.com.easynet.gwt.client.component.EasyNumberField;
import br.com.i9.marata.client.icons.Icones;
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
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import java.util.Date;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Gj_gnfe_nota_fiscalConsultNfeChaveGWT extends CPConsultarBaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Gj_gnfe_nota_fiscalDAOGWT gj_gnfe_nota_fiscalDao = new Gj_gnfe_nota_fiscalDAOGWT();
    private EasyTextField<String> etfNfe = new EasyTextField<String>();
    private Button btnPesquisar = new Button("", ICONS.find());
    private CheckBoxSelectionModel<Gj_gnfe_nota_fiscalTGWT> sm = new CheckBoxSelectionModel<Gj_gnfe_nota_fiscalTGWT>();
    private Button btnDownload = new Button("", ICONS.download());
    protected Button btnEnviarEmail = new Button("", Icones.ICONS.email());

    private NumberFormat formatNumber = NumberFormat.getFormat("#,##0.00");

    public Gj_gnfe_nota_fiscalConsultNfeChaveGWT() {

        setHeaderVisible(false);
        etfNfe.setWidth(300);
        etfNfe.setEmptyText("Número Nota Totvs!");
        etfNfe.setMaskFormat("000000000");
        getBtnNovoSuper().setVisible(false);
        getToolBarMaster().add(etfNfe);
        getToolBarMaster().add(btnPesquisar);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(btnDownload);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(btnEnviarEmail);
        btnDownload.setToolTip("Download de Notas selecionadas.");
        btnEnviarEmail.setToolTip("Enviar Notas por email.");

        btnEnviarEmail.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                List<Gj_gnfe_nota_fiscalTGWT> listNotas = sm.getSelectedItems();
                if (listNotas == null || listNotas.size() ==0) {
                    MessageBox.alert("AVISO", "É necessário selecionar pelo menos uma nota para enviar por email.", null);
                    return;
                }
                //Download das notas fiscais
                String ids = "ids=0";
                for (int i = 0; i < listNotas.size(); i++) {
                    Gj_gnfe_nota_fiscalTGWT gj_gnfe_nota_fiscalTGWT = listNotas.get(i);
                    ids += "&ids=" + gj_gnfe_nota_fiscalTGWT.getNfe_id();
                }
                SolicitarEmail solicitarEmail = new SolicitarEmail();
                solicitarEmail.setIds(ids);
                solicitarEmail.setVisible(true);
            }
        });

        btnDownload.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                List<Gj_gnfe_nota_fiscalTGWT> listNotas = sm.getSelectedItems();
                if (listNotas == null || listNotas.size() ==0) {
                    MessageBox.alert("AVISO", "É necessário selecionar pelo menos uma nota para download.", null);
                    return;
                }
                //Download das notas fiscais
                String ids = "ids=0";
                for (int i = 0; i < listNotas.size(); i++) {
                    Gj_gnfe_nota_fiscalTGWT gj_gnfe_nota_fiscalTGWT = listNotas.get(i);
                    ids += "&ids=" + gj_gnfe_nota_fiscalTGWT.getNfe_id();
                }
                com.extjs.gxt.ui.client.widget.Window win = new com.extjs.gxt.ui.client.widget.Window();
                win.setHeading("Download NFE Zip");
                win.setSize(200, 50);
                win.setLayout(new CenterLayout());
                String url = Constantes.URL + "nfe/GJAV/gj_gnfe_nota_fiscal/downloadnfe.jsp?op=downloadsImage&=" + ids;
                LabelField download = new LabelField("<a href=\"" + url + "\">DOWNLOAD</a>");
                win.add(download);
                win.setVisible(true);

            }
        });
//        etfNfe.addKeyDownHandler(new KeyDownHandler() {
//
//            
//            @Override
//            public void onKeyDown(KeyDownEvent event) {
//                if (KeyCodes.KEY_ENTER == event.getNativeKeyCode()) {
//                    load();
//                }
//            }
//        } 

        //        etfNfe.addListener(Events.OnKeyPress, new Listener<KeyEvent>() {
        //
        //            public void handleEvent(KeyEvent ke) {
        //                load();
        //            }
        //        });
        KeyListener klLocImo = new KeyListener() {

            @Override
            public void componentKeyPress(ComponentEvent event) {
                if (event.getKeyCode() == 13) {
                    load();

                }
            }
        };

        etfNfe.addKeyListener(klLocImo);

        btnPesquisar.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                load();
            }
        });
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Gj_gnfe_nota_fiscalTGWT>> numberRenderer = new NumberCellRenderer<Grid<Gj_gnfe_nota_fiscalTGWT>>(currency);
        final DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");

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


        GridCellRenderer<Gj_gnfe_nota_fiscalTGWT> statusNotaGrid = new GridCellRenderer<Gj_gnfe_nota_fiscalTGWT>() {

            public Object render(Gj_gnfe_nota_fiscalTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Gj_gnfe_nota_fiscalTGWT> store, Grid<Gj_gnfe_nota_fiscalTGWT> grid) {
                String txt = "<div style='color:cor'>valor</div>";
                String cor = "green";
                String valor = "Sim";
                if (0 == model.getTotvs_num_nfe()) {
                    cor = "red";
                    valor = "Não";
                }
                txt = txt.replaceAll("cor", cor);
                txt = txt.replaceAll("valor", valor);
                return txt;
            }
        };

        GridCellRenderer<Gj_gnfe_nota_fiscalTGWT> statusJavaGrid = new GridCellRenderer<Gj_gnfe_nota_fiscalTGWT>() {

            public Object render(Gj_gnfe_nota_fiscalTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Gj_gnfe_nota_fiscalTGWT> store, Grid<Gj_gnfe_nota_fiscalTGWT> grid) {
                String txt = "<div style='color:cor'>valor</div>";
                String cor = "green";
                String valor = "Sim";
                if (0 == model.getStatus_java()) {
                    cor = "red";
                    valor = "Não";
                }
                txt = txt.replaceAll("cor", cor);
                txt = txt.replaceAll("valor", valor);
                return txt;
            }
        };

        GridCellRenderer<Gj_gnfe_nota_fiscalTGWT> statusTotvsGrid = new GridCellRenderer<Gj_gnfe_nota_fiscalTGWT>() {

            public Object render(Gj_gnfe_nota_fiscalTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Gj_gnfe_nota_fiscalTGWT> store, Grid<Gj_gnfe_nota_fiscalTGWT> grid) {
                String txt = "<div style='color:cor'>valor</div>";
                String cor = "green";
                String valor = "Sim";
                if (0 == model.getStatus_totvs()) {
                    cor = "red";
                    valor = "Não";
                }
                txt = txt.replaceAll("cor", cor);
                txt = txt.replaceAll("valor", valor);
                return txt;
            }
        };

        ColumnConfig column = null;

        //Checkbox
        configs.add(sm.getColumn());

        column = new ColumnConfig();
        column.setId("colDownload");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getDownloadRender());
        configs.add(column);

        column = new ColumnConfig();
        column.setId("colViewDanfe");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getViewDanfeRender());
        configs.add(column);


        column = new ColumnConfig();
        column.setId("nfe_id");
        column.setHeader("Nfe");
        column.setWidth(300);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setHeader("Nota Fiscal");
        column.setId("totvs_num_nfe");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.CENTER);
        configs.add(column);

        column = new ColumnConfig();
        column.setHeader("Série");
        column.setId("totvs_ser_nfe");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.CENTER);
        configs.add(column);

//        column = new ColumnConfig();
//        column.setHeader("Emissão");
//        column.setId("totvs_emi_nfe");
//        column.setWidth(100);
//        column.setAlignment(HorizontalAlignment.CENTER);
//        column.setRenderer(statusNotaGrid);
//        configs.add(column);

        column = new ColumnConfig();
        column.setId("date_prot");
        column.setHeader("Data");
        column.setWidth(100);
        column.setDateTimeFormat(dtf);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("num_cgc_cpf");
        column.setHeader("Emissor/Destino");
        column.setWidth(150);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("totvs_val_nfe");
        column.setHeader("Valor Nota");
        column.setWidth(100);
        column.setNumberFormat(formatNumber);
        column.setAlignment(HorizontalAlignment.RIGHT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("status_java");
        column.setHeader("Pelo Email");
        column.setWidth(80);
        column.setRenderer(statusJavaGrid);
        column.setAlignment(HorizontalAlignment.RIGHT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("status_totvs");
        column.setHeader("Pelo Totvs");
        column.setWidth(80);
        column.setRenderer(statusTotvsGrid);
        column.setAlignment(HorizontalAlignment.RIGHT);
        configs.add(column);

//        column = new ColumnConfig();
//        column.setId("colEditar");
//        column.setWidth(30);
//        column.setAlignment(HorizontalAlignment.CENTER);
//        column.setRenderer(getEditarRender());
//        configs.add(column);



        //load();
    }

    private GridCellRenderer<Gj_gnfe_nota_fiscalTGWT> getDownloadRender() {
        return new GridCellRenderer<Gj_gnfe_nota_fiscalTGWT>() {

            public Object render(final Gj_gnfe_nota_fiscalTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Gj_gnfe_nota_fiscalTGWT> store, Grid<Gj_gnfe_nota_fiscalTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        com.extjs.gxt.ui.client.widget.Window win = new com.extjs.gxt.ui.client.widget.Window();
                        win.setHeading("Download NFE");
                        win.setSize(200, 50);
                        win.setLayout(new CenterLayout());
                        String url = Constantes.URL + "nfe/GJAV/gj_gnfe_nota_fiscal/downloadnfe.jsp?op=downloadImage&gj_gnfe_nota_fiscalT.nfe_id=" + model.getNfe_id();
                        LabelField download = new LabelField("<a href=\"" + url + "\">DOWNLOAD</a>");
                        win.add(download);
                        win.setVisible(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Downoad Nota fiscal.");
                b.setIcon(ICONS.download());
                b.setId("btnDownload");

                return b;
            }
        };
    }

    private GridCellRenderer<Gj_gnfe_nota_fiscalTGWT> getViewDanfeRender() {
        return new GridCellRenderer<Gj_gnfe_nota_fiscalTGWT>() {

            public Object render(final Gj_gnfe_nota_fiscalTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Gj_gnfe_nota_fiscalTGWT> store, Grid<Gj_gnfe_nota_fiscalTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        com.extjs.gxt.ui.client.widget.Window win = new com.extjs.gxt.ui.client.widget.Window();
                        win.setModal(true);
                        win.setHeading("Dados Nota");
                        win.setSize(900, 400);
                        win.setLayout(new CenterLayout());
                        String url = Constantes.URL + "nfe/danfe/relatorio_nfe.jsp?op=consult&not_notaT.nfe_id=" + model.getNfe_id();
                        //LabelField download = new LabelField("<a href=\"" + url + "\">DOWNLOAD</a>");
                        //win.add(download);
                        win.setUrl(url);
                        win.setVisible(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("View NFE.");
                b.setIcon(Icones.ICONS.view_nota());
                b.setId("btnViewDanfe");

                return b;
            }
        };
    }

    public void btnAtualizarAction(ButtonEvent be) {
        super.btnAtualizarAction(be);
    }

    public void btnNovoAction(ButtonEvent be) {
        Gj_gnfe_nota_fiscalInsertGWT gj_gnfe_nota_fiscalInsertGWT = new Gj_gnfe_nota_fiscalInsertGWT();
        //gj_gnfe_nota_fiscalInsertGWT.setGj_gnfe_nota_fiscalConsult(this);
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
                        //gj_gnfe_nota_fiscalUpdateDeleteGWT.setGj_gnfe_nota_fiscalConsult(Gj_gnfe_nota_fiscalConsultNfeChaveGWT.this);
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
        if (etfNfe.getValue() == null || etfNfe.getValue().isEmpty()) {
            MessageBox.alert("Falha", "É necessário informar o número da nota!", null);

        } else {
            Gj_gnfe_nota_fiscalTGWT nfe = new Gj_gnfe_nota_fiscalTGWT();
            nfe.setTotvs_num_nfe(Integer.parseInt(etfNfe.getValue()));
            gj_gnfe_nota_fiscalDao.consultByNumeroNota(nfe);
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
                        grid.setSelectionModel(sm);
                        grid.setBorders(true);
                        grid.setColumnReordering(true);
                        grid.getAriaSupport().setLabelledBy("id" + "-label");
                        grid.addPlugin(sm);

                        grid.setStyleAttribute("borderTop", "none");
                        grid.setBorders(true);

                        getCpMaster().add(grid);
                        getCpMaster().layout();
                    }
                }
            };
            timer.schedule(500);
        }

    }
}
