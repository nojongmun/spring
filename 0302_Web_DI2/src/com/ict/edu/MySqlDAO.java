package com.ict.edu;

public class MySqlDAO implements DAO{
	public MySqlDAO() {
		System.out.println("MySqlDAO 생성자");
	}
	@Override
	public String prn() {
		return "MySqlDAO 메소드";
	}
}
