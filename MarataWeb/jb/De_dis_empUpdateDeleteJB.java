package br.com.easynet.nfegen.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class De_dis_empUpdateDeleteJB extends SystemBase {

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
	//
		consultDis_distribuidora();

		consultEmp_empresa();

  }

  public void clear() throws Exception {
    
      de_dis_empT = new De_dis_empT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        De_dis_empDAO de_dis_empDAO = getDe_dis_empDAO();
        de_dis_empDAO.delete(de_dis_empT);	 
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
      De_dis_empDAO de_dis_empDAO = getDe_dis_empDAO();
      List<De_dis_empT> listTemp  = de_dis_empDAO.getById( de_dis_empT);	 

      return listTemp.size()>0;      
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
        De_dis_empDAO de_dis_empDAO = getDe_dis_empDAO();
        de_dis_empDAO.update(de_dis_empT);	 
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

	private List<Emp_empresaT> listemp_empresa;
	public List<Emp_empresaT> getListemp_empresa() {
		return listemp_empresa;
	}

	 public void setListemp_empresa(List<Emp_empresaT> list) {
		this.listemp_empresa=list;
	}
	public void consultEmp_empresa() throws Exception {
		try {
			Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
			listemp_empresa=emp_empresaDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}



  //Method Download Image ? montando se houver algum campo do tipo bin?rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      De_dis_empDAO de_dis_empDAO = getDe_dis_empDAO();
      List<De_dis_empT> listTemp  = de_dis_empDAO.getById( de_dis_empT);	 

      de_dis_empT= listTemp.size()>0?listTemp.get(0):new De_dis_empT();
      
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
	  String page = "de_dis_empConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "de_dis_empConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
