<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="rel_registro_logJB" class="br.com.easynet.gwt.easyportal.jb.Rel_registro_logUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="rel_registro_logJB" property="*"/>                                         
<jsp:setProperty name="rel_registro_logJB" property="page" value="${pageContext}"/>                                         
${rel_registro_logJB.execute}                                         
{"resultado":
{"msg":"${rel_registro_logJB.msg}",
     "rel_registro_log":{	"rel_nr_id":"${rel_registro_logJB.rel_registro_logT.rel_nr_id}"
 ,	"rel_tx_numeronota":"${rel_registro_logJB.rel_registro_logT.rel_tx_numeronota}"
 ,	"rel_dt_datahora":"<fmt:formatDate value="${rel_registro_logJB.rel_registro_logT.rel_dt_datahora}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"rel_tx_ip":"${rel_registro_logJB.rel_registro_logT.rel_tx_ip}"
 ,	"dis_nr_id":"${rel_registro_logJB.rel_registro_logT.dis_nr_id}"
 ,	"rel_tx_usuario":"${rel_registro_logJB.rel_registro_logT.rel_tx_usuario}"
  }
    }
     
}                                                                                
   
