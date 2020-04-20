package com.ict.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ict.service.DAO;
import com.ict.service.VO;

@Controller
public class MyController {
	@Autowired
	private DAO dao ;

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("list.do")
	public ModelAndView getList() {
		ModelAndView mv = new ModelAndView("list");
		 List<VO> list = dao.getList();
		 
		 mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("join.do")
	public ModelAndView getJoin() {
		return new ModelAndView("join");
	}
	
	@RequestMapping("join_ok.do")
	public ModelAndView getJoin_OK(VO vo) {
		int result =  dao.getWrite(vo);
		
		// servlet-context.xml로 되돌아 갔다가 리스트로 가서 결과를 확인하자
		return new ModelAndView("redirect:list.do"); 
	}
	
	@RequestMapping("onelist.do")
	public ModelAndView getOneList(@RequestParam("idx")String idx, 
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("onelist");
		List<VO> list = dao.getOneList(idx);
		
		// 수정과 삭제를 위해서 세션에 저장하자
		// request.getSession().setAttribute("list", list);
		request.getSession().setAttribute("onevo", list.get(0));
		return mv;
	}
	
	@RequestMapping("delete.do")
	public ModelAndView getDelete(@RequestParam("idx")String idx) {
		int result = dao.getDelete(idx);
		return new ModelAndView("redirect:list.do");
	}
	
}
