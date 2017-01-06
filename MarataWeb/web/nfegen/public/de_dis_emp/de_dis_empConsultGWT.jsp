<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="de_dis_empJB" class="br.com.easynet.gwt.easyportal.jb.De_dis_empConsultJB" scope="request"/>                                         
<jsp:setProperty name="de_dis_empJB" property="*"/>                                         
<jsp:setProperty name="de_dis_empJB" property="page" value="${pageContext}"/>                                         
${de_dis_empJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${de_dis_empJB.list}" var="item">
     ,{	"dis_nr_id":"${item.dis_nr_id}"
 ,	"emp_nr_id":"${item.emp_nr_id}"
  }
</c:forEach>
]}                                                                                
   
