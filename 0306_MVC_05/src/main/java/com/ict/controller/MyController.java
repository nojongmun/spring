package com.ict.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.model.MyCalc;

@Controller
public class MyController {
	@Autowired
	private MyCalc myCalc;

	public void setMyCalc(MyCalc myCalc) {
		this.myCalc = myCalc;
	}
	
	@RequestMapping("index.do")
	public ModelAndView IndexController(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		
		String cmd = request.getParameter("cmd");
		int result = 0 ;
		if(cmd.equals("1")) {
			result = myCalc.add();
		}else if(cmd.equals("2")) {
			result = myCalc.sub();
		}else if(cmd.equals("3")) {
			result = myCalc.mul();
		}else if(cmd.equals("4")) {
			result = myCalc.div();
		}
		
		mv.addObject("result", result);
		return mv;
	}
}










