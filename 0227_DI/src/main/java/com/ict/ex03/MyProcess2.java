package com.ict.ex03;

public class MyProcess2 {
	private String name = "홍길동";
	private int age = 13 ;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public void prn() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}
