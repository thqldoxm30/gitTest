package kr.co.daters.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.daters.domain.BoCalcuVO;
import kr.co.daters.domain.BoInfoVO;
import kr.co.daters.domain.BranchOfficeVO;
import kr.co.daters.service.BoCalcuService;
import kr.co.daters.service.BoInfoService;
import kr.co.daters.service.BranchOfficeService;

@Controller
public class BoInfoController {
	@Autowired
	BoInfoService boInfoDAO;
	@Autowired
	BranchOfficeService branchOfficeDAO;
	@Autowired
	BoCalcuService boCalcuDAO;
	
	
	@RequestMapping(value = "/InsertBoInfo.do")
	public String InsertBoInfo(BoInfoVO vo, HttpSession ses, BoCalcuVO cvo) {
		System.out.println("==상세정보입력메소드==");
		boInfoDAO.insertBoInfo(vo);
		cvo.setBoCode(vo.getBoCode());
		cvo.setcCostInfo("첫생성");
		boCalcuDAO.defaultCalcu(cvo);
		return "index";
	}
	
	@RequestMapping(value = "/ownerUpdate.do")
	public String ownerUpdate(BoInfoVO vo) {
		boInfoDAO.ownerUpdate(vo);
		return "Branch/BranchLogin";
	}
	
	@RequestMapping(value = "/BranchMyPage.do")
	public String BranchMyPage(Model model, HttpSession ses) {
		BranchOfficeVO boCode = (BranchOfficeVO) ses.getAttribute("BranchVO");
		BoInfoVO bran = boInfoDAO.selectOneBoInfo(boCode.getBoCode());
		model.addAttribute("BranInfo", bran);
		
		
		return "Branch/BranchMyPage";
	}
}