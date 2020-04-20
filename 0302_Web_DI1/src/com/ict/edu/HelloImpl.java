package com.ict.edu;

public class HelloImpl implements Hello{
	public HelloImpl() {
		System.out.println("HelloImpl 생성자");
	}
	
	// 실행시킬 메소드
	@Override
	public String sayHello() {
		return "Hello Spring World";
	}
}
