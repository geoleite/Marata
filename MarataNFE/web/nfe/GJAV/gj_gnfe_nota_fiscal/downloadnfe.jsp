<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="gj_gnfe_nota_fiscalJB" class="br.com.i9.marata.jb.Gj_gnfe_nota_fiscalUpdateDeleteJB" scope="request"/>
<jsp:setProperty name="gj_gnfe_nota_fiscalJB" property="*"/>
<jsp:setProperty name="gj_gnfe_nota_fiscalJB" property="page" value="${pageContext}"/>
${gj_gnfe_nota_fiscalJB.execute}