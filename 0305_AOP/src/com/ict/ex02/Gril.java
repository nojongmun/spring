package com.ict.ex02;

public class Gril implements Person{
	// 소녀
	// 컴퓨터을 부팅한다.  (공통관심 before)
	// 컴퓨터로 쇼핑 하기     (핵심관심)
	// 컴퓨터로 드라마 보기  (핵심관심)
	// 컴퓨터로 종료한다.   (예외발생)
	// 잠을 잔다.         (공통관심 after)
	
	@Override
	public void doSomtion() {
		System.out.println("컴퓨터로 쇼핑 하기");
	}
	@Override
	public void doPlaying() {
		System.out.println("컴퓨터로 드라마 보기");
	}
}
