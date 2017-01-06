<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="rel_registro_logJB" class="br.com.easynet.nfegen.jb.Rel_registro_logConsultJB" scope="request"/>                                         
<jsp:setProperty name="rel_registro_logJB" property="*"/>                                         
<jsp:setProperty name="rel_registro_logJB" property="page" value="${pageContext}"/>                                         
${rel_registro_logJB.execute}                                         


<form name="rel_registro_log" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/public/rel_registro_log/rel_registro_logConsult.jsp"/>
    <center>
        <label class="msg" align="center">${rel_registro_logJB.msg} </label>
        <h3>Pesquisar no Log</h3>
        <br/>
        <label>Data Inicial:</label> <input onKeyUp="formata(this);" size="11" maxlength="11" type="text" name="datainicial" value="${rel_registro_logJB.datainicial}"/>
        <img src="/easyportal/images/btcalendar1.gif" border="0"  onclick="openCalendar(document.rel_registro_log.elements['datainicial'], true)"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <label>Data Final:</label> <input onKeyUp="formata(this);" size="11" maxlength="11" type="text" name="datafinal" value="${rel_registro_logJB.datafinal}"/>
        <img src="/easyportal/images/btcalendar1.gif" border="0"  onclick="openCalendar(document.rel_registro_log.elements['datafinal'], true)"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button" value="Pesquisar" onClick="setOpPortal('rel_registro_log','consult', '/nfegen/public/rel_registro_log/rel_registro_logConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>

    <hr/>
    <h3 align="center">Resultado</h3>
    <center>

        <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${rel_registro_logJB.list}"  pagesize="50">

            <display:column sortable="false" title="Numero Nota" >
                    <label><c:out value="${item.rel_tx_numeronota}"/></label>
            </display:column>
            <display:column sortable="false" title="Data Hora" >
                    <label><fmt:formatDate value="${item.rel_dt_datahora}" pattern="dd/MM/yyyy HH:mm"/></label>
            </display:column>
            <display:column sortable="false" title="Host" >
                    <label><c:out value="${item.rel_tx_ip}" /></label>
            </display:column>
            <display:column sortable="false" title="Usuario" >
                    <label><c:out value="${item.rel_tx_usuario}" /></label>
            </display:column>

        </display:table>
        </center>

    </form>

