/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.marata.client.nfe.GJAV.gj_gnfe_nota_fiscal;

import br.com.i9.marata.client.nfe.GJAV.transfer.Gj_gnfe_nota_fiscalTGWT;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.user.client.Timer;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class Gj_gnfe_nota_fiscalConsultTotvs extends Gj_gnfe_nota_fiscalConsultClienteGWT {

    public Gj_gnfe_nota_fiscalConsultTotvs() {
        //getToolBarMaster().setVisible(false);
        etfcnpj.setVisible(false);
        dtInicio.setVisible(false);
        dtFinal.setVisible(false);
        btnPesquisar.setVisible(false);
        load();
    }

    public void load() {
        gj_gnfe_nota_fiscalDao.consultByTotvs();
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
