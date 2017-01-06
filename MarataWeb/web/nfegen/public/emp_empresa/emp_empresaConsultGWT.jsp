<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="emp_empresaJB" class="br.com.easynet.nfegen.jb.Emp_empresaConsultJB" scope="request"/>
<jsp:setProperty name="emp_empresaJB" property="*"/>                                         
<jsp:setProperty name="emp_empresaJB" property="page" value="${pageContext}"/>                                         
${emp_empresaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${emp_empresaJB.list}" var="item">
     ,{	"emp_nr_id":"${item.emp_nr_id}"
 ,	"emp_tx_nome":"${item.emp_tx_nome}"
 ,	"emp_tx_cnpj":"${item.emp_tx_cnpj}"
 ,	"emp_tx_estado":"${item.emp_tx_estado}"
 ,	"emp_tx_cidade":"${item.emp_tx_cidade}"
 ,	"emp_tx_bairro":"${item.emp_tx_bairro}"
 ,	"emp_tx_endereco":"${item.emp_tx_endereco}"
 ,	"emp_tx_cep":"${item.emp_tx_cep}"
 ,	"emp_tx_ie":"${item.emp_tx_ie}"
 ,	"emp_nr_id_super":"${item.emp_nr_id_super}"
  }
</c:forEach>
]}                                                                                
   
