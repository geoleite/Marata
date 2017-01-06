<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="dis_distribuidoraJB" class="br.com.easynet.nfegen.jb.Dis_distribuidoraInsertJB" scope="request"/>                                         
<jsp:setProperty name="dis_distribuidoraJB" property="*"/>                                         
<jsp:setProperty name="dis_distribuidoraJB" property="page" value="<%=pageContext%>"/>
<jsp:getProperty name="dis_distribuidoraJB" property="execute"/>
                                                                               
        
<form name="dis_distribuidora" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/public/dis_distribuidora/dis_distribuidoraInsert.jsp"/>
    <div align="center">     
        <label class="msg">${dis_distribuidoraJB.msg}</label><br/>
        <h3>Cadastrar Distribuidora</h3>
        <table width="50%" border="0">
            <tr>
                <td>
                    <label>Nome:</label>
                </td>
                <td>
                    <input type="text" name="dis_distribuidoraT.dis_tx_nome" value="${dis_distribuidoraJB.dis_distribuidoraT.dis_tx_nome}"/> 
                </td>
            </tr>
            <tr>
                <td>
                    <label>Cnpj:</label>
                </td>
                <td>
                    <input type="text" size="16" maxlength="15" name="dis_distribuidoraT.dis_tx_cnpj" value="${dis_distribuidoraJB.dis_distribuidoraT.dis_tx_cnpj}"/> 
                </td>
            </tr>
            <tr>
                <td>
                    <label>Senha:</label>
                </td>
                <td>
                    <input type="password" size="15" maxlength="20" name="usu_usuarioT.usu_tx_senha"/> 
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <label>Distribuidora Associada:</label><br/>
                    <select name="dis_distribuidoraT.dis_nr_id_super" >
                        <option value="-1"> </option>
                    <c:forEach var="item" items="${dis_distribuidoraJB.listaDist}">
                            <option value="${item.dis_nr_id}">${item.dis_tx_nome}-${item.dis_tx_cnpj}</option>
                    </c:forEach>
                    </select>
                </td>
            </tr>

            
            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="Inserir"  onClick="setOpPortal('dis_distribuidora','insert', '/nfegen/public/dis_distribuidora/dis_distribuidoraInsert.jsp')" /> &nbsp;&nbsp;
                    <input type="button" value="Voltar"  onClick="setOpPortal('dis_distribuidora','', '/nfegen/public/dis_distribuidora/dis_distribuidoraConsult.jsp')" />
                </td>
            </tr>
        </table>
    </div>     
    
    
</form>

