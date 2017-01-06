package br.com.i9.marata.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.marata.dao.*;
import br.com.i9.marata.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Gj_gnfe_empresaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Gj_gnfe_empresaT gj_gnfe_empresaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Gj_gnfe_empresaDAO gj_gnfe_empresaDAO =  getGj_gnfe_empresaDAO();
      gj_gnfe_empresaDAO.insert(gj_gnfe_empresaT);	 
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
  public List<Gj_gnfe_empresaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Gj_gnfe_empresaDAO gj_gnfe_empresaDAO = getGj_gnfe_empresaDAO();
      return gj_gnfe_empresaDAO.getAll();	 
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
  public boolean delete(Gj_gnfe_empresaT gj_gnfe_empresaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(gj_gnfe_empresaT)) {
        Gj_gnfe_empresaDAO gj_gnfe_empresaDAO = getGj_gnfe_empresaDAO();
        gj_gnfe_empresaDAO.delete(gj_gnfe_empresaT);	 
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
  public boolean exist(Gj_gnfe_empresaT gj_gnfe_empresaT) throws Exception {
   try {
	
      Gj_gnfe_empresaDAO gj_gnfe_empresaDAO = getGj_gnfe_empresaDAO();
      List<Gj_gnfe_empresaT> listTemp  = gj_gnfe_empresaDAO.getByPK(gj_gnfe_empresaT);	 

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
  public boolean update(Gj_gnfe_empresaT gj_gnfe_empresaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(gj_gnfe_empresaT)) {
        Gj_gnfe_empresaDAO gj_gnfe_empresaDAO = getGj_gnfe_empresaDAO();
        gj_gnfe_empresaDAO.update(gj_gnfe_empresaT);	 
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
  public Gj_gnfe_empresaT findbyid(Gj_gnfe_empresaT gj_gnfe_empresaT) throws Exception {
    try {
      Gj_gnfe_empresaDAO gj_gnfe_empresaDAO = getGj_gnfe_empresaDAO();
      List<Gj_gnfe_empresaT> listTemp  = gj_gnfe_empresaDAO.getByPK( gj_gnfe_empresaT);	 

      return listTemp.size()>0?listTemp.get(0):new Gj_gnfe_empresaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
