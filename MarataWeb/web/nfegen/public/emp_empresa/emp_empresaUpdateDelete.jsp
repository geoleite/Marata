<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="emp_empresaJB" class="br.com.easynet.nfegen.jb.Emp_empresaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="emp_empresaJB" property="*"/>                                         
<jsp:setProperty name="emp_empresaJB" property="page" value="${pageContext}"/>                                         
${emp_empresaJB.execute}                                         
                                                                                

<form name="emp_empresa" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/public/emp_empresa/emp_empresaUpdateDelete.jsp"/>
    <input type="hidden" name="emp_empresaT.emp_nr_id" value="${emp_empresaJB.emp_empresaT.emp_nr_id}"/> 
    <div align="center">     
    <label class="msg">${emp_empresaJB.msg}</label><br/>
    <h3>Alterar ou Excluir Empresa</h3>
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
    <h3>Dados da Empresa</h3>
    <table align="center" border="0" width="50%">
        <tr>
            <td>
                <label>Nome:</label>
            </td>
            <td>
                <input type="text" name="emp_empresaT.emp_tx_nome" value="${emp_empresaJB.emp_empresaT.emp_tx_nome}"/> 
            </td>
        </tr>
        
        <tr>
            <td colspan="2" align="center">
                <input type="button" value="Update"  onClick="setOpPortal('emp_empresa', 'update' , '/nfegen/public/emp_empresa/emp_empresaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
                <input type="button" value="Delete"  onClick="setOpPortal('emp_empresa', 'delete' , '/nfegen/public/emp_empresa/emp_empresaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
                <input type="button" value="Voltar" onClick="setOpPortal('emp_empresa', '', '/nfegen/public/emp_empresa/emp_empresaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
            </td>
        </tr>
    </table>
    
    <br/>
    
    </di>     
    
</form>
