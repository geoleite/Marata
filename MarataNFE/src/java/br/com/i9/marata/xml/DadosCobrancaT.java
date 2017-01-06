/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.marata.xml;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author geoleite
 */
public class DadosCobrancaT {
 private DadosFatT dadosFatT;
 private DadosDupT dadosDupT;

    /**
     * @return the dadosFatT
     */
    public DadosFatT getDadosFatT() {
        return dadosFatT;
    }

    /**
     * @param dadosFatT the dadosFatT to set
     */
    public void setDadosFatT(DadosFatT dadosFatT) {
        this.dadosFatT = dadosFatT;
    }

    /**
     * @return the dadosDupT
     */
    public DadosDupT getDadosDupT() {
        return dadosDupT;
    }

    /**
     * @param dadosDupT the dadosDupT to set
     */
    public void setDadosDupT(DadosDupT dadosDupT) {
        this.dadosDupT = dadosDupT;
    }

}
