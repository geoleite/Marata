<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="relatorio" class="br.com.i9.marata.jb.RelatorioNFEJB" scope="request"/>
<jsp:setProperty name="relatorio" property="*"/>
<jsp:setProperty name="relatorio" property="page" value="${pageContext}"/>
${relatorio.execute}
<style type="text/css">

    .tabela {
        display: table;
        width: 90%;
    }
    #geral {
        position: relative;
        width:401px;
        height:20px;
        left:200px;
        z-index:1;

        visibility: visible;
    }
    <c:forEach var="item" items="${relatorio.abas}">
    #${item} {
        position:absolute;
        z-index:1;
        
        top:100px;
        <c:choose>
            <c:when test="${relatorio.abaSelecionada == item}">
            visibility: visible;
            </c:when>
            <c:otherwise>
            visibility: hidden;
            </c:otherwise>
        </c:choose>
    }
    </c:forEach>

</style>

<script type="text/JavaScript">
    <!--
    function MM_findObj(n, d) { //v4.01
        var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
            d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
        if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
        for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
        if(!x && d.getElementById) x=d.getElementById(n); return x;
    }

    function MM_showHideLayers() { //v6.0
        var i,p,v,obj,args=MM_showHideLayers.arguments;
        for (i=0; i<(args.length-2); i+=3) if ((obj=MM_findObj(args[i]))!=null) { v=args[i+2];
            if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
            obj.visibility=v; }
    }
    var index = 0;
    abas = new Array(<%=relatorio.getAbas().size()%>);
<c:forEach var="item" items="${relatorio.abas}" begin="0" end="8" step="1">
    abas[index++] = "${item}";
</c:forEach>

    function setShowLayers(layerId) {
        
        for (i=0; i < abas.length; i++) {
            //document.getElementById(abas[i]).visibility=hide;
            MM_showHideLayers(abas[i],'','hide');
            document.getElementById('botao_' + abas[i]).className = 'aba_botao';
        }
        //document.getElementById(layerId).visibility=show;
        document.getElementById('botao_' + layerId).className = 'aba_botao_selecionado';
        document.forms[0].elements['abaSelecionada'].value= layerId;
        MM_showHideLayers(layerId,'','show');
    }

    function expandeProduto(imagem, codigoProduto) {
        // Troca as imagens + | -
        if (imagem.src.indexOf('ico_menos.gif') > 0) {
            imagem.src = '../images/ico_mais.gif';
            MM_showHideLayers(codigoProduto,'','hide');
            // Exibir os dados detalhados do Produto
        } else {
            imagem.src = '../images/ico_menos.gif';
            MM_showHideLayers(codigoProduto,'','show');
        }
    }

    function createImpressao() {
        open('portal_Relatorio.jsp?not_notaT.nfe_id=${relatorio.not_notaT.nfe_id}&urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/relatorio/relatorio_nfe_impressao.jsp&op=consult&');
//        window.open('portal_Relatorio.jsp?not_notaT.nfe_id=${relatorio.not_notaT.nfe_id}&urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/relatorio/relatorio_nfe_impressao.jsp&op=consult&', 'impressao' + new Date(), '');
    }
    //-->
</script>
<!--h3 style="width:800" class="relatorio_linhas_titulo">Consulta NFE</h3>
<h3 style="color: red">${relatorio.msg}</h3-->
<form name="relatorio" action="relatorio_nfe.jsp" method="post">
    <input type="hidden" name="op" value="consult"/>
    <input type="hidden" name="abaSelecionada" value="${relatorio.abaSelecionada}"/>

    <c:if test="${param['versao']!='imp'}">
        <!--label>Chave de Acesso: </label><input size="40" name="not_notaT.nfe_id" title="Informe a chave de acesso." value="${relatorio.not_notaT.nfe_id}"/>
        <input type="submit" value="Localizar" /-->
        <!--input type="button" value="Localizar" onclick="setOpPortal('relatorio','consult', '/nfegen/public/relatorio/relatorio_nfe.jsp')"/-->
    </c:if>
    <c:if test="${relatorio.achou}">
        
        <!--div align="center">
            <input type="button" value="Versao para Impressao" onclick="createImpressao()"/>
        </div-->
        <table width="800" cellpadding="5" cellspacing="0">
            <tr>
                <td width="100%" align="left">
                    <table width="100%" cellpadding="0" cellspacing="0">
                        <tr class="relatorio_linhas_titulo">
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
                            <td>
                                <label>${relatorio.chaveAcessoFormatado}</label>
                            </td>
                            <td>
                                <label>${relatorio.numeroNF}</label>
                            </td>
                            <td style="text-align:right">
                                <label>${relatorio.notaFiscalEletronicaT.dadosNFET.versao}</label>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            
            <tr>
                <td bgcolor1="#ddc976">
                    
                    <c:forEach var="item" items="${relatorio.abas}">
                        <c:choose>
                            <c:when test="${relatorio.abaSelecionada==item}">
                                <input id="botao_${item}" class="aba_botao_selecionado" type="button"  value="${item}" onclick="setShowLayers('${item}')"/>
                            </c:when>
                            <c:otherwise>
                                <input id="botao_${item}" class="aba_botao" type="button"  value="${item}" onclick="setShowLayers('${item}')"/>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
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
                                <td align="center"><label>${relatorio.numeroNF}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosIDET.serie}</label></td>
                                <td  align="center"><label>${relatorio.notaFiscalEletronicaT.dadosIDET.demi}</label></td>
                                <td  align="center"><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vnf}</label></td>
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
                                <td align="center" nowrap><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.cnpj}</label></td>
                                <td align="center" nowrap><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.xnome}</label></td>
                                <td align="center" nowrap><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.ie}</label></td>
                                <td align="center" nowrap><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.uf}</label></td>
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
                                <td align="center" nowrap><label>${relatorio.notaFiscalEletronicaT.dadosDestT.cnpj}</label></td>
                                <td align="center" nowrap><label>${relatorio.notaFiscalEletronicaT.dadosDestT.xnome}</label></td>
                                <td align="center" nowrap><label>${relatorio.notaFiscalEletronicaT.dadosDestT.ie}</label></td>
                                <td align="center" nowrap><label>${relatorio.notaFiscalEletronicaT.dadosDestT.uf}</label></td>
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
                                            <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosIDET.procemi}-${relatorio.notaFiscalEletronicaT.dadosIDET.procemi== '0'?'Aplicativo do Contribuinte':relatorio.notaFiscalEletronicaT.dadosIDET.procemi=='1'?'Avulsa pelo Fisco':relatorio.notaFiscalEletronicaT.dadosIDET.procemi=='2'?'Avulsa pelo Contribuinte':'Aplicativo fornecido pelo Fisco' }</label></td>
                                            <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosIDET.verproc}</label></td>
                                            <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosIDET.tpemis} - ${relatorio.notaFiscalEletronicaT.dadosIDET.tpemis=='1'?'Normal':'Contingencia'}</label></td>
                                            <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosIDET.finnfe} -
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
                                            <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosIDET.natop}</label></td>
                                            <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosIDET.tpnf} - ${relatorio.notaFiscalEletronicaT.dadosIDET.tpnf=='0'?'Entrada':'Saida'}</label></td>
                                            <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosAssinaturaT.digestvalue}</label></td>
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
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.xnome}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.xfant}</label></td>
                            </tr>
                            <tr class="relatorio_linhas_titulo">
                                <th>CNPJ</th>
                                <th>Endereco</th>
                            </tr>
                            <tr>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.cnpj}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.xlgr}</label></td>
                            </tr>
                            <tr class="relatorio_linhas_titulo">
                                <th>Bairro/Distrito</th>
                                <th>CEP</th>
                            </tr>
                            <tr>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.xbairro}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.cep}</label></td>
                            </tr>
                            <tr class="relatorio_linhas_titulo">
                                <th>Municipio</th>
                                <th>Fone/Fax</th>
                            </tr>
                            <tr>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.xmun}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.fone}</label></td>
                            </tr>
                            <tr class="relatorio_linhas_titulo">
                                <th>UF</th>
                                <th>Pais</th>
                            </tr>
                            <tr>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.uf}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.xpais}</label></td>
                            </tr>
                            <tr class="relatorio_linhas_titulo">
                                <th>Inscricao Estadual</th>
                                <th>Inscricao Estadual do Substituto Tributario</th>
                            </tr>
                            <tr>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.ie}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.iest}</label></td>
                            </tr>
                            <tr class="relatorio_linhas_titulo">
                                <th>Inscricao Municipal</th>
                                <th>Municipio da Ocorrencia do Fato Gerador do ICMS</th>
                            </tr>
                            <tr>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.im}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.cmun}</label></td>
                            </tr>
                            <tr class="relatorio_linhas_titulo">
                                <th>CNAE Fiscal </th>
                                <th></th>
                            </tr>
                            <tr>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosEmissorT.cnae}</label></td>
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
                                <td colspan="2"  align="center"><label>${relatorio.notaFiscalEletronicaT.dadosDestT.xnome}</label></td>

                            </tr>
                            <tr class="relatorio_linhas_titulo">
                                <th>CNPJ</th>
                                <th>Endereco</th>
                            </tr>
                            <tr>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosDestT.cnpj}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosDestT.xlgr}</label></td>
                            </tr>
                            <tr class="relatorio_linhas_titulo">
                                <th>Bairro/Distrito</th>
                                <th>CEP</th>
                            </tr>
                            <tr>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosDestT.xbairro}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosDestT.cep}</label></td>
                            </tr>
                            <tr class="relatorio_linhas_titulo">
                                <th>Municipio</th>
                                <th>Fone/Fax</th>
                            </tr>
                            <tr>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosDestT.xmun}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosDestT.fone}</label></td>
                            </tr>
                            <tr class="relatorio_linhas_titulo">
                                <th>UF</th>
                                <th>Pais</th>
                            </tr>
                            <tr>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosDestT.uf}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosDestT.xpais}</label></td>
                            </tr>
                            <tr class="relatorio_linhas_titulo">
                                <th>Inscricao Estadual</th>
                                <th>Inscricao SUFRAMA</th>
                            </tr>
                            <tr>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosDestT.ie}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosDestT.isuf}</label></td>
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
                                    <table  width="800" cellpadding="10" cellspacing="0" border="1">
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
                                                            <a href="/maratanfe/nfe/danfe/relatorio_nfe.jsp?not_notaT.nfe_id=${relatorio.not_notaT.nfe_id}&op=consult&abaSelecionada=Produtos-Servicos">
                                                                <img src="${item.cprod==relatorio.codigoproduto?'/maratanfe/images/ico_menos.gif':'/maratanfe/images/ico_mais.gif'}" border="0"  onclick1="expandeProduto(this, 'prod_${item.cprod}')"/>
                                                            </a>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <a href="/maratanfe/nfe/danfe/relatorio_nfe.jsp?not_notaT.nfe_id=${relatorio.not_notaT.nfe_id}&op=consult&abaSelecionada=Produtos-Servicos&codigoproduto=${item.cprod}">
                                                                <img src="${item.cprod==relatorio.codigoproduto?'/maratanfe/images/ico_menos.gif':'/maratanfe/images/ico_mais.gif'}" border="0"  onclick1="expandeProduto(this, 'prod_${item.cprod}')"/>
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
                                            <c:if test="${item.cprod==relatorio.codigoproduto}">
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
                                                                <td align="center">
                                                                    <label>${item.cprod}</label>
                                                                </td>
                                                                <td  align="center">
                                                                    <label>${item.ncm}</label>
                                                                </td>
                                                                <td  align="center">
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
                                                                <td  align="center">
                                                                    <label>${item.extipi}</label>
                                                                </td>
                                                                <td  align="center">
                                                                    <label>${item.cfop}</label>
                                                                </td>
                                                                <td  align="center">
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
                                                                <td  align="center">
                                                                    <label>${item.vprod}</label>
                                                                </td>
                                                                <td  align="center">
                                                                    <label>${item.vfrete}</label>
                                                                </td>
                                                                <td  align="center">
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
                                                                <td  align="center">
                                                                    <label>${item.cean}</label>
                                                                </td>
                                                                <td  align="center">
                                                                    <label>${item.ucom}</label>
                                                                </td>
                                                                <td  align="center">
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
                                                                <td  align="center">
                                                                    <label>${item.vuncom}</label>
                                                                </td align="center">
                                                                <td>
                                                                    <label>${item.vuntrib}</label>
                                                                </td>
                                                                <td align="center">
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
                                                                <td align="center">
                                                                    <label>${item.dadosImpostoT.dadosICMST.orig}-
                                                                           ${item.dadosImpostoT.dadosICMST.orig=='0'?'Nacional': item.dadosImpostoT.dadosICMST.orig=='1'?'Estrangeira (Importacao Direta)':'Estrangeira (Adquirida no Mercado Interno)' }
                                                                    </label>
                                                                </td>
                                                                <td align="center">
                                                                    <label>${item.dadosImpostoT.dadosICMST.cst}-
                                                                    ICMS cobrado anteriormente por substituição tributária
                                                                    </label>
                                                                </td>
                                                                <td align="center">
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
                                                                <td align="center">
                                                                    <label>${item.dadosImpostoT.dadosICMST.vbc}
                                                                    </label>
                                                                </td>
                                                                <td align="center">
                                                                    <label>${item.dadosImpostoT.dadosICMST.picms}</label>
                                                                </td>
                                                                <td align="center">
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
                                                                <td align="center">
                                                                    <label>${item.dadosImpostoT.dadosICMST.vbcst}&nbsp;
                                                                    </label>
                                                                </td>
                                                                <td align="center">
                                                                    <label>${item.dadosImpostoT.dadosICMST.picmsst}</label>
                                                                </td>
                                                                <td align="center">
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
                                                                <td align="center">
                                                                    <label>${item.dadosImpostoT.dadosICMST.predbc}&nbsp;</label>
                                                                </td>
                                                                <td align="center">
                                                                    <label>${item.dadosImpostoT.dadosICMST.predbcst}</label>
                                                                </td>
                                                                <td align="center">
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
                                                                <td align="center">
                                                                    <label>${item.nlote }
                                                                    </label>
                                                                </td>
                                                                <td align="center">
                                                                    <label>${item.qlote}</label>
                                                                </td>
                                                                <td align="center">
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
                                                                <td align="center">
                                                                    <label>${item.dval }
                                                                    </label>
                                                                </td>
                                                                <td align="center">
                                                                    <label>${item.vpmc}</label>
                                                                </td>
                                                                <td>
                                                                    
                                                                </td>
                                                            </tr>

                                                        </table>
                                                    </td>
                                                </tr>
                                            </c:if>

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
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vbc}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vicms}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vbcst}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vst}</label></td>
                            </tr>

                            <tr class="relatorio_linhas_titulo">
                                <th>Valor Total dos Produtos</th>
                                <th>Valor do Frete</th>
                                <th>Valor do Seguro</th>
                                <th>Outras Despesas Acessorias</th>
                            </tr>
                            <tr>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vprod}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vfrete}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vseg}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.voutro}</label></td>
                            </tr>

                            <tr class="relatorio_linhas_titulo">
                                <th>Valor Total do IPI</th>
                                <th>Valor Total da NFE</th>
                                <th>Valor Total Desconto</th>
                                <th>Valor Total do II</th>
                            </tr>
                            <tr>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vipi}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vnf}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vdesc}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vii}</label></td>
                            </tr>

                            <tr class="relatorio_linhas_titulo">
                                <th>Valor Total do PIS</th>
                                <th>Valor Total da CONFINS</th>
                                <th></th>
                                <th></th>
                            </tr>
                            <tr>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vpis}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosTotalT.vcofins}</label></td>
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
                                <td align="center"><label>
                                    ${relatorio.notaFiscalEletronicaT.dadosTranspT.modfrete}-
                                    ${relatorio.notaFiscalEletronicaT.dadosTranspT.modfrete=='0'?'Por Conta do Emitente':'Por Conta do Destinatario'}
                                    </label>
                                </td>
                            </tr>

                        </table>
                    </div>
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
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosCobrancaT.numero}&nbsp;</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosCobrancaT.vorig}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosCobrancaT.vdesc}</label></td>
                            </tr>
                            <tr class="relatorio_linhas_titulo">
                                <th>Valor Liquido</th>
                                <th></th>
                                <th></th>
                            </tr>
                            <tr>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosCobrancaT.vliq}</label></td>
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
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosCobrancaT.ndup}&nbsp;</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosCobrancaT.dvenc}</label></td>
                                <td align="center"><label>${relatorio.notaFiscalEletronicaT.dadosCobrancaT.vdup}</label></td>
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
</form>
<!--
 fecha a página do portal pq foi deixado em comentario
-->

                            </td>
                        </tr>
                    </table>
                    <!--/div-->
                </td>
            </tr>
            <tr valign="top" height="20px">

            </tr>
        </table>

        
    </body>
</html>

<!--
 Desabilitar o rodapé da página que fica no portal.jsp
