package com.ict.ex04;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
// advice = 공통관심사
public class MyAspect {
	@Pointcut("execution(* do*())")
	public void myPointCut() {}
	
	@Before("myPointCut()")
	// 핵심관심사 전 : Before advice
	public void pre() {
		System.out.println("컴퓨터 부팅 하기");
	}
	
	@After("myPointCut()")
	// 핵심관심사 후 : After returning advice
	public void next() {
		System.out.println("잠을 잔다.");
	}
}
