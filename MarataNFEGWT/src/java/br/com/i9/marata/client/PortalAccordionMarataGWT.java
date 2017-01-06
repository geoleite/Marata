/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.marata.client;

import br.com.easyportal.gwt.client.accordionModel.PortalAccordionGWT;
import br.com.easyportal.gwt.client.admin.portal.portal.transfer.Per_perfilTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel; 

/**
 *
 * @author geoleite
 */
public class PortalAccordionMarataGWT extends PortalAccordionGWT {

    private static final String PERFIL_ADM="MARATA.Adm";
    public PortalAccordionMarataGWT() {
        //tabPanel.add(tiWelcome);
        this(0);
    }

    public PortalAccordionMarataGWT(int alturaBanner) {
        super(alturaBanner);
        //tabPanel.add(tiWelcome);
        getTabPanel().remove(getTiWelcome());
    }
    
    public PortalAccordionMarataGWT(String urlImageHeader, int altura) {
        super(urlImageHeader, altura);
        getTabPanel().remove(getTiWelcome());
    }


    public void createMenu() {
        super.createMenu();

        AdminMarataAccordion menuHandler = (AdminMarataAccordion) getMenuHandler().get(0);        
    }
}
