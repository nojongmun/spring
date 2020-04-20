package com.ict.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

@Controller
public class MyController {
	@Autowired
	private DAO dao ;

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
	
	@RequestMapping(value = "write_ok.do" , method = RequestMethod.GET)
	public ModelAndView write_okCommand_Get() {
		return new ModelAndView("write");
	}
	
	// spring에서 지원하는 Multipart 를 사용 할려면
	// root-context.xml에서 객체 생성해야 됨
	@RequestMapping(value = "write_ok.do" , method = RequestMethod.POST)
	public ModelAndView write_okCommand(VO vo, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:list.do");
		try {
			String path = request.getSession().getServletContext().getRealPath("/resources/upload");
			MultipartFile file = vo.getFile();
			
			if(file.isEmpty()) {
				vo.setFile_name("");
			}else {
				vo.setFile_name(vo.getFile().getOriginalFilename());
			}
			int result = dao.getInsert(vo);
			if(result>0) {
				file.transferTo(new File(path+"/"+vo.getFile_name()));
			}
			
		} catch (Exception e) {
		}
		return mv;
	}
	
	@RequestMapping("onelist.do")
	public ModelAndView oneListCommand(@RequestParam("idx")String idx,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("onelist");
		VO vo = dao.getOneList(idx);
		// 수정과 삭제를 위해서 세션에 저장하자
		request.getSession().setAttribute("vo", vo);
		return mv;
	}
	
	@RequestMapping("down.do")
	public void FileDown(@RequestParam("file_name")String file_name,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getSession().getServletContext()
					.getRealPath("/resources/upload/"+file_name);
			
			// 브라우저 설정
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", 
					"attachment; filename="+URLEncoder.encode(file_name, "utf-8"));
			
			// 실제 저장
			File file = new File(new String(path.getBytes()));
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream in = new BufferedInputStream(fis);
			OutputStream out = response.getOutputStream();
			
			FileCopyUtils.copy(in, out);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@RequestMapping("delete.do")
	public ModelAndView deleteCommand() {
		return new ModelAndView("delete");
	}
	
	@RequestMapping("delete_ok.do")
	public ModelAndView delete_OKCommand(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:list.do");
		VO vo = (VO)request.getSession().getAttribute("vo");
		dao.getDelete(vo.getIdx());
		return mv;
	}
	@RequestMapping("update.do")
	public ModelAndView updateCommand() {
		return new ModelAndView("update");
	}
	@RequestMapping(value = "update_ok.do", method = RequestMethod.GET)
	public ModelAndView update_OKCommand_GET() {
		return new ModelAndView("update");
	}
	
	@RequestMapping(value = "update_ok.do", method = RequestMethod.POST)
	public ModelAndView update_OKCommand_POST(VO vo, 
			HttpServletRequest request) {
		try {
			String path = request.getSession()
					.getServletContext().getRealPath("/resources/upload");
			MultipartFile file = vo.getFile();
			
			if(file.isEmpty()) {
				vo.setFile_name("");
			}else {
				vo.setFile_name(vo.getFile().getOriginalFilename());
			}
			
			int result = dao.getUpdate(vo);
			if(result >0) {
				file.transferTo(new File(path+"/"+vo.getFile_name()));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("redirect:onelist.do?idx="+vo.getIdx());
	}
}








