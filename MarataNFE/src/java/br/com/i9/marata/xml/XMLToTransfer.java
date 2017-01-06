/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.marata.xml;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.XML11NMTOKENDatatypeValidator;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.html.HTMLDocument.Iterator;
import org.apache.jasper.tagplugins.jstl.core.Catch;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.jdom.*;
import org.jdom.output.Format;

/**
 *
 * @author Marcelo
 */
public class XMLToTransfer {

    public final static String INFNFE = "infNFe";
    public final static String IDE = "ide";
    public final static String CUF = "cUF";
    public final static String CNF = "cNF";
    public final static String NATOP = "natOp";
    public final static String INFPAG = "indPag";
    public final static String MOD = "mod";
    public final static String SERIE = "serie";
    public final static String NNF = "nNF";
    public final static String DEMI = "dEmi";
    public final static String DSAIENT = "dSaiEnt";
    public final static String TPNF = "tpNF";
    public final static String CMUNFG = "cMunFG";
    public final static String TPIMP = "tpImp";
    public final static String TPEMIS = "tpEmis";
    public final static String CDV = "cDV";
    public final static String TPAMB = "tpAmb";
    public final static String FINNFE = "finNFE";
    public final static String PROCEMI = "procEmi";
    public final static String VERPROC = "verProc";
    public final static String EMIT = "emit";
    public final static String DEST = "dest";
    public final static String CNPJ = "CNPJ";
    public final static String XNOME = "xNome";
    public final static String XFANT = "xFant";
    public final static String ENDEREMIT = "enderEmit";
    public final static String ENDERDEST = "enderDest";
    public final static String XLGR = "xLgr";
    public final static String NRO = "nro";
    public final static String XBAIRRO = "xBairro";
    public final static String CMUN = "cMun";
    public final static String XMUN = "xMun";
    public final static String UF = "UF";
    public final static String CEP = "CEP";
    public final static String CPAIS = "cPais";
    public final static String XPAIS = "xPais";
    public final static String IE = "IE";
    public final static String DET = "det";
    public final static String PROD = "prod";
    public final static String CPROD = "cProd";
    public final static String CEAN = "cEAN";
    public final static String XPROD = "xProd";
    public final static String CFOP = "CFOP";
    public final static String UCOM = "uCom";
    public final static String QCOM = "qCom";
    public final static String VUNCOM = "vUnCom";
    public final static String VPROD = "vProd";
    public final static String CEANTRIB = "cEANTrib";
    public final static String UTRIB = "uTrib";
    public final static String QTRIB = "qTrib";
    public final static String VUNTRIB = "vUnTrib";
    public final static String MED = "med";
    public final static String NLOTE = "nLote";
    public final static String QLOTE = "qLote";
    public final static String DFAB = "dFab";
    public final static String DVAL = "dVal";
    public final static String VPMC = "vPMC";
    public final static String IMPOSTO = "imposto";
    public final static String ICMS = "ICMS";
    public final static String ICMS60 = "ICMS60";
    public final static String ORIG = "orig";
    public final static String CST = "CST";
    public final static String VBCST = "vBCST";
    public final static String VICMSST = "vICMSST";
    public final static String PIS = "PIS";
    public final static String PISNT = "PISNT";
    public final static String COFINS = "COFINS";
    public final static String COFINSNT = "COFINSNT";
    public final static String TOTAL = "total";
    public final static String ICMSTOT = "ICMSTot";
    public final static String VBC = "vBC";
    public final static String VICMS = "vICMS";
    public final static String VST = "vST";
    public final static String VFRETE = "vFrete";
    public final static String VSEG = "vSeg";
    public final static String VDESC = "vDesc";
    public final static String VII = "vII";
    public final static String VIPI = "vIPI";
    public final static String VPIS = "vPIS";
    public final static String VCOFINS = "vCOFINS";
    public final static String VOUTRO = "vOutro";
    public final static String VNF = "vNF";
    public final static String TRANSP = "transp";
    public final static String MODFRETE = "modFrete";
    public final static String COBR = "cobr";
    public final static String FAT = "fat";
    public final static String NFAT = "nFat";
    public final static String VORIG = "vOrig";
    public final static String VLIC = "vLiq";
    public final static String DUP = "dup";
    public final static String NDUP = "nDup";
    public final static String DVENC = "dVenc";
    public final static String VDUP = "vDup";
    public final static String INFADIC = "infAdic";
    public final static String INFCPL = "infCpl";
    private NotaFiscalEletronicaT notafiscal = new NotaFiscalEletronicaT();

    public static void main(String[] args) throws Exception {

        File f = new File("c:/teste.xml");
        Document doc = null;
        SAXBuilder builder = new SAXBuilder();
        doc = builder.build(f);
        Element nfe = doc.getRootElement();
        XMLToTransfer xtt = new XMLToTransfer();
        Element infNfe = xtt.getInfNFe(nfe);

    }

    public void readXml(String xml) throws Exception {
        Document doc = null;
        SAXBuilder builder = new SAXBuilder();
        ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());
        doc = builder.build(bais);
        Element nfe = doc.getRootElement();
        XMLToTransfer xtt = new XMLToTransfer();
        Element infNfe = xtt.getInfNFe(nfe);
    }

    public Element getInfNFe(Element nfe) throws Exception {
        List elements = nfe.getChildren();
        try {
            for (int i = 0; i < elements.size(); i++) {
                Element tempElement = (Element) elements.get(i);
                List listInfNFe = tempElement.getChildren();

                if (INFNFE.equalsIgnoreCase(tempElement.getName())) {
                    Attribute attrId = tempElement.getAttribute("Id");
                    if (attrId != null) {
                        String id = attrId.getValue();
                        notafiscal.setId(id);
                    }
                    notafiscal.setDadosIDET(getIde(tempElement));
                    notafiscal.setDadosEmissorT(getEmit(tempElement));
                    notafiscal.setDadosDestT(getDest(tempElement));
                    notafiscal.setListaDet(getDet(tempElement));
                    notafiscal.setDadosTotalT(getTotal(tempElement));
                    notafiscal.setDadosTranspT(getTransp(tempElement));
                    notafiscal.setDadosCobrancaT(getCobr(tempElement));
                    notafiscal.setDadosInformacoesAdicionaisT(getInfAdic(tempElement));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public DadosIDET getIde(Element ide) throws Exception {
        List elements = ide.getChildren();
        try {
            for (int i = 0; i < elements.size(); i++) {
                Element tempIde = (Element) elements.get(i);
                if (IDE.equalsIgnoreCase(tempIde.getName())) {
                    DadosIDET ideT = new DadosIDET();
                    ideT.setCuf(getCuf(tempIde));
                    ideT.setCnf(getCnf(tempIde));
                    ideT.setNatop(getNatOp(tempIde));
                    ideT.setIndpag(getInfPag(tempIde));
                    ideT.setMod(getMod(tempIde));
                    ideT.setSerie(getSerie(tempIde));
                    ideT.setNnf(getNnf(tempIde));
                    ideT.setDemi(getDEmi(tempIde));
                    ideT.setDsaient(getDSaiEnt(tempIde));
                    ideT.setTpnf(getTpNF(tempIde));
                    ideT.setCmunfg(getCMunFG(tempIde));
                    ideT.setTpimp(getTpImp(tempIde));
                    ideT.setTpemis(getTpEmis(tempIde));
                    ideT.setCdv(getCdv(tempIde));
                    ideT.setTpamb(getTpAmb(tempIde));
                    ideT.setFinnfe(getFinNFE(tempIde));
                    ideT.setProcemi(getProcEmi(tempIde));
                    ideT.setVerproc(getVerProc(tempIde));

                    return ideT;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public String getCuf(Element cUF) {
        List elements = cUF.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Element tempCuf = (Element) elements.get(i);
            if (CUF.equalsIgnoreCase(tempCuf.getName())) {
                return tempCuf.getText();
            }
        }
        return null;
    }

    public String getCnf(Element cNF) {
        List elements = cNF.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempCnf = (Element) elements.get(i);
            if (CNF.equalsIgnoreCase(tempCnf.getName())) {
                return tempCnf.getText();
            }
        }
        return null;
    }

    public String getNatOp(Element natOp) {
        List elements = natOp.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempNatOp = (Element) elements.get(i);
            if (NATOP.equalsIgnoreCase(tempNatOp.getName())) {
                return tempNatOp.getText();
            }
        }
        return null;
    }

    public String getInfPag(Element infPag) {
        List elements = infPag.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempInfPag = (Element) elements.get(i);
            if (INFPAG.equalsIgnoreCase(tempInfPag.getName())) {
                return tempInfPag.getText();
            }
        }
        return null;
    }

    public String getMod(Element mod) {
        List elements = mod.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempMod = (Element) elements.get(i);
            if (MOD.equalsIgnoreCase(tempMod.getName())) {
                return tempMod.getText();
            }
        }
        return null;
    }

    public String getSerie(Element serie) {
        List elements = serie.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempSerie = (Element) elements.get(i);
            if (SERIE.equalsIgnoreCase(tempSerie.getName())) {
                return tempSerie.getText();
            }
        }
        return null;
    }

    public String getNnf(Element nNF) {
        List elements = nNF.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempNNF = (Element) elements.get(i);
            if (NNF.equalsIgnoreCase(tempNNF.getName())) {
                return tempNNF.getText();
            }
        }
        return null;
    }

    public String getDEmi(Element dEmi) {
        List elements = dEmi.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempDEmi = (Element) elements.get(i);
            if (DEMI.equalsIgnoreCase(tempDEmi.getName())) {
                return tempDEmi.getText();
            }
        }
        return null;
    }

    public String getDSaiEnt(Element DSaiEnt) {
        List elements = DSaiEnt.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempDSaiEnt = (Element) elements.get(i);
            if (DSAIENT.equalsIgnoreCase(tempDSaiEnt.getName())) {
                return tempDSaiEnt.getText();
            }
        }
        return null;
    }

    public String getTpNF(Element tpNF) {
        List elements = tpNF.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempTpNF = (Element) elements.get(i);
            if (TPNF.equalsIgnoreCase(tempTpNF.getName())) {
                return tempTpNF.getText();
            }
        }
        return null;
    }

    public String getCMunFG(Element cMunFG) {
        List elements = cMunFG.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempCMunFG = (Element) elements.get(i);
            if (CMUNFG.equalsIgnoreCase(tempCMunFG.getName())) {
                return tempCMunFG.getText();
            }
        }
        return null;
    }

    public String getTpImp(Element tpImp) {
        List elements = tpImp.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempTpImp = (Element) elements.get(i);
            if (TPIMP.equalsIgnoreCase(tempTpImp.getName())) {
                return tempTpImp.getText();
            }
        }
        return null;
    }

    public String getTpEmis(Element tpEmis) {
        List elements = tpEmis.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempTpEmis = (Element) elements.get(i);
            if (TPEMIS.equalsIgnoreCase(tempTpEmis.getName())) {
                return tempTpEmis.getText();
            }
        }
        return null;
    }

    public String getCdv(Element cDV) {
        List elements = cDV.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempCDV = (Element) elements.get(i);
            if (CDV.equalsIgnoreCase(tempCDV.getName())) {
                return tempCDV.getText();
            }
        }
        return null;
    }

    public String getTpAmb(Element tpAmb) {
        List elements = tpAmb.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempTpAmb = (Element) elements.get(i);
            if (TPAMB.equalsIgnoreCase(tempTpAmb.getName())) {
                return tempTpAmb.getText();
            }
        }
        return null;
    }

    public String getFinNFE(Element finNFE) {
        List elements = finNFE.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempFinNFE = (Element) elements.get(i);
            if (FINNFE.equalsIgnoreCase(tempFinNFE.getName())) {
                return tempFinNFE.getText();
            }
        }
        return null;
    }

    public String getProcEmi(Element procEmi) {
        List elements = procEmi.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempProcEmi = (Element) elements.get(i);
            if (PROCEMI.equalsIgnoreCase(tempProcEmi.getName())) {
                return tempProcEmi.getText();
            }
        }
        return null;
    }

    public String getVerProc(Element verProc) {
        List elements = verProc.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVerProc = (Element) elements.get(i);
            if (VERPROC.equalsIgnoreCase(tempVerProc.getName())) {
                return tempVerProc.getText();
            }
        }
        return null;
    }

    public DadosEmissorT getEmit(Element emit) throws Exception {
        List elements = emit.getChildren();
        try {
            for (int i = 0; i < elements.size(); i++) {
                Element tempEmit = (Element) elements.get(i);
                if (EMIT.equalsIgnoreCase(tempEmit.getName())) {
                    DadosEmissorT emitT = new DadosEmissorT();
                    emitT.setCnpj(getCnpj(tempEmit));
                    emitT.setXnome(getXnome(tempEmit));
                    emitT.setXfant(getXFant(tempEmit));
                    emitT.setIe(getIe(tempEmit));
                    emitT.setDadosEnderT(getEnderEmit(tempEmit));
                    return emitT;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public DadosDestT getDest(Element dest) throws Exception {
        List elements = dest.getChildren();
        try {
            for (int i = 0; i < elements.size(); i++) {
                Element tempDest = (Element) elements.get(i);
                if (DEST.equalsIgnoreCase(tempDest.getName())) {
                    DadosDestT destT = new DadosDestT();
                    destT.setCnpj(getCnpj(tempDest));
                    destT.setXnome(getXnome(tempDest));
                    destT.setIe(getIe(tempDest));
                    destT.setDadosEnderT(getEnderDest(tempDest));

                    return null;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getCnpj(Element Cnpj) {
        List elements = Cnpj.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempCNPJ = (Element) elements.get(i);
            if (CNPJ.equalsIgnoreCase(tempCNPJ.getName())) {
                return tempCNPJ.getText();
            }

        }
        return null;
    }

    public String getXnome(Element xNome) {
        List elements = xNome.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempXNome = (Element) elements.get(i);
            if (XNOME.equalsIgnoreCase(tempXNome.getName())) {
                return tempXNome.getText();
            }

        }
        return null;
    }

    public String getXFant(Element xFant) {
        List elements = xFant.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempXFant = (Element) elements.get(i);
            if (XFANT.equalsIgnoreCase(tempXFant.getName())) {
                return tempXFant.getText();
            }

        }
        return null;
    }

    public DadosEnderT getEnderEmit(Element enderEmit) {
        List elements = enderEmit.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Element tempEnderEmit = (Element) elements.get(i);
            if (ENDEREMIT.equalsIgnoreCase(tempEnderEmit.getName())) {
                DadosEnderT enderEmitT = new DadosEnderT();
                enderEmitT.setXlgr(getXLgr(tempEnderEmit));
                enderEmitT.setNro(getNro(tempEnderEmit));
                enderEmitT.setXbairro(getXBairro(tempEnderEmit));
                enderEmitT.setCmun(getCMun(tempEnderEmit));
                enderEmitT.setXmun(getXMun(tempEnderEmit));
                enderEmitT.setUf(getUF(tempEnderEmit));
                enderEmitT.setCep(getCep(tempEnderEmit));
                enderEmitT.setCpais(getCPais(tempEnderEmit));
                enderEmitT.setXpais(getXPais(tempEnderEmit));

                return enderEmitT;
            }

        }
        return null;
    }

    public DadosEnderT getEnderDest(Element ender) {
        List elements = ender.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Element tempEnderDest = (Element) elements.get(i);
            if (ENDERDEST.equalsIgnoreCase(tempEnderDest.getName())) {
                DadosEnderT enderDestT = new DadosEnderT();
                enderDestT.setXlgr(getXLgr(tempEnderDest));
                enderDestT.setNro(getNro(tempEnderDest));
                enderDestT.setXbairro(getXBairro(tempEnderDest));
                enderDestT.setCmun(getCMun(tempEnderDest));
                enderDestT.setXmun(getXMun(tempEnderDest));
                enderDestT.setUf(getUF(tempEnderDest));
                enderDestT.setCep(getCep(tempEnderDest));
                enderDestT.setCpais(getCPais(tempEnderDest));
                enderDestT.setXpais(getXPais(tempEnderDest));
                return enderDestT;
            }

        }
        return null;
    }

    public String getXLgr(Element xLgr) {
        List elements = xLgr.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempXLgr = (Element) elements.get(i);
            if (XLGR.equalsIgnoreCase(tempXLgr.getName())) {
                return tempXLgr.getText();
            }

        }
        return null;
    }

    public String getNro(Element nro) {
        List elements = nro.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempNro = (Element) elements.get(i);
            if (NRO.equalsIgnoreCase(tempNro.getName())) {
                return tempNro.getText();
            }

        }
        return null;
    }

    public String getXBairro(Element xBairro) {
        List elements = xBairro.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempXBairro = (Element) elements.get(i);
            if (XBAIRRO.equalsIgnoreCase(tempXBairro.getName())) {
                return tempXBairro.getText();
            }

        }
        return null;
    }

    public String getCMun(Element cMun) {
        List elements = cMun.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempCMun = (Element) elements.get(i);
            if (CMUN.equalsIgnoreCase(tempCMun.getName())) {
                return tempCMun.getText();
            }

        }
        return null;
    }

    public String getXMun(Element cMun) {
        List elements = cMun.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempCMun = (Element) elements.get(i);
            if (CMUN.equalsIgnoreCase(tempCMun.getName())) {
                return tempCMun.getText();
            }

        }
        return null;
    }

    public String getUF(Element uf) {
        List elements = uf.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempUf = (Element) elements.get(i);
            if (UF.equalsIgnoreCase(tempUf.getName())) {
                return tempUf.getText();
            }
        }
        return null;
    }

    public String getCep(Element cep) {
        List elements = cep.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempCep = (Element) elements.get(i);
            if (CEP.equalsIgnoreCase(tempCep.getName())) {
                return tempCep.getText();
            }
        }
        return null;
    }

    public String getCPais(Element cPais) {
        List elements = cPais.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempCPais = (Element) elements.get(i);
            if (CPAIS.equalsIgnoreCase(tempCPais.getName())) {
                return tempCPais.getText();
            }
        }
        return null;
    }

    public String getXPais(Element xPais) {
        List elements = xPais.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempXPais = (Element) elements.get(i);
            if (XPAIS.equalsIgnoreCase(tempXPais.getName())) {
                return tempXPais.getText();
            }
        }
        return null;
    }

    public String getIe(Element ie) {
        List elements = ie.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempIe = (Element) elements.get(i);
            if (IE.equalsIgnoreCase(tempIe.getName())) {
                return tempIe.getText();
            }
        }
        return null;
    }

    public List<DadosDetT> getDet(Element det) throws Exception {
        List<DadosDetT> listDet = new ArrayList<DadosDetT>();
        List elements = det.getChildren();
        try {
            for (int i = 0; i < elements.size(); i++) {
                Object object = elements.get(i);
                Element tempDet = (Element) elements.get(i);
                if (DET.equalsIgnoreCase(tempDet.getName())) {
                    DadosDetT ddT = new DadosDetT();
                    ddT.setDadosProdT(getProd(tempDet));
                    ddT.setDadosImpostoT(getImposto(tempDet));

                    listDet.add(ddT);
                }
            }
        } catch (Exception e) {
        }

        return listDet;
    }

    public DadosProdT getProd(Element prod) throws Exception {
        List elements = prod.getChildren();
        try {
            for (int i = 0; i < elements.size(); i++) {
                Object object = elements.get(i);
                Element tempProd = (Element) elements.get(i);
                if (PROD.equalsIgnoreCase(tempProd.getName())) {
                    DadosProdT prodT = new DadosProdT();
                    prodT.setCprod(getCProd(tempProd));
                    prodT.setCean(getCEan(tempProd));
                    prodT.setXprod(getXProd(tempProd));
                    prodT.setCfop(getCfop(tempProd));
                    prodT.setUcom(getUCom(tempProd));
                    prodT.setQcom(getQCom(tempProd));
                    prodT.setVuncom(getVUnCom(tempProd));
                    prodT.setVprod(getVProd(tempProd));
                    prodT.setCeantrib(getCEanTrib(tempProd));
                    prodT.setUtrib(getUTrib(tempProd));
                    prodT.setQtrib(getQTrib(tempProd));
                    prodT.setVuntrib(getVUnTrib(tempProd));
                    prodT.setDadosMedT(getMed(tempProd));
                    return prodT;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getCProd(Element cProd) {
        List elements = cProd.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempCProd = (Element) elements.get(i);
            if (CPROD.equalsIgnoreCase(tempCProd.getName())) {
                return tempCProd.getText();
            }
        }
        return null;
    }

    public String getCEan(Element cEan) {
        List elements = cEan.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempCEan = (Element) elements.get(i);
            if (CEAN.equalsIgnoreCase(tempCEan.getName())) {
                return tempCEan.getText();
            }
        }
        return null;
    }

    public String getXProd(Element xProd) {
        List elements = xProd.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempXProd = (Element) elements.get(i);
            if (XPROD.equalsIgnoreCase(tempXProd.getName())) {
                return tempXProd.getText();
            }
        }
        return null;
    }

    public String getCfop(Element cfop) {
        List elements = cfop.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempCfop = (Element) elements.get(i);
            if (CFOP.equalsIgnoreCase(tempCfop.getName())) {
                return tempCfop.getText();
            }
        }
        return null;
    }

    public String getUCom(Element uCom) {
        List elements = uCom.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempUCom = (Element) elements.get(i);
            if (UCOM.equalsIgnoreCase(tempUCom.getName())) {
                return tempUCom.getText();
            }
        }
        return null;
    }

    public String getQCom(Element qCom) {
        List elements = qCom.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempQCom = (Element) elements.get(i);
            if (QCOM.equalsIgnoreCase(tempQCom.getName())) {
                return tempQCom.getText();
            }
        }
        return null;
    }

    public String getVUnCom(Element vUnCom) {
        List elements = vUnCom.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element temVUnCom = (Element) elements.get(i);
            if (VUNCOM.equalsIgnoreCase(temVUnCom.getName())) {
                return temVUnCom.getText();
            }
        }
        return null;
    }

    public String getVProd(Element vProd) {
        List elements = vProd.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVProd = (Element) elements.get(i);
            if (VPROD.equalsIgnoreCase(tempVProd.getName())) {
                return tempVProd.getText();
            }
        }
        return null;
    }

    public String getCEanTrib(Element cEANTrib) {
        List elements = cEANTrib.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempCEANTrib = (Element) elements.get(i);
            if (CEANTRIB.equalsIgnoreCase(tempCEANTrib.getName())) {
                return tempCEANTrib.getText();
            }
        }
        return null;
    }

    public String getUTrib(Element uTrib) {
        List elements = uTrib.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempUTrip = (Element) elements.get(i);
            if (UTRIB.equalsIgnoreCase(tempUTrip.getName())) {
                return tempUTrip.getText();
            }
        }
        return null;
    }

    public String getQTrib(Element qTrib) {
        List elements = qTrib.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempQTrip = (Element) elements.get(i);
            if (UTRIB.equalsIgnoreCase(tempQTrip.getName())) {
                return tempQTrip.getText();
            }
        }
        return null;
    }

    public String getVUnTrib(Element vUnTrib) {
        List elements = vUnTrib.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVUnTrip = (Element) elements.get(i);
            if (VUNTRIB.equalsIgnoreCase(tempVUnTrip.getName())) {
                return tempVUnTrip.getText();
            }
        }
        return null;
    }

    public DadosMedT getMed(Element med) throws Exception {
        List elements = med.getChildren();
        try {
            for (int i = 0; i < elements.size(); i++) {
                Object object = elements.get(i);
                Element tempMed = (Element) elements.get(i);
                if (UCOM.equalsIgnoreCase(tempMed.getName())) {
                    DadosMedT medT = new DadosMedT();
                    medT.setNlote(getNLote(tempMed));
                    medT.setQlote(getQLote(tempMed));
                    medT.setDfab(getDFab(tempMed));
                    medT.setDval(getDVal(tempMed));
                    medT.setVpmc(getVPmc(tempMed));
                    return medT;
                }
            }
        } catch (Exception e) {
        }


        return null;
    }

    public String getNLote(Element nLote) {
        List elements = nLote.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempUTrip = (Element) elements.get(i);
            if (NLOTE.equalsIgnoreCase(tempUTrip.getName())) {
                return tempUTrip.getText();
            }
        }
        return null;
    }

    public String getQLote(Element qLote) {
        List elements = qLote.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempQLote = (Element) elements.get(i);
            if (QLOTE.equalsIgnoreCase(tempQLote.getName())) {
                return tempQLote.getText();
            }
        }
        return null;
    }

    public String getDFab(Element dFab) {
        List elements = dFab.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempDFab = (Element) elements.get(i);
            if (DFAB.equalsIgnoreCase(tempDFab.getName())) {
                return tempDFab.getText();
            }
        }
        return null;
    }

    public String getDVal(Element dVal) {
        List elements = dVal.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempDVal = (Element) elements.get(i);
            if (DVAL.equalsIgnoreCase(tempDVal.getName())) {
                return tempDVal.getText();
            }
        }
        return null;
    }

    public String getVPmc(Element vPMC) {
        List elements = vPMC.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVPmc = (Element) elements.get(i);
            if (VPMC.equalsIgnoreCase(tempVPmc.getName())) {
                return tempVPmc.getText();
            }
        }
        return null;
    }

    public DadosImpostoT getImposto(Element imposto) throws Exception {
        List elements = imposto.getChildren();
        try {
            for (int i = 0; i < elements.size(); i++) {
                Object object = elements.get(i);
                Element tempImposto = (Element) elements.get(i);
                if (IMPOSTO.equalsIgnoreCase(tempImposto.getName())) {
                    DadosImpostoT diT = new DadosImpostoT();
                    diT.setDadosICMST(getIcms(tempImposto));
                    diT.setDadosPisT(getPis(tempImposto));
                    diT.setDadosConfinsT(getCofins(tempImposto));

                    return diT;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public DadosICMST getIcms(Element icms) throws Exception {
        List elements = icms.getChildren();
        try {
            for (int i = 0; i < elements.size(); i++) {
                Object object = elements.get(i);
                Element tempIcms = (Element) elements.get(i);
                if (ICMS.equalsIgnoreCase(tempIcms.getName())) {
                    DadosICMST dicmsT = new DadosICMST();
                    dicmsT.setDadosIcms60T(getIcms60(tempIcms));

                    return dicmsT;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public DadosICMS60T getIcms60(Element icms60) throws Exception {
        List elements = icms60.getChildren();
        try {
            for (int i = 0; i < elements.size(); i++) {
                Object object = elements.get(i);
                Element tempIcms60 = (Element) elements.get(i);
                if (ICMS60.equalsIgnoreCase(tempIcms60.getName())) {
                    DadosICMS60T dicms60T = new DadosICMS60T();
                    dicms60T.setOrig(getOrig(tempIcms60));
                    dicms60T.setCst(getCst(tempIcms60));
                    dicms60T.setVbcst(getVBcst(tempIcms60));
                    dicms60T.setVicmsst(getVIcmsSt(tempIcms60));
                    return dicms60T;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getOrig(Element orig) {
        List elements = orig.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempOrig = (Element) elements.get(i);
            if (ORIG.equalsIgnoreCase(tempOrig.getName())) {
                return tempOrig.getText();
            }
        }
        return null;
    }

    public String getCst(Element cst) {
        List elements = cst.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempCst = (Element) elements.get(i);
            if (CST.equalsIgnoreCase(tempCst.getName())) {
                return tempCst.getText();
            }
        }
        return null;
    }

    public String getVBcst(Element vBcst) {
        List elements = vBcst.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVBcst = (Element) elements.get(i);
            if (VBCST.equalsIgnoreCase(tempVBcst.getName())) {
                return tempVBcst.getText();
            }
        }
        return null;
    }

    public String getVIcmsSt(Element vIcmsST) {
        List elements = vIcmsST.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVIcmsSt = (Element) elements.get(i);
            if (VICMSST.equalsIgnoreCase(tempVIcmsSt.getName())) {
                return tempVIcmsSt.getText();
            }
        }
        return null;
    }

    public DadosPisT getPis(Element pis) throws Exception {
        List elements = pis.getChildren();
        try {
            for (int i = 0; i < elements.size(); i++) {
                Object object = elements.get(i);
                Element tempPis = (Element) elements.get(i);
                if (PIS.equalsIgnoreCase(tempPis.getName())) {
                    DadosPisT dpisT = new DadosPisT();
                    dpisT.setDadosPisntT(getPisnt(tempPis));
                    return dpisT;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public DadosPisntT getPisnt(Element pisnt) throws Exception {
        List elements = pisnt.getChildren();
        try {
            for (int i = 0; i < elements.size(); i++) {
                Object object = elements.get(i);
                Element tempPisNt = (Element) elements.get(i);
                if (PISNT.equalsIgnoreCase(tempPisNt.getName())) {
                    DadosPisntT dpntT = new DadosPisntT();
                    dpntT.setCst(getCst(tempPisNt));
                    return dpntT;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public DadosConfinsT getCofins(Element cofins) throws Exception {
        List elements = cofins.getChildren();
        try {
            for (int i = 0; i < elements.size(); i++) {
                Object object = elements.get(i);
                Element tempCofins = (Element) elements.get(i);
                if (COFINS.equalsIgnoreCase(tempCofins.getName())) {
                    DadosConfinsT dcoT = new DadosConfinsT();
                    dcoT.setCst(getCst(tempCofins));
                    return dcoT;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public DadosConfinsntT getCofinsnt(Element cofinsnt) throws Exception {
        List elements = cofinsnt.getChildren();
        try {
            for (int i = 0; i < elements.size(); i++) {
                Object object = elements.get(i);
                Element tempCofinsnt = (Element) elements.get(i);
                if (COFINSNT.equalsIgnoreCase(tempCofinsnt.getName())) {
                    DadosConfinsntT dcntT = new DadosConfinsntT();
                    dcntT.setCst(getCst(tempCofinsnt));

                    return dcntT;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public DadosTotalT getTotal(Element total) {
        List elements = total.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempTotal = (Element) elements.get(i);
            if (TOTAL.equalsIgnoreCase(tempTotal.getName())) {
                DadosTotalT dtT = new DadosTotalT();
                dtT.setVbc(getVBc(tempTotal));
                dtT.setDadosIcmsTotT(getIcmsTot(tempTotal));
                return dtT;
            }
        }
        return null;
    }

    public DadosICMSTotT getIcmsTot(Element icmsTot) {
        List elements = icmsTot.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempIcmsTot = (Element) elements.get(i);
            if (VBC.equalsIgnoreCase(tempIcmsTot.getName())) {
                DadosICMSTotT itT = new DadosICMSTotT();
                itT.setVbc(getVBc(tempIcmsTot));
                itT.setVicms(getVIcms(tempIcmsTot));
                itT.setVbcst(getVBcst(tempIcmsTot));
                itT.setVst(getVSt(tempIcmsTot));
                itT.setVprod(getVProd(tempIcmsTot));
                itT.setVfrete(getVFrete(tempIcmsTot));
                itT.setVseg(getVSeg(tempIcmsTot));
                itT.setVdesc(getVDesc(tempIcmsTot));
                itT.setVii(getVIi(tempIcmsTot));
                itT.setVipi(getVIpi(tempIcmsTot));
                itT.setVpis(getVPis(tempIcmsTot));
                itT.setVcofins(getVCofins(tempIcmsTot));
                itT.setVoutro(getVOutro(tempIcmsTot));
                itT.setVnf(getVNf(tempIcmsTot));
                return itT;
            }
        }
        return null;
    }

    public String getVBc(Element vBc) {
        List elements = vBc.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVBc = (Element) elements.get(i);
            if (VBC.equalsIgnoreCase(tempVBc.getName())) {
                return tempVBc.getText();
            }
        }
        return null;
    }

    public String getVIcms(Element vIcms) {
        List elements = vIcms.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVIcms = (Element) elements.get(i);
            if (VICMS.equalsIgnoreCase(tempVIcms.getName())) {
                return tempVIcms.getText();
            }
        }
        return null;
    }

    public String getVSt(Element vSt) {
        List elements = vSt.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVSt = (Element) elements.get(i);
            if (VST.equalsIgnoreCase(tempVSt.getName())) {
                return tempVSt.getText();
            }
        }
        return null;
    }

    public String getVFrete(Element vFrete) {
        List elements = vFrete.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVFrete = (Element) elements.get(i);
            if (VFRETE.equalsIgnoreCase(tempVFrete.getName())) {
                return tempVFrete.getText();
            }
        }
        return null;
    }

    public String getVSeg(Element vSeg) {
        List elements = vSeg.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVSeg = (Element) elements.get(i);
            if (VSEG.equalsIgnoreCase(tempVSeg.getName())) {
                return tempVSeg.getText();
            }
        }
        return null;
    }

    public String getVDesc(Element vDesc) {
        List elements = vDesc.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVDesc = (Element) elements.get(i);
            if (VDESC.equalsIgnoreCase(tempVDesc.getName())) {
                return tempVDesc.getText();
            }
        }
        return null;
    }

    public String getVIi(Element vIi) {
        List elements = vIi.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVIi = (Element) elements.get(i);
            if (VII.equalsIgnoreCase(tempVIi.getName())) {
                return tempVIi.getText();
            }
        }
        return null;
    }

    public String getVIpi(Element vIpi) {
        List elements = vIpi.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVIpi = (Element) elements.get(i);
            if (VIPI.equalsIgnoreCase(tempVIpi.getName())) {
                return tempVIpi.getText();
            }
        }
        return null;
    }

    public String getVPis(Element vPis) {
        List elements = vPis.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVPis = (Element) elements.get(i);
            if (VPIS.equalsIgnoreCase(tempVPis.getName())) {
                return tempVPis.getText();
            }
        }
        return null;
    }

    public String getVCofins(Element vCofins) {
        List elements = vCofins.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVCofins = (Element) elements.get(i);
            if (VCOFINS.equalsIgnoreCase(tempVCofins.getName())) {
                return tempVCofins.getText();
            }
        }
        return null;
    }

    public String getVOutro(Element vOutro) {
        List elements = vOutro.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVOutro = (Element) elements.get(i);
            if (VOUTRO.equalsIgnoreCase(tempVOutro.getName())) {
                return tempVOutro.getText();
            }
        }
        return null;
    }

    public String getVNf(Element vNf) {
        List elements = vNf.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVNf = (Element) elements.get(i);
            if (VNF.equalsIgnoreCase(tempVNf.getName())) {
                return tempVNf.getText();
            }
        }
        return null;
    }

    public DadosTranspT getTransp(Element transp) {
        List elements = transp.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempTransp = (Element) elements.get(i);
            if (TRANSP.equalsIgnoreCase(tempTransp.getName())) {
                DadosTranspT dtransT = new DadosTranspT();
                dtransT.setModfrete(getModFrete(tempTransp));
                return dtransT;
            }
        }
        return null;
    }

    public String getModFrete(Element modFrete) {
        List elements = modFrete.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempModFrete = (Element) elements.get(i);
            if (MODFRETE.equalsIgnoreCase(tempModFrete.getName())) {
                return tempModFrete.getText();
            }
        }
        return null;
    }

    public DadosCobrancaT getCobr(Element cobr) {
        List elements = cobr.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempCobr = (Element) elements.get(i);
            if (COBR.equalsIgnoreCase(tempCobr.getName())) {
                DadosCobrancaT dcT = new DadosCobrancaT();
                dcT.setDadosFatT(getFat(tempCobr));
                dcT.setDadosDupT(getDup(tempCobr));
                return dcT;
            }
        }
        return null;
    }

    public DadosFatT getFat(Element fat) {
        List elements = fat.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempFat = (Element) elements.get(i);
            if (FAT.equalsIgnoreCase(tempFat.getName())) {
                DadosFatT dfT = new DadosFatT();
                dfT.setNfat(getNFat(tempFat));
                dfT.setVliq(getVLic(tempFat));
                dfT.setVorig(getVOrig(tempFat));
                return dfT;
            }
        }
        return null;
    }

    public String getNFat(Element nFat) {
        List elements = nFat.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempNFat = (Element) elements.get(i);
            if (NFAT.equalsIgnoreCase(tempNFat.getName())) {
                return tempNFat.getText();
            }
        }
        return null;
    }

    public String getVOrig(Element vOrig) {
        List elements = vOrig.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVOrig = (Element) elements.get(i);
            if (VORIG.equalsIgnoreCase(tempVOrig.getName())) {
                return tempVOrig.getText();
            }
        }
        return null;
    }

    public String getVLic(Element vLic) {
        List elements = vLic.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVLic = (Element) elements.get(i);
            if (VLIC.equalsIgnoreCase(tempVLic.getName())) {
                return tempVLic.getText();
            }
        }
        return null;
    }

    public DadosDupT getDup(Element dup) {
        List elements = dup.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempDup = (Element) elements.get(i);
            if (DUP.equalsIgnoreCase(tempDup.getName())) {
                DadosDupT ddT = new DadosDupT();
                ddT.setDvenc(getDVenc(tempDup));
                ddT.setNdup(getNDup(tempDup));
                ddT.setVdup(getVDup(tempDup));
                return ddT;
            }
        }
        return null;
    }

    public String getNDup(Element nDup) {
        List elements = nDup.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempNDup = (Element) elements.get(i);
            if (NDUP.equalsIgnoreCase(tempNDup.getName())) {
                return tempNDup.getText();
            }
        }
        return null;
    }

    public String getDVenc(Element dVenc) {
        List elements = dVenc.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempDVenc = (Element) elements.get(i);
            if (DVENC.equalsIgnoreCase(tempDVenc.getName())) {
                return tempDVenc.getText();
            }
        }
        return null;
    }

    public String getVDup(Element vDup) {
        List elements = vDup.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempVDup = (Element) elements.get(i);
            if (VDUP.equalsIgnoreCase(tempVDup.getName())) {
                return tempVDup.getText();
            }
        }
        return null;
    }

    public DadosInformacoesAdicionaisT getInfAdic(Element infAdic) {
        List elements = infAdic.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempInfAdic = (Element) elements.get(i);
            if (INFADIC.equalsIgnoreCase(tempInfAdic.getName())) {
                DadosInformacoesAdicionaisT diaT = new DadosInformacoesAdicionaisT();
                diaT.setInfcpl(getInfCpl(tempInfAdic));
                
                return diaT;
            }
        }
        return null;
    }

    public String getInfCpl(Element infCpl) {
        List elements = infCpl.getChildren();
        for (int i = 0; i < elements.size(); i++) {
            Object object = elements.get(i);
            Element tempInfCpl = (Element) elements.get(i);
            if (INFCPL.equalsIgnoreCase(tempInfCpl.getName())) {
                return tempInfCpl.getText();
            }
        }
        return null;
    }
}
