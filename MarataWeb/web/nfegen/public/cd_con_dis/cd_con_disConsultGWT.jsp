<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cd_con_disJB" class="br.com.easynet.gwt.easyportal.jb.Cd_con_disConsultJB" scope="request"/>                                         
<jsp:setProperty name="cd_con_disJB" property="*"/>                                         
<jsp:setProperty name="cd_con_disJB" property="page" value="${pageContext}"/>                                         
${cd_con_disJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${cd_con_disJB.list}" var="item">
     ,{	"con_nr_id":"${item.con_nr_id}"
 ,	"dis_nr_id":"${item.dis_nr_id}"
  }
</c:forEach>
]}                                                                                
   
