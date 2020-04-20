package com.ict.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Test3 {
	HelloTest03 t3 ;
	
	@Before
	public void t_Before() {
		t3 = new HelloTest03();
	}
	
	@Test
	public void test() {
		assertEquals(10, t3.div(50, 5));
	}

}
