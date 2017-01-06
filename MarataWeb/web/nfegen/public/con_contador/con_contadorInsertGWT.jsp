<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="con_contadorJB" class="br.com.easynet.nfegen.jb.Con_contadorInsertJB" scope="request"/>
<jsp:setProperty name="con_contadorJB" property="*"/>
<jsp:setProperty name="con_contadorJB" property="page" value="${pageContext}"/>
${con_contadorJB.execute}
{"resultado":"${con_contadorJB.msg}"}
