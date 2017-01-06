/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.nfegen.transfer;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author geoleite
 */
public class NotaFiscalEletronicaT {
    private DadosNFET dadosNFET;
    private DadosIDET dadosIDET;
    private DadosEmissorT dadosEmissorT;
    private DadosDestT dadosDestT;
    private List<DadosDetT> listaDet = new Vector<DadosDetT>();
    private DadosTotalT dadosTotalT;
    private DadosTranspT dadosTranspT;
    private DadosCobrancaT dadosCobrancaT;
    private DadosInformacoesAdicionaisT dadosInformacoesAdicionaisT;
    private DadosAssinaturaT dadosAssinaturaT;

    /**
     * @return the dadosNFET
     */
    public DadosNFET getDadosNFET() {
        return dadosNFET;
    }

    /**
     * @param dadosNFET the dadosNFET to set
     */
    public void setDadosNFET(DadosNFET dadosNFET) {
        this.dadosNFET = dadosNFET;
    }

    /**
     * @return the dadosIDET
     */
    public DadosIDET getDadosIDET() {
        return dadosIDET;
    }

    /**
     * @param dadosIDET the dadosIDET to set
     */
    public void setDadosIDET(DadosIDET dadosIDET) {
        this.dadosIDET = dadosIDET;
    }

    /**
     * @return the dadosEmissorT
     */
    public DadosEmissorT getDadosEmissorT() {
        return dadosEmissorT;
    }

    /**
     * @param dadosEmissorT the dadosEmissorT to set
     */
    public void setDadosEmissorT(DadosEmissorT dadosEmissorT) {
        this.dadosEmissorT = dadosEmissorT;
    }

    /**
     * @return the dadosDestT
     */
    public DadosDestT getDadosDestT() {
        return dadosDestT;
    }

    /**
     * @param dadosDestT the dadosDestT to set
     */
    public void setDadosDestT(DadosDestT dadosDestT) {
        this.dadosDestT = dadosDestT;
    }

    /**
     * @return the listaDet
     */
    public List<DadosDetT> getListaDet() {
        return listaDet;
    }

    /**
     * @param listaDet the listaDet to set
     */
    public void setListaDet(List<DadosDetT> listaDet) {
        this.listaDet = listaDet;
    }

    /**
     * @return the dadosTotalT
     */
    public DadosTotalT getDadosTotalT() {
        return dadosTotalT;
    }

    /**
     * @param dadosTotalT the dadosTotalT to set
     */
    public void setDadosTotalT(DadosTotalT dadosTotalT) {
        this.dadosTotalT = dadosTotalT;
    }

    /**
     * @return the dadosTranspT
     */
    public DadosTranspT getDadosTranspT() {
        return dadosTranspT;
    }

    /**
     * @param dadosTranspT the dadosTranspT to set
     */
    public void setDadosTranspT(DadosTranspT dadosTranspT) {
        this.dadosTranspT = dadosTranspT;
    }

    /**
     * @return the dadosCobrancaT
     */
    public DadosCobrancaT getDadosCobrancaT() {
        return dadosCobrancaT;
    }

    /**
     * @param dadosCobrancaT the dadosCobrancaT to set
     */
    public void setDadosCobrancaT(DadosCobrancaT dadosCobrancaT) {
        this.dadosCobrancaT = dadosCobrancaT;
    }

    /**
     * @return the dadosAssinaturaT
     */
    public DadosAssinaturaT getDadosAssinaturaT() {
        return dadosAssinaturaT;
    }

    /**
     * @param dadosAssinaturaT the dadosAssinaturaT to set
     */
    public void setDadosAssinaturaT(DadosAssinaturaT dadosAssinaturaT) {
        this.dadosAssinaturaT = dadosAssinaturaT;
    }

    /**
     * @return the dadosInformacoesAdicionaisT
     */
    public DadosInformacoesAdicionaisT getDadosInformacoesAdicionaisT() {
        return dadosInformacoesAdicionaisT;
    }

    /**
     * @param dadosInformacoesAdicionaisT the dadosInformacoesAdicionaisT to set
     */
    public void setDadosInformacoesAdicionaisT(DadosInformacoesAdicionaisT dadosInformacoesAdicionaisT) {
        this.dadosInformacoesAdicionaisT = dadosInformacoesAdicionaisT;
    }
}
