package br.com.i9.marata.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.marata.dao.*;
import br.com.i9.marata.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Gj_gnfe_nota_fiscalBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO =  getGj_gnfe_nota_fiscalDAO();
      gj_gnfe_nota_fiscalDAO.insert(gj_gnfe_nota_fiscalT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Gj_gnfe_nota_fiscalT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO = getGj_gnfe_nota_fiscalDAO();
      return gj_gnfe_nota_fiscalDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }

  }  

  /**
   * Deletar um registro
   */	
  public boolean delete(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(gj_gnfe_nota_fiscalT)) {
        Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO = getGj_gnfe_nota_fiscalDAO();
        gj_gnfe_nota_fiscalDAO.delete(gj_gnfe_nota_fiscalT);	 
        return true;
      } else {  
	return false;
      } 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  } 

  /**
   * Verifica se o objeto existe na base
   */
  public boolean exist(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
   try {
	
      Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO = getGj_gnfe_nota_fiscalDAO();
      List<Gj_gnfe_nota_fiscalT> listTemp  = gj_gnfe_nota_fiscalDAO.getByPK(gj_gnfe_nota_fiscalT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
	
  }

  /**
   * Realiza uma alterac?o na tabela
   */	
  public boolean update(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(gj_gnfe_nota_fiscalT)) {
        Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO = getGj_gnfe_nota_fiscalDAO();
        gj_gnfe_nota_fiscalDAO.update(gj_gnfe_nota_fiscalT);	 
	return true;        
      } else {  
	return false;
      } 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }   

  /**
   * Obt?m os dados de um registro
   */	
  public Gj_gnfe_nota_fiscalT findbyid(Gj_gnfe_nota_fiscalT gj_gnfe_nota_fiscalT) throws Exception {
    try {
      Gj_gnfe_nota_fiscalDAO gj_gnfe_nota_fiscalDAO = getGj_gnfe_nota_fiscalDAO();
      List<Gj_gnfe_nota_fiscalT> listTemp  = gj_gnfe_nota_fiscalDAO.getByPK( gj_gnfe_nota_fiscalT);	 

      return listTemp.size()>0?listTemp.get(0):new Gj_gnfe_nota_fiscalT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
