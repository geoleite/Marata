package br.com.i9.marata.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.marata.dao.*;
import br.com.i9.marata.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Gnfe_cliente_fornecedorInsertJB extends SystemBase {

  // Atributos e propriedades
    private Gnfe_cliente_fornecedorT gnfe_cliente_fornecedorT = new Gnfe_cliente_fornecedorT();

  public void setGnfe_cliente_fornecedorT(Gnfe_cliente_fornecedorT gnfe_cliente_fornecedorT) {
    this.gnfe_cliente_fornecedorT = gnfe_cliente_fornecedorT;
  }

  public Gnfe_cliente_fornecedorT getGnfe_cliente_fornecedorT() {	
    return gnfe_cliente_fornecedorT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Gnfe_cliente_fornecedorDAO gnfe_cliente_fornecedorDAO =  getGnfe_cliente_fornecedorDAO();
      gnfe_cliente_fornecedorDAO.insert(gnfe_cliente_fornecedorT);	 
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
    
      gnfe_cliente_fornecedorT = new Gnfe_cliente_fornecedorT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "gnfe_cliente_fornecedorConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
