package com.ict.model;

public class HelloTest01 {

	private int res ;
	
	// 테스트할 메소드 
	public int add(int su1, int su2) {
		return su1 + su2 ;
	}
	
	// 보통 void를 테스트 할 때는 보통 return으로 변경해서 테스트 함
	public void sub(int su1, int su2) {
	// System.out.println( su1 - su2 );
	 	res = su1 - su2 ; 
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}
	
}
