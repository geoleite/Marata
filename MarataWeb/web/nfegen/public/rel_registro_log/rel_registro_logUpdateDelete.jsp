<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="rel_registro_logJB" class="br.com.easynet.nfegen.jb.Rel_registro_logUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="rel_registro_logJB" property="*"/>                                         
<jsp:setProperty name="rel_registro_logJB" property="page" value="${pageContext}"/>                                         
${rel_registro_logJB.execute}                                         
                                                                                

<form name="rel_registro_log" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/easynfe/rel_registro_log/rel_registro_logUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${rel_registro_logJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
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
		<input type="button" value="Consult" onClick="setOpPortal('rel_registro_log', 'consult', '/nfegen/easynfe/rel_registro_log/rel_registro_logConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('rel_registro_log', 'update' , '/nfegen/easynfe/rel_registro_log/rel_registro_logUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('rel_registro_log', 'delete' , '/nfegen/easynfe/rel_registro_log/rel_registro_logUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('rel_registro_log', 'consult' , '/nfegen/easynfe/rel_registro_log/rel_registro_logConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
