package com.ict.model;

import org.springframework.stereotype.Component;

@Component("myCalc")
public class MyCalc {
	
	public int add() {
		return 200 + 300 ;
	}
	public int sub() {
		return 200 - 300 ;
	}
	public int mul() {
		return 200 * 300 ;
	}
	public int div() {
		return 200 / 300 ;
	}
}
