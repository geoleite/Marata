package br.com.i9.marata.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.marata.dao.*;
import br.com.i9.marata.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Gj_gnfe_empresaConsultJB extends SystemBase {

  // Atributos e propriedades
    private Gj_gnfe_empresaT gj_gnfe_empresaT = new Gj_gnfe_empresaT();

  public void setGj_gnfe_empresaT(Gj_gnfe_empresaT gj_gnfe_empresaT) {
    this.gj_gnfe_empresaT = gj_gnfe_empresaT;
  }

  public Gj_gnfe_empresaT getGj_gnfe_empresaT() {	
    return gj_gnfe_empresaT;
  }


	
  private List<Gj_gnfe_empresaT> list;

  public List<Gj_gnfe_empresaT> getList() {
    return list;
  }
  
  public void setList(List<Gj_gnfe_empresaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Gj_gnfe_empresaDAO gj_gnfe_empresaDAO = getGj_gnfe_empresaDAO();
      list = gj_gnfe_empresaDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Gj_gnfe_empresaDAO gj_gnfe_empresaDAO = getGj_gnfe_empresaDAO();
      gj_gnfe_empresaDAO.delete(gj_gnfe_empresaT);	 
      setMsg("Exclusao efetuada com sucesso!");
      gj_gnfe_empresaT = new Gj_gnfe_empresaT();
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  }  

 public void insert() throws Exception {
	// TODO Insert
	try {
	  String page = "gj_gnfe_empresaInsert.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

}
