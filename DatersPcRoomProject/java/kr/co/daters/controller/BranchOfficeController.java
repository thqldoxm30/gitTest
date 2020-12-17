package kr.co.daters.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.daters.domain.BoInfoVO;
import kr.co.daters.domain.BoUsersVO;
import kr.co.daters.domain.BranchOfficeVO;
import kr.co.daters.service.BoInfoService;
import kr.co.daters.service.BoUsersService;
import kr.co.daters.service.BranchOfficeService;

@Controller
public class BranchOfficeController {
	
	@Autowired
	BranchOfficeService branchOfficeDAO;
	@Autowired
	BoInfoService boInfoDAO;
	@Autowired
	BoUsersService boUserDAO;
	
	@RequestMapping(value = "/BranchJoin.do")
	public String branchJoin(BranchOfficeVO vo, Model model) {
		System.out.println("==업주회원가입메소드==");
		branchOfficeDAO.insertBranch(vo);
		BranchOfficeVO bran = branchOfficeDAO.selectBranch(vo.getBoId());
		model.addAttribute("boCode", bran.getBoCode());
		return "Branch/OwnerInfo";
	}
	
	@RequestMapping(value = "/BranchLogin.do")
	public String branchLogin(BranchOfficeVO vo, HttpSession ses, HttpServletResponse rs) throws IOException {
		System.out.println("==업주로그인메소드==");
		try {
			BranchOfficeVO branch = branchOfficeDAO.selectBranch(vo.getBoId());
			if(branch.getBoId().equals(vo.getBoId())&&branch.getBoPwd().equals(vo.getBoPwd())) {
				ses.setAttribute("BranchVO", branch); //객체 전달
				System.out.println(boInfoDAO.selectOneBoInfo(branch.getBoCode()));
				if(boInfoDAO.selectOneBoInfo(branch.getBoCode()) == null) {
					return "Branch/OwnerInfo";
				}else {
					BoInfoVO myPage = boInfoDAO.selectOneBoInfo(branch.getBoCode());
					ses.setAttribute("myPage", myPage);
					return "redirect:UserTable.do";
				}
			}else {
				errMsg(rs, "아이디 혹은 비밀번호를 확인해주세요!");
				return "Branch/LoginOwner";
			}
		} catch (Exception e) {
			e.printStackTrace();
			errMsg(rs, "아이디 혹은 비밀번호를 확인해주세요!");
			return "Branch/LoginOwner";
		}
	}
	
	@RequestMapping(value = "/UserTable.do")
	public String UserTable(BoUsersVO vo, HttpSession ses) {
		System.out.println("==업주의유저생성==");
		try {
			BoInfoVO bran = (BoInfoVO) ses.getAttribute("myPage");
			List<BoUsersVO> user = boUserDAO.selectUserAll(bran.getBoCode());
			ses.setAttribute("users", user);
			return "Branch/BranchLogin";
		} catch (Exception e) {
			e.printStackTrace();
			return "Branch/LoginOwner";
		}
	}
	
	@RequestMapping(value = "/UserPrivateUpdate.do")
	public String UserPrivateUpdate(BoUsersVO vo, HttpSession ses) {
		if(vo.getuBirth() == null) {
			BoUsersVO user = boUserDAO.selectOneUser(vo.getuId());
			vo.setuBirth(user.getuBirth());
		}
		boUserDAO.updateUser(vo);
		List<BoUsersVO> user = boUserDAO.selectUserAll(vo.getBoCode());
		ses.setAttribute("users", user);
		return "Branch/BranchLogin";
	}
	
	@RequestMapping(value = "/MenuJumun.do")
	public String MenuJumun(BoUsersVO vo) {
		
		return "";
	}

	
	// 에러 메세지
	public void errMsg(HttpServletResponse rs, String msg) throws IOException {
		rs.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = rs.getWriter();
		writer.println("<script type='text/javascript'>");
		writer.println("alert('" + msg + "');");
		writer.println("history.back();");
		writer.println("</script>");
		writer.flush();
	}
}
