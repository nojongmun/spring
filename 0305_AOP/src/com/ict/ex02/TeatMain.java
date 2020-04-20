package com.ict.ex02;

public class TeatMain {
	public static void main(String[] args) {
		Boy boy = new Boy();
		Gril gril = new Gril();
	    Before befor = new Before();
	    After after =  new After();
		
	    PersonProxy proxy = new PersonProxy();
		proxy.setPerson(boy);
		
		proxy.setBefor(befor);
		proxy.setAfter(after);
		
		// proxy.setBefor(new Before());
		// proxy.setAfter(new After());
		
		proxy.Play();
	}
}
