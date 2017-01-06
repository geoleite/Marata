<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html" pageEncoding="latin1"%>
<jsp:useBean id="gerarsenha" class="br.com.easynet.easyportal.jb.GerarSenhaJB" scope="request"/>
<jsp:setProperty name="gerarsenha" property="*"/>
<jsp:setProperty name="gerarsenha" property="page" value="<%=pageContext%>"/>
<jsp:getProperty name="gerarsenha" property="execute"/>
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
                                <div class="space_topo">      Criar Nova Senha      </div>
                                <div class="space_corpo">
                                    
                                    <form action="gerarSenha.jsp" method="post">
                                        <input type="hidden" name="op" value="gerarNovaSenha"/>
                                        <label class="errorMessage">${gerarsenha.msg}</label>
                                        <table width="200px">
                                            <tr>
                                                <label style="font-size:10px">Uma nova senha será enviada para o email.</label>
                                                <td><label>Usuário:</label></td>
                                                <td><input type="text" size="10" name="usu_usuarioT.usu_tx_login" onkeypress="enter(event)"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="2" align="center"><input type="button" value="Criar Nova Senha" onclick="setOp('gerarNovaSenha')"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="2" align="center">
                                                    <label>Volta ao Login</label> <a href="autentication.jsp">Voltar</a>
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

