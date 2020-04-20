package com.ict.ex03;

// advice = 공통관심사
public class MyAspect {

	// 핵심관심사 전 : Before advice
	public void pre() {
		System.out.println("컴퓨터 부팅 하기");
	}
	// 핵심관심사 후 : After returning advice
	public void next() {
		System.out.println("잠을 잔다.");
	}
	
	// 핵심관심사 후 : After throwing advice
	// 
	// public void next_thorwing() {
	//	System.out.println("컴퓨터를  종료하다.");
	// }
	
	// 핵심관심사 후 : After advice
	public void next_fianlly() {
		System.out.println("잠을 잔다.");
	}
	// Around advice
	public void around() {
		System.out.println("실행 전, 실행 후");
	}
}
