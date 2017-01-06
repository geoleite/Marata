<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="dis_distribuidoraJB" class="br.com.easynet.nfegen.jb.Dis_distribuidoraInsertJB" scope="request"/>
<jsp:setProperty name="dis_distribuidoraJB" property="*"/>
<jsp:setProperty name="dis_distribuidoraJB" property="page" value="${pageContext}"/>
${dis_distribuidoraJB.execute}
{"resultado":"${dis_distribuidoraJB.msg}"}
