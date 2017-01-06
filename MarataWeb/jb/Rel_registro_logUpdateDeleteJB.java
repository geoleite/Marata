package br.com.easynet.nfegen.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Rel_registro_logUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Rel_registro_logT rel_registro_logT = new Rel_registro_logT();

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
	//
  }

  public void clear() throws Exception {
    
      rel_registro_logT = new Rel_registro_logT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Rel_registro_logDAO rel_registro_logDAO = getRel_registro_logDAO();
        rel_registro_logDAO.delete(rel_registro_logT);	 
        setMsg("Exclus?o efetuada com sucesso!");
        clear();
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclus?o!");	
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      Rel_registro_logDAO rel_registro_logDAO = getRel_registro_logDAO();
      //List<Rel_registro_logT> listTemp  = rel_registro_logDAO.getById( rel_registro_logT);

      //return listTemp.size()>0;
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
    return false;
	
  }

  public void update() throws Exception {
    try {
      if (exist()) {
        Rel_registro_logDAO rel_registro_logDAO = getRel_registro_logDAO();
        rel_registro_logDAO.update(rel_registro_logT);	 
        setMsg("Altera??o efetuada com sucesso!");	
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar altera??o!");	
    } finally {
	close();
    }
  }   

// Method de lookup
// 


  //Method Download Image ? montando se houver algum campo do tipo bin?rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Rel_registro_logDAO rel_registro_logDAO = getRel_registro_logDAO();
//      List<Rel_registro_logT> listTemp  = rel_registro_logDAO.getById( rel_registro_logT);
//
//      rel_registro_logT= listTemp.size()>0?listTemp.get(0):new Rel_registro_logT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a p?gina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "rel_registro_logConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "rel_registro_logConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
