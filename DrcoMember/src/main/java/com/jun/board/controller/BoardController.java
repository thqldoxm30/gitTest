package com.jun.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jun.board.dao.FileService;
import com.jun.board.domain.BoardVO;
import com.jun.board.service.BoardService;
import com.jun.member.domain.MemberVO;
import com.jun.member.service.MemberService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService dao;
	
	@Autowired
	MemberService memberDAO;
	
	@Autowired
	FileService fileUploadService;
	
	@ModelAttribute("searchMap")
	public Map<String, String> searchMap(){
		Map<String, String> sm = new HashMap<String, String>();
		sm.put("제목", "B_TITLE");
		sm.put("내용", "B_CONTENT");
		
		return sm;
	}
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, MultipartFile uploadFile) throws IOException {
		uploadFile = vo.getB_uploadfile(); 
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("D:/"+fileName));
			fileUploadService.restore(uploadFile);
			vo.setB_fileLoad(fileName);
			System.out.println(fileName);
		}else {
			System.out.println("여기까지 넘어오시나요@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			vo.setB_fileLoad("이 게시물은 등록된 파일이 없습니다.");
		}
		//게시글 작성 수 업데이트
		MemberVO member = memberDAO.selectMemberOne(vo.getDc_id());
		member.setDc_boardCnt(member.getDc_boardCnt()+1);
		memberDAO.updateBoardCnt(member);
		System.out.println("===================vo = " + vo);
		dao.insertBoard(vo);
		return "redirect:viewBoardList.do";
	}
	
	@RequestMapping(value = "/viewBoardList.do")
	public String viewBoardList(BoardVO vo, Model model, HttpServletRequest request) {
		if(vo.getSearchCondition() == null) { //데이터가 넘어오지 않았을 경우
			vo.setSearchCondition("B_TITLE");
		}
		if(vo.getSearchKeyWord() == null) {
			vo.setSearchKeyWord("");
		}
		System.out.println("검색 조건입니다========================"+vo.getSearchCondition());
		System.out.println("검색 키워드입니다======================="+vo.getSearchKeyWord());
		int num;
		if(request.getParameter("num") == null) {
			num = 1;
		}else {
			num = Integer.parseInt(request.getParameter("num"));			
		}
		// 게시물 총 개수
		int count = dao.cntKeyword(vo);
		System.out.println(count);
		// 한 페이지 출력할 개수
		int cntNum = 5;
		// 페이지 끝나는 번호
		int b_rEnd = cntNum * num;
		// 하단 페이징 번호
		int pageNum = (int) Math.ceil((double) count / cntNum);
		// 출력할 게시물
		int b_rStart = (num - 1) * cntNum;
		//표현할 페이징 개수
		int pageNumCnt = 5;
		//표시되는 마지막 번호
		int pageNumEnd = (int)(Math.ceil((double)num/(double)pageNumCnt)*pageNumCnt);
		//표시되는 첫번째 번호
		int pageNumStart = pageNumEnd-(pageNumCnt-1);
		//마지막 번호 계산
		int pageNumLast = (int)(Math.ceil((double)count / (double)pageNumCnt));
		if(pageNumEnd > pageNumLast) {
			pageNumEnd = pageNumLast;
		}
		
		boolean prev = pageNumStart == 1 ? false : true;
		boolean next = pageNumEnd * pageNumCnt >= count ? false : true;
		
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		
		model.addAttribute("pageNumStart", pageNumStart);
		model.addAttribute("pageNumEnd", pageNumEnd);
		model.addAttribute("now", num);
		
		vo.setB_rStart(b_rStart);
		vo.setB_rEnd(b_rEnd);
		model.addAttribute("searchVO", vo);
		model.addAttribute("boardList", dao.keywordSearch(vo));
		model.addAttribute("pageNum", pageNum);
		
		return "viewBoardList";
	}
	
	
	@RequestMapping(value = "/viewBoard.do")
	public String viewBoard(BoardVO vo, Model model) {
		System.out.println(vo);
		BoardVO nowBoard = dao.selectBoardOne(vo);
		System.out.println("========nowBoard========"+nowBoard);
		dao.updateCnt(nowBoard);
		model.addAttribute("thisBoard", dao.selectBoardOne(vo));
		
		return "viewBoard";
	}
	
	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(BoardVO vo, Model model, HttpSession session, MemberVO user) {
		user = (MemberVO) session.getAttribute("loginMember");
		if(user.getDc_id().equals(dao.selectBoardOne(vo).getDc_id())) {
			model.addAttribute("thisBoard", dao.selectBoardOne(vo));
			return "updateBoard";			
		}
		return "failAccess";
	}
	
	@RequestMapping(value = "/updateComplet.do")
	public String updateComplet(@ModelAttribute("board") BoardVO vo, MultipartFile uploadFile) throws IllegalStateException, IOException {
		uploadFile = vo.getB_uploadfile(); 
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("D:/"+fileName));
			fileUploadService.restore(uploadFile);
			vo.setB_fileLoad(fileName);
		}else {
			vo.setB_fileLoad("이 게시물은 등록된 파일이 없습니다.");
		}
		dao.updateBoardOne(vo);
		return "redirect:viewBoardList.do";
	}
		
	@RequestMapping(value = "/deleteBoardOne.do")
	public String deleteBoardOne(BoardVO vo, Model model, HttpSession session, MemberVO user) {
		user = (MemberVO) session.getAttribute("loginMember");
		if(user.getDc_id().equals(dao.selectBoardOne(vo).getDc_id())) {
			dao.deleteBoardOne(vo);
			user.setDc_boardCnt(user.getDc_boardCnt()-1);
			memberDAO.updateBoardCnt(user);
			return "redirect:viewBoardList.do";
		}
		return "failAccess";
	}
}
