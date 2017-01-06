<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="cd_con_disJB" class="br.com.easynet.gwt.easyportal.jb.Cd_con_disInsertJB" scope="request"/>
<jsp:setProperty name="cd_con_disJB" property="*"/>
<jsp:setProperty name="cd_con_disJB" property="page" value="${pageContext}"/>
${cd_con_disJB.execute}
{"resultado":"${cd_con_disJB.msg}"}
