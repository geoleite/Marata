<jsp:useBean id="report" class="br.com.easynet.nfegen.report.ExemploRelatorio" scope="request"/>
<jsp:setProperty name="report" property="*"/>
<jsp:setProperty name="report" property="page" value="${pageContext}"/>
${report.execute}