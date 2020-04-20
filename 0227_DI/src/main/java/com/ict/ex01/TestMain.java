package com.ict.ex01;

public class TestMain {
	public static void main(String[] args) {
		// Service service = new Service();
		// service.biz();
		
		// 생성자 이용
		// Service service = new Service(new MySqlDAO());
		// service.biz();
		
		// Service service = new Service(new OracleDAO());
		// service.biz();
		
		// setter 이용 
		// Service service = new Service();
		// service.setDao(new MySqlDAO());
		// service.biz();
		
		 Service service = new Service();
		 service.setDao(new OracleDAO());
		 service.biz();
	}
}
