package com.ict.ex01;

public class Service {
	private DAO dao ;
	
	public Service() {
		System.out.println("service 생성자");
	}

	public Service(DAO dao) {
		this.dao = dao;
		System.out.println("service 생성자");
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	// 메인에서 실행하고 싶은 메소드 
	public void biz() {
		// OracleDAO oracleDAO = new OracleDAO();
		// oracleDAO.prn();
		
		// MySqlDAO mySqlDAO = new MySqlDAO();
		// mySqlDAO.prn();
		
		// dao = new OracleDAO();
		// dao = new MySqlDAO();
	
		dao.prn();
		
		
	}
}
