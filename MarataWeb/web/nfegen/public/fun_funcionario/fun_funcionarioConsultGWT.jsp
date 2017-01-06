<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="fun_funcionarioJB" class="br.com.easynet.gwt.easyportal.jb.Fun_funcionarioConsultJB" scope="request"/>                                         
<jsp:setProperty name="fun_funcionarioJB" property="*"/>                                         
<jsp:setProperty name="fun_funcionarioJB" property="page" value="${pageContext}"/>                                         
${fun_funcionarioJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${fun_funcionarioJB.list}" var="item">
     ,{	"fun_nr_id":"${item.fun_nr_id}"
 ,	"dis_nr_id":"${item.dis_nr_id}"
  }
</c:forEach>
]}                                                                                
   
