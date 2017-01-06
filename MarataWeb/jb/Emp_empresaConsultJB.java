package br.com.easynet.nfegen.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Emp_empresaConsultJB extends SystemBase {

    // Atributos e propriedades
    private Emp_empresaT emp_empresaT = new Emp_empresaT();
    private Dis_distribuidoraT dis_distribuidoraT = new Dis_distribuidoraT();

    public void setEmp_empresaT(Emp_empresaT emp_empresaT) {
        this.emp_empresaT = emp_empresaT;
    }

    public Emp_empresaT getEmp_empresaT() {
        return emp_empresaT;
    }
    private List<Emp_empresaT> list;

    public List<Emp_empresaT> getList() {
        return list;
    }

    public void setList(List<Emp_empresaT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        dis_distribuidoraT = findbyIdDis_distribuidora(dis_distribuidoraT);
        consult();
    }

    public void consult() throws Exception {
        try {
            //emp_empresaT.setDis_nr_id(dis_distribuidoraT.getDis_nr_id());
            Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
            list = emp_empresaDAO.getByDis_distribuidora(dis_distribuidoraT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
            emp_empresaDAO.delete(emp_empresaT);
            setMsg("Exclusão efetuada com sucesso!");
            emp_empresaT = new Emp_empresaT();
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclusão! Possivelmente há clientes e/ou notas associado a essa distribuidora.");
        } finally {
            close();
        }
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "emp_empresaInsert.jsp";// defina aqui a p?gina que deve ser chamada  

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

    public Dis_distribuidoraT getDis_distribuidoraT() {
        return dis_distribuidoraT;
    }

    public void setDis_distribuidoraT(Dis_distribuidoraT dis_distribuidoraT) {
        this.dis_distribuidoraT = dis_distribuidoraT;
    }
}
