package com.ict.ex02;

public class Boy implements Person{
	// 소년
	// 컴퓨터를 부팅한다.   (공통관심 before)
	// 컴퓨터로 게임을 한다. (핵심관심)  
	// 컴퓨터로 영화 보기      (핵심관심)
	// 컴퓨터로 종료한다.   (예외발생)
	// 잠을 잔다.         (공통관심 after)
	@Override
	public void doSomtion() {
		System.out.println("컴퓨터로 게임 하기 ");
	}
	
	@Override
	public void doPlaying() {
		System.out.println("컴퓨터로 영화 보기");
	}
}
