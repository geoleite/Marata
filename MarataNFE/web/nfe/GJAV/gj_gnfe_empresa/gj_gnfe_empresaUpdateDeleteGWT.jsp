<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="gj_gnfe_empresaJB" class="br.com.i9.marata.jb.Gj_gnfe_empresaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="gj_gnfe_empresaJB" property="*"/>                                         
<jsp:setProperty name="gj_gnfe_empresaJB" property="page" value="${pageContext}"/>                                         
${gj_gnfe_empresaJB.execute}                                         
{"resultado":
{"msg":"${gj_gnfe_empresaJB.msg}",
     "gj_gnfe_empresa":{	"cod_empresa":"${gj_gnfe_empresaJB.gj_gnfe_empresaT.cod_empresa}"
 ,	"cnpj_empresa":"${gj_gnfe_empresaJB.gj_gnfe_empresaT.cnpj_empresa}"
 ,	"den_empresa":"${gj_gnfe_empresaJB.gj_gnfe_empresaT.den_empresa}"
 ,	"id_ent":"${gj_gnfe_empresaJB.gj_gnfe_empresaT.id_ent}"
  }
    }
     
}                                                                                
   
