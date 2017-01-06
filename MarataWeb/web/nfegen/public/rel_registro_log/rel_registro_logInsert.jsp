<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="rel_registro_logJB" class="br.com.easynet.nfegen.jb.Rel_registro_logInsertJB" scope="request"/>                                         
<jsp:setProperty name="rel_registro_logJB" property="*"/>                                         
<jsp:setProperty name="rel_registro_logJB" property="page" value="${pageContext}"/>                                         
${rel_registro_logJB.execute}                                         
                                                                               
	
<form name="rel_registro_log" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/easynfe/rel_registro_log/rel_registro_logInsert.jsp"/>
    <center>     
     	<label class="msg">${rel_registro_logJB.msg}</label><br/>
	<table width="50%" border="0">
	         <tr>
	<td>
		<label>rel_nr_id:</label>
	</td>
	<td>
		<input type="text" name="rel_registro_logT.rel_nr_id" value="${rel_registro_logJB.rel_registro_logT.rel_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>rel_tx_numeronota:</label>
	</td>
	<td>
		<input type="text" name="rel_registro_logT.rel_tx_numeronota" value="${rel_registro_logJB.rel_registro_logT.rel_tx_numeronota}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>rel_dt_datahora:</label>
	</td>
	<td>
		<input type="text" name="rel_registro_logT.rel_dt_datahora" value="<fmt:formatDate value="${rel_registro_logJB.rel_registro_logT.rel_dt_datahora}" pattern="dd/MM/yyyy HH:mm"/>" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('rel_registro_log','insert', '/nfegen/easynfe/rel_registro_log/rel_registro_logInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('rel_registro_log','clear', '/nfegen/easynfe/rel_registro_log/rel_registro_logInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('rel_registro_log','', '/nfegen/easynfe/rel_registro_log/rel_registro_logConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
