<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="not_notaJB" class="br.com.easynet.nfegen.jb.Not_notaInsertJB" scope="request"/>
<jsp:setProperty name="not_notaJB" property="*"/>
<jsp:setProperty name="not_notaJB" property="page" value="${pageContext}"/>
${not_notaJB.execute}
{"resultado":"${not_notaJB.msg}"}
