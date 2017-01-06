package br.com.easynet.nfegen.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Con_contadorConsultJB extends SystemBase {

  // Atributos e propriedades
    private Con_contadorT con_contadorT = new Con_contadorT();

  public void setCon_contadorT(Con_contadorT con_contadorT) {
    this.con_contadorT = con_contadorT;
  }

  public Con_contadorT getCon_contadorT() {	
    return con_contadorT;
  }


	
  private List<Con_contadorT> list;

  public List<Con_contadorT> getList() {
    return list;
  }
  
  public void setList(List<Con_contadorT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Con_contadorDAO con_contadorDAO = getCon_contadorDAO();
      list = con_contadorDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Con_contadorDAO con_contadorDAO = getCon_contadorDAO();
      con_contadorDAO.delete(con_contadorT);	 
      setMsg("Exclus?o efetuada com sucesso!");
      con_contadorT = new Con_contadorT();
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
	  String page = "con_contadorInsert.jsp";// defina aqui a p?gina que deve ser chamada  
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
