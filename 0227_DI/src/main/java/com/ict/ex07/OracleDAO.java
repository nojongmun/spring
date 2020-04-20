package com.ict.ex07;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// @Component("dao")
@Component("oracleDAO")
public class OracleDAO implements DAO{
	public OracleDAO() {
		System.out.println("OracleDAO 생성자");
	}
	
	@Override
	public void prn() {
		System.out.println("OracleDAO 메소드");
	}
}
