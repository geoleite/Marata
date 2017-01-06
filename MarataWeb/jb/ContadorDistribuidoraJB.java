/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.nfegen.jb;

import br.com.easynet.nfegen.transfer.Con_contadorT;
import br.com.easynet.nfegen.transfer.Dis_distribuidoraT;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class ContadorDistribuidoraJB extends SystemBase {

    private Dis_distribuidoraT dis_distribuidoraT = new Dis_distribuidoraT();
    private Con_contadorT con_contadorT = new Con_contadorT();
    private List<Con_contadorT> listContador;

    public void pageLoad() throws Exception {
        
    }

    public void consultarContadores() {
        try {
            listContador = getCon_contadorDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void addContador() throws Exception {
        con_contadorT = findbyIdCon_contador(con_contadorT);
        
    }

    /**
     * @return the listContador
     */
    public List<Con_contadorT> getListContador() {
        return listContador;
    }

    /**
     * @param listContador the listContador to set
     */
    public void setListContador(List<Con_contadorT> listContador) {
        this.listContador = listContador;
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
}
