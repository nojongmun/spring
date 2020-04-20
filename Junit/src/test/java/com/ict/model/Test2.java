package com.ict.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Test2 {
	HelloTest02 t2 ;
	@Before
	public void t_Before() {
		t2 = new HelloTest02();
	}
	@Test
	public void test() {
		assertEquals(50, t2.mul(10, 5));
	}

}
