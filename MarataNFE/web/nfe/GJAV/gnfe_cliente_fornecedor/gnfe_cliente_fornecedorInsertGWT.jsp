<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="gnfe_cliente_fornecedorJB" class="br.com.i9.marata.jb.Gnfe_cliente_fornecedorInsertJB" scope="request"/>
<jsp:setProperty name="gnfe_cliente_fornecedorJB" property="*"/>
<jsp:setProperty name="gnfe_cliente_fornecedorJB" property="page" value="${pageContext}"/>
${gnfe_cliente_fornecedorJB.execute}
{"resultado":"${gnfe_cliente_fornecedorJB.msg}"}
