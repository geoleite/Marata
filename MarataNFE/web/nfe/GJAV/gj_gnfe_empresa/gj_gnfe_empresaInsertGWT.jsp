<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="gj_gnfe_empresaJB" class="br.com.i9.marata.jb.Gj_gnfe_empresaInsertJB" scope="request"/>
<jsp:setProperty name="gj_gnfe_empresaJB" property="*"/>
<jsp:setProperty name="gj_gnfe_empresaJB" property="page" value="${pageContext}"/>
${gj_gnfe_empresaJB.execute}
{"resultado":"${gj_gnfe_empresaJB.msg}"}
