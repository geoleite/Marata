<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="dis_distribuidoraJB" class="br.com.easynet.nfegen.jb.Dis_distribuidoraConsultAssociadasJB" scope="request"/>
<jsp:setProperty name="dis_distribuidoraJB" property="*"/>
<jsp:setProperty name="dis_distribuidoraJB" property="page" value="<%=pageContext%>"/>
<jsp:getProperty name="dis_distribuidoraJB" property="execute"/>
<fmt:setLocale value="pt_BR"/>

<form name="dis_distribuidora" action="portal.jsp" method="post">
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/public/dis_distribuidora/dis_distribuidoraConsult.jsp"/>
    <div align="center">
        <label class="msg" align="center">${dis_distribuidoraJB.msg} </label>
        <br/>
        <h3>Consultar Distribuidoras Associadas</h3>
        <!--input type="button" value="Nova" onClick="setOpPortal('dis_distribuidora','', '/nfegen/public/dis_distribuidora/dis_distribuidoraInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
        <input type="button" value="Atualizar" onClick="setOpPortal('dis_distribuidora','consult', '/nfegen/public/dis_distribuidora/dis_distribuidoraConsult.jsp')"/-->&nbsp;&nbsp;&nbsp;
        <hr/>

        <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${dis_distribuidoraJB.list}"  pagesize="30">

            <display:column sortable="false" title="Nome" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/dis_distribuidora/dis_distribuidoraUpdateDelete.jsp&op=findbyid&dis_distribuidoraT.dis_nr_id=${item.dis_nr_id}&">
                    <c:out value="${item.dis_tx_nome}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="Cnpj" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/dis_distribuidora/dis_distribuidoraUpdateDelete.jsp&op=findbyid&dis_distribuidoraT.dis_nr_id=${item.dis_nr_id}&">
                    <c:out value="${item.dis_tx_cnpj}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/emp_empresa/emp_empresaConsult.jsp&dis_distribuidoraT.dis_nr_id=${item.dis_nr_id}&">
                    Clientes
                </a>
            </display:column>
            <display:column sortable="false" title="" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/con_contador/con_contadorDistribuidoraConsult.jsp&dis_distribuidoraT.dis_nr_id=${item.dis_nr_id}&">
                    Contador
                </a>
            </display:column>
            <display:column sortable="false" title="" >
                <a title="Cadastrar Nova Nota Fiscal Eletronica" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/not_nota/not_notaInsert.jsp&dis_distribuidoraT.dis_nr_id=${item.dis_nr_id}&">
                    Cad. Nota
                </a>
            </display:column>
            <!-- display : column sortable="false" title="" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/not_nota/not_notaConsultEntrada.jsp&dis_distribuidoraT.dis_nr_id=${item.dis_nr_id}&">
                    Pesquisar Notas Entrada
                </a>
            < /  display : column-->
            <display:column sortable="false" title="" >
                <a title="Pesquisar Nova Nota Fiscais" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/not_nota/not_notaConsult.jsp&dis_distribuidoraT.dis_nr_id=${item.dis_nr_id}&">
                    Pesq. Notas
                </a>
            </display:column>
            <display:column sortable="false" title="" >
                <a title="Relatorio de Cobranca" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/not_nota/not_notaConsultCobranca.jsp&dis_distribuidoraT.dis_nr_id=${item.dis_nr_id}&">
                    Rel. de Cobranca
                </a>
            </display:column>
            <display:column sortable="false" title="" >
                <a title="Consultar Nova Nota Fiscal Eletronica" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/relatorio/relatorio_nfe.jsp&dis_distribuidoraT.dis_nr_id=${item.dis_nr_id}&">
                    NF-e Completa
                </a>
            </display:column>
            <display:column sortable="false" title="" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/rel_registro_log/rel_registro_logConsult.jsp&dis_distribuidoraT.dis_nr_id=${item.dis_nr_id}&">
                    Log
                </a>
            </display:column>

            <display:column title="">
                <div align="right">
                    <a onclick="setOpPortal('dis_distribuidora','delete', '/nfegen/public/dis_distribuidora/dis_distribuidoraConsult.jsp?dis_distribuidoraT.dis_nr_id=${item.dis_nr_id}&')" href="#">
                        <img border="0" src="/easyportal/images/delete.png">
                    </a>
                </div>
            </display:column>
        </display:table>
    </div>

</form>

