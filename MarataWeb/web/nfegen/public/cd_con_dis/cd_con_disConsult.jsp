<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="cd_con_disJB" class="br.com.easynet.easynfe.jb.Cd_con_disConsultJB" scope="request"/>                                         
<jsp:setProperty name="cd_con_disJB" property="*"/>                                         
<jsp:setProperty name="cd_con_disJB" property="page" value="${pageContext}"/>                                         
${cd_con_disJB.execute}                                         
                                                                                

<form name="cd_con_dis" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/easynfe/cd_con_dis/cd_con_disConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${cd_con_disJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('cd_con_dis','', '/nfegen/easynfe/cd_con_dis/cd_con_disInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('cd_con_dis','consult', '/nfegen/easynfe/cd_con_dis/cd_con_disConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${cd_con_disJB.list}"  pagesize="10" requestURI="/nfegen/cd_con_dis/cd_con_disConsult.jsp?clearop=true">

		<display:column sortable="false" title="Con_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/easynfe/cd_con_dis/cd_con_disUpdateDelete.jsp&op=findbyid&cd_con_disT.con_nr_id=${item.con_nr_id}&cd_con_disT.dis_nr_id=${item.dis_nr_id}&">
      		<c:out value="${item.con_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Dis_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/easynfe/cd_con_dis/cd_con_disUpdateDelete.jsp&op=findbyid&cd_con_disT.con_nr_id=${item.con_nr_id}&cd_con_disT.dis_nr_id=${item.dis_nr_id}&">
      		<c:out value="${item.dis_nr_id}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('cd_con_dis','delete', '/nfegen/easynfe/cd_con_dis/cd_con_disConsult.jsp?cd_con_disT.con_nr_id=${item.con_nr_id}&cd_con_disT.dis_nr_id=${item.dis_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
