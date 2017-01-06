<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="dis_distribuidoraJB" class="br.com.easynet.nfegen.jb.Dis_distribuidoraUpdateDeleteJB" scope="request"/>
<jsp:setProperty name="dis_distribuidoraJB" property="*"/>                                         
<jsp:setProperty name="dis_distribuidoraJB" property="page" value="${pageContext}"/>                                         
${dis_distribuidoraJB.execute}                                         
{"resultado":
{"msg":"${dis_distribuidoraJB.msg}",
     "dis_distribuidora":{	"dis_nr_id":"${dis_distribuidoraJB.dis_distribuidoraT.dis_nr_id}"
 ,	"dis_tx_nome":"${dis_distribuidoraJB.dis_distribuidoraT.dis_tx_nome}"
 ,	"dis_tx_cnpj":"${dis_distribuidoraJB.dis_distribuidoraT.dis_tx_cnpj}"
 ,	"dis_nr_id_super":"${dis_distribuidoraJB.dis_distribuidoraT.dis_nr_id_super}"
 ,	"dis_tx_status":"${dis_distribuidoraJB.dis_distribuidoraT.dis_tx_status}"
  }
    }
     
}                                                                                
   
