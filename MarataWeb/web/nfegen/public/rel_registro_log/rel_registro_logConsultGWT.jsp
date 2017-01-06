<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="rel_registro_logJB" class="br.com.easynet.gwt.easyportal.jb.Rel_registro_logConsultJB" scope="request"/>                                         
<jsp:setProperty name="rel_registro_logJB" property="*"/>                                         
<jsp:setProperty name="rel_registro_logJB" property="page" value="${pageContext}"/>                                         
${rel_registro_logJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${rel_registro_logJB.list}" var="item">
     ,{	"rel_nr_id":"${item.rel_nr_id}"
 ,	"rel_tx_numeronota":"${item.rel_tx_numeronota}"
 ,	"rel_dt_datahora":"<fmt:formatDate value="${item.rel_dt_datahora}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"rel_tx_ip":"${item.rel_tx_ip}"
 ,	"dis_nr_id":"${item.dis_nr_id}"
 ,	"rel_tx_usuario":"${item.rel_tx_usuario}"
  }
</c:forEach>
]}                                                                                
   
