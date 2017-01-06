<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="not_notaJB" class="br.com.easynet.nfegen.jb.Not_notaConsultContadorJB" scope="request"/>
<jsp:setProperty name="not_notaJB" property="*"/>
<jsp:setProperty name="not_notaJB" property="page" value="${pageContext}"/>
${not_notaJB.execute}

<script>
    function checkSelecionado() {
        var ok = false;
        var formulario = document.forms[0];
        var campos = formulario.elements;
        for (var i=0; i < campos.length; i++) {
            var campo = campos[i];
        //    alert(campo.name + " " + campo.type + " " + campo.checked);
            if ("checkbox" == campo.type && campo.checked) {
                ok = true;
                break;
            }
        }
        return ok;
    }
    function setOpDownload() {
        var formulario = document.forms[0];
        if (checkSelecionado()) {
            formulario.action="../nfegen/public/not_nota/not_notaUpdateDelete.jsp";
            formulario.op.value = "downloadNotas";
            formulario.submit();
        } else {
            alert("E necessario selecionar pelo menos uma Nota Fiscal!");
        }
        formulario.action="/easyportal/portal/portal.jsp";
    }

    var selected = false;
    function selecionarTodos() {
        var formulario = document.forms[0];
        var campos = formulario.elements;
        selected = !selected;
        for (var i=0; i < campos.length; i++) {
            var campo = campos[i];
        //    alert(campo.name + " " + campo.type + " " + campo.checked);
            if ("checkbox" == campo.type) {

                campo.checked = selected;
            }
        }
    }
</script>
<form name="not_nota" action="portal.jsp" method="post">
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/public/not_nota/not_notaConsultContador.jsp"/>
    <div align="center">
        <label style="color:red" align="center">${not_notaJB.msg} </label>
        <br/>
        <h3>Pesquisar Notas Fiscais</h3>
        <table>
            <tr>
                <td>
                    <label>
                        Nr Nota Fiscal:
                    </label>
                </td>
                <td>
                    <input size="15" name="not_notaT.not_tx_numero"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>
                        Distribuidora:
                    </label>
                </td>
                <td>
                    <select name="dis_distribuidoraT.dis_nr_id">
                        <option value="0" ${0==not_notJB.dis_distribuicaoT.dis_nr_id?'selected':' '}>Todas as Distribuidoras</option>
                        <c:forEach var="item" items="${not_notaJB.listDist}">
                            <option value="${item.dis_nr_id}" ${item.dis_nr_id==not_notJB.dis_distribuicaoT.dis_nr_id?'selected':' '}>${item.dis_tx_nome}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
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

                    <input type="button" value="Pesquisar" onClick="setOpPortal('not_nota','consult', '/nfegen/public/not_nota/not_notaConsultContador.jsp')"/>&nbsp;&nbsp;&nbsp;
                    <!-- c :if test="${not_notaJB.perfilUser[0].per_tx_nome!='Distribuidora NFE' && not_notaJB.perfilUser[0].per_tx_nome!='Cliente NFE'}">
                        <input type="button" value="Voltar" onClick="setOpPortal('not_nota','', '/nfegen/public/dis_distribuidora/dis_distribuidoraConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
                    </ c :if-->
                </td>
            </tr>
            <tr>
                <td>
                    <label>
                        Tamanho da Consulta:
                    </label>
                </td>
                <td>
                    <!--input type="text" name="tamanhoConsulta" value="${not_notaJB.tamanhoConsulta}" size="5"/-->
                    <select name="tamanhoConsulta">
                        <option value="10" ${not_notaJB.tamanhoConsulta==10?'selected':' '}>10</option>
                        <option value="20" ${not_notaJB.tamanhoConsulta==20?'selected':' '}>20</option>
                        <option value="50" ${not_notaJB.tamanhoConsulta==50?'selected':' '}>50</option>
                        <c:forEach begin="100" end="1000" step="100" var="qnt">
                            <option value="${qnt}" ${not_notaJB.tamanhoConsulta==qnt?'selected':' '}>${qnt}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

        </table>
        <!--input type="button" value="New" onClick="setOpPortal('not_nota','', '/nfegen/public/not_nota/not_notaInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;-->


        <hr/>
        <hd align="center">Notas</hd>

        <display:table class="tabela" cellpadding="0" cellspacing="0"   id="item" name="${not_notaJB.list}"  pagesize="${not_notaJB.tamanhoConsulta}" >

            <display:column sortable="false" title="Distribuidora" >
                <label>
                    <c:out value="${item.dis_tx_nome}"/>
                </label>
            </display:column>
            <display:column sortable="false" title="Chave Acesso" >
                <a href="portal.jsp?not_notaT.not_tx_identificador=${item.not_tx_identificador}&urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/relatorio/relatorio_nfe.jsp&op=consult&dis_distribuidoraT.dis_nr_id=605">

                    <c:out value="${item.not_tx_identificador}"/>
                </a>
            </display:column>

            <display:column sortable="false" title="Cnpj do Cliente" >
                <label>
                    <c:out value="${item.not_tx_cnpjcliente}"/>
                </label>
            </display:column>
            <display:column sortable="false" title="Data de Emissão" >
                <label>
                    <fmt:formatDate pattern="dd/MM/yyyy" value="${item.not_dt_emissao}"/>
                </label>
            </display:column>
            <display:column sortable="false" title="Numero" >
                <label>
                    <c:out value="${item.not_tx_numero}"/>
                </label>
            </display:column>
            <display:column sortable="false" title="Tipo" >
                <label>
                    <c:out value="${item.not_tx_tipo}"/>
                </label>
            </display:column>
            <!--display:column sortable="false" title="Arquivo" >
                <a href="/easyportal/nfegen/public/not_nota/not_notaUpdateDelete.jsp?op=downloadImage&not_notaT.emp_nr_id=${item.emp_nr_id}&not_notaT.not_nr_id=${item.not_nr_id}&not_notaT.dis_nr_id=${item.dis_nr_id}">
                    Download
                </a>
            < / display:column-->
            <display:column sortable="false" title=""  >
                <div align="center">
                    <input type="checkbox" name="download" value="${item.dis_nr_id};${item.emp_nr_id};${item.not_nr_id}"/>
                </div>
            </display:column>

            <!-- display:column title="">

                <a onclick="setOpPortal('not_nota','delete', '/nfegen/public/not_nota/not_notaConsult.jsp?not_notaT.emp_nr_id=${item.emp_nr_id}&not_notaT.not_nr_id=${item.not_nr_id}&not_notaT.dis_nr_id=${item.dis_nr_id}&')" href="#">
                    <img border="0" src="/easyportal/images/delete.png">
                </a>

            < / display:column-->
            <display:column sortable="false" title="" >
                <img border="0" src="/easyportal/images/${item.not_bln_cancelada}.png">
            </display:column>

        </display:table>
        <c:if test="${not_notaJB.achou}">
            <input type="button" title="Seleciona todas as notas para serem baixadas." value="Selecionar todas as Notas" onclick="selecionarTodos()"/>
            <input type="button" title="Efetua o download das notas selecionadas." value="Download das Notas Fiscais" onclick="setOpDownload()"/>
        </c:if>
    </div>

</form>

