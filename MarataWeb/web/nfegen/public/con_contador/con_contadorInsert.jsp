<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="con_contadorJB" class="br.com.easynet.nfegen.jb.Con_contadorInsertJB" scope="request"/>
<jsp:setProperty name="con_contadorJB" property="*"/>                                         
<jsp:setProperty name="con_contadorJB" property="page" value="${pageContext}"/>                                         
${con_contadorJB.execute}                                         


<form name="con_contador" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/nfegen/con_contador/con_contadorInsert.jsp"/>
    <div align="center">
        <label class="msg">${con_contadorJB.msg}</label><br/>
        <h3>Cadastrar Contador</h3>
        <table width="50%" border="0">
            <tr>
                <td>
                    <label>Nome:</label>
                </td>
                <td>
                    <input type="text" size="50" name="con_contadorT.con_tx_nome" value="${con_contadorJB.con_contadorT.con_tx_nome}" onKeyPress="nextField(this, event)"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>CPF:</label>
                </td>
                <td>
                    <input type="text" size="15" name="con_contadorT.con_tx_cpf" value="${con_contadorJB.con_contadorT.con_tx_cpf}" onKeyPress="nextField(this, event)"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Senha:</label>
                </td>
                <td>
                    <input type="password" size="20" name="usu_usuarioT.usu_tx_senha" onKeyPress="nextField(this, event)"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Conf. Senha:</label>
                </td>
                <td>
                    <input type="password" size="20" name="confSenha"  onKeyPress="nextField(this, event)"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Email:</label>
                </td>
                <td>
                    <input type="text" size="50" name="usu_usuarioT.usu_tx_email" value="${con_contadorJB.usu_usuarioT.usu_tx_email}" onKeyPress="nextField(this, event)"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="Inserir"  onClick="setOpPortal('con_contador','insert', '/nfegen/public/con_contador/con_contadorInsert.jsp')" /> &nbsp;&nbsp;
                    <input type="button" value="Voltar"  onClick="setOpPortal('con_contador','', '/nfegen/public/con_contador/con_contadorConsult.jsp')" />
                </td>
            </tr>
        </table>
    </div>


</form>

