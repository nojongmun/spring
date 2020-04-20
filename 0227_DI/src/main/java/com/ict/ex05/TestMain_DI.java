package com.ict.ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain_DI {
	public static void main(String[] args) {
		ApplicationContext context =
				new GenericXmlApplicationContext("com/ict/ex05/Configuration.xml");
		MapPrint mp = (MapPrint)context.getBean("mp");
		
		mp.s_prn();
		System.out.println("=========");
		mp.i_prn();
	}
}
