package br.com.easynet.nfegen.jb;

import br.com.easynet.criptografia.MD5;
import br.com.easynet.easyportal.dao.Pu_per_usuDAO;
import br.com.easynet.easyportal.dao.Usu_usuarioDAO;
import br.com.easynet.easyportal.transfer.Per_perfilT;
import br.com.easynet.easyportal.transfer.Pu_per_usuT;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;
import br.com.easynet.nfegen.util.ValidacaoCNPJ_CPF;
import br.com.easynet.portal.transfer.Por_usuT;
import br.com.easynet.portal.transfer.Usu_por_canT;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Dis_distribuidoraInsertJB extends SystemBase {

    // Atributos e propriedades
    private final static Object sinal = "sinal";
    private Usu_usuarioT usu_usuarioT = new Usu_usuarioT();
    private Dis_distribuidoraT dis_distribuidoraT = new Dis_distribuidoraT();
    private List<Dis_distribuidoraT> listaDist;
    private String statusUsuario="A";

    public void setDis_distribuidoraT(Dis_distribuidoraT dis_distribuidoraT) {
        this.dis_distribuidoraT = dis_distribuidoraT;
    }

    public Dis_distribuidoraT getDis_distribuidoraT() {
        return dis_distribuidoraT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    
        listaDist = getDis_distribuidoraDAO().getAll();
    }

    private void removerUsuarioPerfilClienteNFE(br.com.easynet.easyportal.jb.SystemBase sb) throws Exception {
            Per_perfilT perT = new Per_perfilT();
            perT.setPer_tx_nome("Cliente NFE");
            List<Per_perfilT> listPer = sb.getPer_perfilDAO().getByPer_tx_nome(perT);
            perT = listPer.size() > 0 ? listPer.get(0) : null;

            // Inserindo o usuário no perfil
            Pu_per_usuT puT = new Pu_per_usuT();
            puT.setPer_nr_id(perT.getPer_nr_id());
            puT.setUsu_nr_id(usu_usuarioT.getUsu_nr_id());
            sb.getPu_per_usuDAO().delete(puT);

    }
    /**
     * Definindo a disribuidora no perfil
     */
    private void insertUsuarioPerfil() {
        br.com.easynet.easyportal.jb.SystemBase sb = new br.com.easynet.easyportal.jb.SystemBase();
        try {
            sb.setPage(page);
            // Apagando o perfil Cliente caso exista
            //removerUsuarioPerfilClienteNFE(sb); // Deve manter o perfil da distribuidora como cliente também

            //Obtendo o código do perfil Distribuidora NFE
            Per_perfilT perT = new Per_perfilT();
            perT.setPer_tx_nome("Distribuidora NFE");
            List<Per_perfilT> listPer = sb.getPer_perfilDAO().getByPer_tx_nome(perT);
            perT = listPer.size() > 0 ? listPer.get(0) : null;

            // Inserindo o usuário no perfil
            Pu_per_usuT puT = new Pu_per_usuT();
            puT.setPer_nr_id(perT.getPer_nr_id());
            puT.setUsu_nr_id(usu_usuarioT.getUsu_nr_id());
            sb.getPu_per_usuDAO().insert(puT);

            perT = new Per_perfilT();
            perT.setPer_tx_nome("Padrao");
            listPer = sb.getPer_perfilDAO().getByPer_tx_nome(perT);
            perT = listPer.size() > 0 ? listPer.get(0) : null;

            // Inserindo o usuário no perfil Padrao
            puT = new Pu_per_usuT();
            puT.setPer_nr_id(perT.getPer_nr_id());
            puT.setUsu_nr_id(usu_usuarioT.getUsu_nr_id());
            sb.getPu_per_usuDAO().insert(puT);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sb.close();
        }
    }

    /**
     * Define o portal do usuário
     */
    private void insertPortalUsuario() {
        br.com.easynet.portal.jb.SystemBase sb = new br.com.easynet.portal.jb.SystemBase();
        try {
            sb.setPage(page);
            Por_usuT puT = new Por_usuT();
            puT.setPor_nr_id(1);// Código um representa o portal padrão
            puT.setUsu_nr_id(usu_usuarioT.getUsu_nr_id());
            sb.getPor_usuDAO().insert(puT);

            Usu_por_canT upcT = new Usu_por_canT();
            upcT.setPor_nr_id(puT.getPor_nr_id());
            upcT.setUsu_nr_id(puT.getUsu_nr_id());
            upcT.setUpc_nr_ordem(1);
            upcT.setUpc_tx_status("A");
            upcT.setCan_nr_id(1);

            sb.getUsu_por_canDAO().insert(upcT);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sb.close();
        }
    }

    /**
     * Insere a distribuidora na tabela de usuário do portal e define o código da distribuidora
     */
    private void insertUsuario() {
        br.com.easynet.easyportal.jb.SystemBase sb = new br.com.easynet.easyportal.jb.SystemBase();
        try {
            usu_usuarioT.setUsu_tx_nome(dis_distribuidoraT.getDis_tx_nome());
            usu_usuarioT.setUsu_tx_login(dis_distribuidoraT.getDis_tx_cnpj());
            usu_usuarioT.setUsu_tx_status(statusUsuario);
            usu_usuarioT.setUsu_tx_senha(MD5.criptografar(usu_usuarioT.getUsu_tx_senha()));

            sb.setPage(page);
            Usu_usuarioDAO usuDao = sb.getUsu_usuarioDAO();
            List<Usu_usuarioT> listUsuT = usuDao.getByUsu_tx_login(usu_usuarioT);
            if (listUsuT.size() == 0) {
                synchronized (sinal) {
                    usuDao.insert(usu_usuarioT);
                    usu_usuarioT = usuDao.getUltimoUsuarioInserido();
                    insertUsuarioPerfil();
                    insertPortalUsuario();
                }
            } else {
                usu_usuarioT = listUsuT.get(0);
                insertUsuarioPerfil();
            }
            dis_distribuidoraT.setDis_nr_id(usu_usuarioT.getUsu_nr_id());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sb.close();
        }
    }
    // M?todos de Eventos

    public void insert() throws Exception {

        try {

            Dis_distribuidoraDAO dis_distribuidoraDAO = getDis_distribuidoraDAO();
            //ValidacaoCNPJ_CPF.
            if (!ValidacaoCNPJ_CPF.valideCNPJ(dis_distribuidoraT.getDis_tx_cnpj())) {
                setMsg("CNPJ inválido!");
                return;
            }
            List<Dis_distribuidoraT> listDist = dis_distribuidoraDAO.getByDis_tx_cnpj(dis_distribuidoraT);
            if (listDist.size() == 0) {
                insertUsuario();
                dis_distribuidoraDAO.insert(dis_distribuidoraT);
                setMsg("Cadastro efetuado com sucesso!");
                clear();
            } else {
                setMsg("Distribuidora ja cadastrada!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar cadastro!");
        } finally {
            close();
        }
    }

// Method de lookup
// 
    public void clear() throws Exception {

        dis_distribuidoraT = new Dis_distribuidoraT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "dis_distribuidoraConsult.jsp";// defina aqui a p?gina que deve ser chamada  

            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public Usu_usuarioT getUsu_usuarioT() {
        return usu_usuarioT;
    }

    public void setUsu_usuarioT(Usu_usuarioT usu_usuarioT) {
        this.usu_usuarioT = usu_usuarioT;
    }

    /**
     * @return the listaDist
     */
    public List<Dis_distribuidoraT> getListaDist() {
        return listaDist;
    }

    /**
     * @param listaDist the listaDist to set
     */
    public void setListaDist(List<Dis_distribuidoraT> listaDist) {
        this.listaDist = listaDist;
    }

    /**
     * @return the statusUsuario
     */
    public String getStatusUsuario() {
        return statusUsuario;
    }

    /**
     * @param statusUsuario the statusUsuario to set
     */
    public void setStatusUsuario(String statusUsuario) {
        this.statusUsuario = statusUsuario;
    }
}
