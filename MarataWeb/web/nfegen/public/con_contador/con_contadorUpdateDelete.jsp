<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="con_contadorJB" class="br.com.easynet.nfegen.jb.Con_contadorUpdateDeleteJB" scope="request"/>
<jsp:setProperty name="con_contadorJB" property="*"/>                                         
<jsp:setProperty name="con_contadorJB" property="page" value="${pageContext}"/>                                         
${con_contadorJB.execute}                                         


<form name="con_contador" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/public/con_contador/con_contadorUpdateDelete.jsp"/>
    <input type="hidden" name="con_contadorT.con_nr_id" value="${con_contadorJB.con_contadorT.con_nr_id}" />
    <center>
        <label class="msg">${con_contadorJB.msg}</label><br/>

        <table align="center" border="0" width="50%">
            <tr>
                <td>
                    <label>Nome:</label>
                </td>
                <td>
                    <input type="text" name="con_contadorT.con_tx_nome" value="${con_contadorJB.con_contadorT.con_tx_nome}" onKeyPress="nextField(this, event)"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>CPF:</label>
                </td>
                <td>
                    <input type="text" name="con_contadorT.con_tx_cpf" value="${con_contadorJB.con_contadorT.con_tx_cpf}" onKeyPress="nextField(this, event)"/>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="Update"  onClick="setOpPortal('con_contador', 'update' , '/nfegen/public/con_contador/con_contadorUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
                    <input type="button" value="Delete"  onClick="setOpPortal('con_contador', 'delete' , '/nfegen/public/con_contador/con_contadorUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
                    <input type="button" value="Voltar" onClick="setOpPortal('con_contador', 'consult', '/nfegen/public/con_contador/con_contadorConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
        </table>

        <br/>

    </center>

</form>
