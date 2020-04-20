package com.ict.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ict.service.CVO;
import com.ict.service.DAO;
import com.ict.service.MVO;
import com.ict.service.VO;

@Controller
public class MyController {
	@Autowired
	private DAO dao;

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("list.do")
	public ModelAndView listCommand(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("product_list");
		try {
			String category = request.getParameter("category");
			if(category == null || category=="") {
				category = "ele002";
			}
			List<VO> list;
			list = dao.getList(category);
			mv.addObject("list", list);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return mv;
	}
	// 로그인 창으로 이동
	@RequestMapping("login.do")
	public ModelAndView loginCommand() {
		return new ModelAndView("login");
	}
	
	@RequestMapping("login_ok.do")
	public ModelAndView login_okCommand(MVO m_vo, 
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		try {
			// 로그인 처리
			MVO mvo = dao.getLogin(m_vo);
			// 로그인 성공
			if(mvo != null) {
				session.setAttribute("mvo", mvo);
				session.setAttribute("login", "ok");
				// 관리자
				if(mvo.getId().equals("adm") 
					&& mvo.getPw().equals("adm")) {
					session.setAttribute("admin", "ok");
					mv.setViewName("redirect:admin.do");
					return mv;
				}
				mv.setViewName("redirect:list.do");
			}else {
				mv.setViewName("redirect:login.do");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return mv;
	}
	// 로그 아웃하기
	@RequestMapping("logout.do")
	public ModelAndView logoutCommand(HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:list.do");
	}
	// 관리자페이지 창으로 이동
	@RequestMapping("admin.do")
	public ModelAndView adminCommand() {
			return new ModelAndView("admin");
	}
	// 회원가입 창으로 이동
	@RequestMapping("join.do")
	public ModelAndView joinCommand() {
		return new ModelAndView("join");
	}
	
	@RequestMapping("content.do")
	public ModelAndView contentCommand(
			@RequestParam("idx")String idx) {
		ModelAndView mv = 
				new ModelAndView("product_content");
		try {
			VO vo = dao.getOneList(idx);
			
			mv.addObject("vo", vo);
		} catch (Exception e) {
			System.out.println(e);	
		}
		return mv;
	}
	@RequestMapping("viewcart.do")
	public ModelAndView vieCartCommand(
			@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("viewcart");
		try {
			List<CVO> cartList = dao.getCartList(id);
			mv.addObject("cartList", cartList);
		} catch (Exception e) {
			System.out.println(e);
		}
		return mv;
	}
	
	@RequestMapping("addcart.do")
	public ModelAndView addCartCommand(
			@RequestParam("idx") String idx,
			@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("redirect:content.do?idx="+idx);
		try {
			// idx를 이용해서 제품 정보 가져오기 
			VO vo = dao.getOneList(idx);
			
			// id와 제품번호를 가지고 카드 정보 가져오기 
			CVO cvo = dao.getCartList(id, vo.getP_num());
			
			// 해당 제품이 카드정보 존재 유무를 확인
			// 존재하면 갯수만 증가, 존재하지 않으면 해당 제품을 카트 정보 추가
			if(cvo == null) {
			// 카트에 제품이 없으므로 카트에 추가 
				 CVO c_vo = new CVO();
				 c_vo.setP_num(vo.getP_num());
				 c_vo.setP_price(String.valueOf(vo.getP_price()));
				 c_vo.setP_name(vo.getP_name());
				 c_vo.setId(id);
				 dao.getCartInsert(c_vo);
			}else {
			// 카트에 제품이 있으므로 제품의 갯수를 1증가 시킨다.
				dao.getCartUpdate(cvo);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return mv ;
		
	}
	
	@RequestMapping("editcount.do")
	public ModelAndView editeCountCommand(CVO cvo) {
		try {
			dao.getCartEdit(cvo);
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("redirect:viewcart.do?id="+cvo.getId());
	}
	@RequestMapping("delproduct.do")
	public ModelAndView delProductCommand(CVO cvo) {
		try {
			dao.getCartDel(cvo);
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("redirect:viewcart.do?id="+cvo.getId());
	}
	
	@RequestMapping(value="addproduct.do",method=RequestMethod.GET)
	public ModelAndView addProuctCommand_GET() {
		return new ModelAndView("redirect:admin.do");
	}
	@RequestMapping(value="addproduct.do",method=RequestMethod.POST)
	public ModelAndView addProuctCommand_POST(VO vo, HttpSession sesson) {
		ModelAndView mv = new ModelAndView("redirect:list.do?category="+vo.getCategory());
		try {
			String path 
			= sesson.getServletContext().getRealPath("/resources/images");
			MultipartFile s_file = vo.getS_file();
			MultipartFile l_file = vo.getL_file();
			
			// 상품이미지는 무조건 넣어주는 것이 맞으므로 없는 경우을 생각하지 않음
			vo.setP_image_s(s_file.getOriginalFilename());
			vo.setP_image_l(l_file.getOriginalFilename());
			
			int result = dao.getProduct_Insert(vo);
			if(result >0) {
				s_file.transferTo(new File(path+"/"+vo.getP_image_s()));
				l_file.transferTo(new File(path+"/"+vo.getP_image_l()));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return mv;
	}
}




