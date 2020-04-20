package com.ict.ex01;

public class PersonProxy {
    private Person person;
    
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public void Play() {
		try {
			System.out.println("컴퓨터를 부팅한다.");  // 공통관심
			person.doSomtion();                   // 핵심관심
			person.doPlaying();                   // 핵심관심
		} catch (Exception e) {
		   System.out.println("컴퓨터를 종료한다.");
		} finally {
			System.out.println("잠을 잔다.");
		}
	
	}
}
