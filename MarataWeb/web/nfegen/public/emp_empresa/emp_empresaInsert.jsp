<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="emp_empresaJB" class="br.com.easynet.nfegen.jb.Emp_empresaInsertJB" scope="request"/>                                         
<jsp:setProperty name="emp_empresaJB" property="*"/>                                         
<jsp:setProperty name="emp_empresaJB" property="page" value="${pageContext}"/>                                         
${emp_empresaJB.execute}                                         
                                                                               
        
<form name="emp_empresa" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/public/emp_empresa/emp_empresaInsert.jsp"/>
    <div align="center">     
        <label class="msg">${emp_empresaJB.msg}</label><br/>
        <h3>Dados da Distribuidora</h3>
        <table width="20%" border="0">
            <tr>
                <td>
                    <label>Nome:</label>
                </td>
                <td>
                    <label>${emp_empresaJB.dis_distribuidoraT.dis_tx_nome}</label>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Cnpj:</label>
                </td>
                <td>
                    <label>${emp_empresaJB.dis_distribuidoraT.dis_tx_cnpj}</label>
                </td>
            </tr>     
        </table>
        
        <h3>Cadastrar Empresa</h3>
        
        <table width="20%" border="0">
            <tr>
                <td>
                    <label>Nome:</label>
                </td>
                <td>
                    <input type="text" name="emp_empresaT.emp_tx_nome" value="${emp_empresaJB.emp_empresaT.emp_tx_nome}"/> 
                </td>
            </tr>
            <tr>
                <td>
                    <label>Cnpj</label>
                </td>
                <td>
                    <input type="text" name="emp_empresaT.emp_tx_cnpj" value="${emp_empresaJB.emp_empresaT.emp_tx_cnpj}"/> 
                </td>
            </tr>
            <tr>
                <td>
                    <label>Estado:</label>
                </td>
                <td>
                    <input type="text" size="50" name="emp_empresaT.emp_tx_estado" value="${emp_empresaJB.emp_empresaT.emp_tx_estado}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Cidade:</label>
                </td>
                <td>
                    <input type="text" size="50" name="emp_empresaT.emp_tx_cidade" value="${emp_empresaJB.emp_empresaT.emp_tx_cidade}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Bairro:</label>
                </td>
                <td>
                    <input type="text" size="80" name="emp_empresaT.emp_tx_bairro" value="${emp_empresaJB.emp_empresaT.emp_tx_bairro}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Endereco:</label>
                </td>
                <td>
                    <input type="text" size="80" name="emp_empresaT.emp_tx_endereco" value="${emp_empresaJB.emp_empresaT.emp_tx_endereco}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>CEP:</label>
                </td>
                <td>
                    <input type="text" size="15" name="emp_empresaT.emp_tx_cep" value="${emp_empresaJB.emp_empresaT.emp_tx_cep}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Inscricao Estadual:</label>
                </td>
                <td>
                    <input type="text" size="20" name="emp_empresaT.emp_tx_ie" value="${emp_empresaJB.emp_empresaT.emp_tx_ie}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Email:</label>
                </td>
                <td>
                    <input type="text" size="20" name="usu_usuarioT.usu_tx_email" value="${emp_empresaJB.usu_usuarioT.usu_tx_email}"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="Insert"  onClick="setOpPortal('emp_empresa','insert', '/nfegen/public/emp_empresa/emp_empresaInsert.jsp')" /> &nbsp;&nbsp;
                    <input type="button" value="Voltar"  onClick="setOpPortal('emp_empresa','', '/nfegen/public/emp_empresa/emp_empresaConsult.jsp')" />
                </td>
            </tr>
        </table>
    </div>     
    
    
</form>

