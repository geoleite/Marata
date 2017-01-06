package br.com.easynet.nfegen.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;
import br.com.easynet.nfegen.util.ValidacaoCNPJ_CPF;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Dis_distribuidoraUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Dis_distribuidoraT dis_distribuidoraT = new Dis_distribuidoraT();
    private List<Dis_distribuidoraT> listaDist;
    
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
        listaDist = getDis_distribuidoraDAO().getAll();
        if (!"update".equals(getOp()) ) {
            dis_distribuidoraT = findbyIdDis_distribuidora(dis_distribuidoraT);
        }
    //
    }

    public void clear() throws Exception {

        dis_distribuidoraT = new Dis_distribuidoraT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Dis_distribuidoraDAO dis_distribuidoraDAO = getDis_distribuidoraDAO();
                dis_distribuidoraDAO.delete(dis_distribuidoraT);
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
            Dis_distribuidoraDAO dis_distribuidoraDAO = getDis_distribuidoraDAO();
            List<Dis_distribuidoraT> listTemp = dis_distribuidoraDAO.getById(dis_distribuidoraT);

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
                if (!ValidacaoCNPJ_CPF.valideCNPJ(dis_distribuidoraT.getDis_tx_cnpj())) {
                    setMsg("CNPJ inválido!");
                    return;
                }

                Dis_distribuidoraDAO dis_distribuidoraDAO = getDis_distribuidoraDAO();
                dis_distribuidoraDAO.update(dis_distribuidoraT);
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
            Dis_distribuidoraDAO dis_distribuidoraDAO = getDis_distribuidoraDAO();
            List<Dis_distribuidoraT> listTemp = dis_distribuidoraDAO.getById(dis_distribuidoraT);

            dis_distribuidoraT = listTemp.size() > 0 ? listTemp.get(0) : new Dis_distribuidoraT();

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
            String page = "dis_distribuidoraConsult.jsp";// defina aqui a p?gina que deve ser chamada  

            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "dis_distribuidoraConsult.jsp";// defina aqui a p?gina que deve ser chamada  

            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the listaDist
     */
    public List<Dis_distribuidoraT> getListaDist() {
        return listaDist;
    }

    /**
     * @param listaDist the listaDist to set
     */
    public void setListaDist(List<Dis_distribuidoraT> listaDist) {
        this.listaDist = listaDist;
    }
}
