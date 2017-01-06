<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="con_contadorJB" class="br.com.easynet.nfegen.jb.Con_contadorDistribuidoraConsultJB" scope="request"/>
<jsp:setProperty name="con_contadorJB" property="*"/>
<jsp:setProperty name="con_contadorJB" property="page" value="${pageContext}"/>
${con_contadorJB.execute}


<form name="con_contador" action="portal.jsp" method="post">
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/public/con_contador/con_contadorConsult.jsp"/>
    <div align="center">
        <label class="msg" align="center">${con_contadorJB.msg} </label>
        <br/>


        <hr/>

        <table width="30%">
            <tr>
                <td colspan="2"><h3 align="center">Dados da Distribuidora</h3></td>
            </tr>
            <tr>
                <td>
                    <label>Distribuidora:</label>
                </td>
                <td>
                    <label>${con_contadorJB.dis_distribuidoraT.dis_tx_nome}</label>
                </td>
            </tr>
            <tr>
                <td colspan="2"><h3 align="center">Definir Contador</h3></td>
            </tr>
            <tr>
                <td>
                    <label>Contador:</label>
                </td>
                <td>
                    <select name="con_contadorTNovo.con_nr_id">
                        <option value="0">Selecione um Contador</option>
                        <c:forEach items="${con_contadorJB.listContadores}" var="item">
                            <option value="${item.con_nr_id}" ${con_contadorJB.con_contadorT.con_nr_id == item.con_nr_id?'selected':' '}>${item.con_tx_nome}</option>
                        </c:forEach>
                    </select>
                </td>
                <tr>
                    <td colspan="2" align="center"><input type="button" value="Definir Contador" title="Define o contador da distribuidora!" onclick="setOpPortal('con_contador','definirContador', '/nfegen/public/con_contador/con_contadorDistribuidoraConsult.jsp')"/></td>
                </tr>
            </tr>
            <tr>
                <td colspan="2"><h3 align="center">Dados do Contador</h3></td>
            </tr>
            <tr>
                <td>
                    <label>Nome:</label>
                </td>
                <td>
                    <label>${con_contadorJB.con_contadorT.con_tx_nome}</label>
                </td>
            </tr>
            <tr>
                <td>
                    <label>CPF:</label>
                </td>
                <td>
                    <label>${con_contadorJB.con_contadorT.con_tx_cpf}</label>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="Voltar"  onClick="setOpPortal('con_contador','', '/nfegen/public/dis_distribuidora/dis_distribuidoraConsult.jsp')" />
                </td>
            </tr>
        </table>

    </div>

</form>

