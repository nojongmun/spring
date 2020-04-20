package com.ict.ex06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain_DI {
	public static void main(String[] args) {
		ApplicationContext context = 
				new GenericXmlApplicationContext("com/ict/ex06/Configuration.xml");
		SetPrint sp = (SetPrint)context.getBean("sp");
		
		sp.s_prn();
		System.out.println("===========");
		sp.i_prn();
		
	}
}
