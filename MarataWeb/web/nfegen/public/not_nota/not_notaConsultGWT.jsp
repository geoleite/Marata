<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="not_notaJB" class="br.com.easynet.nfegen.jb.Not_notaConsultJB" scope="request"/>
<jsp:setProperty name="not_notaJB" property="*"/>                                         
<jsp:setProperty name="not_notaJB" property="page" value="${pageContext}"/>                                         
${not_notaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${not_notaJB.list}" var="item">
     ,{	"emp_nr_id":"${item.emp_nr_id}"
 ,	"not_nr_id":"${item.not_nr_id}"
 ,	"not_bt_arquivo":"IMAGEM"
 ,	"not_tx_identificador":"${item.not_tx_identificador}"
 ,	"not_tx_tipo":"${item.not_tx_tipo}"
 ,	"not_tx_cnpjcliente":"${item.not_tx_cnpjcliente}"
 ,	"not_dt_emissao":"<fmt:formatDate value="${item.not_dt_emissao}" pattern="dd/MM/yyyy"/>"
 ,	"dis_nr_id":"${item.dis_nr_id}"
 ,	"not_tx_numero":"${item.not_tx_numero}"
 ,	"not_bln_cancelada":"${item.not_bln_cancelada}"
  }
</c:forEach>
]}                                                                                
   
