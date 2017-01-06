<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="fun_funcionarioJB" class="br.com.easynet.gwt.easyportal.jb.Fun_funcionarioUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="fun_funcionarioJB" property="*"/>                                         
<jsp:setProperty name="fun_funcionarioJB" property="page" value="${pageContext}"/>                                         
${fun_funcionarioJB.execute}                                         
{"resultado":
{"msg":"${fun_funcionarioJB.msg}",
     "fun_funcionario":{	"fun_nr_id":"${fun_funcionarioJB.fun_funcionarioT.fun_nr_id}"
 ,	"dis_nr_id":"${fun_funcionarioJB.fun_funcionarioT.dis_nr_id}"
  }
    }
     
}                                                                                
   
