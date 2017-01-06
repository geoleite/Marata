package br.com.easynet.nfegen.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.nfegen.transfer.*;

public class Fun_funcionarioDAO extends ObjectDAO { 
	 public Fun_funcionarioDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Fun_funcionarioT fun_funcionarioT ) throws Exception { 
		 String sql = "insert into easynfe.fun_funcionario  ( fun_nr_id, dis_nr_id) values ( ? , ? )";
		 PreparedStatement pStmt = con.prepareStatement(sql);
		 pStmt.setObject(1, fun_funcionarioT.getFun_nr_id());
		 pStmt.setObject(2, fun_funcionarioT.getDis_nr_id());
		 pStmt.execute();
 	 }

	 public void update(Fun_funcionarioT fun_funcionarioT ) throws Exception { 
		 String sql = "update easynfe.fun_funcionario set - where  fun_nr_id=? and dis_nr_id=?";
 		 PreparedStatement pStmt = con.prepareStatement(sql);
		 pStmt.setObject(1, fun_funcionarioT.getFun_nr_id());
		 pStmt.setObject(2, fun_funcionarioT.getDis_nr_id());
		 pStmt.execute();
 	 }

	 public void delete(Fun_funcionarioT fun_funcionarioT ) throws Exception { 
		 String sql = "delete from easynfe.fun_funcionario where  fun_nr_id=? and dis_nr_id=?";
		 PreparedStatement pStmt = con.prepareStatement(sql);
		 pStmt.setObject(1, fun_funcionarioT.getFun_nr_id());
		 pStmt.setObject(2, fun_funcionarioT.getDis_nr_id());
		 pStmt.execute();
 	 }

	 private List<Fun_funcionarioT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Fun_funcionarioT> objs = new Vector();
		 while (rs.next()) { 
 			 Fun_funcionarioT fun_funcionarioT = new Fun_funcionarioT();
			 fun_funcionarioT.setFun_nr_id(rs.getInt("fun_nr_id"));
			 fun_funcionarioT.setDis_nr_id(rs.getInt("dis_nr_id"));
			 objs.add(fun_funcionarioT);
 		 }
		 return objs; 
 	 }
	 public List<Fun_funcionarioT> getAll() throws Exception { 
		 String sql = "select * from easynfe.fun_funcionario"; 
		 PreparedStatement pStmt = con.prepareStatement(sql);
		 ResultSet rs = pStmt.executeQuery();
 		 return resultSetToObjectTransfer(rs); 
 	}

	 public List<Fun_funcionarioT> getById(Fun_funcionarioT fun_funcionarioT) throws Exception { 
		 String sql = "select * from easynfe.fun_funcionario where  fun_nr_id=? and dis_nr_id=?"; 
		 PreparedStatement pStmt = con.prepareStatement(sql);
		 pStmt.setObject(1, fun_funcionarioT.getFun_nr_id());
		 pStmt.setObject(2, fun_funcionarioT.getDis_nr_id());
		 ResultSet rs = pStmt.executeQuery();
 		 return resultSetToObjectTransfer(rs); 
 	}

	 public List<Fun_funcionarioT> getByFun_nr_id(Fun_funcionarioT fun_funcionarioT) throws Exception { 
		 String sql = "select * from easynfe.fun_funcionario where  fun_nr_id = ? "; 
		 PreparedStatement pStmt = con.prepareStatement(sql);
		 pStmt.setObject(1, fun_funcionarioT.getFun_nr_id());
		 ResultSet rs = pStmt.executeQuery();
 		 return resultSetToObjectTransfer(rs); 
 	}
	 public List<Fun_funcionarioT> getByDis_nr_id(Fun_funcionarioT fun_funcionarioT) throws Exception { 
		 String sql = "select * from easynfe.fun_funcionario where  dis_nr_id = ? "; 
		 PreparedStatement pStmt = con.prepareStatement(sql);
		 pStmt.setObject(1, fun_funcionarioT.getDis_nr_id());
		 ResultSet rs = pStmt.executeQuery();
 		 return resultSetToObjectTransfer(rs); 
 	}

	 /** Many to One */
	 public Dis_distribuidoraT getByDis_distribuidoraT(Fun_funcionarioT fun_funcionarioT) throws Exception { 
		Dis_distribuidoraDAO dao = new Dis_distribuidoraDAO(getDAOFactory());
		Dis_distribuidoraT dis_distribuidoraT = new Dis_distribuidoraT();
		dis_distribuidoraT.setDis_nr_id(fun_funcionarioT.getDis_nr_id());
		List<Dis_distribuidoraT> list = dao.getById(dis_distribuidoraT);
		return list.size()>0?list.get(0):null; 
	} 

	/** Métodos FK */
	 public List<Fun_funcionarioT> getByDis_distribuidora(Fun_funcionarioT fun_funcionarioT) throws Exception { 
		 String sql = "select * from easynfe.fun_funcionario where dis_distribuidora.dis_nr_id=?  ";
		 PreparedStatement pStmt = con.prepareStatement(sql);
		 pStmt.setObject(1, fun_funcionarioT.getDis_nr_id());
		 ResultSet rs = pStmt.executeQuery();
 		 return resultSetToObjectTransfer(rs); 
 	}

 }