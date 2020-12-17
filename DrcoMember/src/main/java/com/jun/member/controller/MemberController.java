package com.jun.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jun.board.domain.BoardVO;
import com.jun.board.service.BoardService;
import com.jun.member.domain.MemberVO;
import com.jun.member.service.MemberService;


@Controller
public class MemberController {
	
	@Autowired
	MemberService dao;
	
	@Autowired
	BoardService boardDAO;
	
	@ModelAttribute("searchGender")
	public Map<String, String> searchGender(){
		Map<String, String> searchGender = new HashMap<String, String>();
		searchGender.put("남성", "man");
		searchGender.put("여성", "lady");
		
		return searchGender;
	}

	@ModelAttribute("searchYear")
	public Map<Integer, Integer> searchYear(){
		Map<Integer, Integer> searchYear = new HashMap<Integer, Integer>();
		int nowYear = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println(nowYear);
		for(int i = 1960; i < nowYear+1; i++) {
			searchYear.put(i, i);			
		}
		return searchYear;
	}
	
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(@ModelAttribute("member") MemberVO vo) {
		vo.setDc_id("admin");
		vo.setDc_password("admin");
		return "login";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(MemberVO vo, HttpSession session, HttpServletResponse response, Model model) throws IOException {
//		if(vo.getDc_id() == null || vo.getDc_id().equals("")) {
//			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
//		}
		
		if(vo.getSearchGender() == null) {
			vo.setSearchGender("");
		}
		
		MemberVO loginCheck = dao.selectMemberOne(vo.getDc_id());
		
		if(loginCheck != null && loginCheck.getDc_password().equals(vo.getDc_password())) {
			if(loginCheck.getDc_grade() > 50) {
				session.setAttribute("loginMember", dao.selectMemberOne(vo.getDc_id()));
				return "redirect:adminPage.do?startYear=1960&endYear="
									+Calendar.getInstance().get(Calendar.YEAR);
			}else if(loginCheck.getDc_state() == 2) {
				return "redirect:dormancy.jsp";
			}else if(loginCheck.getDc_state() == 3) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('회원이 등록되지 않았거나 아이디와 비밀번호가 일치하지 않습니다.'); history.go(-1);</script>");
				out.flush(); 
				out.close();
				return "login";
			}else{
				session.setAttribute("loginMember", dao.selectMemberOne(vo.getDc_id()));
				return "redirect:viewBoardList.do?num=1";				
			}
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원이 등록되지 않았거나 아이디와 비밀번호가 일치하지 않습니다.'); history.go(-1);</script>");
			out.flush(); 
			out.close();
		}
		return "login";
	}
	
	@RequestMapping(value = "/adminPage.do")
	public String adminPage(HttpSession session, BoardVO boardVO, 
							MemberVO mem, Model model, HttpServletRequest request) {
		if(boardVO.getSearchCondition() == null) {
			boardVO.setSearchCondition("TITLE");
		}
		if(boardVO.getSearchKeyWord() == null) {
			boardVO.setSearchKeyWord("");
		}
		if(mem.getSearchGender() == null) {
			mem.setSearchGender("lady");
		}
		//------------------ gender --------
		model.addAttribute("memberAllCnt", dao.cntMember());
		model.addAttribute("memberList", dao.selectMemberAll());
		model.addAttribute("genderList", dao.selectMemberGender(mem));
		if(mem.getSearchGender().equals("man")) {
			model.addAttribute("sex", "남성");
		}else {
			model.addAttribute("sex", "여성");
		}
		model.addAttribute("genderCnt", dao.selectMemberGender(mem).size());
		//------------------ year -----------
		int startYear = Integer.parseInt(request.getParameter("startYear"));
		int endYear = Integer.parseInt(request.getParameter("endYear"));
		model.addAttribute("yearList", dao.selectMemberYear(startYear, endYear));
		model.addAttribute("yearCnt", dao.selectMemberYear(startYear, endYear).size());
		model.addAttribute("startYear", startYear);
		model.addAttribute("endYear", endYear);
		
		model.addAttribute("boardList", boardDAO.selectAdminBoard());
		return "adminPage";
	}
	
	@RequestMapping(value = "/logout.do")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:index.jsp";
	}
	
	@RequestMapping(value = "/joinDrco.do")
	public String insertMember(MemberVO vo) {
		System.out.println(vo);
		dao.insertMember(vo);
		return "redirect:joinSuccess.jsp";
	}
	
	@RequestMapping(value = "/myPage.do")
	public String myPage(MemberVO vo, Model model, HttpSession session) {
		MemberVO nowUser = (MemberVO) session.getAttribute("loginMember");
		if(nowUser.getDc_grade() > 50) {
			model.addAttribute("updateMemInfo", dao.selectMemberOne(vo.getDc_id()));
			return "updateMemInfo";
		}
		session.setAttribute("loginMember", dao.selectMemberOne(vo.getDc_id()));
		return "myPage";
	}
	
	@RequestMapping(value = "/updateMyInfo.do")
	public String updateMyInfo(MemberVO vo) {
		dao.updateMyInfo(vo);
		return "redirect:viewBoardList.do";
	}
	
	@RequestMapping(value = "/updateMemInfo.do")
	public String updateMemInfo(MemberVO vo) {
		dao.updateMemInfo(vo);
		return "redirect:adminPage.do?startYear=1960&endYear="
								+Calendar.getInstance().get(Calendar.YEAR);
	}
	
	@RequestMapping(value = "/updateState.do")
	public String updateState(MemberVO vo, Model model, HttpServletResponse response, 
					HttpServletRequest request, HttpSession session) throws IOException {
		if(request.getParameter("agree").equals("드림코스메틱탈퇴동의")) {
			dao.updateState(vo);
			boardDAO.deleteBoardAll(vo);
			session.invalidate();
			return "redirect:index.jsp";
		}else if(request.getParameter("agree").equals("0")) {
			model.addAttribute("dc_id", vo.getDc_id());			
			return "updateState";
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('입력이 틀렸습니다. 정확하게 다시 입력해주세요!'); history.go(-1);</script>");
		out.flush(); 
		out.close();
		return "updateState";
	}
	
}
