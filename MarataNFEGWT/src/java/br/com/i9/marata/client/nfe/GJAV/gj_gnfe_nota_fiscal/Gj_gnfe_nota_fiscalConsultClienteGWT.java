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
import br.com.easynet.gwt.client.component.EasyDateField;
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
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
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

import com.google.gwt.dev.util.msg.Message0;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import java.util.Date;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author geoleite
 */
public class Gj_gnfe_nota_fiscalConsultClienteGWT extends CPConsultarBaseGWT {

    protected List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    protected Gj_gnfe_nota_fiscalDAOGWT gj_gnfe_nota_fiscalDao = new Gj_gnfe_nota_fiscalDAOGWT();
    protected EasyTextField<String> etfcnpj = new EasyTextField<String>();
    protected SimpleComboBox<String> cbTipoNota = new SimpleComboBox<String>();
    protected Button btnPesquisar = new Button("", ICONS.find());
    protected DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
    protected NumberFormat vlr = NumberFormat.getFormat("#,##0.00");
    protected EasyDateField dtInicio = new EasyDateField();
    protected EasyDateField dtFinal = new EasyDateField();
    protected CheckBoxSelectionModel<Gj_gnfe_nota_fiscalTGWT> sm = new CheckBoxSelectionModel<Gj_gnfe_nota_fiscalTGWT>();
    protected Button btnDownload = new Button("", ICONS.download());
    protected Button btnDownloadTodas = new Button("", ICONS.download());
    protected Button btnEnviarEmail = new Button("", Icones.ICONS.email());
    private NumberFormat formatNumber = NumberFormat.getFormat("#,##0.00");

    public Gj_gnfe_nota_fiscalConsultClienteGWT() {
        setHeaderVisible(false);
        
        cbTipoNota.setTypeAhead(true);
        cbTipoNota.setTriggerAction(ComboBox.TriggerAction.ALL);
        cbTipoNota.setEmptyText("Tipo nota.");
        cbTipoNota.setToolTip("Tipo da Nota Fiscal");
        cbTipoNota.setEditable(false);
        cbTipoNota.add("Todas");
        cbTipoNota.add("Entrada");
        cbTipoNota.add("Saida");


        etfcnpj.setEmptyText("CNPJ Cliente/Fornecedor!");
        dtInicio.setEmptyText("Dt. Início");
        dtFinal.setEmptyText("Dt. Final");
        getBtnNovoSuper().setVisible(false);

        etfcnpj.setMaskFormat("000.000.000/0000-00");
        getToolBarMaster().add(etfcnpj);
        getToolBarMaster().add(dtInicio);
        getToolBarMaster().add(dtFinal);
        getToolBarMaster().add(cbTipoNota);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(btnPesquisar);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(btnDownload);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(btnDownloadTodas);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(btnEnviarEmail);
        btnDownload.setToolTip("Download de Notas selecionadas.");
        btnEnviarEmail.setToolTip("Enviar Notas por email.");

        btnEnviarEmail.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                List<Gj_gnfe_nota_fiscalTGWT> listNotas = sm.getSelectedItems();
                if (listNotas == null || listNotas.size() == 0) {
                    MessageBox.alert("AVISO", "É necessário selecionar pelo menos uma nota para download.", null);
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
                if (listNotas == null || listNotas.size() == 0) {
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

        btnDownloadTodas.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                //Download das notas fiscais
                ListStore<Gj_gnfe_nota_fiscalTGWT> list = gj_gnfe_nota_fiscalDao.getList();
                if (list != null && list.getCount() > 0) {
                    List<Gj_gnfe_nota_fiscalTGWT> listNotas = list.getModels();
                    if (listNotas == null || listNotas.size() == 0) {
                        MessageBox.alert("AVISO", "É necessário selecionar pelo menos uma nota para download.", null);
                        return;
                    }
                    //Download das notas fiscais
                    String ids = "0";
//                    for (int i = 0; i < listNotas.size(); i++) {
//                        Gj_gnfe_nota_fiscalTGWT gj_gnfe_nota_fiscalTGWT = listNotas.get(i);
//                        ids += "," + gj_gnfe_nota_fiscalTGWT.getNfe_id();
//                    }
                    com.extjs.gxt.ui.client.widget.Window win = new com.extjs.gxt.ui.client.widget.Window();
                    win.setHeading("Download NFE Zip");
                    win.setSize(200, 50);
                    win.setLayout(new CenterLayout());
                    String url = Constantes.URL + "nfe/GJAV/gj_gnfe_nota_fiscal/downloadnfe.jsp";
                    final FormPanel fp = new FormPanel();
                    fp.setMethod(FormPanel.Method.POST);
                    fp.setAction(url);
                    HiddenField<String> op = new HiddenField<String>();
                    op.setName("op");
                    op.setValue("downloadsImage");
                    fp.add(op);
                    for (int i = 0; i < listNotas.size(); i++) {
                        Gj_gnfe_nota_fiscalTGWT gj_gnfe_nota_fiscalTGWT = listNotas.get(i);
                        //                       ids += "," + gj_gnfe_nota_fiscalTGWT.getNfe_id();
                        HiddenField<String> id = new HiddenField<String>();
                        id.setName("ids");
                        id.setValue(gj_gnfe_nota_fiscalTGWT.getNfe_id());
                        fp.add(id);

                    }
                    Button btn = new Button("Download");
                    fp.setHeaderVisible(false);
                    fp.setBodyBorder(false);
                    fp.setFrame(false);
                    fp.setBorders(false);
                    fp.addButton(btn);
                    win.add(fp);
                    btn.addSelectionListener(new SelectionListener<ButtonEvent>() {

                        @Override
                        public void componentSelected(ButtonEvent ce) {
                            fp.submit();
                        }
                    });
                    win.setVisible(true);
                }
            }
        });
        btnPesquisar.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                load();
            }
        });
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
                        //gj_gnfe_nota_fiscalUpdateDeleteGWT.setGj_gnfe_nota_fiscalConsult(Gj_gnfe_nota_fiscalConsultClienteGWT.this);
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
        if (etfcnpj.getValue() == null || etfcnpj.getValue().isEmpty()) {
            MessageBox.alert("Falha", "É necessário informar o CNPJ  Cliente/Fornecedor", null);
        } else {
            Gj_gnfe_nota_fiscalTGWT cnpj = new Gj_gnfe_nota_fiscalTGWT();
            cnpj.setNum_cgc_cpf(etfcnpj.getValue());
            String tipoNota = "";
            if (cbTipoNota.getValue() != null) {
                tipoNota = cbTipoNota.getValue().getValue();
                if ("Entrada".equalsIgnoreCase(tipoNota)) {
                    tipoNota = "0";
                } else if ("Saida".equalsIgnoreCase(tipoNota)) {
                    tipoNota = "1";
                } else {
                    tipoNota = "";
                }
            }

            if (dtInicio.getValue() != null && dtInicio.getValue().trim().length() > 0 || dtFinal.getValue() != null && dtFinal.getValue().trim().length() > 0) {
                gj_gnfe_nota_fiscalDao.consultByPeriodoEmpresaOuCliente(cnpj, dtInicio.toDate(), dtFinal.toDate(), tipoNota);
            } else {
                gj_gnfe_nota_fiscalDao.consultByCnpj(cnpj, tipoNota);
            }
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
            timer.schedule(100);
        }

    }
}
