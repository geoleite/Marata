package br.com.i9.marata.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.marata.dao.*;
import br.com.i9.marata.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Gnfe_cliente_fornecedorUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Gnfe_cliente_fornecedorT gnfe_cliente_fornecedorT = new Gnfe_cliente_fornecedorT();

  public void setGnfe_cliente_fornecedorT(Gnfe_cliente_fornecedorT gnfe_cliente_fornecedorT) {
    this.gnfe_cliente_fornecedorT = gnfe_cliente_fornecedorT;
  }

  public Gnfe_cliente_fornecedorT getGnfe_cliente_fornecedorT() {	
    return gnfe_cliente_fornecedorT;
  }

	
  private List<Gnfe_cliente_fornecedorT> list;

  public List<Gnfe_cliente_fornecedorT> getList() {
    return list;
  }
  
  public void setList(List<Gnfe_cliente_fornecedorT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      gnfe_cliente_fornecedorT = new Gnfe_cliente_fornecedorT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Gnfe_cliente_fornecedorDAO gnfe_cliente_fornecedorDAO = getGnfe_cliente_fornecedorDAO();
        gnfe_cliente_fornecedorDAO.delete(gnfe_cliente_fornecedorT);	 
        setMsg("Exclusao efetuada com sucesso!");
        clear();
      } else {  
	setMsg(ERROR, "Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      Gnfe_cliente_fornecedorDAO gnfe_cliente_fornecedorDAO = getGnfe_cliente_fornecedorDAO();
      List<Gnfe_cliente_fornecedorT> listTemp  = gnfe_cliente_fornecedorDAO.getByPK( gnfe_cliente_fornecedorT);	 

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
        Gnfe_cliente_fornecedorDAO gnfe_cliente_fornecedorDAO = getGnfe_cliente_fornecedorDAO();
        gnfe_cliente_fornecedorDAO.update(gnfe_cliente_fornecedorT);	 
        setMsg("Alteracao efetuada com sucesso!");	
      } else {  
	setMsg(ERROR,"Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar alteracao!");	
    } finally {
	close();
    }
  }   

// Method de lookup
// 


  //Method Download Image e montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Gnfe_cliente_fornecedorDAO gnfe_cliente_fornecedorDAO = getGnfe_cliente_fornecedorDAO();
      List<Gnfe_cliente_fornecedorT> listTemp  = gnfe_cliente_fornecedorDAO.getByPK( gnfe_cliente_fornecedorT);	 

      gnfe_cliente_fornecedorT= listTemp.size()>0?listTemp.get(0):new Gnfe_cliente_fornecedorT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
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
	  String page = "gnfe_cliente_fornecedorConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "gnfe_cliente_fornecedorConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
