package com.ict.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ict.model.Paging;
import com.ict.service.BVO;
import com.ict.service.CVO;
import com.ict.service.DAO;

@Controller
public class MyController {
	@Autowired
	private DAO dao;
	
	@Autowired
	private Paging paging;

	String cPage ;
	
	public void setDao(DAO dao) {
		this.dao = dao;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	
	@RequestMapping("list.do")
	public ModelAndView listCommand(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("list");
		
		// 전체 게시물의 수
		int count = dao.getTotalCount();
		paging.setTotalRecord(count);
		
		// 전체 게시물의 수를 가지고 전체 페이지의 수를 구하자
		// getNumPerPage 보다 작거나 같으면 1 페이지만 필요
		if(paging.getTotalRecord() <= paging.getNumPerPage()) {
			paging.setTotalPage(1);
		}else {
			paging.setTotalPage(paging.getTotalRecord() / paging.getNumPerPage());
			// 나눠 떨어지지 않으면  기존 페이지의 수에서 한페이지가 더 필요하다.ㅣ
			if(paging.getTotalRecord() % paging.getNumPerPage() != 0) {
				paging.setTotalPage(paging.getTotalPage() + 1);
			}
		}
		
		cPage = request.getParameter("cPage");
		// index에서 넘어온 cPage의 값은 무조건 null
		// 나머지는 list에 넘어올때 무조건 cPage값은 넣어줘야 한다.
		if(cPage == null) {
			paging.setNowPage(1);
		}else {
			paging.setNowPage(Integer.parseInt(cPage));
		}
		
		// 시작번호, 끝번호 구하기 
		paging.setBegin((paging.getNowPage()-1)*paging.getNumPerPage()+1);
		paging.setEnd((paging.getBegin()-1) + paging.getNumPerPage());
		
		// 시작블록, 끝 블록 구하기 
		paging.setBeginBlock((int)((paging.getNowPage()-1)/paging.getPagePerBlock())
				* paging.getPagePerBlock()+1);
		paging.setEndBlock(paging.getBeginBlock() + paging.getPagePerBlock()-1);
		
		// 주의 사항 : endBlock이 totalPage보다 클 수 있다.
		if(paging.getEndBlock() > paging.getTotalPage()) {
			paging.setEndBlock(paging.getTotalPage());
		}
		
		List<BVO> list = dao.getList(paging.getBegin(), paging.getEnd());
		mv.addObject("list", list);
		mv.addObject("paging", paging);
		
		return mv;
	}
	
	@RequestMapping("write.do")
	public ModelAndView writeCommand() {
		return new ModelAndView("write");
	}
	
	@RequestMapping(value="write_ok.do" ,method = RequestMethod.GET)
	public ModelAndView write_OKCommand_GET (BVO bvo) {
		return new ModelAndView("write");
	}
	
	@RequestMapping(value="write_ok.do" ,method = RequestMethod.POST)
	public ModelAndView write_OKCommand_POST (BVO bvo, 
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:list.do");
		try {
			String path = request.getSession()
					.getServletContext().getRealPath("/resources/upload");
			MultipartFile file = bvo.getFile();
			
			if(file.isEmpty()) {
				bvo.setFile_name("");
			}else {
				bvo.setFile_name(bvo.getFile().getOriginalFilename());
			}
			
			int result = dao.getInsert(bvo);
			if(result >0) {
				file.transferTo(new File(path + "/" + bvo.getFile_name()));
			} 
		} catch (Exception e) {
			System.out.println(e);
		}
		return mv;
	}
	
	@RequestMapping("onelist.do")
	public ModelAndView oneListCommand(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("onelist");
		try {
			String b_idx = request.getParameter("b_idx");
			cPage = request.getParameter("cPage");
			
			// 조회 수 업데이트
			dao.getHit(b_idx);
			
			// 상세 보기
			BVO bvo = dao.getOneList(b_idx);
			
			// 수정과 삭제를 위해서 session에 담기 
			request.getSession().setAttribute("bvo", bvo);
			
			// 댓글 가져오기 
			List<CVO> c_list = dao.getCommList(b_idx);
			
			mv.addObject("c_list", c_list);
			mv.addObject("cPage", cPage);
			
		} catch (Exception e) {
		}
		return mv;
	}
	
	// 댓글 Insert
	@RequestMapping("c_write.do")
	public ModelAndView c_WriteCommand(CVO cvo) {
		ModelAndView mv = 
			new ModelAndView("redirect:onelist.do?cPage="+cPage+"&b_idx="+cvo.getB_idx());
		try {
			dao.getComm_Write(cvo);
		} catch (Exception e) {
		}
		return mv;
	}
	
	// 댓글 삭제
	@RequestMapping("c_del.do")
	public ModelAndView c_DelCommand(CVO cvo) {
		ModelAndView mv = 
				new ModelAndView("redirect:onelist.do?cPage="+cPage+"&b_idx="+cvo.getB_idx());
			try {
				dao.getComm_Delete(cvo.getC_idx());
			} catch (Exception e) {
			}
			return mv;
	}
	
	// 다운로드
	@RequestMapping("down.do")
	public void FileDown(@RequestParam("file_name")String file_name,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getSession().getServletContext()
					.getRealPath("/resources/upload/"+file_name);
			// 브라우저 설정
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition",
					"attachment; filename="+URLEncoder.encode(file_name,"utf-8"));
			// 실제 저장
			File file = new File(new String(path.getBytes()));
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream in = new BufferedInputStream(fis);
			OutputStream out = response.getOutputStream();
			
			FileCopyUtils.copy(in, out);
		} catch (Exception e) {
		}
	}
	
	/*
	@RequestMapping("delete.do")
	public ModelAndView deleteCommand(@RequestParam("cPage")String cPage) {
		ModelAndView mv = new ModelAndView("delete");
		mv.addObject("cPage",cPage);
		return mv;
	}
	*/
	
	// @ModelAttribute("cPage")String cPage 의 뜻은 
	// 파라미터 cPage를 받아서 Model 속성에 저장하라는 뜻으로 
	// delete.jsp 에서 cPage를 사용할 수 있게 한다.
	@RequestMapping("delete.do")
	public ModelAndView deleteCommand(@ModelAttribute("cPage")String cPage) {
		return new ModelAndView("delete");
	}
	
	
	@RequestMapping("delete_ok.do")
	public ModelAndView delete_OKCommand(@RequestParam("cPage")String cPage,
			HttpSession session) {
		ModelAndView mv = 
				new ModelAndView("redirect:list.do?cPage="+cPage);
		try {
			BVO bvo = (BVO)session.getAttribute("bvo");
			dao.getDelete(bvo.getB_idx());
		} catch (Exception e) {
			// 댓글이 존재하면 원글 삭제가 안됨
			return new ModelAndView("error");
		}
		return mv;
	}
	
	@RequestMapping("update.do")
	public ModelAndView updateCommand(@ModelAttribute("cPage")String cPage) {
		return new ModelAndView("update");
	}
	
	@RequestMapping(value="update_ok.do", method = RequestMethod.GET)
	public ModelAndView updateCommand_GET(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String b_idx = request.getParameter("b_idx");
		String cPage = request.getParameter("cPage");
		
		mv.setViewName("redirect:onelist.do?cPage="+cPage+"&b_idx="+b_idx);
		return mv;
	}
	
	@RequestMapping(value="update_ok.do", method = RequestMethod.POST)
	public ModelAndView updateCommand_POST(BVO bvo,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String cPage = request.getParameter("cPage");
		mv.setViewName("redirect:onelist.do?cPage="+cPage+"&b_idx="+bvo.getB_idx());
		try {
			String path = request.getSession().getServletContext()
					.getRealPath("/resources/upload");
			MultipartFile file = bvo.getFile();
			if(file.isEmpty()) {
				bvo.setFile_name("");
			}else {
				bvo.setFile_name(bvo.getFile().getOriginalFilename());
			}
			int result = dao.getUpdate(bvo);
			if(result>0) {
				file.transferTo(new File(path+"/"+bvo.getFile_name()));
			}
		} catch (Exception e) {
		}
		return mv;
	}
}







