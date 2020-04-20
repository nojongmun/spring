package com.ict.ex01;

public class TeatMain {
	public static void main(String[] args) {
		Boy boy = new Boy();
		Gril gril = new Gril();
		
		PersonProxy proxy = new PersonProxy();
		
		proxy.setPerson(gril);
		
		proxy.Play();
	}
}
