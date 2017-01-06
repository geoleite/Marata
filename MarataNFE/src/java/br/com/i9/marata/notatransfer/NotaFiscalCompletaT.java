/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.marata.notatransfer;

import java.util.Date;

/**
 *
 * @author geoleite
 */
public class NotaFiscalCompletaT {
    // INICIO Dados IDE
    private String uf="", nf="", natOp="";
    private String indPag="", mod="", serie="", nNF="", tNF="", cMunFG="",
            tpImp="", tpEmis="", cDV="", tpAmb="", finNFe="", procEmi="",
            verProc="";
    private Date dEmi, dSaiEnt;
    // FIM Dados IDE

    //INICIO Dados Emit
    private String cnpjEmit, xNomeEmit, xFantEmit;
      // enderEmit
    private String xLgrEmit, nroEmit, xBairroEmit, cMunEmit, xMunEmit, ufEmitEmit,
            cepEmit, cPaisEmit, xPaisEmit;
    private String ieEmit;
    //FIM Dados Emit

    //INICIO Dados Dest
    private String cnpjDest, xNomeDest, xFantDest;
      // enderEmit
    private String xLgrDest, nroDest, xBairroDest, cMunDest, xMunDest, ufEmitDest,
            cepDest, cPaisDest, xPaisDest;
    private String ieDest;

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
     * @return the nf
     */
    public String getNf() {
        return nf;
    }

    /**
     * @param nf the nf to set
     */
    public void setNf(String nf) {
        this.nf = nf;
    }

    /**
     * @return the natOp
     */
    public String getNatOp() {
        return natOp;
    }

    /**
     * @param natOp the natOp to set
     */
    public void setNatOp(String natOp) {
        this.natOp = natOp;
    }

    /**
     * @return the indPag
     */
    public String getIndPag() {
        return indPag;
    }

    /**
     * @param indPag the indPag to set
     */
    public void setIndPag(String indPag) {
        this.indPag = indPag;
    }

    /**
     * @return the mod
     */
    public String getMod() {
        return mod;
    }

    /**
     * @param mod the mod to set
     */
    public void setMod(String mod) {
        this.mod = mod;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * @return the nNF
     */
    public String getnNF() {
        return nNF;
    }

    /**
     * @param nNF the nNF to set
     */
    public void setnNF(String nNF) {
        this.nNF = nNF;
    }

    /**
     * @return the tNF
     */
    public String gettNF() {
        return tNF;
    }

    /**
     * @param tNF the tNF to set
     */
    public void settNF(String tNF) {
        this.tNF = tNF;
    }

    /**
     * @return the cMunFG
     */
    public String getcMunFG() {
        return cMunFG;
    }

    /**
     * @param cMunFG the cMunFG to set
     */
    public void setcMunFG(String cMunFG) {
        this.cMunFG = cMunFG;
    }

    /**
     * @return the tpImp
     */
    public String getTpImp() {
        return tpImp;
    }

    /**
     * @param tpImp the tpImp to set
     */
    public void setTpImp(String tpImp) {
        this.tpImp = tpImp;
    }

    /**
     * @return the tpEmis
     */
    public String getTpEmis() {
        return tpEmis;
    }

    /**
     * @param tpEmis the tpEmis to set
     */
    public void setTpEmis(String tpEmis) {
        this.tpEmis = tpEmis;
    }

    /**
     * @return the cDV
     */
    public String getcDV() {
        return cDV;
    }

    /**
     * @param cDV the cDV to set
     */
    public void setcDV(String cDV) {
        this.cDV = cDV;
    }

    /**
     * @return the tpAmb
     */
    public String getTpAmb() {
        return tpAmb;
    }

    /**
     * @param tpAmb the tpAmb to set
     */
    public void setTpAmb(String tpAmb) {
        this.tpAmb = tpAmb;
    }

    /**
     * @return the finNFe
     */
    public String getFinNFe() {
        return finNFe;
    }

    /**
     * @param finNFe the finNFe to set
     */
    public void setFinNFe(String finNFe) {
        this.finNFe = finNFe;
    }

    /**
     * @return the procEmi
     */
    public String getProcEmi() {
        return procEmi;
    }

    /**
     * @param procEmi the procEmi to set
     */
    public void setProcEmi(String procEmi) {
        this.procEmi = procEmi;
    }

    /**
     * @return the verProc
     */
    public String getVerProc() {
        return verProc;
    }

    /**
     * @param verProc the verProc to set
     */
    public void setVerProc(String verProc) {
        this.verProc = verProc;
    }

    /**
     * @return the dEmi
     */
    public Date getdEmi() {
        return dEmi;
    }

    /**
     * @param dEmi the dEmi to set
     */
    public void setdEmi(Date dEmi) {
        this.dEmi = dEmi;
    }

    /**
     * @return the dSaiEnt
     */
    public Date getdSaiEnt() {
        return dSaiEnt;
    }

    /**
     * @param dSaiEnt the dSaiEnt to set
     */
    public void setdSaiEnt(Date dSaiEnt) {
        this.dSaiEnt = dSaiEnt;
    }

    /**
     * @return the cnpjEmit
     */
    public String getCnpjEmit() {
        return cnpjEmit;
    }

    /**
     * @param cnpjEmit the cnpjEmit to set
     */
    public void setCnpjEmit(String cnpjEmit) {
        this.cnpjEmit = cnpjEmit;
    }

    /**
     * @return the xNomeEmit
     */
    public String getxNomeEmit() {
        return xNomeEmit;
    }

    /**
     * @param xNomeEmit the xNomeEmit to set
     */
    public void setxNomeEmit(String xNomeEmit) {
        this.xNomeEmit = xNomeEmit;
    }

    /**
     * @return the xFantEmit
     */
    public String getxFantEmit() {
        return xFantEmit;
    }

    /**
     * @param xFantEmit the xFantEmit to set
     */
    public void setxFantEmit(String xFantEmit) {
        this.xFantEmit = xFantEmit;
    }

    /**
     * @return the xLgrEmit
     */
    public String getxLgrEmit() {
        return xLgrEmit;
    }

    /**
     * @param xLgrEmit the xLgrEmit to set
     */
    public void setxLgrEmit(String xLgrEmit) {
        this.xLgrEmit = xLgrEmit;
    }

    /**
     * @return the nroEmit
     */
    public String getNroEmit() {
        return nroEmit;
    }

    /**
     * @param nroEmit the nroEmit to set
     */
    public void setNroEmit(String nroEmit) {
        this.nroEmit = nroEmit;
    }

    /**
     * @return the xBairroEmit
     */
    public String getxBairroEmit() {
        return xBairroEmit;
    }

    /**
     * @param xBairroEmit the xBairroEmit to set
     */
    public void setxBairroEmit(String xBairroEmit) {
        this.xBairroEmit = xBairroEmit;
    }

    /**
     * @return the cMunEmit
     */
    public String getcMunEmit() {
        return cMunEmit;
    }

    /**
     * @param cMunEmit the cMunEmit to set
     */
    public void setcMunEmit(String cMunEmit) {
        this.cMunEmit = cMunEmit;
    }

    /**
     * @return the xMunEmit
     */
    public String getxMunEmit() {
        return xMunEmit;
    }

    /**
     * @param xMunEmit the xMunEmit to set
     */
    public void setxMunEmit(String xMunEmit) {
        this.xMunEmit = xMunEmit;
    }

    /**
     * @return the ufEmitEmit
     */
    public String getUfEmitEmit() {
        return ufEmitEmit;
    }

    /**
     * @param ufEmitEmit the ufEmitEmit to set
     */
    public void setUfEmitEmit(String ufEmitEmit) {
        this.ufEmitEmit = ufEmitEmit;
    }

    /**
     * @return the cepEmit
     */
    public String getCepEmit() {
        return cepEmit;
    }

    /**
     * @param cepEmit the cepEmit to set
     */
    public void setCepEmit(String cepEmit) {
        this.cepEmit = cepEmit;
    }

    /**
     * @return the cPaisEmit
     */
    public String getcPaisEmit() {
        return cPaisEmit;
    }

    /**
     * @param cPaisEmit the cPaisEmit to set
     */
    public void setcPaisEmit(String cPaisEmit) {
        this.cPaisEmit = cPaisEmit;
    }

    /**
     * @return the xPaisEmit
     */
    public String getxPaisEmit() {
        return xPaisEmit;
    }

    /**
     * @param xPaisEmit the xPaisEmit to set
     */
    public void setxPaisEmit(String xPaisEmit) {
        this.xPaisEmit = xPaisEmit;
    }

    /**
     * @return the ieEmit
     */
    public String getIeEmit() {
        return ieEmit;
    }

    /**
     * @param ieEmit the ieEmit to set
     */
    public void setIeEmit(String ieEmit) {
        this.ieEmit = ieEmit;
    }

    /**
     * @return the cnpjDest
     */
    public String getCnpjDest() {
        return cnpjDest;
    }

    /**
     * @param cnpjDest the cnpjDest to set
     */
    public void setCnpjDest(String cnpjDest) {
        this.cnpjDest = cnpjDest;
    }

    /**
     * @return the xNomeDest
     */
    public String getxNomeDest() {
        return xNomeDest;
    }

    /**
     * @param xNomeDest the xNomeDest to set
     */
    public void setxNomeDest(String xNomeDest) {
        this.xNomeDest = xNomeDest;
    }

    /**
     * @return the xFantDest
     */
    public String getxFantDest() {
        return xFantDest;
    }

    /**
     * @param xFantDest the xFantDest to set
     */
    public void setxFantDest(String xFantDest) {
        this.xFantDest = xFantDest;
    }

    /**
     * @return the xLgrDest
     */
    public String getxLgrDest() {
        return xLgrDest;
    }

    /**
     * @param xLgrDest the xLgrDest to set
     */
    public void setxLgrDest(String xLgrDest) {
        this.xLgrDest = xLgrDest;
    }

    /**
     * @return the nroDest
     */
    public String getNroDest() {
        return nroDest;
    }

    /**
     * @param nroDest the nroDest to set
     */
    public void setNroDest(String nroDest) {
        this.nroDest = nroDest;
    }

    /**
     * @return the xBairroDest
     */
    public String getxBairroDest() {
        return xBairroDest;
    }

    /**
     * @param xBairroDest the xBairroDest to set
     */
    public void setxBairroDest(String xBairroDest) {
        this.xBairroDest = xBairroDest;
    }

    /**
     * @return the cMunDest
     */
    public String getcMunDest() {
        return cMunDest;
    }

    /**
     * @param cMunDest the cMunDest to set
     */
    public void setcMunDest(String cMunDest) {
        this.cMunDest = cMunDest;
    }

    /**
     * @return the xMunDest
     */
    public String getxMunDest() {
        return xMunDest;
    }

    /**
     * @param xMunDest the xMunDest to set
     */
    public void setxMunDest(String xMunDest) {
        this.xMunDest = xMunDest;
    }

    /**
     * @return the ufEmitDest
     */
    public String getUfEmitDest() {
        return ufEmitDest;
    }

    /**
     * @param ufEmitDest the ufEmitDest to set
     */
    public void setUfEmitDest(String ufEmitDest) {
        this.ufEmitDest = ufEmitDest;
    }

    /**
     * @return the cepDest
     */
    public String getCepDest() {
        return cepDest;
    }

    /**
     * @param cepDest the cepDest to set
     */
    public void setCepDest(String cepDest) {
        this.cepDest = cepDest;
    }

    /**
     * @return the cPaisDest
     */
    public String getcPaisDest() {
        return cPaisDest;
    }

    /**
     * @param cPaisDest the cPaisDest to set
     */
    public void setcPaisDest(String cPaisDest) {
        this.cPaisDest = cPaisDest;
    }

    /**
     * @return the xPaisDest
     */
    public String getxPaisDest() {
        return xPaisDest;
    }

    /**
     * @param xPaisDest the xPaisDest to set
     */
    public void setxPaisDest(String xPaisDest) {
        this.xPaisDest = xPaisDest;
    }

    /**
     * @return the ieDest
     */
    public String getIeDest() {
        return ieDest;
    }

    /**
     * @param ieDest the ieDest to set
     */
    public void setIeDest(String ieDest) {
        this.ieDest = ieDest;
    }
    //FIM Dados Dest

}
