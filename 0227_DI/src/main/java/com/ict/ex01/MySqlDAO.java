package com.ict.ex01;

public class MySqlDAO implements DAO{
	public MySqlDAO() {
		System.out.println("MySqlDAO 생성자");
	}
	@Override
	public void prn() {
		System.out.println("MySqlDAO 메소드");
	}
}
