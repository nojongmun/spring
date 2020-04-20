package com.ict.ex03;

public class TestMain_NonDI {
	public static void main(String[] args) {
		MyProcess process = new MyProcess();
		process.prn();
		
		// 생성자를 이용해서 변경
		MyProcess process2 = new MyProcess("둘리", 1004);
		process2.prn();
		
		System.out.println("=============");
		
		MyProcess2 p2 = new MyProcess2();
		p2.prn();
		// setter를 이용해서 변경
		p2.setName("태권브이");
		p2.setAge(26);
		p2.prn();
	}
}
