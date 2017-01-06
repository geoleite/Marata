<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="relatorio" class="br.com.easynet.nfegen.jb.RelatorioNFEJB" scope="request"/>
<jsp:setProperty name="relatorio" property="*"/>
<jsp:setProperty name="relatorio" property="page" value="${pageContext}"/>
${relatorio.execute}

<h3>Consulta NFE</h3>


<c:if test="${relatorio.achou}">
    <table width="100%">
        <tr>
            <td width="100%">
                <table width="100%">
                    <tr>
                        <th>
                            Chave Acesso
                        </th>
                        <th>
                            Numero NF-e
                        </th>
                        <th  style="text-align:right">
                            Versao XML
                        </th>
                    </tr>
                    <tr>
                        <td nowrap>
                            <label>${relatorio.chaveAcessoFormatado}</label>
                        </td>
                        <td>
                            <label>${relatorio.numeroNFE}</label>
                        </td>
                        <td style="text-align:right">
                            <label>${relatorio.notaFiscalEletronicaT.dadosNFET.versao}</label>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>

        <tr>
            <td>
                <div id="NF-e" >
                    <table width="800">
                        <tr>
                            <td><h3>Dados da NF-e</h3></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>Numero:</th>
                            <th>Serie:</th>
                            <th>Data de emissao:</th>
                            <th>Valor Total da Nota Fiscal:</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.numeroNFE}<label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosIDET.serie}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosIDET.demi}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vnf}</label></td>
                        </tr>
                        <tr>
                            <td colspan="20"><h3>EMITENTE</h3></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>CNPJ</th>
                            <th>Nome/Razao Social</th>
                            <th>Inscricao Estadual</th>
                            <th>UF</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.cnpj}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.xnome}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.ie}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.uf}</label></td>
                        </tr>
                        <tr>
                            <td colspan="20"><h3>DESTINATARIO</h3></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>CNPJ</th>
                            <th>Nome/Razao Social</th>
                            <th>Inscricao Estadual</th>
                            <th>UF</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosDestT.cnpj}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosDestT.xnome}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosDestT.ie}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosDestT.uf}</label></td>
                        </tr>
                        <tr>
                            <td colspan="20"><h3>EMISSAO</h3></td>
                        </tr>
                        <tr>
                            <td colspan="20">
                                <table width="100%">
                                    <tr class="relatorio_linhas_titulo">
                                        <th>Processo</th>
                                        <th>Versao do Processo</th>
                                        <th>Forma</th>
                                        <th>Finalidade</th>
                                    </tr>
                                    <tr>
                                            <td><label>${relatorio.notaFiscalEletronicaT.dadosIDET.procemi}-${relatorio.notaFiscalEletronicaT.dadosIDET.procemi== '0'?'Aplicativo do Contribuinte':relatorio.notaFiscalEletronicaT.dadosIDET.procemi=='1'?'Avulsa pelo Fisco':relatorio.notaFiscalEletronicaT.dadosIDET.procemi=='2'?'Avulsa pelo Contribuinte':'Aplicativo fornecido pelo Fisco' }</label></td>
                                            <td><label>${relatorio.notaFiscalEletronicaT.dadosIDET.verproc}</label></td>
                                            <td><label>${relatorio.notaFiscalEletronicaT.dadosIDET.tpemis} - ${relatorio.notaFiscalEletronicaT.dadosIDET.tpemis=='1'?'Normal':'Contingencia'}</label></td>
                                            <td><label>${relatorio.notaFiscalEletronicaT.dadosIDET.finnfe} -
                                            ${relatorio.notaFiscalEletronicaT.dadosIDET.finnfe=='1'?'Normal':relatorio.notaFiscalEletronicaT.dadosIDET.finnfe=='1'?'Complementar':'De ajuste'}</label></td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="20">
                                <table width="100%">
                                    <tr class="relatorio_linhas_titulo">
                                        <th>Natureza da Operacao</th>
                                        <th>Tipo da Operacao</th>
                                        <th>Digest Value da NF-e</th>
                                    </tr>
                                    <tr>
                                        <td><label>${relatorio.notaFiscalEletronicaT.dadosIDET.natop}</label></td>
                                        <td><label>${relatorio.notaFiscalEletronicaT.dadosIDET.tpnf} - ${relatorio.notaFiscalEletronicaT.dadosIDET.tpnf=='0'?'Entrada':'Saida'}</label></td>
                                        <td><label>${relatorio.notaFiscalEletronicaT.dadosAssinaturaT.digestvalue}</label></td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
                <div id="Emitente">
                    <table width="800">
                        <tr>
                            <td colspan="2"><h3>Dados do Emitente</h3></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>Nome/Razao Social</th>
                            <th>Nome Fantasia</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.xnome}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.xfant}</label></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>CNPJ</th>
                            <th>Endereco</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.cnpj}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.xlgr}</label></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>Bairro/Distrito</th>
                            <th>CEP</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.xbairro}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.cep}</label></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>Municipio</th>
                            <th>Fone/Fax</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.xmun}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.fone}</label></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>UF</th>
                            <th>Pais</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.uf}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.xpais}</label></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>Inscricao Estadual</th>
                            <th>Inscricao Estadual do Substituto Tributario</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.ie}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.iest}</label></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>Inscricao Municipal</th>
                            <th>Municipio da Ocorrencia do Fato Gerador do ICMS</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.im}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.cmun}</label></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>CNAE Fiscal </th>
                            <th></th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.cnae}</label></td>
                            <td></td>
                        </tr>
                    </table>
                </div>

                <div id="Destinatario">
                    <table width="800">
                        <tr>
                            <td colspan="2"><h3>Dados do Destinatario</h3></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th colspan="2">Nome/Razao Social</th>
                        </tr>
                        <tr>
                            <td colspan="2"><label>${relatorio.notaFiscalEletronicaT.dadosDestT.xnome}</label></td>

                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>CNPJ</th>
                            <th>Endereco</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosDestT.cnpj}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosDestT.xlgr}</label></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>Bairro/Distrito</th>
                            <th>CEP</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosDestT.xbairro}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosDestT.cep}</label></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>Municipio</th>
                            <th>Fone/Fax</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosDestT.xmun}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosDestT.fone}</label></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>UF</th>
                            <th>Pais</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosDestT.uf}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosDestT.xpais}</label></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>Inscricao Estadual</th>
                            <th>Inscricao SUFRAMA</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosDestT.ie}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosDestT.isuf}</label></td>
                        </tr>
                    </table>
                </div>

                <div id="Produtos-Servicos">
                    <table width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                            <td colspan="2"><h3>Dados dos Produtos e Servicos</h3></td>
                        </tr>
                        <tr>
                            <td>
                                <table  width="800" cellpadding="10" cellspacing="0">
                                    <tr class="relatorio_linhas_titulo">
                                        <th colspan="2">Num. Descricao</th>
                                        <th style="text-align: right">Qtd.</th>
                                        <th style="text-align: center"> Unidade Comercial</th>
                                        <th style="text-align: right">Valor (R$)</th>
                                    </tr>
                                    <c:forEach var="item" items="${relatorio.notaFiscalEletronicaT.listaDet}">
                                        <tr class="relatorio_linhas_produto">
                                            <td>
                                                <c:choose >
                                                    <c:when test="${item.cprod == relatorio.codigoproduto}">
                                                        <a href="portal.jsp?not_notaT.not_tx_identificador=${relatorio.not_notaT.not_tx_identificador}&urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/relatorio/relatorio_nfe.jsp&op=consult&abaSelecionada=Produtos-Servicos">
                                                            <!--img src="${item.cprod==relatorio.codigoproduto?'../images/ico_menos.gif':'../images/ico_mais.gif'}" border="0"  onclick1="expandeProduto(this, 'prod_${item.cprod}')"/-->
                                                        </a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a href="portal.jsp?not_notaT.not_tx_identificador=${relatorio.not_notaT.not_tx_identificador}&urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/relatorio/relatorio_nfe.jsp&op=consult&abaSelecionada=Produtos-Servicos&codigoproduto=${item.cprod}">
                                                            <!--img src="${item.cprod==relatorio.codigoproduto?'../images/ico_menos.gif':'../images/ico_mais.gif'}" border="0"  onclick1="expandeProduto(this, 'prod_${item.cprod}')"/-->
                                                        </a>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <label>${item.xprod}</label>
                                            </td>
                                            <td style="text-align: right"><label>${item.qcom}</label></td>
                                            <td style="text-align: center"><label>${item.ucom}</label></td>
                                            <td style="text-align: right"><label>${item.vprod}</label></td>
                                        </tr>
                                        <!--c : if test="${item.cprod==relatorio.codigoproduto}"-->
                                            <tr>
                                                <td colspan="5">
                                                    <table width="800">
                                                        <tr class="relatorio_linhas_titulo">
                                                            <th>
                                                                Codigo do Produto
                                                            </th>
                                                            <th>
                                                                Codigo NCM
                                                            </th>
                                                            <th>

                                                            </th>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <label>${item.cprod}</label>
                                                            </td>
                                                            <td>
                                                                <label>${item.ncm}</label>
                                                            </td>
                                                            <td>
                                                                <label></label>
                                                            </td>
                                                        </tr>
                                                        <tr class="relatorio_linhas_titulo">
                                                            <th>
                                                                Codigo EX da TIPI
                                                            </th>
                                                            <th>
                                                                CFOP
                                                            </th>
                                                            <th>
                                                                Genero
                                                            </th>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <label>${item.extipi}</label>
                                                            </td>
                                                            <td>
                                                                <label>${item.cfop}</label>
                                                            </td>
                                                            <td>
                                                                <label>${item.genero}</label>
                                                            </td>
                                                        </tr>
                                                        <tr class="relatorio_linhas_titulo">
                                                            <th>
                                                                Valor do Documento
                                                            </th>
                                                            <th>
                                                                Valor Total do Frete
                                                            </th>
                                                            <th>
                                                                Valor do Seguro
                                                            </th>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <label>${item.vprod}</label>
                                                            </td>
                                                            <td>
                                                                <label>${item.vfrete}</label>
                                                            </td>
                                                            <td>
                                                                <label>${item.vseg}</label>
                                                            </td>
                                                        </tr>

                                                        <tr class="relatorio_linhas_titulo">
                                                            <th>
                                                                Codigo EAN Comercial
                                                            </th>
                                                            <th>
                                                                Unidade Comercial
                                                            </th>
                                                            <th>
                                                                Quantidade Comercial
                                                            </th>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <label>${item.cean}</label>
                                                            </td>
                                                            <td>
                                                                <label>${item.ucom}</label>
                                                            </td>
                                                            <td>
                                                                <label>${item.qcom}</label>
                                                            </td>
                                                        </tr>

                                                        <tr class="relatorio_linhas_titulo">
                                                            <th>
                                                                Valor Unitario de Comercializacao
                                                            </th>
                                                            <th>
                                                                Valor Unitario de Tributacao
                                                            </th>
                                                            <th>

                                                            </th>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <label>${item.vuncom}</label>
                                                            </td>
                                                            <td>
                                                                <label>${item.vuntrib}</label>
                                                            </td>
                                                            <td>
                                                                <label></label>
                                                            </td>
                                                        </tr>

                                                        <tr>
                                                            <th>
                                                                <h3>ICMS NORMAL E ST</h3>
                                                            </th>
                                                        </tr>
                                                        <tr class="relatorio_linhas_titulo">
                                                            <th>
                                                                Origem da Mercadoria
                                                            </th>
                                                            <th>
                                                                Tributacao do ICMS
                                                            </th>
                                                            <th>
                                                                Modalidade Definicao da BC ICMS NOR
                                                            </th>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <label>${item.dadosImpostoT.dadosICMST.orig}-
                                                                    ${item.dadosImpostoT.dadosICMST.orig=='0'?'Nacional': item.dadosImpostoT.dadosICMST.orig=='1'?'Estrangeira (Importacao Direta)':'Estrangeira (Adquirida no Mercado Interno)' }
                                                                </label>
                                                            </td>
                                                            <td>
                                                                <label>${item.dadosImpostoT.dadosICMST.cst}-
                                                                    ICMS cobrado anteriormente por substituição tributária
                                                                </label>
                                                            </td>
                                                            <td>
                                                                <label>${item.dadosImpostoT.dadosICMST.modbc}</label>
                                                            </td>
                                                        </tr>

                                                        <tr class="relatorio_linhas_titulo">
                                                            <th>
                                                                Base de Calculo do ICMS Normal
                                                            </th>
                                                            <th>
                                                                Aliquota do ICMS Normal
                                                            </th>
                                                            <th>
                                                                Valor do ICMS Normal
                                                            </th>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <label>${item.dadosImpostoT.dadosICMST.vbc}
                                                                </label>
                                                            </td>
                                                            <td>
                                                                <label>${item.dadosImpostoT.dadosICMST.picms}</label>
                                                            </td>
                                                            <td>
                                                                <label>${item.dadosImpostoT.dadosICMST.vicms}</label>
                                                            </td>
                                                        </tr>

                                                        <tr class="relatorio_linhas_titulo">
                                                            <th>
                                                                Base de Calculo do ICMS ST
                                                            </th>
                                                            <th>
                                                                Aliquota do ICMS ST
                                                            </th>
                                                            <th>
                                                                Valor do ICMS ST
                                                            </th>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <label>${item.dadosImpostoT.dadosICMST.vbcst}&nbsp;
                                                                </label>
                                                            </td>
                                                            <td>
                                                                <label>${item.dadosImpostoT.dadosICMST.picmsst}</label>
                                                            </td>
                                                            <td>
                                                                <label>${item.dadosImpostoT.dadosICMST.vicmsst}</label>
                                                            </td>
                                                        </tr>

                                                        <tr class="relatorio_linhas_titulo">
                                                            <th>
                                                                Percentual Reducao BC do ICMS Normal
                                                            </th>
                                                            <th>
                                                                Percentual Reducao BC do ICMS ST
                                                            </th>
                                                            <th>
                                                                Percentual MVA do ICMS ST
                                                            </th>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <label>${item.dadosImpostoT.dadosICMST.predbc}&nbsp;</label>
                                                            </td>
                                                            <td>
                                                                <label>${item.dadosImpostoT.dadosICMST.predbcst}</label>
                                                            </td>
                                                            <td>
                                                                <label>${item.dadosImpostoT.dadosICMST.pmvast}</label>
                                                            </td>
                                                        </tr>

                                                        <tr class="relatorio_linhas_titulo">
                                                            <th colspan="3">
                                                                Modalidade Definição da BC ICMS ST
                                                            </th>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="3">
                                                                <label>${item.dadosImpostoT.dadosICMST.modbcst}&nbsp;
                                                                </label>
                                                            </td>
                                                        </tr>

                                                        <tr>
                                                            <th colspan="4">
                                                                <h3>Detalhamento Especifico de Medicamento</h3>
                                                            </th>
                                                        </tr>
                                                        <tr class="relatorio_linhas_titulo">
                                                            <th>
                                                                Nr Lote
                                                            </th>
                                                            <th>
                                                                Qtd Produto no Lote
                                                            </th>
                                                            <th>
                                                                Data de Fabricacao
                                                            </th>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <label>${item.nlote }
                                                                </label>
                                                            </td>
                                                            <td>
                                                                <label>${item.qlote}</label>
                                                            </td>
                                                            <td>
                                                                <label>${item.dfab}</label>
                                                            </td>
                                                        </tr>

                                                        <tr class="relatorio_linhas_titulo">
                                                            <th>
                                                                Data Validade
                                                            </th>
                                                            <th>
                                                                Preco Maximo Consumidor
                                                            </th>
                                                            <th>

                                                            </th>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <label>${item.dval }
                                                                </label>
                                                            </td>
                                                            <td>
                                                                <label>${item.vpmc}</label>
                                                            </td>
                                                            <td>

                                                            </td>
                                                        </tr>

                                                    </table>
                                                </td>
                                            </tr>
                                        <!-- / c:if-->

                                    </c:forEach>
                                </table>
                            </td>
                        </tr>

                    </table>
                </div>

                <div id="Totais">
                    <table width="100%">
                        <tr>
                            <td colspan="4"><h3>Dados Total</h3></td>
                        </tr>
                        <tr>
                            <td colspan="4"><label>ICMS</label></td>

                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>Base de Calculo ICMS</th>
                            <th>Valor ICMS</th>
                            <th>Base de Calculo Valor ICMS ST</th>
                            <th>Valor ICMS Substituicao</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vbc}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vicms}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vbcst}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vst}</label></td>
                        </tr>

                        <tr class="relatorio_linhas_titulo">
                            <th>Valor Total dos Produtos</th>
                            <th>Valor do Frete</th>
                            <th>Valor do Seguro</th>
                            <th>Outras Despesas Acessorias</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vprod}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vfrete}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vseg}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.voutro}</label></td>
                        </tr>

                        <tr class="relatorio_linhas_titulo">
                            <th>Valor Total do IPI</th>
                            <th>Valor Total da NFE</th>
                            <th>Valor Total Desconto</th>
                            <th>Valor Total do II</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vipi}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vnf}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vdesc}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vii}</label></td>
                        </tr>

                        <tr class="relatorio_linhas_titulo">
                            <th>Valor Total do PIS</th>
                            <th>Valor Total da CONFINS</th>
                            <th></th>
                            <th></th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vpis}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vcofins}</label></td>
                            <td><label></label></td>
                            <td><label></label></td>
                        </tr>
                    </table>
                </div>
                <div id="Transporte">
                    <table  width="800">
                        <tr>
                            <td colspan="2"><h3>Dados do Transporte</h3></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>Modalidade de Frete</th>
                        </tr>
                        <tr>
                            <td><label>
                                    ${relatorio.notaFiscalEletronicaT.dadosTranspT.modfrete}-
                                    ${relatorio.notaFiscalEletronicaT.dadosTranspT.modfrete=='0'?'Por Conta do Emitente':'Por Conta do Destinatario'}</label></td>
                        </tr>

                </table>                </div>
                <div id="Cobranca">
                    <table width="800">
                        <tr>
                            <td colspan="2"><h3>Dados de Cobranca</h3></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th colspan="3">Fatura</th>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>Numero</th>
                            <th>Valor Original</th>
                            <th>Valor do Desconto</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosCobrancaT.numero}&nbsp;</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosCobrancaT.vorig}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosCobrancaT.vdesc}</label></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>Valor Liquido</th>
                            <th></th>
                            <th></th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosCobrancaT.vliq}</label></td>
                            <td></td>
                            <td></td>
                        </tr>

                        <tr class="relatorio_linhas_titulo">
                            <th colspan="3">Duplicatas</th>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>Numero</th>
                            <th>Vencimento</th>
                            <th>Valor</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosCobrancaT.ndup}&nbsp;</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosCobrancaT.dvenc}</label></td>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosCobrancaT.vdup}</label></td>
                        </tr>

                    </table>
                </div>
                <div id="InfAdicionais">
                    <table  width="800">
                        <tr>
                            <td colspan="2"><h3>Informacoes Adicionais</h3></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th colspan="3">Inormacoes Adicionais de Interesse do Fisco</th>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>Descricao</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosInformacoesAdicionaisT.infadfisco}&nbsp;</label></td>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th colspan="3">Inormacoes Complementares de Interesse do Contribuinte</th>
                        </tr>
                        <tr class="relatorio_linhas_titulo">
                            <th>Descricao</th>
                        </tr>
                        <tr>
                            <td><label>${relatorio.notaFiscalEletronicaT.dadosInformacoesAdicionaisT.infcpl}&nbsp;</label></td>
                        </tr>
                    </table>
                </div>

            </td>
        </tr>
    </table>
</c:if>