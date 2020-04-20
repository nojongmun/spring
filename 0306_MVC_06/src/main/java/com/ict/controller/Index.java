package com.ict.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Index {
	
	/*	
	@RequestMapping("index.do")
	public ModelAndView indexController(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		
		int s1 = Integer.parseInt(request.getParameter("s1"));
		int s2 = Integer.parseInt(request.getParameter("s2"));
		String op = request.getParameter("op");
		int result = 0 ;
		switch (op) {
			case "+": result = s1 + s2 ; break;
			case "-": result = s1 - s2 ; break;
			case "*": result = s1 * s2 ; break;
			case "/": result = s1 / s2 ; break;
		}
		mv.addObject("result", result);
		mv.addObject("s1", s1);
		mv.addObject("s2", s2);
		mv.addObject("op", op);
		
		// 배열
		String[] hobby = request.getParameterValues("hobby");
		mv.addObject("hobby", hobby);
		
		String cPage = request.getParameter("cPage");
		mv.addObject("cPage", cPage);
		
		return mv;
	}
	*/
	
	// VO를 만들어 인자로 사용하면 파라미터값들을 받을 수 있다.
	/*
	@RequestMapping(value = "index.do", method = RequestMethod.POST)
	public ModelAndView indexController(VO vo) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		
		int s1 = Integer.parseInt(vo.getS1());
		int s2 = Integer.parseInt(vo.getS2());
		String op = vo.getOp();
		int result = 0 ;
		switch (op) {
			case "+": result = s1 + s2 ; break;
			case "-": result = s1 - s2 ; break;
			case "*": result = s1 * s2 ; break;
			case "/": result = s1 / s2 ; break;
		}
		
		mv.addObject("result", result);
		mv.addObject("s1", s1);
		mv.addObject("s2", s2);
		mv.addObject("op", op);
		
		String[] hobby = vo.getHobby();
		mv.addObject("hobby", hobby);
		
		String cPage = vo.getcPage();
		mv.addObject("cPage", cPage);
		
		return mv ;
	}
	*/
	// 들어온 파라미터들을 다음에 JSP에 넘어갈 정보를  @ModelAttribute("m")에 담았다.
	@RequestMapping(value = "index.do", method = RequestMethod.POST)
	public ModelAndView indexController(@ModelAttribute("m")VO vo) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		
		int s1 = Integer.parseInt(vo.getS1());
		int s2 = Integer.parseInt(vo.getS2());
		String op = vo.getOp();
		int result = 0 ;
		switch (op) {
			case "+": result = s1 + s2 ; break;
			case "-": result = s1 - s2 ; break;
			case "*": result = s1 * s2 ; break;
			case "/": result = s1 / s2 ; break;
		}
		
		mv.addObject("result", result);
		// mv.addObject("s1", s1);
		// mv.addObject("s2", s2);
		// mv.addObject("op", op);
		
		// String[] hobby = vo.getHobby();
		// mv.addObject("hobby", hobby);
		
		// String cPage = vo.getcPage();
		// mv.addObject("cPage", cPage);
		
		return mv ;
	}
}
