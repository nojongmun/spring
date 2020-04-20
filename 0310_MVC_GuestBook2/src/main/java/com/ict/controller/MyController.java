package com.ict.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.multi.MultiProgressBarUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ict.service.DAO;
import com.ict.service.VO;
import com.ict.service.VO2;

@Controller
public class MyController {
	@Autowired
	private DAO dao ;

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	// list
	@RequestMapping("list.do")
	public ModelAndView getList() {
		ModelAndView mv = new ModelAndView("list");
		List<VO> list = dao.getList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping("write.do")
	public ModelAndView getWrite() {
		return new ModelAndView("write");
	}
	
	@RequestMapping(value = "write_ok.do", method = RequestMethod.GET)
	public ModelAndView getWriteOK2() {
		ModelAndView mv = new ModelAndView("write");
		return mv;
	}
	
	// spring 자체 지원 업로드
	// root-context.xml 에서 CommonsMultipartResolver 객체 생성해야 됨
	/*
	@RequestMapping(value = "write_ok.do", method = RequestMethod.POST)
	public ModelAndView getWriteOK(
			@RequestParam("file_name") MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("redirect:list.do");
		try {
			VO vo = new VO();
			vo.setName(request.getParameter("name"));
			vo.setSubject(request.getParameter("subject"));
			vo.setEmail(request.getParameter("email"));
			vo.setPwd(request.getParameter("pwd"));
			vo.setContent(request.getParameter("content"));
			
			String path = request.getSession().getServletContext().getRealPath("/resources/upload");
			if(file.getOriginalFilename() == null) {
				vo.setFile_name("");
			}else{
				vo.setFile_name(file.getOriginalFilename());
			}
			
			int result = dao.getInsert(vo);
			
			// 실제 복사
			if(result>0) {
				byte[] in = file.getBytes();
				File out = new File(path, vo.getFile_name());
				FileCopyUtils.copy(in, out);
			}
			
		} catch (Exception e) {
		}
		return mv;
	}
	*/
	// spring 자체 지원 업로드
	// root-context.xml 에서 CommonsMultipartResolver 객체 생성해야 됨
	@RequestMapping(value = "write_ok.do", method = RequestMethod.POST)
	public ModelAndView getWriteOK(VO2 vo, HttpServletRequest request) {
		try {
			String path = request.getSession().getServletContext().getRealPath("/resources/upload");
			MultipartFile file = vo.getFile();
			
			if(file.isEmpty()) {
				vo.setFile_name("");
			}else {
				vo.setFile_name(vo.getFile().getOriginalFilename());
			}
			int result = dao.getInsert(vo);
			if(result > 0) {
				file.transferTo(new File(path+"/"+vo.getFile_name()));
			}
		} catch (Exception e) {
		}
		return new ModelAndView("redirect:list.do");
	}
	
	@RequestMapping("onelist.do")
	public ModelAndView getOneList(@RequestParam("idx")String idx,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("onelist");
		List<VO> list = dao.getOneList(idx);
		
		// 수정과 삭제를 위해서 세션에 저장하자 
		request.getSession().setAttribute("vo", list.get(0));
		return mv;
	}
	
	@RequestMapping("down.do")
	public void getFileDown(@RequestParam("file_name")String file_name,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getSession().getServletContext().getRealPath("/resources/upload/"+file_name);
			
			// 브라우저 설정
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", 
					"attachment; filename="+URLEncoder.encode(file_name,"UTF-8"));
			
			// 실제 저장
			File file = new File(new String(path.getBytes()));
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream in = new BufferedInputStream(fis);
			OutputStream out = response.getOutputStream();
			
			FileCopyUtils.copy(in, out);
			
		} catch (Exception e) {
		}
	}
	
	@RequestMapping("delete.do")
	public ModelAndView getDelete() {
		return new ModelAndView("delete");
	}
	
	@RequestMapping("update.do")
	public ModelAndView getUpdate() {
		return new ModelAndView("update");
	}
	
	@RequestMapping("delete_ok")
	public ModelAndView getDeleteOK(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:list.do");
		VO vo =(VO)request.getSession().getAttribute("vo");
		dao.getDelete(vo.getIdx());
		return mv;
	}
	
	@RequestMapping(value = "update_ok", method = RequestMethod.GET)
	public ModelAndView getUpdateOK2() {
		return new ModelAndView("redirect:update.do");
	}
	@RequestMapping(value = "update_ok", method = RequestMethod.POST)
	public ModelAndView getUpdateOK(VO2 vo, HttpServletRequest request) {
		try {
			String path = request.getSession().getServletContext().getRealPath("/resources/upload");
			MultipartFile file = vo.getFile();
			
			if(file.isEmpty()) {
				vo.setFile_name("");
			}else {
				vo.setFile_name(vo.getFile().getOriginalFilename());
			}
			
			int result = dao.getUpdate(vo);
			
			if(result > 0) {
				file.transferTo(new File(path+"/"+vo.getFile_name()));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("redirect:onelist.do?idx="+vo.getIdx());	
	}
}








