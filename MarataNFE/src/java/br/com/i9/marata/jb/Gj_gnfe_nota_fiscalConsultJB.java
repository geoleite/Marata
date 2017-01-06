package br.com.i9.marata.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.marata.dao.*;
import br.com.i9.marata.transfer.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Gj_gnfe_nota_fiscalConsultJB extends SystemBase {

    // Atributos e propriedades
    private Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT = new Gj_gnfe_nota_fiscalT();
    private String dataInicial = new String();
    private String dataFinal = new String();
    private String tipoNota = "";

    public void setGj_gnfe_nota_fiscalT(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) {
        this.gj_gnfe_nota_fiscalT = gj_gnfe_nota_fiscalT;
    }

    public Gj_gnfe_nota_fiscalT getGj_gnfe_nota_fiscalT() {
        return gj_gnfe_nota_fiscalT;
    }
    private List<Gj_gnfe_nota_fiscalT> list;

    public List<Gj_gnfe_nota_fiscalT> getList() {
        return list;
    }

    public void setList(List<Gj_gnfe_nota_fiscalT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void consult() throws Exception {
        try {
            Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO = getGj_gnfe_nota_fiscalDAO();
            list = gj_gnfe_nota_fiscalDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultByTotvs() throws Exception {
        try {
            list = getGj_gnfe_nota_fiscalDAO().getBySomenteTotvs();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultByEmail() throws Exception {
        try {
            list = getGj_gnfe_nota_fiscalDAO().getBySomenteEmail();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultByCnpj() throws Exception {
        try {
            Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO = getGj_gnfe_nota_fiscalDAO();
            if (tipoNota != null && tipoNota.trim().length() > 0) {
                gj_gnfe_nota_fiscalT.setOrigem(Integer.parseInt(tipoNota));
                if (gj_gnfe_nota_fiscalT.getOrigem() == 0) {
                    list = gj_gnfe_nota_fiscalDAO.getByTotvs_des_nfeOrigem(gj_gnfe_nota_fiscalT);
                } else {
                    list = gj_gnfe_nota_fiscalDAO.getByTotvs_emi_nfeOrigem(gj_gnfe_nota_fiscalT);
                }
                //list = gj_gnfe_nota_fiscalDAO.getByNum_cgc_cpfTipoNota(gj_gnfe_nota_fiscalT);

            } else {
                list = gj_gnfe_nota_fiscalDAO.getByNum_cgc_cpf(gj_gnfe_nota_fiscalT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultByNfeId() {
        try {
            Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO = getGj_gnfe_nota_fiscalDAO();
            list = gj_gnfe_nota_fiscalDAO.getByNfe(gj_gnfe_nota_fiscalT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultByNumeroNota() {
        try {
            Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO = getGj_gnfe_nota_fiscalDAO();
            list = gj_gnfe_nota_fiscalDAO.getByTotvs_num_nfe(gj_gnfe_nota_fiscalT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultByNfe() throws Exception {
        try {
            Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO = getGj_gnfe_nota_fiscalDAO();
            list = gj_gnfe_nota_fiscalDAO.getByNfe(gj_gnfe_nota_fiscalT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    private Gj_gnfe_empresaT getEmpesa(String idEnt) throws Exception{
        Gj_gnfe_empresaT gj_gnfe_empresaT = new Gj_gnfe_empresaT();
        gj_gnfe_empresaT.setId_ent(idEnt);
        List<Gj_gnfe_empresaT> listEmp = getGj_gnfe_empresaDAO().getById_ent(gj_gnfe_empresaT);
        return listEmp.size() > 0?listEmp.get(0):null;
    }
    public void consultByPeriodo() throws Exception {
        try {
            Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO = getGj_gnfe_nota_fiscalDAO();

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dtInicial = new Date(format.parse(dataInicial).getTime());
            Date dtFinal = new Date(format.parse(dataFinal).getTime());
            Gj_gnfe_empresaT empresaT = getEmpesa(gj_gnfe_nota_fiscalT.getId_ent());
            if (tipoNota != null && tipoNota.trim().length() > 0) {
                gj_gnfe_nota_fiscalT.setOrigem(Integer.parseInt(tipoNota));
                if (gj_gnfe_nota_fiscalT.getOrigem() == 0) {
                    gj_gnfe_nota_fiscalT.setNum_cgc_cpf(empresaT.getCnpj_empresa());
                    list = gj_gnfe_nota_fiscalDAO.getByNfeEmpresaOuClientePeriodoTipoNota(gj_gnfe_nota_fiscalT, dtInicial, dtFinal);
                } else {
                    list = gj_gnfe_nota_fiscalDAO.getByNfePeriodoTipoNota(gj_gnfe_nota_fiscalT, dtInicial, dtFinal);
                }

            } else {
                list = gj_gnfe_nota_fiscalDAO.getByNfePeriodo(gj_gnfe_nota_fiscalT, dtInicial, dtFinal);
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultByPeriodoEmpresaOuCliente() throws Exception {
        try {
            Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO = getGj_gnfe_nota_fiscalDAO();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dtInicial = new Date(format.parse(dataInicial).getTime());
            Date dtFinal = new Date(format.parse(dataFinal).getTime());
            if (tipoNota != null && tipoNota.trim().length() > 0) {
                gj_gnfe_nota_fiscalT.setOrigem(Integer.parseInt(tipoNota));
                list = gj_gnfe_nota_fiscalDAO.getByNfeEmpresaOuClientePeriodoTipoNota(gj_gnfe_nota_fiscalT, dtInicial, dtFinal);
            } else {
                list = gj_gnfe_nota_fiscalDAO.getByNfeEmpresaOuClientePeriodo(gj_gnfe_nota_fiscalT, dtInicial, dtFinal);
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO = getGj_gnfe_nota_fiscalDAO();
            gj_gnfe_nota_fiscalDAO.delete(gj_gnfe_nota_fiscalT);
            setMsg("Exclusao efetuada com sucesso!");
            gj_gnfe_nota_fiscalT = new Gj_gnfe_nota_fiscalT();
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar exclusao!");
        } finally {
            close();
        }
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "gj_gnfe_nota_fiscalInsert.jsp";// defina aqui a pagina que deve ser chamada  
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "";// defina aqui a pagina que deve ser chamada  
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the dataInicial
     */
    public String getDataInicial() {
        return dataInicial;
    }

    /**
     * @param dataInicial the dataInicial to set
     */
    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    /**
     * @return the dataFinal
     */
    public String getDataFinal() {
        return dataFinal;
    }

    /**
     * @param dataFinal the dataFinal to set
     */
    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
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
