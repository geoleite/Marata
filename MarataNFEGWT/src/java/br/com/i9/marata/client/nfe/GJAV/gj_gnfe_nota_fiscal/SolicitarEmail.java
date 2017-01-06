/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.marata.client.nfe.GJAV.gj_gnfe_nota_fiscal;

import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;
import br.com.i9.marata.client.Constantes;
import br.com.i9.marata.client.icons.Icones;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.json.client.JSONValue;

/**
 *
 * @author geoleite
 */
public class SolicitarEmail extends Window {

    private Button btnEnviarEmail = new Button("Enviar Email", Icones.ICONS.email());
    private Button btnFechar = new Button("Fechar", br.com.easynet.gwt.client.icons.Icones.ICONS.close());
    private EasyTextField<String> etfEmail = new EasyTextField<String>();
    private String ids;

    public SolicitarEmail() {
        setHeading("Informar Email");
        setSize(300, 120);
        setModal(true);
        addButton(btnEnviarEmail);
        addButton(btnFechar);
        //setLayout(new Vertical);
        add(new LabelField("Email do Destinatário: "));
        add(etfEmail);
        etfEmail.setWidth(280);
        etfEmail.setUpperCase(false);
        etfEmail.setAllowCharSpecial(true);
        etfEmail.setRegex("\\S*@\\S+.\\S*");
        btnEnviarEmail.setToolTip("Enviar por emiail.");
        btnFechar.setToolTip("Fechar Janela");

        btnFechar.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                SolicitarEmail.this.setVisible(false);
            }
        });

        btnEnviarEmail.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                if (!etfEmail.validate()) {
                    MessageBox.alert("AVISO", "O email informado não é válido.", null);
                } else {
                    String url = Constantes.URL + "nfe/GJAV/gj_gnfe_nota_fiscal/downloadnfe.jsp?op=enviarEmail&destinatario=" + etfEmail.getValue() + "&" + ids;
                    IListenetResponse listener = new IListenetResponse() {

                        public void read(JSONValue jsonValue) {
                        }
                    };
                    com.google.gwt.user.client.Window.alert(url);
                    EasyAccessURL access = new EasyAccessURL(listener);
                    access.accessJSon(url);
                }
            }
        });
    }

    /**
     * @return the ids
     */
    public String getIds() {
        return ids;
    }

    /**
     * @param ids the ids to set
     */
    public void setIds(String ids) {
        this.ids = ids;
    }
}
