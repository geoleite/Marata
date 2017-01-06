<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="dis_distribuidoraJB" class="br.com.easynet.nfegen.jb.Dis_distribuidoraUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="dis_distribuidoraJB" property="*"/>                                         
<jsp:setProperty name="dis_distribuidoraJB" property="page" value="<%=pageContext%>"/>
<jsp:getProperty name="dis_distribuidoraJB" property="execute"/>
                                                                                

<form name="dis_distribuidora" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/public/dis_distribuidora/dis_distribuidoraUpdateDelete.jsp"/>
    <input type="hidden" name="dis_distribuidoraT.dis_nr_id" value="${dis_distribuidoraJB.dis_distribuidoraT.dis_nr_id}"/> 
    <div align="center">     
        <label class="msg">${dis_distribuidoraJB.msg}</label><br/>
        <h3>Alterar Distribuidoras</h3>
        <table align="center" border="0" width="50%">
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
                <td colspan="2">
                    <label>Distribuidora Associada:</label><br/>
                    <select name="dis_distribuidoraT.dis_nr_id_super" >
                        <option value="-1"> </option>
                    <c:forEach var="item" items="${dis_distribuidoraJB.listaDist}">
                        <c:if test="${dis_distribuidoraJB.dis_distribuidoraT.dis_nr_id != item.dis_nr_id}">
                            <option value="${item.dis_nr_id}" ${dis_distribuidoraJB.dis_distribuidoraT.dis_nr_id_super==item.dis_nr_id?'selected':' '}>${item.dis_tx_nome}-${item.dis_tx_cnpj}</option>
                        </c:if>
                    </c:forEach>
                    </select>
                </td>
            </tr>
            
            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="Update"  onClick="setOpPortal('dis_distribuidora', 'update' , '/nfegen/public/dis_distribuidora/dis_distribuidoraUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
                    <input type="button" value="Delete"  onClick="setOpPortal('dis_distribuidora', 'delete' , '/nfegen/public/dis_distribuidora/dis_distribuidoraUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
                    <input type="button" value="Voltar" onClick="setOpPortal('dis_distribuidora', 'consult', '/nfegen/public/dis_distribuidora/dis_distribuidoraConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
        </table>
        
    </div>     
    
</form>
