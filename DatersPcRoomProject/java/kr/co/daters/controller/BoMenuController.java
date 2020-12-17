package kr.co.daters.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.daters.domain.BoMenuVO;
import kr.co.daters.domain.BoUsersVO;
import kr.co.daters.service.BoMenuService;

@Controller
public class BoMenuController {
	
	@Autowired
	BoMenuService boMenuDAO;
	
	@RequestMapping(value = "/MenuPlace.do")
	public String MenuPlace(HttpSession ses, Model model) {
		BoUsersVO user = (BoUsersVO) ses.getAttribute("UserInfo");
		System.out.println(user.getuUseBoCode());
		List<BoMenuVO> menuList = boMenuDAO.selectMenu(user.getuUseBoCode());
		model.addAttribute("menuList", menuList);
		return "Branch/MenuPlace";
	}
	
	@RequestMapping(value = "/MenuChoice.do")
	public String MenuChoice(BoMenuVO vo, HttpSession ses, HttpServletRequest sr) {
		String[] mNo = sr.getParameterValues("mNo"); // 1, 1, 3, 10, 15
		
		for(int i = 0; i<mNo.length; i++) {
			System.out.println(mNo[i]);
		}
		ses.setAttribute("ChoiceMenu", mNo);
		return "Branch/OrderComplet";
	}
}
