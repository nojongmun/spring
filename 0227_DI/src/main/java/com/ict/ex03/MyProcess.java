package com.ict.ex03;

public class MyProcess {
	private String name = "홍길동";
	private int age = 13 ;
	
	public MyProcess() {}

	public MyProcess(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void prn() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}
