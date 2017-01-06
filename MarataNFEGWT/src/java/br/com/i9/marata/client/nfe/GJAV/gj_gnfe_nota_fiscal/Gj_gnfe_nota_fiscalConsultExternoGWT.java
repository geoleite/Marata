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
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import java.util.Date;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Image;

/**
 *
 * @author geoleite
 */
public class Gj_gnfe_nota_fiscalConsultExternoGWT extends CPConsultarBaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Gj_gnfe_nota_fiscalDAOGWT gj_gnfe_nota_fiscalDao = new Gj_gnfe_nota_fiscalDAOGWT();
    protected DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected EasyTextField<String> etfNfeId = new EasyTextField<String>();
    protected Button btnPesquisar = new Button("", ICONS.find());
    private NumberFormat formatNumber = NumberFormat.getFormat("#,##0.00");

    public Gj_gnfe_nota_fiscalConsultExternoGWT(int altura) {

        getCpTop().setVisible(true);
        getCpTop().setBorders(false);
        getCpTop().setFrame(false);
        getCpTop().setBodyBorder(false);
        getCpTop().setLayout(new RowLayout(Orientation.VERTICAL));
        getDataNORTH().setMaxSize(altura);
        getDataNORTH().setMinSize(altura);
        getDataNORTH().setSize(altura);
        Image img = new Image("images/topo.png");
        getCpTop().add(img, new RowData(1, 1));

        getBtnRefersh().setVisible(false);
        getBtnNovoSuper().setVisible(false);
        setHeaderVisible(false);
        etfNfeId.setToolTip("Informe o número da NFE com 44 dígitos!");
        etfNfeId.setEmptyText("NFE ID!");
        etfNfeId.setMaskFormat("00000000000000000000000000000000000000000000");
        etfNfeId.setMaxLength(44);
        etfNfeId.setWidth(300);
        getToolBarMaster().add(new LabelField("Chave de Acesso:"));
        getToolBarMaster().add(etfNfeId);
        getToolBarMaster().add(btnPesquisar);

        btnPesquisar.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                load();
            }
        });

        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Gj_gnfe_nota_fiscalTGWT>> numberRenderer = new NumberCellRenderer<Grid<Gj_gnfe_nota_fiscalTGWT>>(currency);

        ColumnConfig column = null;

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
        column.setId("colEnviarEmail");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getEnviarEmailRender());
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
//
//        column = new ColumnConfig();
//        column.setId("num_cgc_cpf");
//        column.setHeader("Emissor/Destino");
//        column.setWidth(150);
//        column.setAlignment(HorizontalAlignment.LEFT);
//        configs.add(column);
//
//        column = new ColumnConfig();
//        column.setId("totvs_val_nfe");
//        column.setHeader("Valor Nota");
//        column.setWidth(100);
//        column.setNumberFormat(formatNumber);
//        column.setAlignment(HorizontalAlignment.LEFT);
//        configs.add(column);
//
//        column = new ColumnConfig();
//        column.setId("status_java");
//        column.setHeader("Pelo Email");
//        column.setWidth(80);
//        column.setRenderer(statusJavaGrid);
//        column.setAlignment(HorizontalAlignment.RIGHT);
//        configs.add(column);
//
//        column = new ColumnConfig();
//        column.setId("status_totvs");
//        column.setHeader("Pelo Totvs");
//        column.setWidth(80);
//        column.setRenderer(statusTotvsGrid);
//        column.setAlignment(HorizontalAlignment.RIGHT);
//        configs.add(column);

    }

    public void btnAtualizarAction(ButtonEvent be) {
        super.btnAtualizarAction(be);
    }

    public void btnNovoAction(ButtonEvent be) {
    }

    private GridCellRenderer<Gj_gnfe_nota_fiscalTGWT> getDownloadRender() {
        return new GridCellRenderer<Gj_gnfe_nota_fiscalTGWT>() {

            public Object render(final Gj_gnfe_nota_fiscalTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Gj_gnfe_nota_fiscalTGWT> store, Grid<Gj_gnfe_nota_fiscalTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        //http://localhost:8084/maratanfe/nfe/GJAV/gj_gnfe_nota_fiscal/downloadnfe.jsp?op=downloadImage&gj_gnfe_nota_fiscalT.nfe_id=
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

    private GridCellRenderer<Gj_gnfe_nota_fiscalTGWT> getEnviarEmailRender() {
        return new GridCellRenderer<Gj_gnfe_nota_fiscalTGWT>() {

            public Object render(final Gj_gnfe_nota_fiscalTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Gj_gnfe_nota_fiscalTGWT> store, Grid<Gj_gnfe_nota_fiscalTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {

                        String ids = "ids=" + model.getNfe_id();
                        SolicitarEmail solicitarEmail = new SolicitarEmail();
                        solicitarEmail.setId(ids);
                        solicitarEmail.setVisible(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Enviar nota fiscal por email.");
                b.setIcon(Icones.ICONS.email());
                b.setId("btnEmail");

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

    public void load() {
        if (etfNfeId.getValue() == null || etfNfeId.getValue().trim().length() == 0) {
            MessageBox.alert("AVISO", "É necessário informar o NFE ID", null);
        } else {
            Gj_gnfe_nota_fiscalTGWT notaT = new Gj_gnfe_nota_fiscalTGWT();
            notaT.setNfe_id(etfNfeId.getValue());
            gj_gnfe_nota_fiscalDao.consultByNfe(notaT);
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
                        grid.setBorders(true);

                        grid.setStyleAttribute("borderTop", "none");
                        grid.setBorders(true);

                        getCpMaster().add(grid);
                        getCpMaster().layout();
                    }
                }
            };
            timer.schedule(100);
        }

    }
}
