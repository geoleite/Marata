package br.com.easynet.nfegen.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cd_con_disInsertJB extends SystemBase {

  // Atributos e propriedades
    private Cd_con_disT cd_con_disT = new Cd_con_disT();

  public void setCd_con_disT(Cd_con_disT cd_con_disT) {
    this.cd_con_disT = cd_con_disT;
  }

  public Cd_con_disT getCd_con_disT() {	
    return cd_con_disT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultCon_contador();

		consultDis_distribuidora();

  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Cd_con_disDAO cd_con_disDAO =  getCd_con_disDAO();
      cd_con_disDAO.insert(cd_con_disT);	 
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
	private List<Con_contadorT> listcon_contador;
	public List<Con_contadorT> getListcon_contador() {
		return listcon_contador;
	}

	 public void setListcon_contador(List<Con_contadorT> list) {
		this.listcon_contador=list;
	}
	public void consultCon_contador() throws Exception {
		try {
			Con_contadorDAO con_contadorDAO = getCon_contadorDAO();
			listcon_contador=con_contadorDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	private List<Dis_distribuidoraT> listdis_distribuidora;
	public List<Dis_distribuidoraT> getListdis_distribuidora() {
		return listdis_distribuidora;
	}

	 public void setListdis_distribuidora(List<Dis_distribuidoraT> list) {
		this.listdis_distribuidora=list;
	}
	public void consultDis_distribuidora() throws Exception {
		try {
			Dis_distribuidoraDAO dis_distribuidoraDAO = getDis_distribuidoraDAO();
			listdis_distribuidora=dis_distribuidoraDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}


  
  public void clear() throws Exception {
    
      cd_con_disT = new Cd_con_disT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "cd_con_disConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
