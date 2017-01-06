/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.nfegen.jb;

import br.com.easynet.nfegen.dao.Cd_con_disDAO;
import br.com.easynet.nfegen.transfer.Cd_con_disT;
import br.com.easynet.nfegen.transfer.Con_contadorT;
import br.com.easynet.nfegen.transfer.Dis_distribuidoraT;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class Con_contadorDistribuidoraConsultJB extends SystemBase {
    private Dis_distribuidoraT dis_distribuidoraT = new Dis_distribuidoraT();
    private Con_contadorT con_contadorT = new Con_contadorT();
    private Con_contadorT con_contadorTNovo = new Con_contadorT();
    private List<Con_contadorT> listContadores ;


    public void pageLoad() throws Exception {
        super.pageLoad();
        dis_distribuidoraT = findbyIdDis_distribuidora(dis_distribuidoraT);
        consultContador();
        consultContadores();
    }

    public void consultContadores() {
        try {
            listContadores = getCon_contadorDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }


    public void consultContador() {
        try {
            con_contadorT = getCon_contadorDAO().getByDistribuidora(dis_distribuidoraT);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void definirContador() {
        try {
            Cd_con_disT cdT = new Cd_con_disT();
            cdT.setDis_nr_id(dis_distribuidoraT.getDis_nr_id());
            Cd_con_disDAO cdDao = getCd_con_disDAO();
            cdDao.deleteContadorDistribuidora(cdT);
            cdT.setCon_nr_id(con_contadorTNovo.getCon_nr_id());
            cdDao.insert(cdT);
            consultContador();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    /**
     * @return the dis_distribuidoraT
     */
    public Dis_distribuidoraT getDis_distribuidoraT() {
        return dis_distribuidoraT;
    }

    /**
     * @param dis_distribuidoraT the dis_distribuidoraT to set
     */
    public void setDis_distribuidoraT(Dis_distribuidoraT dis_distribuidoraT) {
        this.dis_distribuidoraT = dis_distribuidoraT;
    }

    /**
     * @return the con_contadorT
     */
    public Con_contadorT getCon_contadorT() {
        return con_contadorT;
    }

    /**
     * @param con_contadorT the con_contadorT to set
     */
    public void setCon_contadorT(Con_contadorT con_contadorT) {
        this.con_contadorT = con_contadorT;
    }

    /**
     * @return the listContadores
     */
    public List<Con_contadorT> getListContadores() {
        return listContadores;
    }

    /**
     * @param listContadores the listContadores to set
     */
    public void setListContadores(List<Con_contadorT> listContadores) {
        this.listContadores = listContadores;
    }

    /**
     * @return the con_contadorTNovo
     */
    public Con_contadorT getCon_contadorTNovo() {
        return con_contadorTNovo;
    }

    /**
     * @param con_contadorTNovo the con_contadorTNovo to set
     */
    public void setCon_contadorTNovo(Con_contadorT con_contadorTNovo) {
        this.con_contadorTNovo = con_contadorTNovo;
    }

}
