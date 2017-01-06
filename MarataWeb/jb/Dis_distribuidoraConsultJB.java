package br.com.easynet.nfegen.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Dis_distribuidoraConsultJB extends SystemBase {

    // Atributos e propriedades
    private Dis_distribuidoraT dis_distribuidoraT = new Dis_distribuidoraT();

    public void setDis_distribuidoraT(Dis_distribuidoraT dis_distribuidoraT) {
        this.dis_distribuidoraT = dis_distribuidoraT;
    }

    public Dis_distribuidoraT getDis_distribuidoraT() {
        return dis_distribuidoraT;
    }
    private List<Dis_distribuidoraT> list;

    public List<Dis_distribuidoraT> getList() {
        return list;
    }

    public void setList(List<Dis_distribuidoraT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        consult();
    }

    public void consult() throws Exception {
        try {
            Dis_distribuidoraDAO dis_distribuidoraDAO = getDis_distribuidoraDAO();
            list = dis_distribuidoraDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Dis_distribuidoraDAO dis_distribuidoraDAO = getDis_distribuidoraDAO();
            dis_distribuidoraDAO.delete(dis_distribuidoraT);
            setMsg("Exclusão efetuada com sucesso!");
            dis_distribuidoraT = new Dis_distribuidoraT();
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclusão! Possivelmente há empresas e notas para esta distribuidora.");
        } finally {
            close();
        }
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "dis_distribuidoraInsert.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
