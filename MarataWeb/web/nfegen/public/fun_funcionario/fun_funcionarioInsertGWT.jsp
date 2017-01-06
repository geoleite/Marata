<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="fun_funcionarioJB" class="br.com.easynet.gwt.easyportal.jb.Fun_funcionarioInsertJB" scope="request"/>
<jsp:setProperty name="fun_funcionarioJB" property="*"/>
<jsp:setProperty name="fun_funcionarioJB" property="page" value="${pageContext}"/>
${fun_funcionarioJB.execute}
{"resultado":"${fun_funcionarioJB.msg}"}
