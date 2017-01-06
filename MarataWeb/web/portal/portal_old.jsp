<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="portal" class="br.com.easynet.portal.jb.PortalBaseJB" scope="request"/>
<jsp:setProperty name="portal" property="*"/>
<jsp:setProperty name="portal" property="page" value="${pageContext}"/>
${portal.execute}
<html>
    <head>
        <title>NFEINBOX SOLUCOES LTDA ..::: Portal ::..</title>
        <script src="../script/eventos.js"></script>
        <script src="../script/calendario.js"></script>
        <link href="../css/model.css" rel="stylesheet" type="text/css" />


    </head>


    <body topmargin=0 leftmargin=0 >
        <div id="layer_calendar" style="position:absolute;top:0;left:0;z-index:100"></div>        
        <table border=0 cellSpacing=0 cellPadding=0 width="100%" style="background-image:url(../imagesnfe/topo.gif)">
            <tr>

                <td width="10%"></td>
                <td><img src="../imagesnfe/logo.gif"></td>
                <td width="10%"></td>
                <td><center><br/><br/></center><br/>
                    <div align="center" >
                        <jsp:include page="menu/montaMenu.jsp" flush="true">
                            <jsp:param name="clearop" value="true"/>
                        </jsp:include>

                    </div>

                </td>
                <td width="50%"></td>
            </tr>
        </table>
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr valign="top">
                <td width="100%" valign="top" align="center">
                    
                    <label>Bem Vindo ${portal.usuarioLogado.usu_tx_nome}
                        <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=alterarSenha.jsp">Alterar Senha</a>
                    </label>

                    <table align="center" width="100%" height="100%">
                        <tr>
                            <td align="center" valign="top">
                                ${portal.msg}
                            </td>
                        </tr>
                        <tr>
                            <td align="center" valign="top">
                                
                                    ${portal.montaCanal}
                            </td>
                        </tr>
                    </table>
                    
                </td>
            </tr>
            <tr valign="top" height="20px">

            </tr>
        </table>

        <table border=0 cellSpacing=0 cellPadding=0 width="100%" style="background-image:url(../imagesnfe/rodape.gif)">
            <tr align="center">
                <td width="25%"><br><img src="../imagesnfe/lg3.jpg"><br><br></td>
                <td width="25%"><br><img src="../imagesnfe/lg4.jpg"><br><br></td>
                <td width="25%"><br><img src="../imagesnfe/lg5.jpg"><br><br></td>
                <td width="25%"><br><img src="../imagesnfe/lg6.jpg"><br><br></td>
            </tr>
        </table>
        <center><img src="../imagesnfe/barra.gif"></center>
    </body>
</html>
<!-- -->

