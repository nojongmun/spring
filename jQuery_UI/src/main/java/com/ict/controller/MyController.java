package com.ict.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping("reservation.do")
	public ModelAndView Reservation(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("index");
		String re_date = request.getParameter("re_date");
		String re_content = request.getParameter("re_content");
		
		// DB 처리 
		
		// DB처리 후
		mv.addObject("re_date",re_date );
		mv.addObject("re_content",re_content );
		
		return mv;
	}
}
