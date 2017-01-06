package br.com.i9.marata.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.marata.dao.*;
import br.com.i9.marata.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Gj_gnfe_empresaUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Gj_gnfe_empresaT gj_gnfe_empresaT = new Gj_gnfe_empresaT();

    public void setGj_gnfe_empresaT(Gj_gnfe_empresaT gj_gnfe_empresaT) {
        this.gj_gnfe_empresaT = gj_gnfe_empresaT;
    }

    public Gj_gnfe_empresaT getGj_gnfe_empresaT() {
        return gj_gnfe_empresaT;
    }
    private List<Gj_gnfe_empresaT> list;

    public List<Gj_gnfe_empresaT> getList() {
        return list;
    }

    public void setList(List<Gj_gnfe_empresaT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
    }

    public void clear() throws Exception {

        gj_gnfe_empresaT = new Gj_gnfe_empresaT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Gj_gnfe_empresaDAO gj_gnfe_empresaDAO = getGj_gnfe_empresaDAO();
                gj_gnfe_empresaDAO.delete(gj_gnfe_empresaT);
                setMsg("Exclusao efetuada com sucesso!");
                clear();
            } else {
                setMsg(ERROR, "Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar exclusao!");
        } finally {
            close();
        }
    }

    public boolean exist() throws Exception {
        try {
            Gj_gnfe_empresaDAO gj_gnfe_empresaDAO = getGj_gnfe_empresaDAO();
            List<Gj_gnfe_empresaT> listTemp = gj_gnfe_empresaDAO.getByPK(gj_gnfe_empresaT);

            return listTemp.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
        return false;

    }

    public void update() throws Exception {
        try {
            if (exist()) {
                Gj_gnfe_empresaDAO gj_gnfe_empresaDAO = getGj_gnfe_empresaDAO();
                gj_gnfe_empresaDAO.update(gj_gnfe_empresaT);
                setMsg("Alteracao efetuada com sucesso!");
            } else {
                setMsg(ERROR, "Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar alteracao!");
        } finally {
            close();
        }
    }

// Method de lookup
// 
    //Method Download Image e montando se houver algum campo do tipo binario
    //|DOWNLOADIMAGE|
    public void findbyid() throws Exception {
        try {
            Gj_gnfe_empresaDAO gj_gnfe_empresaDAO = getGj_gnfe_empresaDAO();
            List<Gj_gnfe_empresaT> listTemp = gj_gnfe_empresaDAO.getByPK(gj_gnfe_empresaT);

            gj_gnfe_empresaT = listTemp.size() > 0 ? listTemp.get(0) : new Gj_gnfe_empresaT();

        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    /**
     * Volta para a p?gina de consulta
     */
    public void consult() throws Exception {
        // TODO Consult
        try {
            String page = "gj_gnfe_empresaConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "gj_gnfe_empresaConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
