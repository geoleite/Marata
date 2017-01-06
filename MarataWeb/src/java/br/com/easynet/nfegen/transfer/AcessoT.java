/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.nfegen.transfer;

/**
 *
 * @author geoleite
 */
public class AcessoT {
    private String codUsuario;
    private String codEmpresa;
    private int nivelAcesso;

    /**
     * @return the codUsuario
     */
    public String getCodUsuario() {
        return codUsuario;
    }

    /**
     * @param codUsuario the codUsuario to set
     */
    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    /**
     * @return the codEmpresa
     */
    public String getCodEmpresa() {
        return codEmpresa;
    }

    /**
     * @param codEmpresa the codEmpresa to set
     */
    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    /**
     * @return the nivelAcesso
     */
    public int getNivelAcesso() {
        return nivelAcesso;
    }

    /**
     * @param nivelAcesso the nivelAcesso to set
     */
    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}
