package com.ict.ex07;

import org.springframework.stereotype.Component;

@Component("mySqlDAO")
public class MySqlDAO implements DAO{
	public MySqlDAO() {
		System.out.println("MySqlDAO 생성자");
	}
	@Override
	public void prn() {
		System.out.println("MySqlDAO 메소드");
	}
}
