<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="not_notaJB" class="br.com.easynet.nfegen.jb.Not_notaInsertJB" scope="request"/>                                         
<jsp:setProperty name="not_notaJB" property="*"/>                                         
<jsp:setProperty name="not_notaJB" property="page" value="${pageContext}"/>                                         
${not_notaJB.execute}                                         


<form name="not_nota" action="portal.jsp" method="post"  enctype="multipart/form-data" >
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/public/not_nota/not_notaInsert.jsp"/>
    <div align="center">     
        <label class="msg">${not_notaJB.msg}</label><br/>
        <h3>Cadastrar Arquivo de Nota Fiscal</h3>
        <h3>Dados da Distribuidora</h3>
        <table width="20%" border="0">
            <tr>
                <td>
                    <label>Nome:</label>
                </td>
                <td>
                    <label>${not_notaJB.dis_distribuidoraT.dis_tx_nome}</label>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Cnpj:</label>
                </td>
                <td>
                    <label>${not_notaJB.dis_distribuidoraT.dis_tx_cnpj}</label>
                </td>
            </tr>     
        </table>        
        <table width="50%" border="0">
            <tr>
                <td>
                    <label>Arquivo da Nota NFe:</label>
                </td>
                <td>
                    <input type="file" title="Escolher notas fiscais no formato XML ou ZIP"  name="not_notaT.not_bt_arquivo" />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="Insert"  onClick="setOpPortal('not_nota','insert', '/nfegen/public/not_nota/not_notaInsert.jsp')" /> &nbsp;&nbsp;
                    <c:if test="${not_notaJB.perfilUser[0].per_tx_nome!='Distribuidora NFE'}">
                        <input type="button" value="Voltar"  onClick="setOpPortal('not_nota','', '/nfegen/public/dis_distribuidora/dis_distribuidoraConsult.jsp')" />
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>
                    <label style="color:black;font-size:14">Total de Notas enviadas:${not_notaJB.contInseridas + not_notaJB.contProblemas}</label><br/>
                </td>
            </tr>
            <tr>

                <td colspan="2" align="left">
                    <label style="color:green;font-size:14">${not_notaJB.contInseridas} notas Inseridas:</label><br/>
                    <c:if test="${ ! empty not_notaJB.listNotasInseridas }">
                        <c:forEach var="item" items="${not_notaJB.listNotasInseridas}">
                            <label style="color:green">${item.not_notaT.not_tx_identificador}  -  ${item.not_notaT.not_tx_numero}: ${item.msg}</label><br/>
                        </c:forEach>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <label style="color:red;font-size:14">${not_notaJB.contProblemas} notas nao Inseridas: </label><br/>
                    <c:if test="${!empty not_notaJB.listNotasNaoInseridas}">
                        <c:forEach var="item" items="${not_notaJB.listNotasNaoInseridas}">
                            <label style="color:red">${item.not_notaT.not_tx_identificador}  -  ${item.not_notaT.not_tx_numero}: ${item.msg}</label><br/>
                        </c:forEach>
                    </c:if>
                </td>
            </tr>
        </table>
    </div>     
</form>

