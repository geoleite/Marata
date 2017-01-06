<!-- Gerado pelo EasyNet Generate JDragon -->
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<jsp:useBean id="principalPageJB" class="br.com.easynet.easyportal.jb.PrincipalPageJB" scope="request"/>                                         
<jsp:setProperty name="principalPageJB" property="*"/>                                         
<jsp:setProperty name="principalPageJB" property="page" value="${pageContext}"/>                                         
${principalPageJB.execute}                                         
                                          
 
                                    
<form action="principalPage.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <center>     
        <label class="msg">${principalPageJB.msg}</label><br/>
        <h3>Bem vindo ao Portal</h3>
    </center>     
</form>           
