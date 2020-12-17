package kr.co.daters.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.daters.domain.BoInfoVO;
import kr.co.daters.domain.BoUsersVO;
import kr.co.daters.domain.BranchOfficeVO;
import kr.co.daters.security.SecurityMain;
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
	@Autowired
	SecurityMain security;
	
	@RequestMapping(value = "/BranchJoin.do")
	public String branchJoin(BranchOfficeVO vo, Model model) {
		System.out.println("==업주회원가입메소드==");
		vo.setBoPwd(security.insertPassword(vo.getBoPwd()));
		branchOfficeDAO.insertBranch(vo);
		BranchOfficeVO bran = branchOfficeDAO.selectBranch(vo.getBoId());
		bran.setBoPwd(security.restorationPassword(bran.getBoPwd()));
		model.addAttribute("boCode", bran.getBoCode());
		return "Branch/OwnerInfo";
	}
	
	@RequestMapping(value = "/BranchLogin.do")
	public String branchLogin(BranchOfficeVO vo, HttpSession ses) {
		System.out.println("==업주로그인메소드==");
		try {
			BranchOfficeVO branch = branchOfficeDAO.selectBranch(vo.getBoId());
			branch.setBoPwd(security.restorationPassword(branch.getBoPwd()));
			if(branch.getBoId().equals(vo.getBoId())&&branch.getBoPwd().equals(vo.getBoPwd())) {
				ses.setAttribute("BranchVO", branch); //객체 전달
				if(boInfoDAO.selectOneBoInfo(branch.getBoCode()) == null) {
					return "Branch/OwnerInfo";
				}else {
					BoInfoVO myPage = boInfoDAO.selectOneBoInfo(branch.getBoCode());
					ses.setAttribute("myPage", myPage);
					return "redirect:UserTable.do";
				}
			}else {
				return "redirect:LoginOwnerGo.do";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:LoginOwnerGo.do";
		}
	}
	
	@RequestMapping(value = "/UserTable.do")
	public String UserTable(BoUsersVO vo, HttpSession ses) {
		System.out.println("==업주의유저생성==");
		try {
			BoInfoVO bran = (BoInfoVO) ses.getAttribute("myPage");
			List<BoUsersVO> user = boUserDAO.selectUserAll(bran.getBoCode());
			for(int i = 0; i < user.size(); i++) {
				user.get(i).setuPwd(security.restorationPassword(user.get(i).getuPwd()));
			}
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
		vo.setuPwd(security.insertPassword(vo.getuPwd()));
		boUserDAO.updateUser(vo);
		List<BoUsersVO> user = boUserDAO.selectUserAll(vo.getBoCode());
		for(int i = 0; i < user.size(); i++) {
			user.get(i).setuPwd(security.restorationPassword(user.get(i).getuPwd()));
		}
		ses.setAttribute("users", user);
		return "Branch/BranchLogin";
	}
	
	@RequestMapping(value = "/MenuJumun.do")
	public String MenuJumun(BoUsersVO vo) {
		return "";
	}

}
