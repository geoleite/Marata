package br.com.easynet.nfegen.jb;

import br.com.easynet.easyportal.transfer.Usu_usuarioT;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Not_notaConsultCobracaJB extends SystemBase {

    // Atributos e propriedades
    private Usu_usuarioT usu_usuarioT = new Usu_usuarioT();
    private Dis_distribuidoraT dis_distribuidoraT = new Dis_distribuidoraT();
    private Emp_empresaT emp_empresaT = new Emp_empresaT();
    private Not_notaT not_notaT = new Not_notaT();
    private String datainicial,  datafinal;
    private String tamanhoConsulta = "20";
    private String tipoNota = "S";
    private boolean achou = false;
    private boolean achouNotasSemData = false;
    private int nrTotalNotas,  nrTotalNotasGeral;
    private java.sql.Date dtInicio;
    private java.sql.Date dtFinal;
    private int notaInicial,  notaFinal;
    private List<String> listNrNotasFaltando;
    private List<String> listDataSemNotas;

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
        br.com.easynet.easyportal.jb.SystemBase sbPortal = new br.com.easynet.easyportal.jb.SystemBase();
        try {
            sbPortal.setPage(page);
            usu_usuarioT.setUsu_nr_id(dis_distribuidoraT.getDis_nr_id());
            List<Usu_usuarioT> listUsu = sbPortal.getUsu_usuarioDAO().getById(usu_usuarioT);
            usu_usuarioT = listUsu.size() > 0 ? listUsu.get(0) : new Usu_usuarioT();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sbPortal.close();
        }
    //getPerfilUser().get(0).getPer_tx_nome()
//        emp_empresaT.setDis_nr_id(dis_distribuidoraT.getDis_nr_id());
//        emp_empresaT = findbyIdEmp_empresa(emp_empresaT);
//        consult();

    }

    public void consult() throws Exception {
        try {
            List param = new Vector();
            StringBuffer sql = null;
            if ("E".equals(tipoNota)) {
                sql = new StringBuffer("select not_bln_cancelada, not_nr_id, not_tx_numero, emp.emp_nr_id, emp.emp_tx_nome, not_tx_identificador, not_tx_tipo, not_tx_cnpjcliente, dis_nr_id, not_dt_emissao from easynfe.not_nota nota, (select * from easynfe.emp_empresa) emp where 1=1 ");
                sql.append(" and not_tx_cnpjcliente = ?");
                param.add(dis_distribuidoraT.getDis_tx_cnpj());
            } else {
                sql = new StringBuffer("select not_bln_cancelada, not_nr_id, not_tx_numero, emp.emp_nr_id, emp.emp_tx_nome, not_tx_identificador, not_tx_tipo, not_tx_cnpjcliente, dis_nr_id, not_dt_emissao from easynfe.not_nota nota, (select * from easynfe.emp_empresa) emp where  dis_nr_id=? and emp.emp_nr_id=nota.emp_nr_id ");
                param.add(dis_distribuidoraT.getDis_nr_id());
                if (not_notaT.getNot_tx_cnpjcliente() != null && not_notaT.getNot_tx_cnpjcliente().trim().length() == 14) {
                    sql.append(" and not_tx_cnpjcliente = ?");
                    param.add(not_notaT.getNot_tx_cnpjcliente());
                }
            }
            if (not_notaT.getNot_tx_numero() != 0) {
                sql.append(" and not_tx_numero=? ");
                param.add(not_notaT.getNot_tx_numero());
            }

            /*
             * Verificando se a data foi informada
             */
            if (datainicial == null || datainicial.trim().length() == 0 ||
                    datafinal == null || datafinal.trim().length() == 0) {

                setMsg("E obrigatorio informar a data inicial e a data final!");
                return;
            }

            // Verificando se a data foi preenchida
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
                dtInicio = new java.sql.Date(sdf.parse(datainicial).getTime());
                dtFinal = new java.sql.Date(sdf.parse(datafinal).getTime());

                // Verificando o numero de dias do periodo definido
                long timeinicio = dtInicio.getTime();
                long timefim = dtFinal.getTime();
                long time = timefim - timeinicio;
                long dia = time / (1000 * 60 * 60 * 24);
                if (dia > DIAS_INTERVALO) {
                    setMsg("O periodo definido para a busca deve ser de no maximo 2 meses dias!");
                    return;
                }

                param.add(dtInicio);
                Calendar cal = Calendar.getInstance();
                cal.setTime(dtFinal);
                cal.add(Calendar.HOUR, 1);
                dtFinal = new java.sql.Date(cal.getTimeInMillis());
                param.add(dtFinal);
            }

            sql.append("order by not_tx_numero, not_dt_emissao desc, not_tx_cnpjcliente");
            list = getNot_notaDAO().executeQuery(sql.toString(), param);
            nrTotalNotas = list.size();

            listNrNotasFaltando = new Vector<String>();
            listDataSemNotas = new Vector<String>();
            if (list.size() > 0) {
                verificarSequenciasFaltandoNotas(list);
                verificarDiasSemNotas(list);
            }
            if (list.size() > 0) {
                achou = true;
                notaInicial = list.get(0).getNot_tx_numero();
                notaFinal = list.get(list.size() - 1).getNot_tx_numero();
            }
            nrTotalNotasGeral = totalNotasArmazenadas();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    /**
     * Obtem a quantidade de notas fiscais de um distribuidor
     * @return
     * @throws java.lang.Exception
     */
    private int totalNotasArmazenadas() throws Exception {
        Not_notaT notT = new Not_notaT();
        notT.setDis_nr_id(dis_distribuidoraT.getDis_nr_id());
        return getNot_notaDAO().getTotalNotasDistribuidora(notT);
    }

    private void verificarDiasSemNotas(List<Not_notaT> list) {
        Date dtIni = dtInicio;
        TreeMap<String, Date> map = new TreeMap<String, Date>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        while (dtIni.before(dtFinal)) {
            map.put(sdf.format(dtIni), dtIni);
            cal.setTime(dtIni);
            cal.add(Calendar.DAY_OF_MONTH, 1);
            dtIni = cal.getTime();
        }

        List<String> datasSemNotas = new Vector<String>();
        for (int i = 0; i < list.size(); i++) {
            Not_notaT not_notaT = list.get(i);
            Date dt = not_notaT.getNot_dt_emissao();
            String dtStr = sdf.format(dt);

            if (map.containsKey(dtStr)) {
                map.remove(dtStr);
            }
        }
        Iterator<Date> iter = map.values().iterator();
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        listDataSemNotas = new Vector<String>();
        while (iter.hasNext()) {
            Date dt = iter.next();
            listDataSemNotas.add(sdf.format(dt));
            setAchouNotasSemData(true);
        }
    }

    /**
     * Verifica as notas que estao faltando.
     * @param list
     */
    private void verificarSequenciasFaltandoNotas(List<Not_notaT> list) {
        // obtendo a primeira nota q nao seja de entrada
        int nrNotaSequencia = 0;
        for (Not_notaT not_notaT : list) {
            String tipoNota = not_notaT.getNot_tx_tipo();
            if (tipoNota!= null && tipoNota.toUpperCase().indexOf("VENDA") > -1) {
            //if ("VENDA".equalsIgnoreCase()) {
                nrNotaSequencia = not_notaT.getNot_tx_numero();
                break;
            }
        }


        for (int i = 1; i < list.size(); i++) {
            Not_notaT notT = list.get(i);
            String tipoNota = notT.getNot_tx_tipo();
            if (tipoNota!= null && tipoNota.toUpperCase().indexOf("VENDA") > -1) {
            //if ("VENDA".equalsIgnoreCase(notT.getNot_tx_tipo())) {
                int nrNota = list.get(i).getNot_tx_numero();
                //Obtem o numero da nota da proxima sequencia
                nrNotaSequencia++;
                //Checando as se a sequencia esta correta
                if (nrNota != (nrNotaSequencia)) {
                    int fim = nrNota - nrNotaSequencia;
                    //listNrNotasFaltando.add(String.valueOf(nrNotaSequencia));
                    for (int j = 0; j < fim; j++) {
                        listNrNotasFaltando.add(String.valueOf(nrNotaSequencia++));
                    }
                }
            }
        }

        // Confirma se realmente as notas estão faltando ou foram inseridas em outro período
        StringBuffer sql = new StringBuffer("select not_tx_numero from easynfe.not_nota where dis_nr_id=");
        sql.append(dis_distribuidoraT.getDis_nr_id()).append(" and not_tx_numero in (");

        if (listNrNotasFaltando.size() > 0) {
            sql.append(listNrNotasFaltando.get(0));
            for (int i = 1; i < listNrNotasFaltando.size(); i++) {
                String nota = listNrNotasFaltando.get(i);
                sql.append(", ").append(nota);
            }
            sql.append(") order by not_tx_numero");
            try {
                List<String> listNotas = getNot_notaDAO().getNrNotasQuery(sql.toString());
                for (String strNota : listNotas) {
                    listNrNotasFaltando.remove(strNota);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
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
            setMsg("Falha ao realizar exclus?o!");
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

    /**
     * @return the listNrNotasFaltando
     */
    public List<String> getListNrNotasFaltando() {
        return listNrNotasFaltando;
    }

    /**
     * @param listNrNotasFaltando the listNrNotasFaltando to set
     */
    public void setListNrNotasFaltando(List<String> listNrNotasFaltando) {
        this.setListNrNotasFaltando(listNrNotasFaltando);
    }

    /**
     * @return the nrTotalNotas
     */
    public int getNrTotalNotas() {
        return nrTotalNotas;
    }

    /**
     * @param nrTotalNotas the nrTotalNotas to set
     */
    public void setNrTotalNotas(int nrTotalNotas) {
        this.nrTotalNotas = nrTotalNotas;
    }

    /**
     * Monta a tabela com as datas em aberto
     * @return
     */
    public String getDatasEmAberto() {
        StringBuffer sb = new StringBuffer();
        int nrColunas = 5;
        int count = listDataSemNotas.size() / 5;
        if (listDataSemNotas.size() % 5 > 0) {
            count++;
        }
        int j = 0;

        for (int i = 0; i < count; i++) {
            sb.append("<tr>");
            int limite = (i + 1) * nrColunas;
            for (; (j < (limite) && j < listDataSemNotas.size()); j++) {
                String data = listDataSemNotas.get(j);
                String s = String.format("<td width=\"%s\">%s</td>", "20%", data);
                sb.append(s);
            }
            sb.append("</tr>");
        }
        return sb.toString();
    }

    /**
     * Monta a tabela com os numeros das notas ausentes
     * @return
     */
    public String getNotasAusentes() {
        StringBuffer sb = new StringBuffer();
        int nrColunas = 5;

        int count = listNrNotasFaltando.size() / 5;
        if (getListNrNotasFaltando().size() % 5 > 0) {
            count++;
        }
        int j = 0;
        for (int i = 0; i < count; i++) {
            sb.append("<tr>");
            int limite = (i + 1) * nrColunas;
            for (; (j < (limite) && j < getListNrNotasFaltando().size()); j++) {
                String nrNota = getListNrNotasFaltando().get(j);
                String s = String.format("<td width=\"%s\">%s</td>", "20%", nrNota);
                sb.append(s);
            }
            sb.append("</tr>");
        }
        return sb.toString();
    }

    /**
     * @return the notaInicial
     */
    public int getNotaInicial() {
        return notaInicial;
    }

    /**
     * @param notaInicial the notaInicial to set
     */
    public void setNotaInicial(int notaInicial) {
        this.notaInicial = notaInicial;
    }

    /**
     * @return the notaFinal
     */
    public int getNotaFinal() {
        return notaFinal;
    }

    /**
     * @param notaFinal the notaFinal to set
     */
    public void setNotaFinal(int notaFinal) {
        this.notaFinal = notaFinal;
    }

    /**
     * @return the nrTotalNotasGeral
     */
    public int getNrTotalNotasGeral() {
        return nrTotalNotasGeral;
    }

    /**
     * @param nrTotalNotasGeral the nrTotalNotasGeral to set
     */
    public void setNrTotalNotasGeral(int nrTotalNotasGeral) {
        this.nrTotalNotasGeral = nrTotalNotasGeral;
    }

    /**
     * @return the usu_usuarioT
     */
    public Usu_usuarioT getUsu_usuarioT() {
        return usu_usuarioT;
    }

    /**
     * @param usu_usuarioT the usu_usuarioT to set
     */
    public void setUsu_usuarioT(Usu_usuarioT usu_usuarioT) {
        this.usu_usuarioT = usu_usuarioT;
    }

    /**
     * @return the listDataSemNotas
     */
    public List<String> getListDataSemNotas() {
        return listDataSemNotas;
    }

    /**
     * @param listDataSemNotas the listDataSemNotas to set
     */
    public void setListDataSemNotas(List<String> listDataSemNotas) {
        this.listDataSemNotas = listDataSemNotas;
    }

    /**
     * @return the achouNotasSemData
     */
    public boolean isAchouNotasSemData() {
        return achouNotasSemData;
    }

    /**
     * @param achouNotasSemData the achouNotasSemData to set
     */
    public void setAchouNotasSemData(boolean achouNotasSemData) {
        this.achouNotasSemData = achouNotasSemData;
    }
}
