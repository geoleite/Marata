package br.com.i9.marata.client.nfe.GJAV.dao;

import br.com.i9.marata.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.marata.client.nfe.GJAV.transfer.Gnfe_cliente_fornecedorTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

import java.util.*;

public class Gnfe_cliente_fornecedorDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "nfe/GJAV/gnfe_cliente_fornecedor/gnfe_cliente_fornecedorInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "nfe/GJAV/gnfe_cliente_fornecedor/gnfe_cliente_fornecedorConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "nfe/GJAV/gnfe_cliente_fornecedor/gnfe_cliente_fornecedorUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Gnfe_cliente_fornecedorTGWT gnfe_cliente_fornecedorT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void consultByNomeCpfCnpj(Gnfe_cliente_fornecedorTGWT cliForT) {
        list = null;
        msg = null;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByNomeCpfCnpj");
        param.put("gnfe_cliente_fornecedorT.razao", cliForT.getRazao() + "");
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void inserir(Gnfe_cliente_fornecedorTGWT gnfe_cliente_fornecedorT) {
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
        param.put("gnfe_cliente_fornecedorT.codigo", gnfe_cliente_fornecedorT.getCodigo() + "");
        param.put("gnfe_cliente_fornecedorT.razao", gnfe_cliente_fornecedorT.getRazao() + "");
        param.put("gnfe_cliente_fornecedorT.status", gnfe_cliente_fornecedorT.getStatus() + "");
        param.put("gnfe_cliente_fornecedorT.tipo", gnfe_cliente_fornecedorT.getTipo() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Gnfe_cliente_fornecedorTGWT gnfe_cliente_fornecedorT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("gnfe_cliente_fornecedor").isObject();
                    Gnfe_cliente_fornecedorDAOGWT.this.gnfe_cliente_fornecedorT = lerRegistroJson(registro);
                }
            }
        };
        this.gnfe_cliente_fornecedorT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Gnfe_cliente_fornecedorTGWT gnfe_cliente_fornecedorT) {
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

    public void alterar(Gnfe_cliente_fornecedorTGWT gnfe_cliente_fornecedorT) {
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
        param.put("gnfe_cliente_fornecedorT.codigo", gnfe_cliente_fornecedorT.getCodigo() + "");
        param.put("gnfe_cliente_fornecedorT.razao", gnfe_cliente_fornecedorT.getRazao() + "");
        param.put("gnfe_cliente_fornecedorT.status", gnfe_cliente_fornecedorT.getStatus() + "");
        param.put("gnfe_cliente_fornecedorT.tipo", gnfe_cliente_fornecedorT.getTipo() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Gnfe_cliente_fornecedorTGWT> lista = new ListStore<Gnfe_cliente_fornecedorTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Gnfe_cliente_fornecedorTGWT gnfe_cliente_fornecedorT = lerRegistroJson(registro);
                lista.add(gnfe_cliente_fornecedorT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Gnfe_cliente_fornecedorTGWT lerRegistroJson(JSONObject registro) {
        Gnfe_cliente_fornecedorTGWT gnfe_cliente_fornecedorTGWT = new Gnfe_cliente_fornecedorTGWT();
        String codigo = registro.get("codigo").isString().stringValue();
        gnfe_cliente_fornecedorTGWT.setCodigo(codigo);

        String razao = registro.get("razao").isString().stringValue();
        gnfe_cliente_fornecedorTGWT.setRazao(razao);

        String cgcCpf = registro.get("num_cgc_cpf").isString().stringValue();
        gnfe_cliente_fornecedorTGWT.setNum_cgc_cpf(cgcCpf);

        String status = registro.get("status").isString().stringValue();
        gnfe_cliente_fornecedorTGWT.setStatus(status);

        String tipo = registro.get("tipo").isString().stringValue();
        gnfe_cliente_fornecedorTGWT.setTipo(tipo);


        return gnfe_cliente_fornecedorTGWT;
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
     * @return the gnfe_cliente_fornecedorT
     */
    public Gnfe_cliente_fornecedorTGWT getGnfe_cliente_fornecedorT() {
        return gnfe_cliente_fornecedorT;
    }

    /**
     * @param gnfe_cliente_fornecedorTGWT the gnfe_cliente_fornecedorTGWT to set
     */
    public void setGnfe_cliente_fornecedorTGWT(Gnfe_cliente_fornecedorTGWT gnfe_cliente_fornecedorT) {
        this.gnfe_cliente_fornecedorT = gnfe_cliente_fornecedorT;
    }
}
