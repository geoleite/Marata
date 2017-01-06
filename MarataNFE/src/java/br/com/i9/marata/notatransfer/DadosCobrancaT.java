/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.marata.notatransfer;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author geoleite
 */
public class DadosCobrancaT {
    private String fat;
    private String dup;
    private String numero;
    private String nfat;
    private String vorig;
    private String vdesc;
    private String vliq;
    private String ndup;
    private String dvenc;
    private String vdup;
    
//    private String valororiginal, valordesconto, valorliquido;
//    private String numeroduplicata, vencimento,  valor;

    /**
     * @return the numero
     */
    public String getNumero() {
        try {

            //MaskFormatter mf = new MaskFormatter("##-##/##-##.###.###/####-##-##-###-###.###.###-###.###.###-#");
            //JFormattedTextField tfcep = new JFormattedTextField(mf);
            String str = numero;
            str = str.substring(str.length() - 10, str.length() - 1);
            //str = str.substring(3, str.length());
            //000342973
            //tfcep.setText(str);
            //return tfcep.getText();
            return str;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the nfat
     */
    public String getNfat() {
        return nfat;
    }

    /**
     * @param nfat the nfat to set
     */
    public void setNfat(String nfat) {
        this.nfat = nfat;
    }

    /**
     * @return the vorig
     */
    public String getVorig() {
        return vorig;
    }

    /**
     * @param vorig the vorig to set
     */
    public void setVorig(String vorig) {
        this.vorig = vorig;
    }

    /**
     * @return the vdesc
     */
    public String getVdesc() {
        return vdesc;
    }

    /**
     * @param vdesc the vdesc to set
     */
    public void setVdesc(String vdesc) {
        this.vdesc = vdesc;
    }

    /**
     * @return the vliq
     */
    public String getVliq() {
        return vliq;
    }

    /**
     * @param vliq the vliq to set
     */
    public void setVliq(String vliq) {
        this.vliq = vliq;
    }

    /**
     * @return the ndup
     */
    public String getNdup() {
        return ndup;
    }

    /**
     * @param ndup the ndup to set
     */
    public void setNdup(String ndup) {
        this.ndup = ndup;
    }

    /**
     * @return the dvenc
     */
    public String getDvenc() {
        return dvenc;
    }

    /**
     * @param dvenc the dvenc to set
     */
    public void setDvenc(String dvenc) {
        this.dvenc = dvenc;
    }

    /**
     * @return the vdup
     */
    public String getVdup() {
        return vdup;
    }

    /**
     * @param vdup the vdup to set
     */
    public void setVdup(String vdup) {
        this.vdup = vdup;
    }

    /**
     * @return the fat
     */
    public String getFat() {
        return fat;
    }

    /**
     * @param fat the fat to set
     */
    public void setFat(String fat) {
        this.fat = fat;
    }

    /**
     * @return the dup
     */
    public String getDup() {
        return dup;
    }

    /**
     * @param dup the dup to set
     */
    public void setDup(String dup) {
        this.dup = dup;
    }

}
