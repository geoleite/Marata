<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="gj_gnfe_empresaJB" class="br.com.i9.marata.jb.Gj_gnfe_empresaConsultJB" scope="request"/>                                         
<jsp:setProperty name="gj_gnfe_empresaJB" property="*"/>                                         
<jsp:setProperty name="gj_gnfe_empresaJB" property="page" value="${pageContext}"/>                                         
${gj_gnfe_empresaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${gj_gnfe_empresaJB.list}" var="item">
     ,{	"cod_empresa":"${item.cod_empresa}"
 ,	"cnpj_empresa":"${item.cnpj_empresa}"
 ,	"den_empresa":"${item.den_empresa}"
 ,	"id_ent":"${item.id_ent}"
  }
</c:forEach>
]}                                                                                
   
