package com.ict.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class StartController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("output2");
		
		// 데이터 저장 방법(request, ModelAndView, session)
		mv.addObject("company","ICT 인재 개발원");
		request.setAttribute("subject", "java, android");
		request.getSession().setAttribute("content","spring mvc");
		
		return mv;
	}
}
