package br.com.easynet.nfegen.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Not_notaConsultJB extends SystemBase {

    // Atributos e propriedades
    private Dis_distribuidoraT dis_distribuidoraT = new Dis_distribuidoraT();
    private Emp_empresaT emp_empresaT = new Emp_empresaT();
    private Not_notaT not_notaT = new Not_notaT();
    private String datainicial,  datafinal;
    private String tamanhoConsulta = "20";
    private String tipoNota = "S";
    private boolean achou = false;

    public void setNot_notaT(Not_notaT not_notaT) {
        this.not_notaT = not_notaT;
    }

    public Not_notaT getNot_notaT() {
        return not_notaT;
    }
    private List<Not_notaT> list;

    public List<Not_notaT> getList() {
        return list;
    }

    public void setList(List<Not_notaT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        // se a datainicial estiver nula, sera inicializada com a o primeiro dia do mes corrente
        //  e a datafinal com 30 dias apos o primeiro dia do mes corrente
        if (datainicial == null) {
            Calendar cal = Calendar.getInstance();
            int mes = cal.get(Calendar.MONTH) + 1;
            int ano = cal.get(Calendar.YEAR);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            cal.setTime(sdf.parse("1/" + mes + "/" + ano));
            datainicial = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 30);
            datafinal = sdf.format(cal.getTime());
        }
        dis_distribuidoraT = findbyIdDis_distribuidora(dis_distribuidoraT);
    //getPerfilUser().get(0).getPer_tx_nome()
//        emp_empresaT.setDis_nr_id(dis_distribuidoraT.getDis_nr_id());
//        emp_empresaT = findbyIdEmp_empresa(emp_empresaT);
//        consult();

    }

    public void consultTodos() {
        try {

            //list = getNot_notaDAO().executeQuery(sql.toString(), param);
            list = getNot_notaDAO().getAll();
            achou = list.size() > 0;
            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }

    }
    public void consult() throws Exception {
        try {
            List param = new Vector();
            StringBuffer sql = null;
            if ("E".equals(tipoNota)) {
                sql = new StringBuffer("select not_bln_cancelada, not_nr_id, not_tx_numero, dis.dis_nr_id as emp_nr_id, dis.dis_tx_nome as emp_tx_nome, not_tx_identificador, not_tx_tipo, dis.dis_tx_cnpj as not_tx_cnpjcliente, dis.dis_nr_id, not_dt_emissao from  easynfe.not_nota nota, easynfe.dis_distribuidora dis ");
                sql.append(" where  not_tx_cnpjcliente = ?  and dis.dis_nr_id=nota.dis_nr_id");
//and not_tx_tipo='VENDA'
//                sql = new StringBuffer("select not_nr_id, not_tx_numero, emp.emp_nr_id, emp.emp_tx_nome, not_tx_identificador, 'Compra' as not_tx_tipo , not_tx_cnpjcliente, dis_nr_id, not_dt_emissao from  easynfe.not_nota nota , easynfe.emp_empresa emp where ");
//                sql.append(" not_tx_cnpjcliente = ? and not_tx_tipo='VENDA' and emp.emp_nr_id=nota.emp_nr_id");
                param.add(dis_distribuidoraT.getDis_tx_cnpj());
            } else {
                sql = new StringBuffer("select not_nr_id,not_bln_cancelada, not_tx_numero, emp.emp_nr_id, emp.emp_tx_nome, not_tx_identificador, not_tx_tipo, not_tx_cnpjcliente, dis_nr_id, not_dt_emissao from easynfe.not_nota nota, (select * from easynfe.emp_empresa) emp where  dis_nr_id=? and emp.emp_nr_id=nota.emp_nr_id ");
                param.add(dis_distribuidoraT.getDis_nr_id());
                if (not_notaT.getNot_tx_cnpjcliente() != null && not_notaT.getNot_tx_cnpjcliente().trim().length() == 14) {
                    sql.append(" and not_tx_cnpjcliente = ?");
                    param.add(not_notaT.getNot_tx_cnpjcliente());
                }
            }
            if (not_notaT.getNot_tx_numero() != 0) {
                sql.append(" and not_tx_numero=? ");
                param.add(not_notaT.getNot_tx_numero());
            } else {

                /*
                 * Verificando se a data foi informada
                 */
                if (datainicial == null || datainicial.trim().length() == 0 ||
                        datafinal == null || datafinal.trim().length() == 0) {

                    setMsg("E obrigatorio informar a data inicial e a data final!");
                    return;
                }

                if (datainicial != null && datainicial.trim().length() > 0) {
                    sql.append(" and not_dt_emissao between ? and ? ");
                    if (datafinal == null || datafinal.trim().length() == 0) {
                        datafinal = datainicial;
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    java.sql.Date dtInicio = new java.sql.Date(sdf.parse(datainicial).getTime());
                    java.sql.Date dtFinal = new java.sql.Date(sdf.parse(datafinal).getTime());

                    // Verificando o numero de dias do periodo definido
                    long timeinicio = dtInicio.getTime();
                    long timefim = dtFinal.getTime();
                    long time = timefim - timeinicio;
                    long dia = time / (1000 * 60 * 60 * 24);
                    if (dia > DIAS_INTERVALO) {
                        setMsg("O periodo definido para a busca deve ser de no maximo 2 meses!");
                        return;
                    }
                    param.add(dtInicio);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(dtFinal);
                    cal.add(Calendar.HOUR, 1);
                    dtFinal = new java.sql.Date(cal.getTimeInMillis());
                    param.add(dtFinal);
                }
            }

            sql.append("order by not_tx_numero, not_dt_emissao desc, not_tx_cnpjcliente");
            list = getNot_notaDAO().executeQuery(sql.toString(), param);
            achou = list.size() > 0;
            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Not_notaDAO not_notaDAO = getNot_notaDAO();
            not_notaDAO.delete(not_notaT);
            setMsg("Exclusao efetuada com sucesso!");
            not_notaT = new Not_notaT();
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclusao!");
        } finally {
            close();
        }
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "not_notaInsert.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public Dis_distribuidoraT getDis_distribuidoraT() {
        return dis_distribuidoraT;
    }

    public void setDis_distribuidoraT(Dis_distribuidoraT dis_distribuidoraT) {
        this.dis_distribuidoraT = dis_distribuidoraT;
    }

    public Emp_empresaT getEmp_empresaT() {
        return emp_empresaT;
    }

    public void setEmp_empresaT(Emp_empresaT emp_empresaT) {
        this.emp_empresaT = emp_empresaT;
    }

    public String getDatainicial() {

        return datainicial;
    }

    public void setDatainicial(String datainicial) {
        this.datainicial = datainicial;
    }

    public String getDatafinal() {
        return datafinal;
    }

    public void setDatafinal(String datafinal) {
        this.datafinal = datafinal;
    }

    /**
     * @return the achou
     */
    public boolean isAchou() {
        return achou;
    }

    /**
     * @param achou the achou to set
     */
    public void setAchou(boolean achou) {
        this.achou = achou;
    }

    /**
     * @return the tamanhoConsulta
     */
    public String getTamanhoConsulta() {
        try {
            Integer.parseInt(tamanhoConsulta);
        } catch (Exception e) {
            tamanhoConsulta = "20";
        }
        return tamanhoConsulta;
    }

    /**
     * @param tamanhoConsulta the tamanhoConsulta to set
     */
    public void setTamanhoConsulta(String tamanhoConsulta) {
        this.tamanhoConsulta = tamanhoConsulta;
    }

    /**
     * @return the tipoNota
     */
    public String getTipoNota() {
        return tipoNota;
    }

    /**
     * @param tipoNota the tipoNota to set
     */
    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
    }
}
