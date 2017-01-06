package br.com.easynet.nfegen.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class De_dis_empConsultJB extends SystemBase {

  // Atributos e propriedades
    private De_dis_empT de_dis_empT = new De_dis_empT();

  public void setDe_dis_empT(De_dis_empT de_dis_empT) {
    this.de_dis_empT = de_dis_empT;
  }

  public De_dis_empT getDe_dis_empT() {	
    return de_dis_empT;
  }


	
  private List<De_dis_empT> list;

  public List<De_dis_empT> getList() {
    return list;
  }
  
  public void setList(List<De_dis_empT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      De_dis_empDAO de_dis_empDAO = getDe_dis_empDAO();
      list = de_dis_empDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      De_dis_empDAO de_dis_empDAO = getDe_dis_empDAO();
      de_dis_empDAO.delete(de_dis_empT);	 
      setMsg("Exclus?o efetuada com sucesso!");
      de_dis_empT = new De_dis_empT();
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
	  String page = "de_dis_empInsert.jsp";// defina aqui a p?gina que deve ser chamada  
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
