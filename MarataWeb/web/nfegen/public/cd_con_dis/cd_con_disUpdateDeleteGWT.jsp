<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cd_con_disJB" class="br.com.easynet.gwt.easyportal.jb.Cd_con_disUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="cd_con_disJB" property="*"/>                                         
<jsp:setProperty name="cd_con_disJB" property="page" value="${pageContext}"/>                                         
${cd_con_disJB.execute}                                         
{"resultado":
{"msg":"${cd_con_disJB.msg}",
     "cd_con_dis":{	"con_nr_id":"${cd_con_disJB.cd_con_disT.con_nr_id}"
 ,	"dis_nr_id":"${cd_con_disJB.cd_con_disT.dis_nr_id}"
  }
    }
     
}                                                                                
   
