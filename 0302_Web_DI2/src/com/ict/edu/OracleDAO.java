package com.ict.edu;

public class OracleDAO implements DAO{
	public OracleDAO() {
		System.out.println("OracleDAO 생성자");
	}
	
	@Override
	public String prn() {
		return "OracleDAO 메소드";
	}
}
