package br.com.easynet.nfegen.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cd_con_disConsultJB extends SystemBase {

  // Atributos e propriedades
    private Cd_con_disT cd_con_disT = new Cd_con_disT();

  public void setCd_con_disT(Cd_con_disT cd_con_disT) {
    this.cd_con_disT = cd_con_disT;
  }

  public Cd_con_disT getCd_con_disT() {	
    return cd_con_disT;
  }


	
  private List<Cd_con_disT> list;

  public List<Cd_con_disT> getList() {
    return list;
  }
  
  public void setList(List<Cd_con_disT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Cd_con_disDAO cd_con_disDAO = getCd_con_disDAO();
      list = cd_con_disDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Cd_con_disDAO cd_con_disDAO = getCd_con_disDAO();
      cd_con_disDAO.delete(cd_con_disT);	 
      setMsg("Exclus?o efetuada com sucesso!");
      cd_con_disT = new Cd_con_disT();
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
	  String page = "cd_con_disInsert.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

}
