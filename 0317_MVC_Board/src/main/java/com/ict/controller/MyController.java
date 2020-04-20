package com.ict.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ict.model.Paging;
import com.ict.service.DAO;
import com.ict.service.VO;

@Controller
public class MyController {
	@Autowired
	private DAO dao;
	@Autowired
	private Paging paging;
	
	public void setDao(DAO dao) {
		this.dao = dao;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	
	@RequestMapping("list.do")
	public ModelAndView listCommand(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("list");
		try {
			// 1. 전체 게시물의 수
			int count = dao.getTotalCount();
			paging.setTotalRecord(count);
			
			// 2. 전체 게시물의 수를 가지고 전체 페이지의 수를 구하자.
			// 전체 게시물의 수가 getNumPerPage(5) 보다 작거나 같으면 전체 페이지의 수는 1페이지
			if(paging.getTotalRecord() <= paging.getNumPerPage()) {
				paging.setTotalPage(1);
			}else {
				paging.setTotalPage(paging.getTotalRecord()/paging.getNumPerPage());
				// 나눠서 나머지가 0이 아니면 현재 페이지에서 한페이지 증가 시키자 
				if(paging.getTotalRecord()%paging.getNumPerPage() != 0) {
					paging.setTotalPage(paging.getTotalPage()+1);
				}
			}
			
			String cPage = request.getParameter("cPage");
			// index에서 넘어오면 cPage의 무조건 null이다.
			// 나머지는 list에 넘어올때 무조건 cPage값을 넣어줘야 한다.
			// cPage가 현재 페이지(nowPage)로 변경
			if(cPage == null) {
				paging.setNowPage(1);
			}else {
				paging.setNowPage(Integer.parseInt(cPage));
			}
			
			// 시작번호, 끝번호 
			paging.setBegin((paging.getNowPage()-1)*paging.getNumPerPage()+1);
			paging.setEnd((paging.getBegin()-1) + paging.getNumPerPage());
			
			
		    // 시작 블록과 끝블록
			paging.setBeginBlock((int)((paging.getNowPage()-1) / paging.getPagePerBlock()) * paging.getPagePerBlock()+1);
			paging.setEndBlock(paging.getBeginBlock()+paging.getPagePerBlock()-1);
			
			// 주의사항 : endBlock이 totalPage보다 클수 있다.
			// 이때는  endBlock를 totalPage에 맞춰 주세요
			if(paging.getEndBlock() > paging.getTotalPage()) {
				paging.setEndBlock(paging.getTotalPage());
			}
			
			List<VO> list = dao.getList(paging.getBegin(), paging.getEnd());
			
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return mv;
	}
	
	@RequestMapping("write.do")
	public ModelAndView writeCommand() {
		return new ModelAndView("write");
	}
	
	@RequestMapping(value="write_ok.do", method = RequestMethod.GET)
	public ModelAndView write_OKCommand() {
		return new ModelAndView("write");
	}
	@RequestMapping(value="write_ok.do", method = RequestMethod.POST)
	public ModelAndView write_OKCommand_POST(
			VO vo, HttpSession session ) {
		ModelAndView mv = new ModelAndView("redirect:list.do");
		try {
			String path = session.getServletContext().getRealPath("/resources/upload");
			MultipartFile file = vo.getFile();
			if(file.isEmpty()) {
				vo.setFile_name("");
			}else {
				vo.setFile_name(file.getOriginalFilename());
			}
			int result = dao.getInsert(vo);
			if(result >0) {
				file.transferTo(new File(path + "/" + vo.getFile_name()));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return mv;
	}
	@RequestMapping("view.do")
	public ModelAndView viewCommand(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("view");
		try {
			String idx = request.getParameter("idx");
			String cPage = request.getParameter("cPage");
			
			// hit update
			  dao.getHitUpdate(idx);
			  
			// 상세보기
			  VO vo = dao.getOneList(idx);
			  
			// 수정과 삭제를 위해서 세션에 저장
			 request.getSession().setAttribute("vo", vo); 
			 
			 mv.addObject("cPage", cPage);
		} catch (Exception e) {
			System.out.println(e);
		}
		return mv;
	}
	
	@RequestMapping("download.do")
	public void FileDown(@RequestParam("file_name")String file_name,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getSession().getServletContext()
					.getRealPath("/resources/upload/"+file_name);
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
			System.out.println(e);
		}
	}
	
	@RequestMapping("ans_write.do")
	public ModelAndView ans_WriteCommnad(@ModelAttribute("cPage")String cPage) {
		return new ModelAndView("ans_write");
	}
	
	@RequestMapping(value="ans_write_ok.do", method = RequestMethod.GET)
	public ModelAndView ans_WriteCommand_GET(@ModelAttribute("cPage")String cPage) {
		return new ModelAndView("ans_write");
	}
	
	@RequestMapping(value="ans_write_ok.do", method = RequestMethod.POST)
	public ModelAndView ans_WriteCommand_POST(
			@ModelAttribute("cPage")String cPage,
			VO vo, HttpSession session) {
		ModelAndView mv = new ModelAndView("redirect:list.do");
		try {
			int lev  = Integer.parseInt(vo.getLev());
			int step = Integer.parseInt(vo.getStep());
			int groups = Integer.parseInt(vo.getGroups());
			
			step ++ ;
			lev ++ ;
			
			// DB에 groups, lev를 업데이트 한다.
			// groups는 같은 원글 찾아서 레벨이 같거나 크면, 레벨 증가
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("groups", groups);
			map.put("lev", lev);
			
			dao.getLevUp(map);
			
			vo.setStep(String.valueOf(step));
			vo.setLev(String.valueOf(lev));
			
			String path = session.getServletContext()
					.getRealPath("/resources/upload");
			MultipartFile file = vo.getFile();
			
			if(file.isEmpty()) {
				vo.setFile_name("");
			}else {
				vo.setFile_name(file.getOriginalFilename());
			}
			int result = dao.getAnsInsert(vo);
			if(result>0) {
				file.transferTo(new File(path+"/"+vo.getFile_name()));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return mv;
	}
	
	
	@RequestMapping("update_go.do")
	public ModelAndView updateCommand(@ModelAttribute("cPage")String cPage) {
		return new ModelAndView("update");
	}
	
	@RequestMapping("delete_go.do")
	public ModelAndView deleteCommand(@ModelAttribute("cPage")String cPage) {
		return new ModelAndView("delete");
	}
	
	@RequestMapping("delete_ok")
	public ModelAndView delete_OKCommand(
			@ModelAttribute("cPage")String cPage,
			@RequestParam("idx")String idx) {
		try {
			dao.getDelete(idx);
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("redirect:list.do");
	}
	
	@RequestMapping(value="update_ok.do", method = RequestMethod.GET)
	public ModelAndView update_OkCommand_GET(
			@ModelAttribute("cPage")String cPage){
		return new ModelAndView("update");
	}
	
	@RequestMapping(value="update_ok.do", method = RequestMethod.POST)
	public ModelAndView update_OkCommand_POST(
			@ModelAttribute("cPage")String cPage,
			VO vo, HttpSession session){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:view.do?idx="+vo.getIdx());
		try {
			String path = session.getServletContext().getRealPath("/resources/upload");
			MultipartFile file = vo.getFile();
			if(file.isEmpty()) {
				vo.setFile_name("");
			}else {
				vo.setFile_name(file.getOriginalFilename());
			}
			
			int result = dao.getUpdate(vo);
			if(result>0) {
				file.transferTo(new File(path+"/"+vo.getFile_name()));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return mv;
	}
	
}










