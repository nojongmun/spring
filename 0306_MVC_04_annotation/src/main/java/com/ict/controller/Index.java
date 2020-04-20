package com.ict.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.model.MyProcess;

// 어노테이션이 아니면 반드시 Controller로 상속 받아야 한다. 
// 어노테이션 일때는   @Controller 사용하고 개발자가 메소드를 직접 만들어야 한다.
@Controller
public class Index {
	@Autowired  // spring
	// @Inject  // java
	private MyProcess myProcess;
	
	public void setMyProcess(MyProcess myProcess) {
		this.myProcess = myProcess;
	}
	
	public Index() {
		System.out.println("index 생성자");
	}
	
	// 어노테이션일때 개발자가 직접 메소드를 만들어야 한다.
	// 요청에 따른 실행에 대한 정보를 어노테이션으로 만든다.
	@RequestMapping(value = "index.do")
	public ModelAndView indexController() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		
		// 일처리하고 내용 저장하기 
		mv.addObject("name", "홍길동");
		mv.addObject("age", 24);
		mv.addObject("addr", "충청도");
		
		String msg = myProcess.getGreeting();
		mv.addObject("msg", msg);
		
		return mv;
	}
	
}
