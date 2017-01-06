package br.com.easynet.nfegen.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Emp_empresaUpdateDeleteGeralJB extends SystemBase {

    // Atributos e propriedades
    private Dis_distribuidoraT dis_distribuidoraT = new Dis_distribuidoraT();
    private Emp_empresaT emp_empresaT = new Emp_empresaT();
    private List<Emp_empresaT> listEmp;

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
        listEmp = getEmp_empresaDAO().getAll();

        //emp_empresaT.setDis_nr_id(dis_distribuidoraT.getDis_nr_id());
    }

    public void clear() throws Exception {

        emp_empresaT = new Emp_empresaT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
                emp_empresaDAO.delete(emp_empresaT);
                setMsg("Exclusão efetuada com sucesso!");
                clear();
            } else {
                setMsg("Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclusão! Possivelmente há notas fiscais para esta empresa.");
        } finally {
            close();
        }
    }

    public boolean exist() throws Exception {
        try {
            Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
            List<Emp_empresaT> listTemp = emp_empresaDAO.getById(emp_empresaT);

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
                Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
                emp_empresaDAO.updateGeral(emp_empresaT);
                setMsg("Alteracão efetuada com sucesso!");
            } else {
                setMsg("Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar alteracão!");
        } finally {
            close();
        }
    }

// Method de lookup
// 
    //Method Download Image ? montando se houver algum campo do tipo bin?rio
    //|DOWNLOADIMAGE| 
    public void findbyid() throws Exception {
        try {
            Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
            List<Emp_empresaT> listTemp = emp_empresaDAO.getById(emp_empresaT);

            emp_empresaT = listTemp.size() > 0 ? listTemp.get(0) : new Emp_empresaT();

        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
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
            String page = "emp_empresaConsult.jsp";// defina aqui a p?gina que deve ser chamada  

            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "emp_empresaConsult.jsp";// defina aqui a p?gina que deve ser chamada  

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

    /**
     * @return the listEmp
     */
    public List<Emp_empresaT> getListEmp() {
        return listEmp;
    }

    /**
     * @param listEmp the listEmp to set
     */
    public void setListEmp(List<Emp_empresaT> listEmp) {
        this.listEmp = listEmp;
    }
}
