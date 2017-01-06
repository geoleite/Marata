<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="de_dis_empJB" class="br.com.easynet.gwt.easyportal.jb.De_dis_empInsertJB" scope="request"/>
<jsp:setProperty name="de_dis_empJB" property="*"/>
<jsp:setProperty name="de_dis_empJB" property="page" value="${pageContext}"/>
${de_dis_empJB.execute}
{"resultado":"${de_dis_empJB.msg}"}
