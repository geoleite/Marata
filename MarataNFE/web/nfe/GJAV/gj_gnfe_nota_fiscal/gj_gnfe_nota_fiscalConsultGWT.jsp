<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="gj_gnfe_nota_fiscalJB" class="br.com.i9.marata.jb.Gj_gnfe_nota_fiscalConsultJB" scope="request"/>                                         
<jsp:setProperty name="gj_gnfe_nota_fiscalJB" property="*"/>                                         
<jsp:setProperty name="gj_gnfe_nota_fiscalJB" property="page" value="${pageContext}"/>                                         
${gj_gnfe_nota_fiscalJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${gj_gnfe_nota_fiscalJB.list}" var="item">
     ,{	"id_ent":"${item.id_ent}"
 ,	"nfe_id":"${item.nfe_id}"
 ,	"reg_nfe":"${item.reg_nfe}"
 ,	"des_reg":"${item.des_reg}"
 ,	"modelo":"${item.modelo}"
 ,	"ambiente":"${item.ambiente}"
 ,	"modalidade":"${item.modalidade}"
 ,	"status":"${item.status}"
 ,	"cstatus_sefr":"${item.cstatus_sefr}"
 ,	"xmot_sefr":"${item.xmot_sefr}"
 ,	"prot":"${item.prot}"
 ,	"date_prot":"<fmt:formatDate value="${item.date_prot}" pattern="dd/MM/yyyy"/>"
 ,	"origem":"${item.origem}"
 ,	"status_java":"${item.status_java}"
 ,	"status_totvs":"${item.status_totvs}"
 ,	"totvs_cod_empresa":"${item.totvs_cod_empresa}"
 ,	"totvs_num_ar":"${item.totvs_num_ar}"
 ,	"totvs_num_nfe":"${item.totvs_num_nfe}"
 ,	"totvs_ser_nfe":"${item.totvs_ser_nfe}"
 ,	"totvs_ssr_nfe":"${item.totvs_ssr_nfe}"
 ,	"totvs_emi_nfe":"${item.totvs_emi_nfe}"
 ,	"totvs_des_nfe":"${item.totvs_des_nfe}"
 ,	"totvs_dat_nfe":"<fmt:formatDate value="${item.totvs_dat_nfe}" pattern="dd/MM/yyyy"/>"
 ,	"totvs_val_nfe":"${item.totvs_val_nfe}"
 ,	"num_cgc_cpf":"${item.num_cgc_cpf}"
  }
</c:forEach>
]}                                                                                
   
