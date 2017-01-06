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
public class DadosDestT {
    private String numero;
    private String cnpj;
    private String cpf;
    private String xnome;
    private String ie;
    private DadosEnderT dadosEnderT;
    
    

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
     * @return the dadosEnderT
     */
    public DadosEnderT getDadosEnderT() {
        return dadosEnderT;
    }

    /**
     * @param dadosEnderT the dadosEnderT to set
     */
    public void setDadosEnderT(DadosEnderT dadosEnderT) {
        this.dadosEnderT = dadosEnderT;
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

    
}
