<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="con_contadorJB" class="br.com.easynet.nfegen.jb.Con_contadorUpdateDeleteJB" scope="request"/>
<jsp:setProperty name="con_contadorJB" property="*"/>                                         
<jsp:setProperty name="con_contadorJB" property="page" value="${pageContext}"/>                                         
${con_contadorJB.execute}                                         
{"resultado":
{"msg":"${con_contadorJB.msg}",
     "con_contador":{	"con_nr_id":"${con_contadorJB.con_contadorT.con_nr_id}"
 ,	"con_tx_cpf":"${con_contadorJB.con_contadorT.con_tx_cpf}"
 ,	"con_tx_nome":"${con_contadorJB.con_contadorT.con_tx_nome}"
  }
    }
     
}                                                                                
   
