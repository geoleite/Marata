package br.com.i9.marata.client.nfe.GJAV.dao;

import br.com.easynet.gwt.client.component.EasyTextField;
import br.com.i9.marata.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.marata.client.nfe.GJAV.transfer.Gj_gnfe_nota_fiscalTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

import java.util.*;

public class Gj_gnfe_nota_fiscalDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "nfe/GJAV/gj_gnfe_nota_fiscal/gj_gnfe_nota_fiscalInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "nfe/GJAV/gj_gnfe_nota_fiscal/gj_gnfe_nota_fiscalConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "nfe/GJAV/gj_gnfe_nota_fiscal/gj_gnfe_nota_fiscalUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Gj_gnfe_nota_fiscalTGWT gj_gnfe_nota_fiscalT;

    public void consultarTodos() {
        list = null;
        msg = null;
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void consultByCnpj(Gj_gnfe_nota_fiscalTGWT notaT, String tipoNota) {

        list = null;
        msg = null;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByCnpj");
        param.put("gj_gnfe_nota_fiscalT.num_cgc_cpf", notaT.getNum_cgc_cpf() + "");
        param.put("tipoNota", tipoNota);
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void consultByTotvs() {

        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByTotvs");
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }

    public void consultByEmail() {

        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByEmail");
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }

    public void consultByNfe(Gj_gnfe_nota_fiscalTGWT notaT) {

        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByNfe");
        param.put("gj_gnfe_nota_fiscalT.nfe_id", notaT.getNfe_id() + "");
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }

    public void consultByNumeroNota(Gj_gnfe_nota_fiscalTGWT notaT) {

        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByNumeroNota");
        param.put("gj_gnfe_nota_fiscalT.totvs_num_nfe", notaT.getTotvs_num_nfe() + "");
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }

    public void consultByPeriodo(Gj_gnfe_nota_fiscalTGWT notaT, Date dtInicial, Date dtFinal, String tipoNota) {

        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByPeriodo");
        param.put("gj_gnfe_nota_fiscalT.id_ent", notaT.getId_ent() + "");
        param.put("dataInicial", dtfDate.format(dtInicial));
        param.put("dataFinal", dtfDate.format(dtFinal));
        param.put("tipoNota", tipoNota);
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }

    public void consultByPeriodoEmpresaOuCliente(Gj_gnfe_nota_fiscalTGWT notaT, Date dtInicial, Date dtFinal, String tipoNota) {

        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByPeriodoEmpresaOuCliente");
        param.put("gj_gnfe_nota_fiscalT.num_cgc_cpf", notaT.getNum_cgc_cpf() + "");
        //param.put("gj_gnfe_nota_fiscalT.num_cgc_cpf", notaT.getNum_cgc_cpf() + "");
        param.put("dataInicial", dtfDate.format(dtInicial));
        param.put("dataFinal", dtfDate.format(dtFinal));
        param.put("tipoNota", tipoNota);
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }

    public void inserir(Gj_gnfe_nota_fiscalTGWT gj_gnfe_nota_fiscalT) {
        msg = null;
        list = null;
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    String result = jsonObject.get("resultado").isString().stringValue();
                    msg = result;
                }
            }
        };
        String url = Constantes.URL + PAGE_INSERIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "insert");
        param.put("gj_gnfe_nota_fiscalT.id_ent", gj_gnfe_nota_fiscalT.getId_ent() + "");
        param.put("gj_gnfe_nota_fiscalT.nfe_id", gj_gnfe_nota_fiscalT.getNfe_id() + "");
        param.put("gj_gnfe_nota_fiscalT.reg_nfe", gj_gnfe_nota_fiscalT.getReg_nfe() + "");
        param.put("gj_gnfe_nota_fiscalT.des_reg", gj_gnfe_nota_fiscalT.getDes_reg() + "");
        param.put("gj_gnfe_nota_fiscalT.modelo", gj_gnfe_nota_fiscalT.getModelo() + "");
        param.put("gj_gnfe_nota_fiscalT.ambiente", gj_gnfe_nota_fiscalT.getAmbiente() + "");
        param.put("gj_gnfe_nota_fiscalT.modalidade", gj_gnfe_nota_fiscalT.getModalidade() + "");
        param.put("gj_gnfe_nota_fiscalT.status", gj_gnfe_nota_fiscalT.getStatus() + "");
        param.put("gj_gnfe_nota_fiscalT.cstatus_sefr", gj_gnfe_nota_fiscalT.getCstatus_sefr() + "");
        param.put("gj_gnfe_nota_fiscalT.xmot_sefr", gj_gnfe_nota_fiscalT.getXmot_sefr() + "");
        param.put("gj_gnfe_nota_fiscalT.prot", gj_gnfe_nota_fiscalT.getProt() + "");
        param.put("gj_gnfe_nota_fiscalT.date_prot", gj_gnfe_nota_fiscalT.getDate_prot() + "");
        param.put("gj_gnfe_nota_fiscalT.origem", gj_gnfe_nota_fiscalT.getOrigem() + "");
        param.put("gj_gnfe_nota_fiscalT.status_java", gj_gnfe_nota_fiscalT.getStatus_java() + "");
        param.put("gj_gnfe_nota_fiscalT.status_totvs", gj_gnfe_nota_fiscalT.getStatus_totvs() + "");
        param.put("gj_gnfe_nota_fiscalT.totvs_cod_empresa", gj_gnfe_nota_fiscalT.getTotvs_cod_empresa() + "");
        param.put("gj_gnfe_nota_fiscalT.totvs_num_ar", gj_gnfe_nota_fiscalT.getTotvs_num_ar() + "");
        param.put("gj_gnfe_nota_fiscalT.totvs_num_nfe", gj_gnfe_nota_fiscalT.getTotvs_num_nfe() + "");
        param.put("gj_gnfe_nota_fiscalT.totvs_ser_nfe", gj_gnfe_nota_fiscalT.getTotvs_ser_nfe() + "");
        param.put("gj_gnfe_nota_fiscalT.totvs_ssr_nfe", gj_gnfe_nota_fiscalT.getTotvs_ssr_nfe() + "");
        param.put("gj_gnfe_nota_fiscalT.totvs_emi_nfe", gj_gnfe_nota_fiscalT.getTotvs_emi_nfe() + "");
        param.put("gj_gnfe_nota_fiscalT.totvs_des_nfe", gj_gnfe_nota_fiscalT.getTotvs_des_nfe() + "");
        param.put("gj_gnfe_nota_fiscalT.totvs_dat_nfe", dtfDate.format(gj_gnfe_nota_fiscalT.getTotvs_dat_nfe()));
        param.put("gj_gnfe_nota_fiscalT.totvs_val_nfe", gj_gnfe_nota_fiscalT.getTotvs_val_nfe() + "");
        param.put("gj_gnfe_nota_fiscalT.num_cgc_cpf", gj_gnfe_nota_fiscalT.getNum_cgc_cpf() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Gj_gnfe_nota_fiscalTGWT gj_gnfe_nota_fiscalT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("gj_gnfe_nota_fiscal").isObject();
                    Gj_gnfe_nota_fiscalDAOGWT.this.gj_gnfe_nota_fiscalT = lerRegistroJson(registro);
                }
            }
        };
        this.gj_gnfe_nota_fiscalT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Gj_gnfe_nota_fiscalTGWT gj_gnfe_nota_fiscalT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                }
            }
        };

        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "delete");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Gj_gnfe_nota_fiscalTGWT gj_gnfe_nota_fiscalT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                }
            }
        };
        msg = null;
        list = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "update");
        param.put("gj_gnfe_nota_fiscalT.id_ent", gj_gnfe_nota_fiscalT.getId_ent() + "");
        param.put("gj_gnfe_nota_fiscalT.nfe_id", gj_gnfe_nota_fiscalT.getNfe_id() + "");
        param.put("gj_gnfe_nota_fiscalT.reg_nfe", gj_gnfe_nota_fiscalT.getReg_nfe() + "");
        param.put("gj_gnfe_nota_fiscalT.des_reg", gj_gnfe_nota_fiscalT.getDes_reg() + "");
        param.put("gj_gnfe_nota_fiscalT.modelo", gj_gnfe_nota_fiscalT.getModelo() + "");
        param.put("gj_gnfe_nota_fiscalT.ambiente", gj_gnfe_nota_fiscalT.getAmbiente() + "");
        param.put("gj_gnfe_nota_fiscalT.modalidade", gj_gnfe_nota_fiscalT.getModalidade() + "");
        param.put("gj_gnfe_nota_fiscalT.status", gj_gnfe_nota_fiscalT.getStatus() + "");
        param.put("gj_gnfe_nota_fiscalT.cstatus_sefr", gj_gnfe_nota_fiscalT.getCstatus_sefr() + "");
        param.put("gj_gnfe_nota_fiscalT.xmot_sefr", gj_gnfe_nota_fiscalT.getXmot_sefr() + "");
        param.put("gj_gnfe_nota_fiscalT.prot", gj_gnfe_nota_fiscalT.getProt() + "");
        param.put("gj_gnfe_nota_fiscalT.date_prot", gj_gnfe_nota_fiscalT.getDate_prot() + "");
        param.put("gj_gnfe_nota_fiscalT.origem", gj_gnfe_nota_fiscalT.getOrigem() + "");
        param.put("gj_gnfe_nota_fiscalT.status_java", gj_gnfe_nota_fiscalT.getStatus_java() + "");
        param.put("gj_gnfe_nota_fiscalT.status_totvs", gj_gnfe_nota_fiscalT.getStatus_totvs() + "");
        param.put("gj_gnfe_nota_fiscalT.totvs_cod_empresa", gj_gnfe_nota_fiscalT.getTotvs_cod_empresa() + "");
        param.put("gj_gnfe_nota_fiscalT.totvs_num_ar", gj_gnfe_nota_fiscalT.getTotvs_num_ar() + "");
        param.put("gj_gnfe_nota_fiscalT.totvs_num_nfe", gj_gnfe_nota_fiscalT.getTotvs_num_nfe() + "");
        param.put("gj_gnfe_nota_fiscalT.totvs_ser_nfe", gj_gnfe_nota_fiscalT.getTotvs_ser_nfe() + "");
        param.put("gj_gnfe_nota_fiscalT.totvs_ssr_nfe", gj_gnfe_nota_fiscalT.getTotvs_ssr_nfe() + "");
        param.put("gj_gnfe_nota_fiscalT.totvs_emi_nfe", gj_gnfe_nota_fiscalT.getTotvs_emi_nfe() + "");
        param.put("gj_gnfe_nota_fiscalT.totvs_des_nfe", gj_gnfe_nota_fiscalT.getTotvs_des_nfe() + "");
        param.put("gj_gnfe_nota_fiscalT.totvs_dat_nfe", dtfDate.format(gj_gnfe_nota_fiscalT.getTotvs_dat_nfe()));
        param.put("gj_gnfe_nota_fiscalT.totvs_val_nfe", gj_gnfe_nota_fiscalT.getTotvs_val_nfe() + "");
        param.put("gj_gnfe_nota_fiscalT.num_cgc_cpf", gj_gnfe_nota_fiscalT.getNum_cgc_cpf() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Gj_gnfe_nota_fiscalTGWT> lista = new ListStore<Gj_gnfe_nota_fiscalTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Gj_gnfe_nota_fiscalTGWT gj_gnfe_nota_fiscalT = lerRegistroJson(registro);
                lista.add(gj_gnfe_nota_fiscalT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Gj_gnfe_nota_fiscalTGWT lerRegistroJson(JSONObject registro) {
        Gj_gnfe_nota_fiscalTGWT gj_gnfe_nota_fiscalTGWT = new Gj_gnfe_nota_fiscalTGWT();
        try {
            String id_ent = registro.get("id_ent").isString().stringValue();
            gj_gnfe_nota_fiscalTGWT.setId_ent(id_ent);

            String nfe_id = registro.get("nfe_id").isString().stringValue();
            gj_gnfe_nota_fiscalTGWT.setNfe_id(nfe_id);


            Integer reg_nfe = Integer.parseInt(registro.get("reg_nfe").isString().stringValue());
            gj_gnfe_nota_fiscalTGWT.setReg_nfe(reg_nfe);

            String des_reg = registro.get("des_reg").isString().stringValue();
            gj_gnfe_nota_fiscalTGWT.setDes_reg(des_reg);

            String modelo = registro.get("modelo").isString().stringValue();
            gj_gnfe_nota_fiscalTGWT.setModelo(modelo);

            Integer ambiente = Integer.parseInt(registro.get("ambiente").isString().stringValue());
            gj_gnfe_nota_fiscalTGWT.setAmbiente(ambiente);

            Integer modalidade = Integer.parseInt(registro.get("modalidade").isString().stringValue());
            gj_gnfe_nota_fiscalTGWT.setModalidade(modalidade);

            Integer status = Integer.parseInt(registro.get("status").isString().stringValue());
            gj_gnfe_nota_fiscalTGWT.setStatus(status);

            String cstatus_sefr = registro.get("cstatus_sefr").isString().stringValue();
            gj_gnfe_nota_fiscalTGWT.setCstatus_sefr(cstatus_sefr);

            String xmot_sefr = registro.get("xmot_sefr").isString().stringValue();
            gj_gnfe_nota_fiscalTGWT.setXmot_sefr(xmot_sefr);

            String prot = registro.get("prot").isString().stringValue();
            gj_gnfe_nota_fiscalTGWT.setProt(prot);

            String date_prot = registro.get("date_prot").isString().stringValue();
            if (date_prot != null && date_prot.trim().length() > 0) {
                gj_gnfe_nota_fiscalTGWT.setDate_prot(dtfDate.parse(date_prot));
            }


            Integer origem = Integer.parseInt(registro.get("origem").isString().stringValue());
            gj_gnfe_nota_fiscalTGWT.setOrigem(origem);

            Integer status_java = Integer.parseInt(registro.get("status_java").isString().stringValue());
            gj_gnfe_nota_fiscalTGWT.setStatus_java(status_java);

            Integer status_totvs = Integer.parseInt(registro.get("status_totvs").isString().stringValue());
            gj_gnfe_nota_fiscalTGWT.setStatus_totvs(status_totvs);

            String totvs_cod_empresa = registro.get("totvs_cod_empresa").isString().stringValue();
            gj_gnfe_nota_fiscalTGWT.setTotvs_cod_empresa(totvs_cod_empresa);

            Integer totvs_num_ar = Integer.parseInt(registro.get("totvs_num_ar").isString().stringValue());
            gj_gnfe_nota_fiscalTGWT.setTotvs_num_ar(totvs_num_ar);

            Integer totvs_num_nfe = Integer.parseInt(registro.get("totvs_num_nfe").isString().stringValue());
            gj_gnfe_nota_fiscalTGWT.setTotvs_num_nfe(totvs_num_nfe);

            String totvs_ser_nfe = registro.get("totvs_ser_nfe").isString().stringValue();
            gj_gnfe_nota_fiscalTGWT.setTotvs_ser_nfe(totvs_ser_nfe);

            Integer totvs_ssr_nfe = Integer.parseInt(registro.get("totvs_ssr_nfe").isString().stringValue());
            gj_gnfe_nota_fiscalTGWT.setTotvs_ssr_nfe(totvs_ssr_nfe);

            String totvs_emi_nfe = registro.get("totvs_emi_nfe").isString().stringValue();
            gj_gnfe_nota_fiscalTGWT.setTotvs_emi_nfe(totvs_emi_nfe);

            String totvs_des_nfe = registro.get("totvs_des_nfe").isString().stringValue();
            gj_gnfe_nota_fiscalTGWT.setTotvs_des_nfe(totvs_des_nfe);

            String datNfe = registro.get("totvs_dat_nfe").isString().stringValue();
            if (datNfe != null && datNfe.trim().length() > 0) {
                Date totvs_dat_nfe = dtfDate.parse(datNfe);
                gj_gnfe_nota_fiscalTGWT.setTotvs_dat_nfe(totvs_dat_nfe);
            }

            double totvs_val_nfe = Double.parseDouble(registro.get("totvs_val_nfe").isString().stringValue());
            gj_gnfe_nota_fiscalTGWT.setTotvs_val_nfe(totvs_val_nfe);

            String num_cgc_cpf = registro.get("num_cgc_cpf").isString().stringValue();
            gj_gnfe_nota_fiscalTGWT.setNum_cgc_cpf(num_cgc_cpf);
        } catch (Exception e) {
        }
        return gj_gnfe_nota_fiscalTGWT;

    }

    /**
     * @return the list
     */
    public ListStore getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ListStore list) {
        this.list = list;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the gj_gnfe_nota_fiscalT
     */
    public Gj_gnfe_nota_fiscalTGWT getGj_gnfe_nota_fiscalT() {
        return gj_gnfe_nota_fiscalT;
    }

    /**
     * @param gj_gnfe_nota_fiscalTGWT the gj_gnfe_nota_fiscalTGWT to set
     */
    public void setGj_gnfe_nota_fiscalTGWT(Gj_gnfe_nota_fiscalTGWT gj_gnfe_nota_fiscalT) {
        this.gj_gnfe_nota_fiscalT = gj_gnfe_nota_fiscalT;
    }

    public void consultByNfe(EasyTextField<String> etfNfe) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
