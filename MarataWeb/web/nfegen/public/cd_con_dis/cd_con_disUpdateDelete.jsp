<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="cd_con_disJB" class="br.com.easynet.easynfe.jb.Cd_con_disUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="cd_con_disJB" property="*"/>                                         
<jsp:setProperty name="cd_con_disJB" property="page" value="${pageContext}"/>                                         
${cd_con_disJB.execute}                                         
                                                                                

<form name="cd_con_dis" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/easynfe/cd_con_dis/cd_con_disUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${cd_con_disJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		<tr>
	<td>
		<label>con_nr_id:</label>
	</td>
	<td>
	    <select name="cd_con_disT.con_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${cd_con_disJB.listcon_contador}" var="item">
            	  <option value="${item.con_nr_id}">${item.con_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>dis_nr_id:</label>
	</td>
	<td>
	    <select name="cd_con_disT.dis_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${cd_con_disJB.listdis_distribuidora}" var="item">
            	  <option value="${item.dis_nr_id}">${item.dis_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('cd_con_dis', 'consult', '/nfegen/easynfe/cd_con_dis/cd_con_disConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('cd_con_dis', 'update' , '/nfegen/easynfe/cd_con_dis/cd_con_disUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('cd_con_dis', 'delete' , '/nfegen/easynfe/cd_con_dis/cd_con_disUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('cd_con_dis', 'consult' , '/nfegen/easynfe/cd_con_dis/cd_con_disConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
