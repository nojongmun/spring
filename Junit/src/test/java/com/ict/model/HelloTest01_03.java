package com.ict.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// 한번에 여러 클래스들의 메소드를 테스트 하기 
@RunWith(Suite.class)
@SuiteClasses({Test1.class, Test2.class, Test3.class})
public class HelloTest01_03 {
	
}
