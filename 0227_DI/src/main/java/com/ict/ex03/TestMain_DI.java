package com.ict.ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain_DI {
	public static void main(String[] args) {
		ApplicationContext context =
				new GenericXmlApplicationContext("com/ict/ex03/Configuration.xml");
		
		MyProcess myProcess = (MyProcess)context.getBean("process");
		myProcess.prn();
		System.out.println("============");
		
		MyProcess myProcess2 = (MyProcess)context.getBean("process2");
		myProcess2.prn();
		System.out.println("============");
		
		MyProcess2 myProcess3 = (MyProcess2)context.getBean("process3");
		myProcess3.prn();
 	}
}
