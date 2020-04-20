package com.ict.ex06;

public class TestMain_NonDI {
	public static void main(String[] args) {
		SetPrint sp = new SetPrint();
		sp.input();
		
		sp.s_prn();
		System.out.println("========");
		sp.i_prn();
		
	}
}
