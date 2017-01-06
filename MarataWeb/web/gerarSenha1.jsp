<%-- 
    Document   : autentication
    Created on : 08/06/2008, 19:48:34
    Author     : geoleite
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="gerarsenha" class="br.com.easynet.easyportal.jb.GerarSenhaJB" scope="request"/>
<jsp:setProperty name="gerarsenha" property="*"/>
<jsp:setProperty name="gerarsenha" property="page" value="${pageContext}"/>
${gerarsenha.execute}
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
        <script src="script/eventos.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Index</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link href="css/model.css" rel="stylesheet" type="text/css" />  
    </head>
    
    <body> 
        <div id="container">
            <table align="center" width="100%" cellpadding="0" cellspacing="0" border="0">
                <tr>
                    <td id="topo" align="center" valign="middle">
                    </td>
                </tr>
                <tr>
                    <td>
                        <div id="subtopo_menu">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td align="center" valign="top" id="conteudo">
                        
                        
                            <h3> Form Password Generate </h3>
                            <form action="gerarSenha.jsp" method="post">
                                <input type="hidden" name="op" value="gerarNovaSenha"/>
                                <label class="errorMessage">${gerarsenha.msg}</label>
                                <table width="200px">
                                    <tr>
                                        <td><label>Username:</label></td>
                                        <td><input type="text" name="usu_usuarioT.usu_tx_login" onkeypress="enter(event)"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" align="center"><input type="button" value="Generate" onclick="setOp('gerarNovaSenha')"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" align="center">
                                            <label>Volta ao Login</label> <a href="autentication.jsp">Voltar</a>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div id="rodape">
                            <table width="100%" height="100%" border="0">
                                <tr>
                                    <td align="center" valign="middle">
                                    </td>
                                </tr>
                                <tr>
                                    <td align="center" valign="middle">
                                        <label>Contato: contato@geoleite.com.br</label>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>                    
