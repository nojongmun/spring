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
	private DAO dao;
	
	public void setDao(DAO dao) {
		this.dao = dao;
	}

	@RequestMapping("list.do")
	public ModelAndView listCommand() {
		ModelAndView mv = new ModelAndView("list");
		List<VO> list = dao.getList();
		mv.addObject("list", list); 
		return mv;
	}
	
	@RequestMapping("write.do")
	public ModelAndView writeCommand() {
		return new ModelAndView("write");
	}
	
	@RequestMapping("write_ok.do")
	public ModelAndView write_okCommand(VO vo) {
		ModelAndView mv = new ModelAndView("redirect:list.do");
		int result = dao.getInsert(vo);
		mv.addObject("result", result);
		return mv ;
	}
	
	@RequestMapping("onelist.do")
	public ModelAndView oneListCommand(@RequestParam("idx") String idx,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("onelist");
		VO vo = dao.getOneList(idx);
		// 수정과 삭제를 위해서 session 에 저장 하자
		request.getSession().setAttribute("vo", vo);
		
		return mv;
	}
	
	@RequestMapping("delete.do")
	public ModelAndView deleteCommand() {
		return  new ModelAndView("delete");
	}
	
	@RequestMapping("delete_ok.do")
	public ModelAndView delete_okCommand(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:list.do");
		VO vo = (VO)request.getSession().getAttribute("vo");
		dao.getDelete(vo.getIdx());
		return mv;
	}
	
	@RequestMapping("update.do")
	public ModelAndView updateCommand() {
		return  new ModelAndView("update");
	}
	
	@RequestMapping("update_ok")
	public ModelAndView update_okCommand(VO vo) {
		ModelAndView mv 
			= new ModelAndView("redirect:onelist.do?idx="+vo.getIdx());
		dao.getUpdate(vo);
		return mv;
	}
}






