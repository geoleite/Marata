/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.marata.jb;


import br.com.i9.marata.notatransfer.*;
import br.com.i9.marata.transfer.Gj_gnfe_nota_fiscalT;
import java.awt.TextField;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.Formatter;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
/**
 *
 * @author geoleite
 */
public class RelatorioNFEJB extends SystemBase {

    private String numeroNF;
    private String codigoproduto;
    private Gj_gnfe_nota_fiscalT not_notaT = new Gj_gnfe_nota_fiscalT();
    private DadosNFET dadosNFET = new DadosNFET();
    private DadosIDET dadosIDET = new DadosIDET();
    private DadosEmissorT dadosEmissorT = new DadosEmissorT();
    private DadosDestT dadosDestT = new DadosDestT();
    //private DadosDetT dadosDetT;
    //private DadosICMST dadosICMST;
    //private DadosPisT dadosPisT;
    //private DadosConfinsT dadosConfinsT;
    private DadosTotalT dadosTotalT = new DadosTotalT();
    private DadosTranspT dadosTranspT = new DadosTranspT();
    private DadosCobrancaT dadosCobrancaT = new DadosCobrancaT();
    private DadosInformacoesAdicionaisT dadosInformacoesAdicionaisT = new DadosInformacoesAdicionaisT();
    private DadosAssinaturaT dadosAssinaturaT = new DadosAssinaturaT();
    private List<String> abas;
    private String abaSelecionada = "NF-e";
    private boolean achou = false;
    private NotaFiscalEletronicaT notaFiscalEletronicaT = new NotaFiscalEletronicaT();

    public void pageLoad() throws Exception {
        super.pageLoad();
        defineAbas();
    }

    public void consult() {
        try {
            String chaveAcesso = getNot_notaT().getNfe_id();
            if (chaveAcesso == null || chaveAcesso.trim().length() == 0) {
                setMsg("Chave de Acesso nao informada!");
                return;
            }
            //if (chaveAcesso.indexOf("NFe") == -1) {
            //    getNot_notaT().setNfe_id("NFe" + getNot_notaT().getNfe_id());
            //}
            List<Gj_gnfe_nota_fiscalT> list = getGj_gnfe_nota_fiscalDAO().getByNfe(getNot_notaT());
            if (list.size() > 0) {
                achou = true;
                setNot_notaT(list.get(0));

                notaFiscalEletronicaT.setDadosNFET(getDadosNFET());
                notaFiscalEletronicaT.setDadosIDET(getDadosIDET());
                notaFiscalEletronicaT.setDadosEmissorT(getDadosEmissorT());
                notaFiscalEletronicaT.setDadosDestT(dadosDestT);
                notaFiscalEletronicaT.setDadosTotalT(dadosTotalT);
                notaFiscalEletronicaT.setDadosTranspT(dadosTranspT);
                notaFiscalEletronicaT.setDadosCobrancaT(dadosCobrancaT);
                notaFiscalEletronicaT.setDadosAssinaturaT(dadosAssinaturaT);
                notaFiscalEletronicaT.setDadosInformacoesAdicionaisT(dadosInformacoesAdicionaisT); 

                dadosCobrancaT.setNumero(getNot_notaT().getId_ent());
                numeroNF = getNot_notaT().getId_ent();
                //notaFiscalEletronicaT.etDadosDetT(dadosDetT)
                Gj_gnfe_nota_fiscalT notaXml = getGj_gnfe_nota_fiscalDAO().getByXml_sig_mailNfeId(not_notaT);
                System.out.println(notaXml.getXml_sig_mail().length);
                getNot_notaT().setXml_sig_mail(notaXml.getXml_sig_mail());
                prepareNotaXML();

            // Definindo os valores da cobranca
            } else {
                setMsg("Nota fiscal nao existe!");
            }
        } catch (Exception ex) {
            Logger.getLogger(RelatorioNFEJB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void defineAbas() {
        setAbas(new Vector<String>());
        getAbas().add("NF-e");
        getAbas().add("Emitente");
        getAbas().add("Destinatario");
        getAbas().add("Produtos-Servicos");
        getAbas().add("Totais");
        getAbas().add("Transporte");
        getAbas().add("Cobranca");
        getAbas().add("InfAdicionais");

    }

    /**
     * Ler os dados da nota
     */
    private void prepareNotaXML() throws Exception {
        readXML(getNot_notaT().getXml_sig_mail());
    }

    private void readXML(byte[] arq) throws Exception {
        SAXBuilder builder = new SAXBuilder();
        System.out.println("arq " + new String(arq));
        StringBuffer txtXml = new StringBuffer();
        ByteArrayInputStream bais = new ByteArrayInputStream(arq);
        //CharSet
        BufferedReader br = new BufferedReader(new InputStreamReader(bais, "ISO-8859-1"));
        while (br.ready()) {
            txtXml.append(br.readLine());
        }
        String strXml = txtXml.toString();
        strXml = strXml.replaceAll("UTF-8", "ISO-8859-1");
        StringReader sw = new StringReader(strXml);
        Document doc = builder.build(sw);
        readDocument(doc);
    }

    /**
     * LER O documento xml
     * @param doc
     * @throws java.lang.Exception
     */
    private void readDocument(Document doc) throws Exception {
        List list = doc.getContent();
        if ("NFe".equals(doc.getRootElement().getName())) {
            readNFE(doc.getRootElement());
        } else {
            for (Object object : list) {
                //ContentList cl = (ContentList) object
                Element elemento = (Element) object;
                List<Element> list2 = elemento.getChildren();
                for (Element element : list2) {
                    if ("NFe".equals(element.getName())) {
                        //System.out.println(element.getName());

                        readNFE(element);
                    }
                }
            }
        }
    }

    public void readNFE(Element element) throws Exception {
        List<Element> list = element.getChildren();
        for (Element element1 : list) {
            if ("infNFe".equals(element1.getName())) {
                String id = element1.getAttributeValue("id");
                String versao = element1.getAttributeValue("versao");
                getDadosNFET().setId(id);
                getDadosNFET().setVersao(versao);
                readInfNFe(element1);
            } else if ("Signature".equals(element1.getName())) {
                readSignature(element1);
            }
        }
    }

    public void readSignature(Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            if ("SignedInfo".equals(element1.getName())) {
                readSignature(element1);
            } else if ("Reference".equals(element1.getName())) {
                List<Element> listE2 = element1.getChildren();
                for (Element element12 : listE2) {
                    if ("DigestValue".equals(element12.getName())) {
                        String valor = element12.getValue();
                        dadosAssinaturaT.setDigestvalue(valor);
                    }
                }
            }
        }

    }

    public void readInfNFe(Element element) throws Exception {
        List<Element> listE = element.getChildren();
        //List<DadosDetT> listDet = notaFiscalEletronicaT.getListaDet();
        for (Element element1 : listE) {
            if ("ide".equalsIgnoreCase(element1.getName())) {
                readIde(element1);
            } else if ("emit".equalsIgnoreCase(element1.getName())) {
                readEmit(element1);
            } else if ("dest".equalsIgnoreCase(element1.getName())) {
                readDest(element1);
            } else if ("det".equalsIgnoreCase(element1.getName())) {
                readDet(element1);
            } else if ("total".equalsIgnoreCase(element1.getName())) {
                readTotal(element1);
            } else if ("transp".equalsIgnoreCase(element1.getName())) {
                readTransp(element1);
            } else if ("cobr".equalsIgnoreCase(element1.getName())) {
                readCobranca(element1);
            } else if ("infAdic".equalsIgnoreCase(element1.getName())) {
                readInfAdic(element1);
            }
        }
    }

    public void readInfAdic(Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            String tag = element1.getName();
            String valor = element1.getValue();
            setReflexao(dadosInformacoesAdicionaisT, tag, valor);
        }
    }

    public void readFat(Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            String tag = element1.getName();
            String valor = element1.getValue();
            setReflexao(dadosCobrancaT, tag, valor);
        }
    }
    public void readDup(Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            String tag = element1.getName();
            String valor = element1.getValue();
            setReflexao(dadosCobrancaT, tag, valor);
        }
    }

    public void readCobranca(Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            String tag = element1.getName();
            if ("fat".equals(tag))
                readFat(element1);
            if ("dup".equals(tag))
                readDup(element1);
        }
    }
    public void readTransp(Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            String tag = element1.getName();
            String valor = element1.getValue();
            setReflexao(dadosTranspT, tag, valor);
        }
    }

    public void readTotal(Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            String tag = element1.getName();
            if ("ICMSTot".equals(tag)) {
                readICMSTot(element1);
            }
        }
    }

    public void readDet(Element element) throws Exception {
        List<Element> listE = element.getChildren();
        String nItem = element.getAttributeValue("nItem");
        DadosDetT dadosDetT = new DadosDetT();
        dadosDetT.setNumero(nItem);
        notaFiscalEletronicaT.getListaDet().add(dadosDetT);
        for (Element element1 : listE) {
            String tag = element1.getName();
            if ("prod".equals(tag)) {
                readProd(dadosDetT, element1);
            } else if ("imposto".equals(tag)) {
                DadosImpostoT dadosImpostoT = new DadosImpostoT();
                dadosDetT.setDadosImpostoT(dadosImpostoT);
                readImposto(dadosImpostoT, element1);
            }
        }
    }

    public void readImposto(DadosImpostoT dadosImpostoT, Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            String tag = element1.getName();
            if ("ICMS".equals(tag)) {
                List<Element> listE2 = element1.getChildren();
                DadosICMST dadosICMST = new DadosICMST();
                for (Element element2 : listE2) {
                    dadosImpostoT.setDadosICMST(dadosICMST);
                    readICMS(dadosICMST, element2);
                }
            } else if ("PIS".equals(tag)) {
                List<Element> listE2 = element1.getChildren();
                DadosPisT dadosPisT = new DadosPisT();
                for (Element element2 : listE2) {
                    dadosImpostoT.setDadosPisT(dadosPisT);
                    readPis(dadosPisT, element2);
                }
            } else if ("COFINS".equals(tag)) {
                List<Element> listE2 = element1.getChildren();
                DadosConfinsT dadosConfinsT = new DadosConfinsT();
                for (Element element2 : listE2) {
                    dadosImpostoT.setDadosConfinsT(dadosConfinsT);
                    readConfins(dadosConfinsT, element2);
                }
            }
        }
    }

    public void readICMSTot(Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            String tag = element1.getName();
            String valor = element1.getValue();
            setReflexao(dadosTotalT, tag, valor);
        }
    }

    public void readICMS(DadosICMST dadosICMST, Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            String tag = element1.getName();
            String valor = element1.getValue();
            setReflexao(dadosICMST, tag, valor);
        }
    }

    public void readPis(DadosPisT dadosPisT, Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            String tag = element1.getName();
            String valor = element1.getValue();
            setReflexao(dadosPisT, tag, valor);
        }
    }

    public void readConfins(DadosConfinsT dadosConfinsT, Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            String tag = element1.getName();
            String valor = element1.getValue();
            setReflexao(dadosConfinsT, tag, valor);
        }
    }

    public void readProd(DadosDetT dadosDetT, Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            String tag = element1.getName();
            if ("med".equals(tag)) {
                readMed(dadosDetT, element1);
            } else {
                String valor = element1.getValue();
                setReflexao(dadosDetT, tag, valor);
            }
        }
    }

    public void readMed(DadosDetT dadosDetT, Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            String tag = element1.getName();
            String valor = element1.getValue();
            setReflexao(dadosDetT, tag, valor);
        }
    }

    public void readIde(Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            String tag = element1.getName();
            String valor = element1.getValue();
            setReflexao(getDadosIDET(), tag, valor);
        }
    }

    public void readEmit(Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            String tag = element1.getName();
            if ("enderEmit".equals(tag)) {
                readEnderEmit(element1);
            } else {
                String valor = element1.getValue();
                setReflexao(getDadosEmissorT(), tag, valor);
            }
        }
    }

    public void readDest(Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            String tag = element1.getName();
            if ("enderDest".equals(tag)) {
                readEnderDest(element1);
            } else {
                String valor = element1.getValue();
                setReflexao(getDadosDestT(), tag, valor);
            }
        }
    }

    public void readEnderEmit(Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            String tag = element1.getName();
            String valor = element1.getValue();
            setReflexao(getDadosEmissorT(), tag, valor);
        }
    }

    public void readEnderDest(Element element) throws Exception {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            String tag = element1.getName();
            String valor = element1.getValue();
            setReflexao(getDadosDestT(), tag, valor);
        }
    }

    /**
     * Atribui automaticamente os valores aos metodos sempre no formato String
     * @param obj
     * @param metodo
     * @param valor
     */
    private void setReflexao(Object obj, String metodo, String valor) throws Exception {
            String nomeMetodo = (metodo.toCharArray()[0] + "").toUpperCase();
            nomeMetodo += metodo.toLowerCase().substring(1, metodo.length());
        try {
            Class[] param = {String.class};
            Method metodoClass = obj.getClass().getMethod("set" + nomeMetodo, param);
            Object[] valores = {valor};
            metodoClass.invoke(obj, valores);
        } catch (Exception e) {
            System.err.println("Nao encontrou o metodo set" + nomeMetodo + " na classe " + obj.getClass().getName());
            e.printStackTrace();
        }
    }

    

    /**
     * @return the notaFiscalEletronicaT
     */
    public NotaFiscalEletronicaT getNotaFiscalEletronicaT() {
        return notaFiscalEletronicaT;
    }

    /**
     * @param notaFiscalEletronicaT the notaFiscalEletronicaT to set
     */
    public void setNotaFiscalEletronicaT(NotaFiscalEletronicaT notaFiscalEletronicaT) {
        this.notaFiscalEletronicaT = notaFiscalEletronicaT;
    }

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
     * @return the abas
     */
    public List<String> getAbas() {
        return abas;
    }

    /**
     * @param abas the abas to set
     */
    public void setAbas(List<String> abas) {
        this.abas = abas;
    }

    /**
     * @return the chaveAcessoFormatad
     */
    public String getChaveAcessoFormatado() {
        try {

            MaskFormatter mf = new MaskFormatter("##-##/##-##.###.###/####-##-##-###-###.###.###-###.###.###-#");
            JFormattedTextField tfcep = new JFormattedTextField(mf);
            String str = getNot_notaT().getNfe_id();
            //str = str.substring(3, str.length());
            tfcep.setText(str);
            return tfcep.getText();
        } catch (ParseException ex) {
            Logger.getLogger(RelatorioNFEJB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     * @return the numeroNFE
     */
    public String getNumeroNFE() {
        try {

            MaskFormatter mf = new MaskFormatter("###.###");
            JFormattedTextField tfcep = new JFormattedTextField(mf);
            String str = getNot_notaT().getId_ent();
            str = str.substring(str.length() - 7, str.length() - 1);
            tfcep.setText(str);
            return tfcep.getText();
        } catch (ParseException ex) {
            Logger.getLogger(RelatorioNFEJB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     * @return the codigoproduto
     */
    public String getCodigoproduto() {
        return codigoproduto;
    }

    /**
     * @param codigoproduto the codigoproduto to set
     */
    public void setCodigoproduto(String codigoproduto) {
        this.codigoproduto = codigoproduto;
    }

    /**
     * @return the achou
     */
    public boolean isAchou() {
        return achou;
    }

    /**
     * @param achou the achou to set
     */
    public void setAchou(boolean achou) {
        this.achou = achou;
    }

    /**
     * @return the abaSelecionada
     */
    public String getAbaSelecionada() {
        return abaSelecionada;
    }

    /**
     * @param abaSelecionada the abaSelecionada to set
     */
    public void setAbaSelecionada(String abaSelecionada) {
        this.abaSelecionada = abaSelecionada;
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
     * @return the not_notaT
     */
    public Gj_gnfe_nota_fiscalT getNot_notaT() {
        return not_notaT;
    }

    /**
     * @param not_notaT the not_notaT to set
     */
    public void setNot_notaT(Gj_gnfe_nota_fiscalT not_notaT) {
        this.not_notaT = not_notaT;
    }

    /**
     * @return the numeroNF
     */
    public String getNumeroNF() {
        return numeroNF;
    }

    /**
     * @param numeroNF the numeroNF to set
     */
    public void setNumeroNF(String numeroNF) {
        this.numeroNF = numeroNF;
    }
}