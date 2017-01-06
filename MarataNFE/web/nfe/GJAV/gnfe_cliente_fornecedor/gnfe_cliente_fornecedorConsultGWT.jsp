<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="gnfe_cliente_fornecedorJB" class="br.com.i9.marata.jb.Gnfe_cliente_fornecedorConsultJB" scope="request"/>                                         
<jsp:setProperty name="gnfe_cliente_fornecedorJB" property="*"/>                                         
<jsp:setProperty name="gnfe_cliente_fornecedorJB" property="page" value="${pageContext}"/>                                         
${gnfe_cliente_fornecedorJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${gnfe_cliente_fornecedorJB.list}" var="item">
     ,{	"codigo":"${item.codigo}"
 ,	"razao":"${item.razao}"
 ,	"status":"${item.status}"
 ,	"num_cgc_cpf":"${item.num_cgc_cpf}"
 ,	"tipo":"${item.tipo}"
  }
</c:forEach>
]}                                                                                
   
