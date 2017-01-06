<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="resetSenhaJB" class="br.com.easynet.easyportal.jb.ResetSenhaJB" scope="request"/>
<jsp:setProperty name="resetSenhaJB" property="*"/>
<jsp:setProperty name="resetSenhaJB" property="page" value="${pageContext}"/>
${resetSenhaJB.execute}
{"resultado":"${usu_usuarioJB.msg}"}