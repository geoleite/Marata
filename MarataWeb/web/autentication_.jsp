<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html" pageEncoding="latin1"%>
<jsp:useBean id="autentication" class="br.com.easynet.easyportal.jb.AutenticationJB" scope="request"/>
<jsp:setProperty name="autentication" property="*"/>
<jsp:setProperty name="autentication" property="page" value="<%=pageContext%>"/>
<jsp:getProperty name="autentication" property="execute"/>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
        <script src="script/eventos.js"></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>MC Sistemas ..::: Portal ::..</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link href="css/model.css" rel="stylesheet" type="text/css" />  
    </head>
    
    
    <body>
        <div class="container">
            <div class="topo">
                
            </div>
            <div class="menu">
            </div>
            <div class="conteudo">
                
                <table width="972" border="0" cellpadding="0" cellspacing="0">
                    <tr valign="top">
                        <td width="617" valign="top" align="center">
                            <div class="space_texto style1"> Slogan </div>
                        </td>
                        <td width="345" align="center">
                            <div class="space_1">
                                <div class="space_topo">      Sistema      </div>
                                <div class="space_corpo">
                                    
                                    
                                    <form action="autentication.jsp" method="post">
                                        <input type="hidden" name="op" value="autenticar"/>
                                        <table width="200px">
                                            <tr>
                                                <td><label>Usuario:</label></td>
                                                <td><input type="text" name="usu_usuarioT.usu_tx_login" onKeyPress="enter(event)"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td><label>Senha:</label></td>
                                                <td><input type="password" name="usu_usuarioT.usu_tx_senha" onKeyPress="enter(event)"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td rowspan="2"><input type="button" value="Enter" onClick="setOp('autenticar')"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td rowspan="2">
                                                    <label>
                                                        Nao lembra senha? Entao clique <a href="gerarSenha.jsp">aqui</a>
                                                    </label>
                                                </td>
                                            </tr>
                                        </table>
                                    </form>  
                                </div>
                                <div class="space_rodape">            </div>
                            </div>
                            
                            
                            <div class="space_2">
                                <div class="space_topo">            </div>
                                <div class="space_corpo">            </div>
                                <div class="space_rodape">            </div>
                            </div>
                            <div class="space_3">
                                <div class="space_topo">            </div>
                                <div class="space_corpo">            </div>
                                <div class="space_rodape">            </div>
                            </div>
                        </td>
                    </tr>
                    <tr valign="top" height="20px">
                        
                    </tr>
                </table>
                
                
            </div>
            <div class="rodape">
            </div>
        </div>
        
    </body>
</html>

