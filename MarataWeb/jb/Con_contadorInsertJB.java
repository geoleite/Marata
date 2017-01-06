package br.com.easynet.nfegen.jb;

import br.com.easynet.criptografia.MD5;
import br.com.easynet.easyportal.dao.Usu_usuarioDAO;
import br.com.easynet.easyportal.transfer.Per_perfilT;
import br.com.easynet.easyportal.transfer.Pu_per_usuT;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;
import br.com.easynet.portal.transfer.Por_usuT;
import br.com.easynet.portal.transfer.Usu_por_canT;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Con_contadorInsertJB extends SystemBase {

  // Atributos e propriedades
    private Con_contadorT con_contadorT = new Con_contadorT();
    private Usu_usuarioT usu_usuarioT = new Usu_usuarioT();
    private String confSenha;
    public static String sinal = "sinal";


  public void setCon_contadorT(Con_contadorT con_contadorT) {
    this.con_contadorT = con_contadorT;
  }

  public Con_contadorT getCon_contadorT() {	
    return con_contadorT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  /**
     * Definindo a disribuidora no perfil
     */
    private void insertUsuarioPerfil() {
        br.com.easynet.easyportal.jb.SystemBase sb = new br.com.easynet.easyportal.jb.SystemBase();
        try {
            sb.setPage(page);
            //Obtendo o código do perfil
            Per_perfilT perT = new Per_perfilT();
            perT.setPer_tx_nome("Contador NFE");
            List<Per_perfilT> listPer = sb.getPer_perfilDAO().getByPer_tx_nome(perT);
            perT = listPer.size()>0?listPer.get(0):null;

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
            Por_usuT puT =  new Por_usuT();
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
    private void insertUsuario(Con_contadorT conT) {
        br.com.easynet.easyportal.jb.SystemBase sb = new br.com.easynet.easyportal.jb.SystemBase();
        try {
            usu_usuarioT.setUsu_tx_nome(conT.getCon_tx_nome());
            usu_usuarioT.setUsu_tx_login(conT.getCon_tx_cpf());
            usu_usuarioT.setUsu_tx_status("A");
            String senhaGerada = String.valueOf(System.currentTimeMillis())  ;
            usu_usuarioT.setUsu_tx_senha(MD5.criptografar(usu_usuarioT.getUsu_tx_senha()));

            sb.setPage(page);
            Usu_usuarioDAO usuDao = sb.getUsu_usuarioDAO();
            synchronized (sinal) {
                usuDao.insert(usu_usuarioT);
                //usu_usuarioT = usuDao.getUltimoUsuarioInserido();
                conT.setCon_nr_id(usu_usuarioT.getUsu_nr_id());
                insertUsuarioPerfil();
                insertPortalUsuario();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sb.close();
        }
    }
  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
        if (confSenha != null && confSenha.trim().length() > 0 &&
            confSenha.equalsIgnoreCase(usu_usuarioT.getUsu_tx_senha()) ) {
          insertUsuario(con_contadorT);
          Con_contadorDAO con_contadorDAO =  getCon_contadorDAO();
          con_contadorDAO.insert(getCon_contadorT());
          setMsg("Cadastro efetuado com sucesso!");
          clear();
            
        } else {
            setMsg("Senha nao confirmada!");
            return;
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
    
        setCon_contadorT(new Con_contadorT());
        usu_usuarioT = new Usu_usuarioT();
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "con_contadorConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
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
     * @return the confSenha
     */
    public String getConfSenha() {
        return confSenha;
    }

    /**
     * @param confSenha the confSenha to set
     */
    public void setConfSenha(String confSenha) {
        this.confSenha = confSenha;
    }

}
