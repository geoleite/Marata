<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="por_usuJB" class="br.com.easynet.portal.jb.Por_usuConsultJB" scope="request"/>                                         
<jsp:setProperty name="por_usuJB" property="*"/>                                         
<jsp:setProperty name="por_usuJB" property="page" value="${pageContext}"/>                                         
${por_usuJB.execute}                                         
                                       

<h3>Adicionar ou Remover Usuários do Portal</h3>

<form name="por_usu" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="por_usuConsult.jsp"/>
    <input type="hidden" name="por_portalT.por_nr_id" value="${por_usuJB.por_portalT.por_nr_id}"/>
    
    <div align="center">     
        <label class="msg" align="center">${por_usuJB.msg} </label>
        <h3>Dados do Portal</h3>
        <table>
            <tr>
                <td align="left">
                    <label>Nome:</label>                    
                </td>
                <td align="left">
                    ${por_usuJB.por_portalT.por_tx_nome}
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Status:</label>            
                </td>
                <td align="left">
                    ${can_porJB.por_portalT.por_tx_status=='A'?'Ativo':'Inativo'}
                </td>
            </tr>
        </table>             
        <h3>Usuários</h3>
        <table>
            <tr>
                <td align="left">
                    Não selecionado:<br/>
                    <select name="por_usuT.usu_nr_id" size="1   0">
                        <c:forEach var="item" items="${por_usuJB.listNoUsuario}">
                            <option value="${item.usu_nr_id}">${item.usu_tx_nome}</option>
                        </c:forEach>
                    </select>
                </td>
                <td width="20px" align="center" valign="middle">
                    <input type="button" value="  >  " onClick="setOpPortal('por_usu', 'add', 'por_usuConsult.jsp')"/><br/><br/>
                    <input type="button" value="  <  " onClick="setOpPortal('por_usu', 'rem', 'por_usuConsult.jsp')"/><br/><br/>
                </td>
                <td align="right">
                    Selecionado:<br/>
                    <select name="por_usuT.usu_nr_id" size="10">
                        <c:forEach var="item" items="${por_usuJB.listUsuario}">
                            <option value="${item.usu_nr_id}">${item.usu_tx_nome}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="3">
                </td>
            </tr>
            <tr>
                <td align="center" colspan="3">
                    <input type="button" value="Voltar" onclick="setOpPortal('por_usu', '','por_portalConsult.jsp')"/>
                </td>
            </tr>
        </table>
    </div>
    
</form>
