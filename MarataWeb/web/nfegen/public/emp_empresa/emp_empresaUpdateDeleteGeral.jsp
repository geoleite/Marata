<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="emp_empresaJB" class="br.com.easynet.nfegen.jb.Emp_empresaUpdateDeleteGeralJB" scope="request"/>
<jsp:setProperty name="emp_empresaJB" property="*"/>                                         
<jsp:setProperty name="emp_empresaJB" property="page" value="${pageContext}"/>                                         
${emp_empresaJB.execute}                                         


<form name="emp_empresa" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/public/emp_empresa/emp_empresaUpdateDeleteGeral.jsp"/>
    <input type="hidden" name="emp_empresaT.emp_nr_id" value="${emp_empresaJB.emp_empresaT.emp_nr_id}"/> 
    <div align="center">     
        <label class="msg">${emp_empresaJB.msg}</label><br/>
        <h3>Alterar Empresa</h3>
        <h3>Dados da Empresa</h3>
        <table align="center" border="0" width="50%">
            <tr>
                <td>
                    <label>Nome:</label>
                </td>
                <td>
                    <input readonly type="text" size="60" name="emp_empresaT.emp_tx_nome" value="${emp_empresaJB.emp_empresaT.emp_tx_nome}"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <label>Empresa Associada:</label><br/>
                    <select name="emp_empresaT.emp_nr_id_super" >
                        <option value="-1"> </option>
                        <c:forEach var="item" items="${emp_empresaJB.listEmp}">
                            <c:if test="${emp_empresaJB.emp_empresaT.emp_nr_id != item.emp_nr_id}">
                                <option value="${item.emp_nr_id}" ${emp_empresaJB.emp_empresaT.emp_nr_id_super==item.emp_nr_id?'selected':' '}>${item.emp_tx_nome} - ${item.emp_tx_cnpj}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="Alterar"  onClick="setOpPortal('emp_empresa', 'update' , '/nfegen/public/emp_empresa/emp_empresaUpdateDeleteGeral.jsp')"/>&nbsp;&nbsp;&nbsp;
                    <input type="button" value="Voltar" onClick="setOpPortal('emp_empresa', '', '/nfegen/public/emp_empresa/emp_empresaConsultGeral.jsp')"/>&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
        </table>

        <br/>

    </div>

</form>
