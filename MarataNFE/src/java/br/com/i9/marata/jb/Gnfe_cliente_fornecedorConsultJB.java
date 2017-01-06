package br.com.i9.marata.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.marata.dao.*;
import br.com.i9.marata.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Gnfe_cliente_fornecedorConsultJB extends SystemBase {

    // Atributos e propriedades
    private Gnfe_cliente_fornecedorT gnfe_cliente_fornecedorT = new Gnfe_cliente_fornecedorT();

    public void setGnfe_cliente_fornecedorT(Gnfe_cliente_fornecedorT gnfe_cliente_fornecedorT) {
        this.gnfe_cliente_fornecedorT = gnfe_cliente_fornecedorT;
    }

    public Gnfe_cliente_fornecedorT getGnfe_cliente_fornecedorT() {
        return gnfe_cliente_fornecedorT;
    }
    private List<Gnfe_cliente_fornecedorT> list;

    public List<Gnfe_cliente_fornecedorT> getList() {
        return list;
    }

    public void setList(List<Gnfe_cliente_fornecedorT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //consult();
    }

    public void consult() throws Exception {
        try {
            Gnfe_cliente_fornecedorDAO gnfe_cliente_fornecedorDAO = getGnfe_cliente_fornecedorDAO();
            list = gnfe_cliente_fornecedorDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultByNomeCpfCnpj() {
        try {
            Gnfe_cliente_fornecedorDAO gnfe_cliente_fornecedorDAO = getGnfe_cliente_fornecedorDAO();
            try {
                Long.parseLong(gnfe_cliente_fornecedorT.getRazao());
                gnfe_cliente_fornecedorT.setCodigo(gnfe_cliente_fornecedorT.getRazao());
                list = gnfe_cliente_fornecedorDAO.getByCodigo(gnfe_cliente_fornecedorT);
                return;
            } catch (Exception e) {
                list = gnfe_cliente_fornecedorDAO.getByRazao(gnfe_cliente_fornecedorT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Gnfe_cliente_fornecedorDAO gnfe_cliente_fornecedorDAO = getGnfe_cliente_fornecedorDAO();
            gnfe_cliente_fornecedorDAO.delete(gnfe_cliente_fornecedorT);
            setMsg("Exclusao efetuada com sucesso!");
            gnfe_cliente_fornecedorT = new Gnfe_cliente_fornecedorT();
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar exclusao!");
        } finally {
            close();
        }
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "gnfe_cliente_fornecedorInsert.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
