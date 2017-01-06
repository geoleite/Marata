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

public class Emp_empresaInsertJB extends SystemBase {

  // Atributos e propriedades
    private Dis_distribuidoraT dis_distribuidoraT = new Dis_distribuidoraT();
    private Emp_empresaT emp_empresaT = new Emp_empresaT();
    private Usu_usuarioT usu_usuarioT = new Usu_usuarioT();
    private String sinal = "sinal";

  public void setEmp_empresaT(Emp_empresaT emp_empresaT) {
    this.emp_empresaT = emp_empresaT;
  }

  public Emp_empresaT getEmp_empresaT() {	
    return emp_empresaT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
        dis_distribuidoraT = findbyIdDis_distribuidora(dis_distribuidoraT);
	
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
            perT.setPer_tx_nome("Cliente NFE");
            List<Per_perfilT> listPer = sb.getPer_perfilDAO().getByPer_tx_nome(perT);
            perT = listPer.size()>0?listPer.get(0):null;

            // Inserindo o usuário no perfil
            Pu_per_usuT puT = new Pu_per_usuT();
            puT.setPer_nr_id(perT.getPer_nr_id());
            puT.setUsu_nr_id(getUsu_usuarioT().getUsu_nr_id());
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
            puT.setUsu_nr_id(getUsu_usuarioT().getUsu_nr_id());
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
    private void insertUsuario(Emp_empresaT empT) {
        br.com.easynet.easyportal.jb.SystemBase sb = new br.com.easynet.easyportal.jb.SystemBase();
        try {
            getUsu_usuarioT().setUsu_tx_nome(empT.getEmp_tx_nome());
            getUsu_usuarioT().setUsu_tx_login(empT.getEmp_tx_cnpj());
            getUsu_usuarioT().setUsu_tx_status("A");
            String senhaGerada = String.valueOf(System.currentTimeMillis())  ;
            getUsu_usuarioT().setUsu_tx_senha(MD5.criptografar(senhaGerada));

            sb.setPage(page);
            Usu_usuarioDAO usuDao = sb.getUsu_usuarioDAO();
            synchronized (sinal) {
                usuDao.insert(getUsu_usuarioT());
                setUsu_usuarioT(usuDao.getUltimoUsuarioInserido());
                empT.setEmp_nr_id(getUsu_usuarioT().getUsu_nr_id());
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
      Emp_empresaDAO emp_empresaDAO =  getEmp_empresaDAO();
      //emp_empresaT.setDis_nr_id(dis_distribuidoraT.getDis_nr_id());
      insertUsuario(emp_empresaT);
      emp_empresaDAO.insert(emp_empresaT);	 
      setMsg("Cadastro efetuado com sucesso!");
      clear();
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
    
      emp_empresaT = new Emp_empresaT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "emp_empresaConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

    public Dis_distribuidoraT getDis_distribuidoraT() {
        return dis_distribuidoraT;
    }

    public void setDis_distribuidoraT(Dis_distribuidoraT dis_distribuidoraT) {
        this.dis_distribuidoraT = dis_distribuidoraT;
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

}
