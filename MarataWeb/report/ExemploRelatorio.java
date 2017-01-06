/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.nfegen.report;

import br.com.easynet.easylog.jb.INotLog;
import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.easynet.nfegen.jb.RelatorioNFEJB;
import br.com.easynet.nfegen.jb.SystemBase;
import br.com.easynet.nfegen.transfer.Not_notaT;
import br.com.easynet.nfegen.transfer.NotaFiscalEletronicaT;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author geoleite
 */
public class ExemploRelatorio extends SystemBase implements INotSecurity, INotLog {
    private Not_notaT not_notaT = new Not_notaT();
    public void relatorio1() {
        try {
            Map parameters = new HashMap();

            List<Not_notaT> listNot = getNot_notaDAO().getAll();
            JRDataSource jrds = new JRBeanCollectionDataSource(listNot);

            ResultSet rs = getDAO().getConnection().createStatement().executeQuery("select * from easynfe.not_nota");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            InputStream is = ExemploRelatorio.class.getResourceAsStream("Relatorio1.jasper");
            JasperFillManager.fillReportToStream(is, baos, parameters, jrRS);


            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            baos = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(bais, baos);
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "application/pdf");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, "pdf.pdf");
            getRequest().setAttribute(EasyDownloadJB.DATA, baos.toByteArray());
            getPage().forward("/portal/easydownload.jsp");

            //getResponse().getOutputStream().write(baos.toByteArray());
            //getResponse().getOutputStream().flush();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    /**
     * Obtém os dados da nota em formato de Classe
     * @param chaveAcesso
     * @return
     */
    private NotaFiscalEletronicaT getNotaFiscal(String chaveAcesso) {
        RelatorioNFEJB relatorioNFEJB = new RelatorioNFEJB();
        not_notaT.setNot_tx_identificador(chaveAcesso);
        relatorioNFEJB.setPage(getPage());
        relatorioNFEJB.setNot_notaT(not_notaT);
        relatorioNFEJB.consult();
        NotaFiscalEletronicaT notaFiscalEletronicaT = relatorioNFEJB.getNotaFiscalEletronicaT();
        return notaFiscalEletronicaT;
    }
    public void relatorio2() {
        try {
            String chaveAcesso = "NFe28100504521471000104550010000032290000032297";
            NotaFiscalEletronicaT notaFiscal = getNotaFiscal(chaveAcesso);
            
            Map parameters = new HashMap();
            
            // Dados da Nota
            parameters.put("chaveAcesso", chaveAcesso);
            parameters.put("numeroNota", notaFiscal.getDadosIDET().getCnf());
            parameters.put("serie", notaFiscal.getDadosIDET().getSerie());
            parameters.put("natOp", notaFiscal.getDadosIDET().getNatop());
            parameters.put("tipoNota", notaFiscal.getDadosIDET().getTpnf());
            if (chaveAcesso.indexOf("NFe") >-1) {
                chaveAcesso = chaveAcesso.substring(3, chaveAcesso.length());
            }

            //Dados do Emissor
            parameters.put("cnpj", notaFiscal.getDadosEmissorT().getCnpj());
            parameters.put("inscricaoEstadual", notaFiscal.getDadosEmissorT().getIe());
            parameters.put("inscEstSubs", notaFiscal.getDadosEmissorT().getIest());

            //Dados do Destinatario
            parameters.put("razaoSocialDest", notaFiscal.getDadosDestT().getXnome());
            parameters.put("cnpjDest", notaFiscal.getDadosDestT().getCnpj());
//            parameters.put("inscricaoEstadualDest", notaFiscal.getDadosEmissorT().getIe());
            parameters.put("endereco", notaFiscal.getDadosDestT().getXlgr());
            parameters.put("cep", notaFiscal.getDadosDestT().getCep());
            parameters.put("municipio", notaFiscal.getDadosDestT().getCmun());
            parameters.put("foneFax", notaFiscal.getDadosDestT().getFone());
            parameters.put("inscEstadualDest", notaFiscal.getDadosDestT().getIe());
            parameters.put("bairroDistrito", notaFiscal.getDadosDestT().getXbairro());
            parameters.put("uf", notaFiscal.getDadosDestT().getUf());
            parameters.put("dataEmissao", notaFiscal.getDadosIDET().getDemi());
            parameters.put("dataSaida", notaFiscal.getDadosIDET().getDsaient());
            parameters.put("horaSaida", "");

            //Dados do Imposto
            parameters.put("baseCalculoICMS", notaFiscal.getDadosTotalT().getVbc());
            parameters.put("valorFrete", notaFiscal.getDadosTotalT().getVfrete());
            parameters.put("valorICMS", notaFiscal.getDadosTotalT().getVicms());
            parameters.put("valorSeguro", notaFiscal.getDadosTotalT().getVseg());
            parameters.put("baseCalculoICMSSubst", notaFiscal.getDadosTotalT().getVbcst());
            parameters.put("desconto", notaFiscal.getDadosTotalT().getVdesc());
            parameters.put("outrasDespesas", notaFiscal.getDadosTotalT().getVoutro());
            parameters.put("valorICMSubst", "?");
            parameters.put("valorIpi", notaFiscal.getDadosTotalT().getVipi());
            parameters.put("valorTotalProdutos", "?");
            parameters.put("valorTotalNota", notaFiscal.getDadosTotalT().getVnf());

            //Dados Transportadora
            parameters.put("razaoSocial", "O Próprio");
            parameters.put("frete", "");
            parameters.put("antt", "");
            parameters.put("placa", "");
            parameters.put("cnpjCpf", "");
            parameters.put("enderecoTransportador", "");
            parameters.put("municipioTransportador", "");
            parameters.put("ufTransportador", "");
            parameters.put("inscricaoEstadualTransportador", "");
            parameters.put("quantidade", "");
            parameters.put("especie", "");
            parameters.put("marca", "");
            parameters.put("numeracao", "");
            parameters.put("pesoBruto", "");
            parameters.put("pesoLiquido", "");

            //Dados Itens da nota
            JRDataSource jrds = new JRBeanCollectionDataSource(notaFiscal.getListaDet());
       



            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            InputStream is = ExemploRelatorio.class.getResourceAsStream("Relatorio3.jasper");
            JasperFillManager.fillReportToStream(is, baos, parameters, jrds);


            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            baos = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(bais, baos);
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "application/pdf");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, "pdf.pdf");
            getRequest().setAttribute(EasyDownloadJB.DATA, baos.toByteArray());
            getPage().forward("/portal/easydownload.jsp");

            //getResponse().getOutputStream().write(baos.toByteArray());
            //getResponse().getOutputStream().flush();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    /**
     * @return the not_notaT
     */
    public Not_notaT getNot_notaT() {
        return not_notaT;
    }

    /**
     * @param not_notaT the not_notaT to set
     */
    public void setNot_notaT(Not_notaT not_notaT) {
        this.not_notaT = not_notaT;
    }

  
}
