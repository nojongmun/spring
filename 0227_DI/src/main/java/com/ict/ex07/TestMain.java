package com.ict.ex07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
			
		ApplicationContext context = 
		        new GenericXmlApplicationContext("com/ict/ex07/Configuration.xml");

		 Service service = (Service)context.getBean("myService");
		service.biz();
	}
}
