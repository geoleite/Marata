/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.marata.notatransfer;

/**
 *
 * @author geoleite
 */
public class DadosAssinaturaT {
    private String digestvalue;
    private String signaturevalue;
    private String x509certificate;

    /**
     * @return the digestvalue
     */
    public String getDigestvalue() {
        return digestvalue;
    }

    /**
     * @param digestvalue the digestvalue to set
     */
    public void setDigestvalue(String digestvalue) {
        this.digestvalue = digestvalue;
    }

    /**
     * @return the x509certificate
     */
    public String getX509certificate() {
        return x509certificate;
    }

    /**
     * @param x509certificate the x509certificate to set
     */
    public void setX509certificate(String x509certificate) {
        this.x509certificate = x509certificate;
    }
}
