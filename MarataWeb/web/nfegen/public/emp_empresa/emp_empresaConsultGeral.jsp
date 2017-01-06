<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="emp_empresaJB" class="br.com.easynet.nfegen.jb.Emp_empresaConsultGeralJB" scope="request"/>
<jsp:setProperty name="emp_empresaJB" property="*"/>                                         
<jsp:setProperty name="emp_empresaJB" property="page" value="${pageContext}"/>                                         
${emp_empresaJB.execute}                                         
                                                                                

<form name="emp_empresa" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/public/emp_empresa/emp_empresaConsultGeral.jsp"/>
    <div align="center">     
        <label class="msg" align="center">${emp_empresaJB.msg} </label>
        <br/>
        <h3 align="center">Pesquisar Empresas</h3>
        <br/>
        <label>Informacão:</label><input name="informacao" value="${emp_empresaJB.informacao}"/>
        <select name="tipo">
            <option value="N" ${emp_empresaJB.tipo=='N'?'selected':' '}>Pesquisar por Nome</option>
            <option value="C" ${emp_empresaJB.tipo=='C'?'selected':' '}>Pesquisar por CNPJ</option>
        </select>
        <input type="button" value="Pesquisar"  onClick="setOpPortal('emp_empresa','consult', '/nfegen/public/emp_empresa/emp_empresaConsultGeral.jsp')" />
        <br/>
        <br/>
        <h3 align="center">Empresas Cadastradas</h3>
        <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${emp_empresaJB.list}"  pagesize="50" >
            
            <display:column sortable="false" title="Nome" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/emp_empresa/emp_empresaUpdateDeleteGeral.jsp&op=findbyid&emp_empresaT.emp_nr_id=${item.emp_nr_id}&">
                 <c:out value="${item.emp_tx_nome}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="Cnpj" >
                <!--a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/emp_empresa/emp_empresaUpdateDelete.jsp&op=findbyid&emp_empresaT.emp_nr_id=${item.emp_nr_id}&"-->
                <label> <c:out value="${item.emp_tx_cnpj}"/></label>
                <!--/a-->
            </display:column>
            <display:column sortable="false" title="Estado" >
                <!--a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/emp_empresa/emp_empresaUpdateDelete.jsp&op=findbyid&emp_empresaT.emp_nr_id=${item.emp_nr_id}&"-->
                <label> <c:out value="${item.emp_tx_estado}"/></label>
                <!--/a-->
            </display:column>
            <display:column sortable="false" title="Cidade" >
                <!--a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/emp_empresa/emp_empresaUpdateDelete.jsp&op=findbyid&emp_empresaT.emp_nr_id=${item.emp_nr_id}&"-->
                <label> <c:out value="${item.emp_tx_cidade}"/></label>
                <!--/a-->
            </display:column>
            
        </display:table>
    </div>	    
</form>

