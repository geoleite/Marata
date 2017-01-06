<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="gj_gnfe_nota_fiscalJB" class="br.com.i9.marata.jb.Gj_gnfe_nota_fiscalUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="gj_gnfe_nota_fiscalJB" property="*"/>                                         
<jsp:setProperty name="gj_gnfe_nota_fiscalJB" property="page" value="${pageContext}"/>                                         
${gj_gnfe_nota_fiscalJB.execute}                                         
{"resultado":
{"msg":"${gj_gnfe_nota_fiscalJB.msg}",
     "gj_gnfe_nota_fiscal":{	"id_ent":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.id_ent}"
 ,	"nfe_id":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.nfe_id}"
 ,	"reg_nfe":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.reg_nfe}"
 ,	"des_reg":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.des_reg}"
 ,	"modelo":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.modelo}"
 ,	"ambiente":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.ambiente}"
 ,	"modalidade":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.modalidade}"
 ,	"status":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.status}"
 ,	"cstatus_sefr":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.cstatus_sefr}"
 ,	"xmot_sefr":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.xmot_sefr}"
 ,	"prot":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.prot}"
 ,	"date_prot":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.date_prot}"
 ,	"origem":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.origem}"
 ,	"status_java":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.status_java}"
 ,	"status_totvs":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.status_totvs}"
 ,	"totvs_cod_empresa":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.totvs_cod_empresa}"
 ,	"totvs_num_ar":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.totvs_num_ar}"
 ,	"totvs_num_nfe":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.totvs_num_nfe}"
 ,	"totvs_ser_nfe":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.totvs_ser_nfe}"
 ,	"totvs_ssr_nfe":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.totvs_ssr_nfe}"
 ,	"totvs_emi_nfe":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.totvs_emi_nfe}"
 ,	"totvs_des_nfe":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.totvs_des_nfe}"
 ,	"totvs_dat_nfe":"<fmt:formatDate value="${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.totvs_dat_nfe}" pattern="dd/MM/yyyy"/>"
 ,	"totvs_val_nfe":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.totvs_val_nfe}"
 ,	"num_cgc_cpf":"${gj_gnfe_nota_fiscalJB.gj_gnfe_nota_fiscalT.num_cgc_cpf}"
  }
    }
     
}                                                                                
   
