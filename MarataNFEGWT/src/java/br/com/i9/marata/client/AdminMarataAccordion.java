    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.marata.client;

import br.com.easyportal.gwt.client.accordionModel.AMenuHandlerAccordion;
import br.com.easyportal.gwt.client.accordionModel.PortalAccordionGWT;

import br.com.i9.marata.client.nfe.GJAV.gj_gnfe_empresa.Gj_gnfe_empresaConsultGWT;
import br.com.i9.marata.client.nfe.GJAV.gj_gnfe_nota_fiscal.Gj_gnfe_nota_fiscalConsultClienteGWT;
import br.com.i9.marata.client.nfe.GJAV.gj_gnfe_nota_fiscal.Gj_gnfe_nota_fiscalConsultEmail;
import br.com.i9.marata.client.nfe.GJAV.gj_gnfe_nota_fiscal.Gj_gnfe_nota_fiscalConsultNfeChaveGWT;
import br.com.i9.marata.client.nfe.GJAV.gj_gnfe_nota_fiscal.Gj_gnfe_nota_fiscalConsultPeriodoGWT;
import br.com.i9.marata.client.nfe.GJAV.gj_gnfe_nota_fiscal.Gj_gnfe_nota_fiscalConsultTotvs;
import br.com.i9.marata.client.nfe.GJAV.gnfe_cliente_fornecedor.Gnfe_cliente_fornecedorConsultGWT;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.LabelField; 
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Window;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class AdminMarataAccordion extends AMenuHandlerAccordion {

    private HashMap<String, TabItem> itens = new HashMap<String, TabItem>();

    public AdminMarataAccordion() {
        setSystem("MARATA");
    }

    @Override
    public void actionEventMenu(Object me, String acao) {
        TabItem tabItem = null;
        tabItem = itens.get(acao);

        if (tabItem == null) {
            tabItem = new TabItem();
            tabItem.setClosable(true);
            tabItem.setLayout(new FitLayout());
            ContentPanel cp = new ContentPanel();
            cp.setFrame(false);
            cp.setBorders(false);
            cp.setHeaderVisible(false);
            cp.setBodyBorder(false);
            cp.setLayout(new FitLayout());
            if ("MARATA.empTodos".equalsIgnoreCase(acao)) {
                tabItem.setText("Todas Empresas");
                cp.add(new Gj_gnfe_empresaConsultGWT());
            } else if ("MARATA.empCnpj".equalsIgnoreCase(acao)) {
                tabItem.setText("NFe por Cliente/Fornec");
                cp.add(new Gj_gnfe_nota_fiscalConsultClienteGWT());
            } else if ("MARATA.empData".equalsIgnoreCase(acao)) {
                tabItem.setText("NFe por Empresa/Periodo");
                cp.add(new Gj_gnfe_nota_fiscalConsultPeriodoGWT());
            } else if ("MARATA.notTotvs".equalsIgnoreCase(acao)) {
                tabItem.setText("NFe somente Totvs");
                cp.add(new Gj_gnfe_nota_fiscalConsultTotvs());
            } else if ("MARATA.notEmail".equalsIgnoreCase(acao)) {
                tabItem.setText("NFe somente Email");
                cp.add(new Gj_gnfe_nota_fiscalConsultEmail());
            } else if ("MARATA.consNFE".equalsIgnoreCase(acao)) {
                tabItem.setText("Consulta de NFE");
                cp.add(new Gj_gnfe_nota_fiscalConsultNfeChaveGWT());
            } else if ("MARATA.consClienteFornecedor".equalsIgnoreCase(acao)) {
                tabItem.setText("Consulta Cliente/Fornecedor");
                cp.add(new Gnfe_cliente_fornecedorConsultGWT());
            } else {
                MessageBox.alert("Opcao ainda nao implementada", "Em breve esta opcao estara disponivel!", null);
                cp = null;
            }
            if (cp != null) {   
                tabItem.add(cp);
                //Adiciona o tabitem se nao existir no tabPanel
                getPortalAccordionGWT().getTabPanel().add(tabItem);
                itens.put(acao, tabItem);
            }
        } else {
            TabItem tabTemp = getPortalAccordionGWT().getTabPanel().getItemByItemId(acao);
            if (tabTemp == null) {
                getPortalAccordionGWT().getTabPanel().add(tabItem);
            }
        }
        getPortalAccordionGWT().getTabPanel().setSelection(tabItem);
        getPortalAccordionGWT().layout();
    }
}
