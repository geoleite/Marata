package br.com.i9.marata.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.marata.dao.*;
import br.com.i9.marata.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Gj_gnfe_empresaInsertJB extends SystemBase {

  // Atributos e propriedades
    private Gj_gnfe_empresaT gj_gnfe_empresaT = new Gj_gnfe_empresaT();

  public void setGj_gnfe_empresaT(Gj_gnfe_empresaT gj_gnfe_empresaT) {
    this.gj_gnfe_empresaT = gj_gnfe_empresaT;
  }

  public Gj_gnfe_empresaT getGj_gnfe_empresaT() {	
    return gj_gnfe_empresaT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Gj_gnfe_empresaDAO gj_gnfe_empresaDAO =  getGj_gnfe_empresaDAO();
      gj_gnfe_empresaDAO.insert(gj_gnfe_empresaT);	 
      setMsg(INFO,"Cadastro efetuado com sucesso!");
      clear();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar cadastro!");	
    } finally {
	close();
    }
  } 

// Method de lookup
// 

  
  public void clear() throws Exception {
    
      gj_gnfe_empresaT = new Gj_gnfe_empresaT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "gj_gnfe_empresaConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
