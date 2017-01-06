<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="gj_gnfe_empresaJB" class="br.com.i9.marata.jb.Gj_gnfe_empresaInsertJB" scope="request"/>                                         
<jsp:setProperty name="gj_gnfe_empresaJB" property="*"/>                                         
<jsp:setProperty name="gj_gnfe_empresaJB" property="page" value="${pageContext}"/>                                         
${gj_gnfe_empresaJB.execute}                                         
                                                                               
	
<form name="gj_gnfe_empresa" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfe/GJAV/gj_gnfe_empresa/gj_gnfe_empresaInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${gj_gnfe_empresaJB.tipoMsg}">${gj_gnfe_empresaJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('gj_gnfe_empresa','insert', '/nfe/GJAV/gj_gnfe_empresa/gj_gnfe_empresaInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('gj_gnfe_empresa','Limpar', '/nfe/GJAV/gj_gnfe_empresa/gj_gnfe_empresaInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('gj_gnfe_empresa','', '/nfe/GJAV/gj_gnfe_empresa/gj_gnfe_empresaConsult.jsp')" />
    </div></td>
  </tr>
</table>
<br/>
<table align="left" width="600" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="300" nowrap="nowrap">&nbsp;</td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><span class="style1">*</span> Indica um campo obrigat&oacute;rio </div></td>
  </tr>
</table>
<br/>
	<table align="left" width="50%" border="0">
	         <tr>
	<td class="ms-standardheader">
		cod_empresa:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="gj_gnfe_empresaT.cod_empresa" value="${gj_gnfe_empresaJB.gj_gnfe_empresaT.cod_empresa}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cnpj_empresa:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="gj_gnfe_empresaT.cnpj_empresa" value="${gj_gnfe_empresaJB.gj_gnfe_empresaT.cnpj_empresa}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		den_empresa:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="gj_gnfe_empresaT.den_empresa" value="${gj_gnfe_empresaJB.gj_gnfe_empresaT.den_empresa}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		id_ent:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="gj_gnfe_empresaT.id_ent" value="${gj_gnfe_empresaJB.gj_gnfe_empresaT.id_ent}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

		
    	</table>
	<br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('gj_gnfe_empresa','insert', '/nfe/GJAV/gj_gnfe_empresa/gj_gnfe_empresaInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('gj_gnfe_empresa','Limpar', '/nfe/GJAV/gj_gnfe_empresa/gj_gnfe_empresaInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('gj_gnfe_empresa','', '/nfe/GJAV/gj_gnfe_empresa/gj_gnfe_empresaConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
