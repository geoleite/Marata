package br.com.i9.marata.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.marata.dao.*;
import br.com.i9.marata.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Gj_gnfe_nota_fiscalInsertJB extends SystemBase {

  // Atributos e propriedades
    private Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT = new Gj_gnfe_nota_fiscalT();

  public void setGj_gnfe_nota_fiscalT(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) {
    this.gj_gnfe_nota_fiscalT = gj_gnfe_nota_fiscalT;
  }

  public Gj_gnfe_nota_fiscalT getGj_gnfe_nota_fiscalT() {	
    return gj_gnfe_nota_fiscalT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO =  getGj_gnfe_nota_fiscalDAO();
      gj_gnfe_nota_fiscalDAO.insert(gj_gnfe_nota_fiscalT);	 
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
    
      gj_gnfe_nota_fiscalT = new Gj_gnfe_nota_fiscalT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "gj_gnfe_nota_fiscalConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
