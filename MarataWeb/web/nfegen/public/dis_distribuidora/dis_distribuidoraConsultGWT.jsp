<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="dis_distribuidoraJB" class="br.com.easynet.nfegen.jb.Dis_distribuidoraConsultJB" scope="request"/>
<jsp:setProperty name="dis_distribuidoraJB" property="*"/>                                         
<jsp:setProperty name="dis_distribuidoraJB" property="page" value="${pageContext}"/>                                         
${dis_distribuidoraJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${dis_distribuidoraJB.list}" var="item">
     ,{	"dis_nr_id":"${item.dis_nr_id}"
 ,	"dis_tx_nome":"${item.dis_tx_nome}"
 ,	"dis_tx_cnpj":"${item.dis_tx_cnpj}"
 ,	"dis_nr_id_super":"${item.dis_nr_id_super}"
 ,	"dis_tx_status":"${item.dis_tx_status}"
  }
</c:forEach>
]}                                                                                
   
