<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="not_notaJB" class="br.com.easynet.gwt.easyportal.jb.Not_notaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="not_notaJB" property="*"/>                                         
<jsp:setProperty name="not_notaJB" property="page" value="${pageContext}"/>                                         
${not_notaJB.execute}                                         
{"resultado":
{"msg":"${not_notaJB.msg}",
     "not_nota":{	"emp_nr_id":"${not_notaJB.not_notaT.emp_nr_id}"
 ,	"not_nr_id":"${not_notaJB.not_notaT.not_nr_id}"
 ,	"not_bt_arquivo":"IMAGEM"
 ,	"not_tx_identificador":"${not_notaJB.not_notaT.not_tx_identificador}"
 ,	"not_tx_tipo":"${not_notaJB.not_notaT.not_tx_tipo}"
 ,	"not_tx_cnpjcliente":"${not_notaJB.not_notaT.not_tx_cnpjcliente}"
 ,	"not_dt_emissao":"<fmt:formatDate value="${not_notaJB.not_notaT.not_dt_emissao}" pattern="dd/MM/yyyy"/>"
 ,	"dis_nr_id":"${not_notaJB.not_notaT.dis_nr_id}"
 ,	"not_tx_numero":"${not_notaJB.not_notaT.not_tx_numero}"
 ,	"not_bln_cancelada":"${not_notaJB.not_notaT.not_bln_cancelada}"
  }
    }
     
}                                                                                
   
