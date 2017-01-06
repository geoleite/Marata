package br.com.i9.marata.client.nfe.GJAV.dao;
import br.com.i9.marata.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.marata.client.nfe.GJAV.transfer.Gj_gnfe_empresaTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Gj_gnfe_empresaDAOGWT implements IListenetResponse {
    public static final String PAGE_INSERIR = "nfe/GJAV/gj_gnfe_empresa/gj_gnfe_empresaInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "nfe/GJAV/gj_gnfe_empresa/gj_gnfe_empresaConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "nfe/GJAV/gj_gnfe_empresa/gj_gnfe_empresaUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;	
    private ListStore list;
    private Gj_gnfe_empresaTGWT gj_gnfe_empresaT;	
    public void consultarTodos() {        
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Gj_gnfe_empresaTGWT gj_gnfe_empresaT) {
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
	param.put("gj_gnfe_empresaT.cod_empresa" , gj_gnfe_empresaT.getCod_empresa() + "");
param.put("gj_gnfe_empresaT.cnpj_empresa" , gj_gnfe_empresaT.getCnpj_empresa() + "");
param.put("gj_gnfe_empresaT.den_empresa" , gj_gnfe_empresaT.getDen_empresa() + "");
param.put("gj_gnfe_empresaT.id_ent" , gj_gnfe_empresaT.getId_ent() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Gj_gnfe_empresaTGWT gj_gnfe_empresaT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("gj_gnfe_empresa").isObject();
                    Gj_gnfe_empresaDAOGWT.this.gj_gnfe_empresaT = lerRegistroJson(registro);
                }
            }
        };
	this.gj_gnfe_empresaT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }
    public void excluir(Gj_gnfe_empresaTGWT gj_gnfe_empresaT) {
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

    public void alterar(Gj_gnfe_empresaTGWT gj_gnfe_empresaT) {
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
	param.put("gj_gnfe_empresaT.cod_empresa" , gj_gnfe_empresaT.getCod_empresa() + "");
param.put("gj_gnfe_empresaT.cnpj_empresa" , gj_gnfe_empresaT.getCnpj_empresa() + "");
param.put("gj_gnfe_empresaT.den_empresa" , gj_gnfe_empresaT.getDen_empresa() + "");
param.put("gj_gnfe_empresaT.id_ent" , gj_gnfe_empresaT.getId_ent() + "");

        
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }
    
    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Gj_gnfe_empresaTGWT> lista = new ListStore<Gj_gnfe_empresaTGWT>();            

            for (int i = 1; i < resultado.size(); i++) {		
                JSONObject registro = resultado.get(i).isObject();
	        Gj_gnfe_empresaTGWT gj_gnfe_empresaT = lerRegistroJson(registro);
                lista.add(gj_gnfe_empresaT);            
            }
	    list = lista;
        }
    }

    /**
     * Ler os dados o conteudo json
     */	
    private Gj_gnfe_empresaTGWT lerRegistroJson(JSONObject registro) {
	Gj_gnfe_empresaTGWT gj_gnfe_empresaTGWT = new Gj_gnfe_empresaTGWT();
	                String cod_empresa= registro.get("cod_empresa").isString().stringValue();
                gj_gnfe_empresaTGWT.setCod_empresa(cod_empresa);

                String cnpj_empresa= registro.get("cnpj_empresa").isString().stringValue();
                gj_gnfe_empresaTGWT.setCnpj_empresa(cnpj_empresa);

                String den_empresa= registro.get("den_empresa").isString().stringValue();
                gj_gnfe_empresaTGWT.setDen_empresa(den_empresa);

                String id_ent= registro.get("id_ent").isString().stringValue();
                gj_gnfe_empresaTGWT.setId_ent(id_ent);


	return gj_gnfe_empresaTGWT;
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
     * @return the gj_gnfe_empresaT
     */
    public Gj_gnfe_empresaTGWT getGj_gnfe_empresaT() {
        return gj_gnfe_empresaT;
    }

    /**
     * @param gj_gnfe_empresaTGWT the gj_gnfe_empresaTGWT to set
     */
    public void setGj_gnfe_empresaTGWT(Gj_gnfe_empresaTGWT gj_gnfe_empresaT) {
        this.gj_gnfe_empresaT = gj_gnfe_empresaT;
    }
}
