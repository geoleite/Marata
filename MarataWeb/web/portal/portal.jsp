<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="portal" class="br.com.easynet.portal.jb.PortalBaseJB" scope="request"/>
<jsp:setProperty name="portal" property="*"/>
<jsp:setProperty name="portal" property="page" value="${pageContext}"/>
${portal.execute}
<%@page contentType="text/html" pageEncoding="latin1"%>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>EasyPortal</title>
        <meta http-equiv="Content-Type" content="text/html; charset=latin1" />
        <!--style type="text/css">td img {display: block;}</style-->
        <script src="../script/eventos.js"></script>
        <script src="../script/calendario.js"></script>
        <script type="text/javascript">var dmWorkPath="menu.files/";</script>
        <script type="text/javascript" src="menu.files/dmenu.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>...::EasyPortal::...</title>

        <link href="../css/displaytag.css" rel="stylesheet" type="text/css" />
        <link href="../css/model.css" rel="stylesheet" type="text/css" />
        <style type="text/css">
            * {
                margin: 0 0 0 0;
            }
            #topo {
                width:100%;
                height:90px;
                background-image:url(../images/logo_fundo.jpg);
                text-align:left;
            }
            #out {
                width:100%;
                height:74px;
                background:url(../images/meio.jpg);
            }
            #propag {
                width:100%;
                height:100px;
                background:#E4E0D0;
                text-align:center;
            }
            #rodape {
                width:100%;
                height:28px;
                text-align:center;
            }
            #propag table {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr style="background-image:url(../images/logo_fundo.jpg);">
                <td width="32%"><img src="../images/logo.jpg"/></td>

                <td colspan="3" valign="top" align="center">
                    <br/>
                    <script type="text/javascript" src="menu/montaMenu2.jsp"></script>
                    <br/>
                    <label style="color:black;font-size:14">Bem Vindo ${portal.usuarioLogado.usu_tx_nome}&nbsp;&nbsp;
                        <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=alterarSenha.jsp" style="color:red;font-size:14">Alterar Senha</a>
                    </label>
                </td>

            </tr>
            <tr>
                <td bgcolor="#E3E0D1" colspan="4" >
                    <!--img src="../images/meio.jpg" width="100%"/-->
                    <div id="layer_calendar" style="position:absolute;top:0;left:0;z-index:100"></div>
                    <label class="warnMessage">${autentication.msg}</label>
                    <table align="center" width="100%" height="100%">
                        <tr>
                            <td align="center" height="5" valign="top" style="background-image:url(../images/meio.jpg);">
                                ${portal.msg}
                            </td>
                        </tr>
                        <tr>
                            <td align="center" valign="top">
                                ${portal.montaCanal}
                            </td>
                        </tr>
                    </table>
                            <br/>
                </td>
            </tr>
            <tr bgcolor="#E3E0D1">
                <td align="right"><img src="../images/banner.jpg" width="167" height="80" /></td>
                <td align="center"><img src="../images/banner2.jpg" width="167" height="80" /></td>
                <td align="center"><img src="../images/banner3.jpg" width="167" height="80" /></td>
                <td align="left"> <img src="../images/banner4.jpg" width="167" height="80" /></td>

            </tr>
            <tr>
                <td colspan="4" align="center"><img src="../images/assinatura.jpg"/></td>
            </tr>
        </table>

    </body>

</html>


<script>
    // Redirecionador de Páginas
    <%
            String redirect = (String) session.getAttribute(br.com.easynet.easyportal.jb.SystemBase.REDIRECT_SESSION);
            session.removeAttribute(br.com.easynet.easyportal.jb.SystemBase.REDIRECT_SESSION);
            redirect = redirect == null ? "" : redirect;
    %>
        var redirect = '<%=redirect%>';
        if (redirect.length > 0) {
            document.location= redirect;
        }
</script>

