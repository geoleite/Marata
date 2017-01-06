/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.nfegen.transfer;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author geoleite
 */
public class DadosDestT {
    private String numero;
    private String cnpj;
    private String cpf;
    private String ie;
    private String xnome;
    private String xlgr;
    private String nro;
    private String xbairro;
    private String cmun;
    private String xmun;
    private String uf;
    private String cep;
    private String cpais;
    private String xpais;
    private String fone="";
    private String isuf;
    private String xcpl;
    

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        try {

            MaskFormatter mf = new MaskFormatter("##.###.###/####-##");
            if (cnpj == null) {
                cnpj = getCpf();
                mf = new MaskFormatter("###.###.###-##");
            }

            JFormattedTextField tfcep = new JFormattedTextField(mf);
            String str = cnpj;
            tfcep.setText(str);
            return tfcep.getText();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    /**
     * @return the ie
     */
    public String getIe() {
        return ie;
    }

    /**
     * @param ie the ie to set
     */
    public void setIe(String ie) {
        this.ie = ie;
    }

  
    /**
     * @return the xnome
     */
    public String getXnome() {
        return xnome;
    }

    /**
     * @param xnome the xnome to set
     */
    public void setXnome(String xnome) {
        this.xnome = xnome;
    }

    /**
     * @return the xlgr
     */
    public String getXlgr() {
        return xlgr;
    }

    /**
     * @param xlgr the xlgr to set
     */
    public void setXlgr(String xlgr) {
        this.xlgr = xlgr;
    }

    /**
     * @return the nro
     */
    public String getNro() {
        return nro;
    }

    /**
     * @param nro the nro to set
     */
    public void setNro(String nro) {
        this.nro = nro;
    }

    /**
     * @return the xbairro
     */
    public String getXbairro() {
        return xbairro;
    }

    /**
     * @param xbairro the xbairro to set
     */
    public void setXbairro(String xbairro) {
        this.xbairro = xbairro;
    }

    /**
     * @return the cmun
     */
    public String getCmun() {
        return cmun;
    }

    /**
     * @param cmun the cmun to set
     */
    public void setCmun(String cmun) {
        this.cmun = cmun;
    }

    /**
     * @return the xmun
     */
    public String getXmun() {
        return xmun;
    }

    /**
     * @param xmun the xmun to set
     */
    public void setXmun(String xmun) {
        this.xmun = xmun;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the cpais
     */
    public String getCpais() {
        return cpais;
    }

    /**
     * @param cpais the cpais to set
     */
    public void setCpais(String cpais) {
        this.cpais = cpais;
    }

    /**
     * @return the xpais
     */
    public String getXpais() {
        return xpais;
    }

    /**
     * @param xpais the xpais to set
     */
    public void setXpais(String xpais) {
        this.xpais = xpais;
    }

    /**
     * @return the fone
     */
    public String getFone() {
        return fone;
    }

    /**
     * @param fone the fone to set
     */
    public void setFone(String fone) {
        this.fone = fone;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the isuf
     */
    public String getIsuf() {
        return isuf;
    }

    /**
     * @param isuf the isuf to set
     */
    public void setIsuf(String isuf) {
        this.isuf = isuf;
    }

    /**
     * @return the xcpl
     */
    public String getXcpl() {
        return xcpl;
    }

    /**
     * @param xcpl the xcpl to set
     */
    public void setXcpl(String xcpl) {
        this.xcpl = xcpl;
    }

    
}
