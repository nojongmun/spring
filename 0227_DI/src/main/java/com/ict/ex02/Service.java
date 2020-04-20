package com.ict.ex02;

public class Service {
	private DAO dao ;
	private String name ;
	
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 메인에서 실행하고 싶은 메소드 
	public void biz() {
		dao.prn();
	}
}
