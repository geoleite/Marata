package br.com.easynet.nfegen.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Rel_registro_logConsultJB extends SystemBase {

    // Atributos e propriedades
    private String datainicial,  datafinal;
    private Rel_registro_logT rel_registro_logT = new Rel_registro_logT();
    private Dis_distribuidoraT dis_distribuidoraT = new Dis_distribuidoraT();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void setRel_registro_logT(Rel_registro_logT rel_registro_logT) {
        this.rel_registro_logT = rel_registro_logT;
    }

    public Rel_registro_logT getRel_registro_logT() {
        return rel_registro_logT;
    }
    private List<Rel_registro_logT> list;

    public List<Rel_registro_logT> getList() {
        return list;
    }

    public void setList(List<Rel_registro_logT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        dis_distribuidoraT = findbyIdDis_distribuidora(dis_distribuidoraT);

        if (datainicial == null) {
            datainicial = sdf.format(new Date());
        }
        if (datafinal == null) {
            datafinal = sdf.format(new Date());
        }
    //consult();
    }

    public void consult() throws Exception {
        try {
            Rel_registro_logDAO rel_registro_logDAO = getRel_registro_logDAO();
            if ((datainicial != null && datainicial.trim().length() > 0) && (datafinal != null && datafinal.trim().length() > 0)) {
                java.sql.Date dtInicio = new java.sql.Date(sdf.parse(datainicial).getTime());
                java.sql.Date dtFim = new java.sql.Date(sdf.parse(datafinal).getTime());
                Calendar cal = Calendar.getInstance();
                cal.setTime(dtFim);
                cal.add(Calendar.HOUR, 24);
                dtFim = new java.sql.Date(cal.getTimeInMillis());
                list = rel_registro_logDAO.getByData(dis_distribuidoraT, dtInicio, dtFim);
            } else {
                list = rel_registro_logDAO.getAllDistribuidora(dis_distribuidoraT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Rel_registro_logDAO rel_registro_logDAO = getRel_registro_logDAO();
            rel_registro_logDAO.delete(rel_registro_logT);
            setMsg("Exclus?o efetuada com sucesso!");
            rel_registro_logT = new Rel_registro_logT();
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
            String page = "rel_registro_logInsert.jsp";// defina aqui a p?gina que deve ser chamada
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

    /**
     * @return the datainicial
     */
    public String getDatainicial() {
        return datainicial;
    }

    /**
     * @param datainicial the datainicial to set
     */
    public void setDatainicial(String datainicial) {
        this.datainicial = datainicial;
    }

    /**
     * @return the datafinal
     */
    public String getDatafinal() {
        return datafinal;
    }

    /**
     * @param datafinal the datafinal to set
     */
    public void setDatafinal(String datafinal) {
        this.datafinal = datafinal;
    }

    /**
     * @return the dis_distribuidoraT
     */
    public Dis_distribuidoraT getDis_distribuidoraT() {
        return dis_distribuidoraT;
    }

    /**
     * @param dis_distribuidoraT the dis_distribuidoraT to set
     */
    public void setDis_distribuidoraT(Dis_distribuidoraT dis_distribuidoraT) {
        this.dis_distribuidoraT = dis_distribuidoraT;
    }
}
