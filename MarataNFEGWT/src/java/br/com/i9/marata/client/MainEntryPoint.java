/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.marata.client;

import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easyportal.gwt.client.AuthenticationGWT;
import br.com.easyportal.gwt.client.accordionModel.PortalAccordionGWT;
import br.com.i9.marata.client.nfe.GJAV.gj_gnfe_nota_fiscal.Gj_gnfe_nota_fiscalConsultExternoGWT;
import br.com.i9.portal.client.AdminPortalAccordion;
import com.extjs.gxt.themes.client.Access;
import com.extjs.gxt.themes.client.Slate;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.util.ThemeManager;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;

/**
 * Main entry point.
 *
 * @author geoleite
 */
public class MainEntryPoint implements EntryPoint {

    /**
     * Creates a new instance of MainEntryPoint
     */
    public MainEntryPoint() {
    }

    /** 
     * The entry point method, called automatically by loading a module
     * that declares an implementing class as an entry-point
     */
    public void onModuleLoad() {
        ThemeManager.register(Slate.SLATE);
        ThemeManager.register(Access.ACCESS);
        //ThemeManager.register(com.sensei.themes.i9ti.I9ti);
        GXT.setDefaultTheme(Slate.SLATE, true);

        br.com.i9.portal.client.Constantes.URL = Constantes.URL;
        br.com.easyportal.gwt.client.Constantes.URL = Constantes.URL;

        com.google.gwt.user.client.Window.setTitle("Marata NFE");
        String tipoAcesso = com.google.gwt.user.client.Window.Location.getParameter("tipoAcesso");
        //com.google.gwt.user.client.Window.alert("tipoAcesso " + tipoAcesso);

        if ("externo".equalsIgnoreCase(tipoAcesso)) {
            //Acesso do contribuinte
            Gj_gnfe_nota_fiscalConsultExternoGWT consultGWT = new Gj_gnfe_nota_fiscalConsultExternoGWT(87);
            //acessoAdquirenteGWT.setVisible(true);
            Viewport viewport = new Viewport();
            viewport.setLayout(new RowLayout());
            viewport.add(consultGWT, new RowData(1, 1));

            RootPanel.get().add(viewport);
        } else {
            AdminMarataAccordion adminMenu = new AdminMarataAccordion();
            AdminPortalAccordion adminMenuPortal = new AdminPortalAccordion();

            //PortalAccordionGWT portal = new PortalAccordionMarataGWT(110);
            PortalAccordionGWT portal = new PortalAccordionMarataGWT("images/topo.png", 87);
            portal.checkSession(60000 * 35);//35 minutos
            portal.setObsText("Versão: 1.0.0");
            //checkSession();

            portal.addMenuHandler(adminMenu);
            portal.addMenuHandler(adminMenuPortal);

            AuthenticationGWT authentication = new AuthenticationGWT();
            authentication.setPortal(portal);
            authentication.setVisible(true);
        }
    }
}
