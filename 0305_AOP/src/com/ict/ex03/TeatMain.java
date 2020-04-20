package com.ict.ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TeatMain {
	public static void main(String[] args) {
		ApplicationContext context =
				new GenericXmlApplicationContext("com/ict/ex03/aop.xml");
		
		// java.lang.ClassCastException 
		// Boy boy = (Boy)context.getBean("boy");
		// Gril gril = (Gril)context.getBean("gril");
		// gril.doPlaying();

		 Person person = (Person)context.getBean("boy");
		 person.doSomtion();
		 
		 System.out.println("===================");
		 
		 Person person2 = (Person)context.getBean("gril");
		 person2.doSomtion();
		 
	}
}
