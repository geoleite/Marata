package br.com.easynet.nfegen.jb;

import br.com.easynet.easyportal.dao.Usu_usuarioDAO;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Con_contadorUpdateDeleteJB extends SystemBase {

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
  }

  public void clear() throws Exception {
    
      con_contadorT = new Con_contadorT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Con_contadorDAO con_contadorDAO = getCon_contadorDAO();
        con_contadorDAO.delete(con_contadorT);	 
        setMsg("Exclusao efetuada com sucesso!");
        clear();
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclusso!");
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      Con_contadorDAO con_contadorDAO = getCon_contadorDAO();
      List<Con_contadorT> listTemp  = con_contadorDAO.getByPK( con_contadorT);

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
    return false;
	
  }

  private void updateUsuario(Con_contadorT conT) {
      br.com.easynet.easyportal.jb.SystemBase sb = new br.com.easynet.easyportal.jb.SystemBase();
      sb.setPage(page);
      try {          
          Usu_usuarioDAO usuDao = sb.getUsu_usuarioDAO();
          Usu_usuarioT usuT = new Usu_usuarioT();
          usuT.setUsu_nr_id(conT.getCon_nr_id());
          List<Usu_usuarioT> list = usuDao.getById(usuT);
          usuT = list.size()>0?list.get(0):null;
          usuT.setUsu_tx_login(conT.getCon_tx_cpf());
          usuT.setUsu_tx_nome(conT.getCon_tx_nome());          
          usuDao.update(usuT);
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          sb.close();
      }
  }
  public void update() throws Exception {
    try {
      if (exist()) {
        Con_contadorDAO con_contadorDAO = getCon_contadorDAO();
        con_contadorDAO.update(con_contadorT);
        updateUsuario(con_contadorT);
        setMsg("Alteracao efetuada com sucesso!");
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar alteracao!");
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
      Con_contadorDAO con_contadorDAO = getCon_contadorDAO();
      List<Con_contadorT> listTemp  = con_contadorDAO.getByPK( con_contadorT);

      con_contadorT= listTemp.size()>0?listTemp.get(0):new Con_contadorT();
      
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
	  String page = "con_contadorConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "con_contadorConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
