package com.ict.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ict.model.MyProcess;

// 어노테이션이 아니면 반드시 Controller로 상속 받아야 한다. 
public class Index implements Controller{
	private MyProcess myProcess;
	
	public void setMyProcess(MyProcess myProcess) {
		this.myProcess = myProcess;
	}
	
	public Index() {
		System.out.println("index 생성자");
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		
		// 일처리하고 내용 저장하기 
		request.setAttribute("name", "홍길동");
		mv.addObject("age", 24);
		request.getSession().setAttribute("addr", "충청도");
		
		// Non-DI
		// MyProcess process = new MyProcess();
		String msg = myProcess.getGreeting();
		mv.addObject("msg", msg);
		
		return mv;
	}
}
