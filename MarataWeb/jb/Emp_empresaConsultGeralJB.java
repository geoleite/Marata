package br.com.easynet.nfegen.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Emp_empresaConsultGeralJB extends SystemBase {

    // Atributos e propriedades

    private String informacao="";
    private String tipo="N";
    private List<Emp_empresaT> list;

    public List<Emp_empresaT> getList() {
        return list;
    }

    public void setList(List<Emp_empresaT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //consult();
    }

    public void consult() throws Exception {
        try {
            //emp_empresaT.setDis_nr_id(dis_distribuidoraT.getDis_nr_id());
            Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
            Emp_empresaT empT = new Emp_empresaT();
            if ("N".equals(tipo)) {
                empT.setEmp_tx_nome(informacao);
                list = emp_empresaDAO.getByEmp_tx_nome(empT);
            } else {
                empT.setEmp_tx_cnpj(informacao);
                list = emp_empresaDAO.getByCnpj(empT);
            }
            
            //list = emp_empresaDAO.getByDis_distribuidora(dis_distribuidoraT);
            //list = emp_empresaDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    /**
     * @return the informacao
     */
    public String getInformacao() {
        return informacao;
    }

    /**
     * @param informacao the informacao to set
     */
    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
