<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="emp_empresaJB" class="br.com.easynet.nfegen.jb.Emp_empresaUpdateDeleteJB" scope="request"/>
<jsp:setProperty name="emp_empresaJB" property="*"/>                                         
<jsp:setProperty name="emp_empresaJB" property="page" value="${pageContext}"/>                                         
${emp_empresaJB.execute}                                         
{"resultado":
{"msg":"${emp_empresaJB.msg}",
     "emp_empresa":{	"emp_nr_id":"${emp_empresaJB.emp_empresaT.emp_nr_id}"
 ,	"emp_tx_nome":"${emp_empresaJB.emp_empresaT.emp_tx_nome}"
 ,	"emp_tx_cnpj":"${emp_empresaJB.emp_empresaT.emp_tx_cnpj}"
 ,	"emp_tx_estado":"${emp_empresaJB.emp_empresaT.emp_tx_estado}"
 ,	"emp_tx_cidade":"${emp_empresaJB.emp_empresaT.emp_tx_cidade}"
 ,	"emp_tx_bairro":"${emp_empresaJB.emp_empresaT.emp_tx_bairro}"
 ,	"emp_tx_endereco":"${emp_empresaJB.emp_empresaT.emp_tx_endereco}"
 ,	"emp_tx_cep":"${emp_empresaJB.emp_empresaT.emp_tx_cep}"
 ,	"emp_tx_ie":"${emp_empresaJB.emp_empresaT.emp_tx_ie}"
 ,	"emp_nr_id_super":"${emp_empresaJB.emp_empresaT.emp_nr_id_super}"
  }
    }
     
}                                                                                
   
