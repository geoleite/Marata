<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="con_contadorJB" class="br.com.easynet.nfegen.jb.Con_contadorConsultJB" scope="request"/>
<jsp:setProperty name="con_contadorJB" property="*"/>                                         
<jsp:setProperty name="con_contadorJB" property="page" value="${pageContext}"/>                                         
${con_contadorJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${con_contadorJB.list}" var="item">
     ,{	"con_nr_id":"${item.con_nr_id}"
 ,	"con_tx_cpf":"${item.con_tx_cpf}"
 ,	"con_tx_nome":"${item.con_tx_nome}"
  }
</c:forEach>
]}                                                                                
   
