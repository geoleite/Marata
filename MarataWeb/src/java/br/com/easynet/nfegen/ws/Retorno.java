/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.nfegen.ws;

import java.util.List;

/**
 *
 * @author geoleite
 */
public class Retorno {
    private String mensagem;
    private boolean resultadoAutenticacao = false;
    private List<String> notas;

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * @return the resultadoAutenticacao
     */
    public boolean isResultadoAutenticacao() {
        return resultadoAutenticacao;
    }

    /**
     * @param resultadoAutenticacao the resultadoAutenticacao to set
     */
    public void setResultadoAutenticacao(boolean resultadoAutenticacao) {
        this.resultadoAutenticacao = resultadoAutenticacao;
    }

    /**
     * @return the notas
     */
    public List<String> getNotas() {
        return notas;
    }

    /**
     * @param notas the notas to set
     */
    public void setNotas(List<String> notas) {
        this.notas = notas;
    }

}
