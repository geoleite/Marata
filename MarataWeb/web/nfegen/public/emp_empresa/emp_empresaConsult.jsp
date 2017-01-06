<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="emp_empresaJB" class="br.com.easynet.nfegen.jb.Emp_empresaConsultJB" scope="request"/>                                         
<jsp:setProperty name="emp_empresaJB" property="*"/>                                         
<jsp:setProperty name="emp_empresaJB" property="page" value="${pageContext}"/>                                         
${emp_empresaJB.execute}                                         
                                                                                

<form name="emp_empresa" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/nfegen/public/emp_empresa/emp_empresaConsult.jsp"/>
    <div align="center">     
        <label class="msg" align="center">${emp_empresaJB.msg} </label>
        <br/>
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
        <input type="button" value="Novo" onClick="setOpPortal('emp_empresa','', '/nfegen/public/emp_empresa/emp_empresaInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
        <input type="button" value="Refresh" onClick="setOpPortal('emp_empresa','', '/nfegen/public/emp_empresa/emp_empresaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
        <input type="button" value="Voltar" onClick="setOpPortal('emp_empresa','', '/nfegen/public/dis_distribuidora/dis_distribuidoraConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
        <hr/> 
        <h3 align="center">Empresas</h3>        
        <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${emp_empresaJB.list}"  pagesize="30" >
            
            <display:column sortable="false" title="Nome" >
                <!--a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/nfegen/public/emp_empresa/emp_empresaUpdateDelete.jsp&op=findbyid&emp_empresaT.emp_nr_id=${item.emp_nr_id}&"-->
                <label> <c:out value="${item.emp_tx_nome}"/></label>
                <!--/a-->
            </display:column>
            
            <display:column title="">
                <div align="left">
                    <a onclick="setOpPortal('emp_empresa','delete', '/nfegen/public/emp_empresa/emp_empresaConsult.jsp?emp_empresaT.emp_nr_id=${item.emp_nr_id}&')" href="#">
                        <img border="0" src="/easyportal/images/delete.png">                    
                    </a>
                </div>
            </display:column>	
        </display:table>
    </div>	    
</form>

