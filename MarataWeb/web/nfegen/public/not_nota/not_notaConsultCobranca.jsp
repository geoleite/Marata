<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="not_notaJB" class="br.com.easynet.nfegen.jb.Not_notaConsultCobracaJB" scope="request"/>
<jsp:setProperty name="not_notaJB" property="*"/>                                         
<jsp:setProperty name="not_notaJB" property="page" value="${pageContext}"/>                                         
${not_notaJB.execute}                                         
                                                                                

<form name="not_nota" action="portal_Relatorio.jsp" method="post" target="_blank">
    <input type="hidden" name="op"/>
    
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/public/not_nota/not_notaBoderoCobranca.jsp"/>
    <div align="center">     
        <label style="color:red" align="center">${not_notaJB.msg} </label>
        <br/>
        <h3>Pesquisar Notas para Cobranca</h3>
        
        <table>

            <tr>
                <td>
                    <label>
                        Data de Emissão Inicial:
                    </label>
                </td>
                <td>
                    <input onKeyUp="formata(this);" size="11" maxlength="11" type="text" name="datainicial" value="${not_notaJB.datainicial}"/>
                    <img src="/easyportal/images/btcalendar1.gif" border="0"  onclick="openCalendar(document.not_nota.elements['datainicial'], true)"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>
                        Data de Emissão Final:
                    </label>
                </td>
                <td>
                    <input onKeyUp="formata(this);" size="11" maxlength="11" type="text" name="datafinal" value="${not_notaJB.datafinal}"/>
                    <img src="/easyportal/images/btcalendar1.gif" border="0"  onclick="openCalendar(document.not_nota.elements['datafinal'], true)"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    
                    <input type="button" value="Pesquisar" onClick="setOpPortal('not_nota','consult', '/nfegen/public/not_nota/not_notaBoderoCobranca.jsp')"/>&nbsp;&nbsp;&nbsp;
                    <c:if test="${not_notaJB.perfilUser[0].per_tx_nome!='Distribuidora NFE'}">
                        <input type="button" value="Voltar" onClick="setOpPortal('not_nota','', '/nfegen/public/dis_distribuidora/dis_distribuidoraConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
                    </c:if>
                </td>
            </tr>

        </table>
        
        <hr/> 
    </div>	
    
</form>

