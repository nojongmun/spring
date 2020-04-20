package com.ict.ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ArrayMain_DI {
	public static void main(String[] args) {
		ApplicationContext context =
				new GenericXmlApplicationContext("com/ict/ex04/Configuration.xml");
		
		ArrayPrint ap = (ArrayPrint)context.getBean("ap");
		ap.s_prn();
		System.out.println("=======");
		ap.i_prn();
		
	}
}
