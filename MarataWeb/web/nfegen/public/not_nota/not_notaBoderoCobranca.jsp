<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="not_notaJB" class="br.com.easynet.nfegen.jb.Not_notaConsultCobracaJB" scope="request"/>
<jsp:setProperty name="not_notaJB" property="*"/>
<jsp:setProperty name="not_notaJB" property="page" value="${pageContext}"/>
${not_notaJB.execute}

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bodero Cobranca</title>
    </head>
    <body>

    <label style="color:red" align="center">${not_notaJB.msg} </label>

    <table width="700"  border="1" cellpadding="3" cellspacing="0" style="border-style: hidden ; color:#000000; border-left-style:hidden ; border-right-style:hidden; border-top-style:hidden; border-bottom-style:hidden;">
        <tr>
            <td>
                <div align="center">
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" style="border-style: hidden ; color:#000000; border-left-style:hidden ; border-right-style:hidden; border-top-style:hidden; border-bottom-style:hidden"s>
                        <tr>
                            <td><img src="../imagesnfe/3d.png" s/></td>
                            <td><font face="verdana" size="+1"><strong>NFE INBOX - SOLUCOES LTDA</strong></font><br><font face="verdana" size="-1">AV. PEDRO CALAZANS, 978 - GALERIA VILLAS BOAS - SALA 15<BR>BAIRRO: GETULIO VARGAS CEP: 49.055-520<br>ARACAJU-SE TELEFONE:79-3041-7976<br>E-MAIL: nfeinbox@nfeinbox.com.br</font></td>
                        </tr>
                    </table>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <div align="center">
                    <font face="verdana" size="-1"><b>EXTRATO DE ARMAZENAMENTO</b></font>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <font face="verdana" size="-1"><b>CLIENTE:</b> ${not_notaJB.dis_distribuidoraT.dis_tx_nome} <BR><b>CNPJ:</b> ${not_notaJB.dis_distribuidoraT.dis_tx_cnpj}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>E-MAIL: </b>${not_notaJB.usu_usuarioT.usu_tx_email} <BR>
                    <c:if test="${not_notaJB.datainicial != ''}">
                        <b>PERIODO:</b> ${not_notaJB.datainicial} E ${not_notaJB.datafinal}
                    </c:if>
                    <c:if test="${not_notaJB.datainicial == ''}">
                        <b>PERIODO:</b> TODO O PERIODO
                    </c:if>
                </font>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <font face="verdana" size="-1"><b>NOTA INICIAL:</b>${not_notaJB.notaInicial}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>NOTA FINAL:</b>${not_notaJB.notaFinal}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>TOTAL PERIODO:</b>${not_notaJB.nrTotalNotas}</font>
            </td>
        </tr>
        <!--tr>
                <td colspan="2">
                    <font face="verdana" size="-1"><b>TOTAL DE CLIENTES ARMAZENADOS:</b></font>
                </td>
        </tr-->
        <tr>
            <td colspan="2">
                <font face="verdana" size="-1"><b>TOTAL NOTAS ARMAZENADAS: ${not_notaJB.nrTotalNotasGeral}</b></font>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <div align="center">
                    <font face="verdana" size="-1"><b>LISTA DE AUSENTES "NAO ENVIADAS"</b></font>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <table border="1" width="100%" cellpadding="0" cellspacing="0" style="border-style: hidden ; color:#000000; border-left-style:hidden ; border-right-style:hidden; border-top-style:hidden; border-bottom-style:hidden">
                    <c:if test="${not_notaJB.achou == false}">
                        <tr>
                            <td>
                                <div align="center">
                                    Notas nao encontradas
                                </div>
                            </td>

                        </tr>
                    </c:if>
                    ${not_notaJB.notasAusentes}
                </table>
                <table border="1" width="100%" cellpadding="0" cellspacing="0" style="border-style: hidden ; color:#000000; border-left-style:hidden ; border-right-style:hidden; border-top-style:hidden; border-bottom-style:hidden">
                    <tr>
                        <td colspan="5">
                            <div align="center">
                                <font face="verdana" size="-1"><b>LISTA DE DATAS EM "ABERTO"</b></font>
                            </div>
                        </td>
                    </tr>
                    <c:if test="${not_notaJB.achouNotasSemData == false}">
                        <tr>
                            <td>
                                <div align="center">
                                    N�o h� datas em aberto.
                                </div>
                            </td>

                        </tr>
                    </c:if>
                    ${not_notaJB.datasEmAberto}
                </table>

            </td>
        </tr>

    </table>
</html>
