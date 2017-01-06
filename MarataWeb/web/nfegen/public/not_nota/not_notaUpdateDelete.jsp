<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="not_notaJB" class="br.com.easynet.nfegen.jb.Not_notaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="not_notaJB" property="*"/>                                         
<jsp:setProperty name="not_notaJB" property="page" value="${pageContext}"/>                                         
${not_notaJB.execute}                                         
                                                                                

<form name="not_nota" action="portal.jsp" method="post" enctype="multipart/form-data" >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/public/not_nota/not_notaUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${not_notaJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		<tr>
	<td>
		<label>emp_nr_id:</label>
	</td>
	<td>
	    <select name="not_notaT.emp_nr_id">
         	<c:forEach items="${not_notaJB.listemp_empresa}" var="item">
            	  <option value="${item.emp_nr_id}">${item.emp_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>not_nr_id:</label>
	</td>
	<td>
		<input type="text" name="not_notaT.not_nr_id" value="${not_notaJB.not_notaT.not_nr_id}"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>not_tx_arquivo:</label>
	</td>
	<td>
		<input type="file" name="not_notaT.not_tx_arquivo" value=""/> <img border="0" src="not_notaUpdateDelete.jsp?op=downloadImage&not_notaT.emp_nr_id=${not_notaJB.not_notaT.emp_nr_id}&not_notaT.not_nr_id=${not_notaJB.not_notaT.not_nr_id}&not_notaT.dis_nr_id=${not_notaJB.not_notaT.dis_nr_id}&"/>
	</td>
     </tr>
     <tr>
	<td>
		<label>not_tx_identificador:</label>
	</td>
	<td>
		<input type="text" name="not_notaT.not_tx_identificador" value="${not_notaJB.not_notaT.not_tx_identificador}"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>not_tx_tipo:</label>
	</td>
	<td>
		<input type="text" name="not_notaT.not_tx_tipo" value="${not_notaJB.not_notaT.not_tx_tipo}"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>not_tx_cnpjcliente:</label>
	</td>
	<td>
		<input type="text" name="not_notaT.not_tx_cnpjcliente" value="${not_notaJB.not_notaT.not_tx_cnpjcliente}"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>emp_nr_id:</label>
	</td>
	<td>
	    <select name="not_notaT.emp_nr_id">
         	<c:forEach items="${not_notaJB.listemp_empresa}" var="item">
            	  <option value="${item.emp_nr_id}">${item.emp_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('not_nota', 'consult', '/nfegen/public/not_nota/not_notaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('not_nota', 'update' , '/nfegen/public/not_nota/not_notaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('not_nota', 'delete' , '/nfegen/public/not_nota/not_notaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('not_nota', 'consult' , '/nfegen/public/not_nota/not_notaConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
