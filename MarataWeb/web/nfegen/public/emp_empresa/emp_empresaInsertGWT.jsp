<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="emp_empresaJB" class="br.com.easynet.nfegen.jb.Emp_empresaInsertJB" scope="request"/>
<jsp:setProperty name="emp_empresaJB" property="*"/>
<jsp:setProperty name="emp_empresaJB" property="page" value="${pageContext}"/>
${emp_empresaJB.execute}
{"resultado":"${emp_empresaJB.msg}"}
