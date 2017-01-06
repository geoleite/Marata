<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="gnfe_cliente_fornecedorJB" class="br.com.i9.marata.jb.Gnfe_cliente_fornecedorUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="gnfe_cliente_fornecedorJB" property="*"/>                                         
<jsp:setProperty name="gnfe_cliente_fornecedorJB" property="page" value="${pageContext}"/>                                         
${gnfe_cliente_fornecedorJB.execute}                                         
{"resultado":
{"msg":"${gnfe_cliente_fornecedorJB.msg}",
     "gnfe_cliente_fornecedor":{	"codigo":"${gnfe_cliente_fornecedorJB.gnfe_cliente_fornecedorT.codigo}"
 ,	"razao":"${gnfe_cliente_fornecedorJB.gnfe_cliente_fornecedorT.razao}"
 ,	"status":"${gnfe_cliente_fornecedorJB.gnfe_cliente_fornecedorT.status}"
 ,	"num_cgc_cpf":"${gnfe_cliente_fornecedorJB.gnfe_cliente_fornecedorT.num_cgc_cpf}"
 ,	"tipo":"${gnfe_cliente_fornecedorJB.gnfe_cliente_fornecedorT.tipo}"
  }
    }
     
}                                                                                
   
