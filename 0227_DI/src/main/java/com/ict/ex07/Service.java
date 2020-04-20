package com.ict.ex07;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myService")
public class Service {
	
	// @Autowired (참조하는 클래스의 아이디와 변수이름이 같을경우)
	
	// 참조하는 클래스의 아이디와 변수이름이 다른 경우
	// @Autowired
	// @Qualifier("oracleDAO")
	
	// @Autowired +  @Qualifier("oracleDAO") 을 한번에 처리 
	@Resource(name="mySqlDAO")
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
