package com.ict.edu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		ApplicationContext context = 
				new GenericXmlApplicationContext("com/ict/edu/Configuration.xml");
		
		HelloImpl hello = (HelloImpl)context.getBean("hello");
		System.out.println( hello.sayHello());
	}
}
