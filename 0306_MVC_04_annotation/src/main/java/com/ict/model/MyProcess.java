package com.ict.model;

import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component("myProcess")
public class MyProcess {
	
	public MyProcess() {
		System.out.println("MyProcess 생성자");
	}
	
	// 실행하고하는 메소드
	public String getGreeting() {
	  // 현재 시간을 구하자
		int hour = Calendar.getInstance().get(Calendar.HOUR);
		
		if(hour >= 7  && hour <=10) {
			return "좋은 아침 입니다. ";
		}else if(hour >=12 && hour <=14) {
			return "점심식사 하셨나요?";
		}else if(hour>=22 && hour<=24) {
			return "안녕히 주무세요";
		}else {
			return "Hi~~~~~";
		}
	}
}
