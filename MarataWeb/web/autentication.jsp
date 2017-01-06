<jsp:useBean id="autentication" class="br.com.easynet.easyportal.jb.AutenticationJB" scope="request"/>
<jsp:setProperty name="autentication" property="*"/>
<jsp:setProperty name="autentication" property="page" value="<%=pageContext%>"/>
<jsp:getProperty name="autentication" property="execute"/>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <title>NFE - inbox</title>
        <script src="script/eventos.js"></script>

        <link href="/css/style.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript">
            var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
            document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
        </script>
        <script type="text/javascript">
            try {
                var pageTracker = _gat._getTracker("UA-11907454-1");
                pageTracker._trackPageview();
            } catch(err) {}</script>
        <script src="/Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
        <script src="/Scripts/swfobject_modified.js" type="text/javascript"></script>
        <style type="text/css">
            <!--
            #conteudo #sistema #sistema_1 #logar table {
                font-family: Arial, Helvetica, sans-serif;
                font-size: 12px;
            }
            -->
        </style>

    </head>

    <body>
        <div id="conteudo">
            <div id="banner_1">
                <object id="FlashID" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="874" height="121">
                    <param name="movie" value="/flash/banner_1.swf" />
                    <param name="quality" value="high" />

                    <param name="swfversion" value="6.0.65.0" />
                    <!-- Esta tag param solicita que os usuários com o Flash Player 6.0 r65 e versões posteriores baixem a versão mais recente do Flash Player. Exclua-o se você não deseja que os usuários vejam o prompt. -->
                    <param name="expressinstall" value="/Scripts/expressInstall.swf" />

                    <param name="wmode" value="transparent" />
                    <!-- A tag object a seguir aplica-se a navegadores que não sejam o IE. Portanto, oculte-a do IE usando o IECC. -->
                    <!--[if !IE]>-->
                    <object type="application/x-shockwave-flash" data="/flash/banner_1.swf" width="874" height="121">
                        <!--<![endif]-->
                        <param name="quality" value="high" />
                        <param name="swfversion" value="6.0.65.0" />
                        <param name="expressinstall" value="/Scripts/expressInstall.swf" />
                        <param name="wmode" value="transparent" />

                        <!-- O navegador exibe o seguinte conteúdo alternativo para usuários que tenham o Flash Player 6.0 e versões anteriores. -->
                        <div>
                            <h4>O conte&uacute;do desta p&aacute;gina requer uma vers&atilde;o mais recente do Adobe Flash Player.</h4>
                            <p><a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Obter Adobe Flash player" width="112" height="33" /></a></p>
                        </div>
                        <!--[if !IE]>-->
                    </object>

                    <!--<![endif]-->
                </object>

            </div>
            <div id="base">
                <iframe src="/galeria.htm" scrolling="no" frameborder="0" width="874" height="362"></iframe>
            </div>
            <div id="rodape">

                <img src="/img/rodape.png" width="874" height="53" /></div>

            <div id="sistema">
                <table width="100%" border="0" cellspacing="2" cellpadding="2">
                    <tr>
                        <td width="48%"><div id="sistema_1">
                                
                                <form id="logar" name="logar" method="post" action="autentication.jsp">
                                    <input type="hidden" name="op" value="autenticar"/>
                                    <table width="90%" border="0" align="left" cellpadding="2" cellspacing="2">
                                        <tr>
                                            <td align="center" colspan="2"><label style="color:red;font-size:10px">${autentication.msg}</label>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td height="55">&nbsp;</td>
                                            <td>&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td align="right" >Usu&aacute;rio:</td>

                                            <td><label>
                                                    <input type="text" name="usu_usuarioT.usu_tx_login" id="usu_usuarioT.usu_tx_login" size="10"/>
                                                </label></td>
                                        </tr>
                                        <tr>
                                            <td align="right">Senha:</td>
                                            <td><label>
                                                    <input type="password" name="usu_usuarioT.usu_tx_senha" id="usu_usuarioT.usu_tx_senha" size="10"/>

                                                </label></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2"> <label style="font-size:10px"><a href="gerarSenha.jsp">Esqucei a senha? </a></label>
                                                &nbsp;&nbsp;&nbsp;
                                            <input type="submit" name="entrar" id="entrar" value="Entrar" /></td>
                                        </tr>
                                        <tr>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>

                                        </tr>
                                    </table>
                                </form>
                            </div></td>
                        <td width="52%"><img src="/images/sistema2.png" width="253" height="183" /></td>
                    </tr>
                </table>
            </div>
        </div>

        <script type="text/javascript">
            <!--
            swfobject.registerObject("FlashID");
            //-->
        </script>
    </body>
</html>
