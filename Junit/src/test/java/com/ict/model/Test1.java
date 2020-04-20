package com.ict.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Test1 {
	HelloTest01 t1 ;
	@Before
	public void t_Before() {
		t1 = new HelloTest01();
	}
	@Test
	public void test1() {
		assertEquals(40, t1.add(30, 10));
		
	}
	@Test
	public void test2() {
		t1.sub(30, 10);
		assertEquals(10,t1.getRes());
	}

}
