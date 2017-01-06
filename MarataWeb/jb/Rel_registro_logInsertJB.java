package br.com.easynet.nfegen.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Rel_registro_logInsertJB extends SystemBase {

  // Atributos e propriedades
    private Rel_registro_logT rel_registro_logT = new Rel_registro_logT();

  public void setRel_registro_logT(Rel_registro_logT rel_registro_logT) {
    this.rel_registro_logT = rel_registro_logT;
  }

  public Rel_registro_logT getRel_registro_logT() {	
    return rel_registro_logT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Rel_registro_logDAO rel_registro_logDAO =  getRel_registro_logDAO();
      rel_registro_logDAO.insert(rel_registro_logT);	 
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

  
  public void clear() throws Exception {
    
      rel_registro_logT = new Rel_registro_logT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "rel_registro_logConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
