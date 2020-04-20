package com.ict.model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

// 0. 다양한 TestCase 만들기 
@RunWith(Parameterized.class)
public class HelloTest01_T2 {
	HelloTest01 t1 ;
	
    // 1. 변수 처리 (테스트 할 메소드의 매개변수 만큼)
	private int expected ; // 예상값
	private int valueA ;   // 입력값1 
	private int valueB ;   // 입력값2
	
	public HelloTest01_T2(int expected, int valueA, int valueB) {
		super();
		this.expected = expected;
		this.valueA = valueA;
		this.valueB = valueB;
		System.out.println("HelloTest01_T2 생성자");
	}

	@Before
	public void testBefore() {
		t1 = new HelloTest01();
	}
	
	//3.테스트 케이스들을 배열에 넣는다.(규격화 )
	@Parameters
	public static Collection<Integer[]> getTestParameters(){
		return Arrays.asList(new Integer[][]{
			// {예상값, 입력1, 입력2}
			{5,3,2},  
			{-5,3,-8},
			{-1,-3,2},
			{-11,-3,-8}
		}); 
	}
	
	
	@Test
	public void test() {
		// 2. 테스트 처리 (변수처리된 변수를 해당 메소드의 매개변수에 넣어준다.)
		assertEquals(expected, t1.add(valueA, valueB));
	}

}
