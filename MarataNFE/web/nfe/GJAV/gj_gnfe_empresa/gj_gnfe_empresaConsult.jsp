<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="gj_gnfe_empresaJB" class="br.com.i9.marata.jb.Gj_gnfe_empresaConsultJB" scope="request"/>                                         
<jsp:setProperty name="gj_gnfe_empresaJB" property="*"/>                                         
<jsp:setProperty name="gj_gnfe_empresaJB" property="page" value="${pageContext}"/>                                         
${gj_gnfe_empresaJB.execute}                                         
                                                                                

<form name="gj_gnfe_empresa" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfe/GJAV/gj_gnfe_empresa/gj_gnfe_empresaConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${gj_gnfe_empresaJB.tipoMsg}">${gj_gnfe_empresaJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('gj_gnfe_empresa','', '/nfe/GJAV/gj_gnfe_empresa/gj_gnfe_empresaInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('gj_gnfe_empresa','consult', '/nfe/GJAV/gj_gnfe_empresa/gj_gnfe_empresaConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${gj_gnfe_empresaJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Cod_empresa" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfe/GJAV/gj_gnfe_empresa/gj_gnfe_empresaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.cod_empresa}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cnpj_empresa" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfe/GJAV/gj_gnfe_empresa/gj_gnfe_empresaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.cnpj_empresa}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Den_empresa" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfe/GJAV/gj_gnfe_empresa/gj_gnfe_empresaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.den_empresa}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Id_ent" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfe/GJAV/gj_gnfe_empresa/gj_gnfe_empresaUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.id_ent}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('gj_gnfe_empresa','delete', '/nfe/GJAV/gj_gnfe_empresa/gj_gnfe_empresaConsult.jsp?')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
