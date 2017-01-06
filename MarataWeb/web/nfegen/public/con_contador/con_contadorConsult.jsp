<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="con_contadorJB" class="br.com.easynet.nfegen.jb.Con_contadorConsultJB" scope="request"/>
<jsp:setProperty name="con_contadorJB" property="*"/>                                         
<jsp:setProperty name="con_contadorJB" property="page" value="${pageContext}"/>                                         
${con_contadorJB.execute}                                         


<form name="con_contador" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/public/con_contador/con_contadorConsult.jsp"/>
    <center>
        <label class="msg" align="center">${con_contadorJB.msg} </label>
        <br/>
        <input type="button" value="New" onClick="setOpPortal('con_contador','', '/nfegen/public/con_contador/con_contadorInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
        <input type="button" value="List" onClick="setOpPortal('con_contador','consult', '/nfegen/public/con_contador/con_contadorConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>

    <hr/>
    <h3 align="center">Contadores</h3>
    <center>

        <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${con_contadorJB.list}"  pagesize="30" >

            <display:column sortable="false" title="Nome" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/con_contador/con_contadorUpdateDelete.jsp&op=findbyid&con_contadorT.con_nr_id=${item.con_nr_id}&">
                    <c:out value="${item.con_tx_nome}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="CPF" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/con_contador/con_contadorUpdateDelete.jsp&op=findbyid&con_contadorT.con_nr_id=${item.con_nr_id}&">
                    <c:out value="${item.con_tx_cpf}"/>
                </a>
            </display:column>

            <display:column title="">
            
                <!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
                <div align="right">
                    <a onclick="setOpPortal('con_contador','delete', '/nfegen/public/con_contador/con_contadorConsult.jsp?con_contadorT.con_nr_id=${item.con_nr_id}&')" href="#">
                        <img border="0" src="/easyportal/images/delete.png">

                    </a>
                </div>
            </display:column>
        </display:table>
    </center>

</form>

