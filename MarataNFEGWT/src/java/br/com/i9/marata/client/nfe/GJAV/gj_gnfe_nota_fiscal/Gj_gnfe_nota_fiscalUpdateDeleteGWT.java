package br.com.i9.marata.client.nfe.GJAV.gj_gnfe_nota_fiscal;

import br.com.i9.marata.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9.marata.client.nfe.GJAV.transfer.*;
import br.com.i9.marata.client.nfe.GJAV.dao.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;
import br.com.easynet.gwt.client.component.EasyDateField;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.user.client.Timer;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.widget.Dialog;

/**
 *
 * @author geoleite
 */
public class Gj_gnfe_nota_fiscalUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private Gj_gnfe_nota_fiscalConsultGWT gj_gnfe_nota_fiscalConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Gj_gnfe_nota_fiscalDAOGWT gj_gnfe_nota_fiscalDao = new Gj_gnfe_nota_fiscalDAOGWT();
    private Gj_gnfe_nota_fiscalTGWT gj_gnfe_nota_fiscalT;
    private EasyTextField<String> id_ent = new EasyTextField<String>();
    private EasyTextField<String> nfe_id = new EasyTextField<String>();
    private EasyTextField<String> reg_nfe = new EasyTextField<String>();
    private EasyTextField<String> des_reg = new EasyTextField<String>();
    private EasyTextField<String> modelo = new EasyTextField<String>();
    private EasyTextField<String> ambiente = new EasyTextField<String>();
    private EasyTextField<String> modalidade = new EasyTextField<String>();
    private EasyTextField<String> status = new EasyTextField<String>();
    private EasyTextField<String> cstatus_sefr = new EasyTextField<String>();
    private EasyTextField<String> xmot_sefr = new EasyTextField<String>();
    private EasyTextField<String> xml_sig = new EasyTextField<String>();
    private EasyTextField<String> xml_sig_mail = new EasyTextField<String>();
    private EasyTextField<String> prot = new EasyTextField<String>();
    private DateField date_prot = new DateField();
    private EasyTextField<String> xml_prot = new EasyTextField<String>();
    private EasyTextField<String> xml_prot_mail = new EasyTextField<String>();
    private EasyTextField<String> origem = new EasyTextField<String>();
    private EasyTextField<String> status_java = new EasyTextField<String>();
    private EasyTextField<String> status_totvs = new EasyTextField<String>();
    private EasyTextField<String> totvs_cod_empresa = new EasyTextField<String>();
    private EasyTextField<String> totvs_num_ar = new EasyTextField<String>();
    private EasyTextField<String> totvs_num_nfe = new EasyTextField<String>();
    private EasyTextField<String> totvs_ser_nfe = new EasyTextField<String>();
    private EasyTextField<String> totvs_ssr_nfe = new EasyTextField<String>();
    private EasyTextField<String> totvs_emi_nfe = new EasyTextField<String>();
    private EasyTextField<String> totvs_des_nfe = new EasyTextField<String>();
    private DateField totvs_dat_nfe = new DateField();
    private EasyTextField<String> totvs_val_nfe = new EasyTextField<String>();
    private EasyTextField<String> num_cgc_cpf = new EasyTextField<String>();

    public Gj_gnfe_nota_fiscalUpdateDeleteGWT() {
        setHeading("Alterar Gj_gnfe_nota_fiscal");
        this.setSize("500", "400");
        TableLayout tl = new TableLayout(2);
        tl.setCellPadding(4);
        getCpMaster().setLayout(tl);
        LabelField lfid_ent = new LabelField("id_ent:");
        lfid_ent.setId("lfid_ent");
        getCpMaster().add(lfid_ent);
        id_ent.setId("id_ent");
        id_ent.setMaxLength(6);
        getCpMaster().add(id_ent);

        LabelField lfnfe_id = new LabelField("nfe_id:");
        lfnfe_id.setId("lfnfe_id");
        getCpMaster().add(lfnfe_id);
        nfe_id.setId("nfe_id");
        nfe_id.setMaxLength(250);
        getCpMaster().add(nfe_id);

        LabelField lfreg_nfe = new LabelField("reg_nfe:");
        lfreg_nfe.setId("lfreg_nfe");
        getCpMaster().add(lfreg_nfe);
        reg_nfe.setId("reg_nfe");
        reg_nfe.setMaxLength(2);
        getCpMaster().add(reg_nfe);

        LabelField lfdes_reg = new LabelField("des_reg:");
        lfdes_reg.setId("lfdes_reg");
        getCpMaster().add(lfdes_reg);
        des_reg.setId("des_reg");
        des_reg.setMaxLength(25);
        getCpMaster().add(des_reg);

        LabelField lfmodelo = new LabelField("modelo:");
        lfmodelo.setId("lfmodelo");
        getCpMaster().add(lfmodelo);
        modelo.setId("modelo");
        modelo.setMaxLength(2);
        getCpMaster().add(modelo);

        LabelField lfambiente = new LabelField("ambiente:");
        lfambiente.setId("lfambiente");
        getCpMaster().add(lfambiente);
        ambiente.setId("ambiente");
        ambiente.setMaxLength(1);
        getCpMaster().add(ambiente);

        LabelField lfmodalidade = new LabelField("modalidade:");
        lfmodalidade.setId("lfmodalidade");
        getCpMaster().add(lfmodalidade);
        modalidade.setId("modalidade");
        modalidade.setMaxLength(1);
        getCpMaster().add(modalidade);

        LabelField lfstatus = new LabelField("status:");
        lfstatus.setId("lfstatus");
        getCpMaster().add(lfstatus);
        status.setId("status");
        status.setMaxLength(1);
        getCpMaster().add(status);

        LabelField lfcstatus_sefr = new LabelField("cstatus_sefr:");
        lfcstatus_sefr.setId("lfcstatus_sefr");
        getCpMaster().add(lfcstatus_sefr);
        cstatus_sefr.setId("cstatus_sefr");
        cstatus_sefr.setMaxLength(3);
        getCpMaster().add(cstatus_sefr);

        LabelField lfxmot_sefr = new LabelField("xmot_sefr:");
        lfxmot_sefr.setId("lfxmot_sefr");
        getCpMaster().add(lfxmot_sefr);
        xmot_sefr.setId("xmot_sefr");
        xmot_sefr.setMaxLength(250);
        getCpMaster().add(xmot_sefr);

        LabelField lfxml_sig = new LabelField("xml_sig:");
        lfxml_sig.setId("lfxml_sig");
        getCpMaster().add(lfxml_sig);
        xml_sig.setId("xml_sig");
        xml_sig.setMaxLength(4000);
        getCpMaster().add(xml_sig);

        LabelField lfxml_sig_mail = new LabelField("xml_sig_mail:");
        lfxml_sig_mail.setId("lfxml_sig_mail");
        getCpMaster().add(lfxml_sig_mail);
        xml_sig_mail.setId("xml_sig_mail");
        xml_sig_mail.setMaxLength(4000);
        getCpMaster().add(xml_sig_mail);

        LabelField lfprot = new LabelField("prot:");
        lfprot.setId("lfprot");
        getCpMaster().add(lfprot);
        prot.setId("prot");
        prot.setMaxLength(15);
        getCpMaster().add(prot);

        LabelField lfdate_prot = new LabelField("date_prot:");
        lfdate_prot.setId("lfdate_prot");
        getCpMaster().add(lfdate_prot);
        date_prot.setId("date_prot");
        date_prot.setMaxLength(8);
        getCpMaster().add(date_prot);

        LabelField lfxml_prot = new LabelField("xml_prot:");
        lfxml_prot.setId("lfxml_prot");
        getCpMaster().add(lfxml_prot);
        xml_prot.setId("xml_prot");
        xml_prot.setMaxLength(4000);
        getCpMaster().add(xml_prot);

        LabelField lfxml_prot_mail = new LabelField("xml_prot_mail:");
        lfxml_prot_mail.setId("lfxml_prot_mail");
        getCpMaster().add(lfxml_prot_mail);
        xml_prot_mail.setId("xml_prot_mail");
        xml_prot_mail.setMaxLength(4000);
        getCpMaster().add(xml_prot_mail);

        LabelField lforigem = new LabelField("origem:");
        lforigem.setId("lforigem");
        getCpMaster().add(lforigem);
        origem.setId("origem");
        origem.setMaxLength(1);
        getCpMaster().add(origem);

        LabelField lfstatus_java = new LabelField("status_java:");
        lfstatus_java.setId("lfstatus_java");
        getCpMaster().add(lfstatus_java);
        status_java.setId("status_java");
        status_java.setMaxLength(2);
        getCpMaster().add(status_java);

        LabelField lfstatus_totvs = new LabelField("status_totvs:");
        lfstatus_totvs.setId("lfstatus_totvs");
        getCpMaster().add(lfstatus_totvs);
        status_totvs.setId("status_totvs");
        status_totvs.setMaxLength(2);
        getCpMaster().add(status_totvs);

        LabelField lftotvs_cod_empresa = new LabelField("totvs_cod_empresa:");
        lftotvs_cod_empresa.setId("lftotvs_cod_empresa");
        getCpMaster().add(lftotvs_cod_empresa);
        totvs_cod_empresa.setId("totvs_cod_empresa");
        totvs_cod_empresa.setMaxLength(2);
        getCpMaster().add(totvs_cod_empresa);

        LabelField lftotvs_num_ar = new LabelField("totvs_num_ar:");
        lftotvs_num_ar.setId("lftotvs_num_ar");
        getCpMaster().add(lftotvs_num_ar);
        totvs_num_ar.setId("totvs_num_ar");
        totvs_num_ar.setMaxLength(10);
        getCpMaster().add(totvs_num_ar);

        LabelField lftotvs_num_nfe = new LabelField("totvs_num_nfe:");
        lftotvs_num_nfe.setId("lftotvs_num_nfe");
        getCpMaster().add(lftotvs_num_nfe);
        totvs_num_nfe.setId("totvs_num_nfe");
        totvs_num_nfe.setMaxLength(10);
        getCpMaster().add(totvs_num_nfe);

        LabelField lftotvs_ser_nfe = new LabelField("totvs_ser_nfe:");
        lftotvs_ser_nfe.setId("lftotvs_ser_nfe");
        getCpMaster().add(lftotvs_ser_nfe);
        totvs_ser_nfe.setId("totvs_ser_nfe");
        totvs_ser_nfe.setMaxLength(3);
        getCpMaster().add(totvs_ser_nfe);

        LabelField lftotvs_ssr_nfe = new LabelField("totvs_ssr_nfe:");
        lftotvs_ssr_nfe.setId("lftotvs_ssr_nfe");
        getCpMaster().add(lftotvs_ssr_nfe);
        totvs_ssr_nfe.setId("totvs_ssr_nfe");
        totvs_ssr_nfe.setMaxLength(5);
        getCpMaster().add(totvs_ssr_nfe);

        LabelField lftotvs_emi_nfe = new LabelField("totvs_emi_nfe:");
        lftotvs_emi_nfe.setId("lftotvs_emi_nfe");
        getCpMaster().add(lftotvs_emi_nfe);
        totvs_emi_nfe.setId("totvs_emi_nfe");
        totvs_emi_nfe.setMaxLength(14);
        getCpMaster().add(totvs_emi_nfe);

        LabelField lftotvs_des_nfe = new LabelField("totvs_des_nfe:");
        lftotvs_des_nfe.setId("lftotvs_des_nfe");
        getCpMaster().add(lftotvs_des_nfe);
        totvs_des_nfe.setId("totvs_des_nfe");
        totvs_des_nfe.setMaxLength(14);
        getCpMaster().add(totvs_des_nfe);

        LabelField lftotvs_dat_nfe = new LabelField("totvs_dat_nfe:");
        lftotvs_dat_nfe.setId("lftotvs_dat_nfe");
        getCpMaster().add(lftotvs_dat_nfe);
        totvs_dat_nfe.setId("totvs_dat_nfe");
        totvs_dat_nfe.setMaxLength(7);
        getCpMaster().add(totvs_dat_nfe);

        LabelField lftotvs_val_nfe = new LabelField("totvs_val_nfe:");
        lftotvs_val_nfe.setId("lftotvs_val_nfe");
        getCpMaster().add(lftotvs_val_nfe);
        totvs_val_nfe.setId("totvs_val_nfe");
        totvs_val_nfe.setMaxLength(17);
        getCpMaster().add(totvs_val_nfe);

        LabelField lfnum_cgc_cpf = new LabelField("num_cgc_cpf:");
        lfnum_cgc_cpf.setId("lfnum_cgc_cpf");
        getCpMaster().add(lfnum_cgc_cpf);
        num_cgc_cpf.setId("num_cgc_cpf");
        num_cgc_cpf.setMaxLength(14);
        getCpMaster().add(num_cgc_cpf);


    }

    public void load(Gj_gnfe_nota_fiscalTGWT gj_gnfe_nota_fiscalT) {
        this.gj_gnfe_nota_fiscalT = gj_gnfe_nota_fiscalT;
        id_ent.setValue(gj_gnfe_nota_fiscalT.getId_ent());
        nfe_id.setValue(gj_gnfe_nota_fiscalT.getNfe_id());
        reg_nfe.setValue(gj_gnfe_nota_fiscalT.getReg_nfe() + "");
        des_reg.setValue(gj_gnfe_nota_fiscalT.getDes_reg());
        modelo.setValue(gj_gnfe_nota_fiscalT.getModelo());
        ambiente.setValue(gj_gnfe_nota_fiscalT.getAmbiente() + "");
        modalidade.setValue(gj_gnfe_nota_fiscalT.getModalidade() + "");
        status.setValue(gj_gnfe_nota_fiscalT.getStatus() + "");
        cstatus_sefr.setValue(gj_gnfe_nota_fiscalT.getCstatus_sefr());
        xmot_sefr.setValue(gj_gnfe_nota_fiscalT.getXmot_sefr());
        prot.setValue(gj_gnfe_nota_fiscalT.getProt());
        date_prot.setValue(gj_gnfe_nota_fiscalT.getDate_prot());
        origem.setValue(gj_gnfe_nota_fiscalT.getOrigem() + "");
        status_java.setValue(gj_gnfe_nota_fiscalT.getStatus_java() + "");
        status_totvs.setValue(gj_gnfe_nota_fiscalT.getStatus_totvs() + "");
        totvs_cod_empresa.setValue(gj_gnfe_nota_fiscalT.getTotvs_cod_empresa());
        totvs_num_ar.setValue(gj_gnfe_nota_fiscalT.getTotvs_num_ar() + "");
        totvs_num_nfe.setValue(gj_gnfe_nota_fiscalT.getTotvs_num_nfe() + "");
        totvs_ser_nfe.setValue(gj_gnfe_nota_fiscalT.getTotvs_ser_nfe());
        totvs_ssr_nfe.setValue(gj_gnfe_nota_fiscalT.getTotvs_ssr_nfe() + "");
        totvs_emi_nfe.setValue(gj_gnfe_nota_fiscalT.getTotvs_emi_nfe());
        totvs_des_nfe.setValue(gj_gnfe_nota_fiscalT.getTotvs_des_nfe());
        totvs_dat_nfe.setValue(gj_gnfe_nota_fiscalT.getTotvs_dat_nfe());
        totvs_val_nfe.setValue(gj_gnfe_nota_fiscalT.getTotvs_val_nfe() + "");
        num_cgc_cpf.setValue(gj_gnfe_nota_fiscalT.getNum_cgc_cpf());

    }

    public void btnUpdateAction(ButtonEvent ce) {
        gj_gnfe_nota_fiscalT.setId_ent(id_ent.getValue());
        gj_gnfe_nota_fiscalT.setNfe_id(nfe_id.getValue());
        gj_gnfe_nota_fiscalT.setReg_nfe(Integer.parseInt(reg_nfe.getValue()));
        gj_gnfe_nota_fiscalT.setDes_reg(des_reg.getValue());
        gj_gnfe_nota_fiscalT.setModelo(modelo.getValue());
        gj_gnfe_nota_fiscalT.setAmbiente(Integer.parseInt(ambiente.getValue()));
        gj_gnfe_nota_fiscalT.setModalidade(Integer.parseInt(modalidade.getValue()));
        gj_gnfe_nota_fiscalT.setStatus(Integer.parseInt(status.getValue()));
        gj_gnfe_nota_fiscalT.setCstatus_sefr(cstatus_sefr.getValue());
        gj_gnfe_nota_fiscalT.setXmot_sefr(xmot_sefr.getValue());
        gj_gnfe_nota_fiscalT.setProt(prot.getValue());
        gj_gnfe_nota_fiscalT.setDate_prot(date_prot.getValue());
        gj_gnfe_nota_fiscalT.setOrigem(Integer.parseInt(origem.getValue()));
        gj_gnfe_nota_fiscalT.setStatus_java(Integer.parseInt(status_java.getValue()));
        gj_gnfe_nota_fiscalT.setStatus_totvs(Integer.parseInt(status_totvs.getValue()));
        gj_gnfe_nota_fiscalT.setTotvs_cod_empresa(totvs_cod_empresa.getValue());
        gj_gnfe_nota_fiscalT.setTotvs_num_ar(Integer.parseInt(totvs_num_ar.getValue()));
        gj_gnfe_nota_fiscalT.setTotvs_num_nfe(Integer.parseInt(totvs_num_nfe.getValue()));
        gj_gnfe_nota_fiscalT.setTotvs_ser_nfe(totvs_ser_nfe.getValue());
        gj_gnfe_nota_fiscalT.setTotvs_ssr_nfe(Integer.parseInt(totvs_ssr_nfe.getValue()));
        gj_gnfe_nota_fiscalT.setTotvs_emi_nfe(totvs_emi_nfe.getValue());
        gj_gnfe_nota_fiscalT.setTotvs_des_nfe(totvs_des_nfe.getValue());
        gj_gnfe_nota_fiscalT.setTotvs_dat_nfe(totvs_dat_nfe.getValue());
        gj_gnfe_nota_fiscalT.setTotvs_val_nfe(Double.parseDouble(totvs_val_nfe.getValue()));
        gj_gnfe_nota_fiscalT.setNum_cgc_cpf(num_cgc_cpf.getValue());

        gj_gnfe_nota_fiscalDao.alterar(gj_gnfe_nota_fiscalT);
        Timer timer = new Timer() {

            public void run() {
                String msg = gj_gnfe_nota_fiscalDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        gj_gnfe_nota_fiscalConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

        MessageBox.confirm("Aviso", "Tem certeza que deseja excluir registro?", new Listener<MessageBoxEvent>() {

            public void handleEvent(MessageBoxEvent be) {

                if (new Dialog().yesText.equalsIgnoreCase(be.getButtonClicked().getText())) {
                    gj_gnfe_nota_fiscalDao.excluir(gj_gnfe_nota_fiscalT);
                    Timer timer = new Timer() {

                        public void run() {
                            String msg = gj_gnfe_nota_fiscalDao.getMsg();
                            if (msg == null) {
                                schedule(500);
                            } else {
                                if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                                    MessageBox.alert("Problemas", msg, null);
                                } else {
                                    Info.display("Resultado", msg);
                                    gj_gnfe_nota_fiscalConsult.load();
                                    setVisible(false);
                                }
                            }
                        }
                    };
                    timer.schedule(500);
                }
            }
        });
    }

    /**
     * @return the gj_gnfe_nota_fiscalConsult
     */
    public Gj_gnfe_nota_fiscalConsultGWT getGj_gnfe_nota_fiscalConsult() {
        return gj_gnfe_nota_fiscalConsult;
    }

    /**
     * @param gj_gnfe_nota_fiscalConsult the gj_gnfe_nota_fiscalConsult to set
     */
    public void setGj_gnfe_nota_fiscalConsult(Gj_gnfe_nota_fiscalConsultGWT gj_gnfe_nota_fiscalConsult) {
        this.gj_gnfe_nota_fiscalConsult = gj_gnfe_nota_fiscalConsult;
    }
}
