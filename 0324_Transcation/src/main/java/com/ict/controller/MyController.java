package com.ict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.service.DAO;
import com.ict.service.VO;

@Controller
public class MyController {
	@Autowired
	private DAO dao;

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("result.do")
	public ModelAndView resultCommand(@ModelAttribute("vo")VO vo) {
		ModelAndView mv = new ModelAndView("result");
		try {
		   int res = dao.getInsert(vo);
		   mv.addObject("res", res);
		} catch (Exception e) {
			System.out.println(e);
		}
		return mv;
	}
}
