package com.ict.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// 하나의 클래스의 있는 여러개의 메소드를 한번 테스트 
public class HelloTest01_T1 {

	HelloTest01 t1 ;
	@Before
	public void testBefore() {
		System.out.println("테스트 이전");
		t1 = new HelloTest01();
	}
	// 실제 테스트 메소드 
	// 블랙박스 테스트 : 입력값을 넣어서 예상값과 일치하면 성공
	//              예상값과 일치 하지 않으면 실패
	@Test
	public void test() {
		System.out.println("테스트1");
		int result = t1.add(10, 30);
		// assertArrayEquals(a, b) : 배열 a와 배열 b가 일치하면 성공
		// assertFalse(조건) : 조건이 거짓이면 성공
		// assertTrue(조건) : 조건이  참이면 성공
		// assertNotNull : 객체가 NotNull 이면 성공
		// assertNull : 객체가 Null이면 성공
		// assertSame : 두 객체의 주소가 같으면 (두 객체가 같은 객체이면 )성공
		// assertEquals :기본자료형 변수에서 두 개의 값이 같으면 성공 
		assertEquals(40, result);
	}
	
	@Test
	public void test2() {
		System.out.println("테스트2");
		 t1.sub(10, 30);
		 assertEquals(-20, t1.getRes());
	}
	
	@After
	public void testAfter() {
		System.out.println("테스트 이후");
	}

}
