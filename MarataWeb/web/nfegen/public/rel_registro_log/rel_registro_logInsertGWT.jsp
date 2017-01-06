<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="rel_registro_logJB" class="br.com.easynet.gwt.easyportal.jb.Rel_registro_logInsertJB" scope="request"/>
<jsp:setProperty name="rel_registro_logJB" property="*"/>
<jsp:setProperty name="rel_registro_logJB" property="page" value="${pageContext}"/>
${rel_registro_logJB.execute}
{"resultado":"${rel_registro_logJB.msg}"}
