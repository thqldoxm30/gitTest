package kr.co.daters.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.daters.domain.BoCalcuVO;
import kr.co.daters.domain.BoHistoryVO;
import kr.co.daters.domain.BranchOfficeVO;
import kr.co.daters.domain.UHistoryVO;
import kr.co.daters.service.BoCalcuService;
import kr.co.daters.service.BoHistoryService;
import kr.co.daters.service.UHistoryService;

@Controller
public class BoCalcuController {
	
	@Autowired
	BoCalcuService boCalcuDAO;
	
	@Autowired
	UHistoryService uHistoryDAO;
	
	@Autowired
	BoHistoryService boHistoryDAO;
	
	@RequestMapping(value = "/BranchCalculateGo.do")
	public String BranchCalculate(HttpSession ses, Model model) {
		BranchOfficeVO branch = (BranchOfficeVO) ses.getAttribute("BranchVO");
		BoCalcuVO bvo = boCalcuDAO.selectCalcuInfo(branch.getBoCode());
		model.addAttribute("CalcuInfo", bvo);
		List<UHistoryVO> history = uHistoryDAO.usersHistorySelectAll(branch.getBoCode());
		model.addAttribute("UserHistory", history);
		return "Branch/BranchCalculate";
	}
	
	@RequestMapping(value = "/NowCalcu.do")
	public String updateCalcu(BoCalcuVO vo, HttpSession ses, Model model) {
		System.out.println("==정산 작업==");
		BranchOfficeVO branch = (BranchOfficeVO) ses.getAttribute("BranchVO");
		
		BoCalcuVO bCal = boCalcuDAO.selectCalcuInfo(branch.getBoCode());
		System.out.println(bCal);
		
		BoHistoryVO bHis = new BoHistoryVO(bCal.getBoCode(), bCal.getcToday(), bCal.getcTotalTime(), bCal.getcTotalOther(),
				bCal.getcNetProfit(), bCal.getcCost(), bCal.getcCostInfo(), bCal.getcInsen());
		boHistoryDAO.insertBoHistory(bHis);
		
		List<BoHistoryVO> bHisList = boHistoryDAO.selectBoHistoryList(bCal.getBoCode());
		model.addAttribute("bHisList", bHisList);

		vo.setcCost(0);	vo.setcCostInfo("첫 정산 완료");vo.setcInsen(0);
		vo.setcNetProfit(0);vo.setcTotalOther(0);vo.setcTotalTime(0);
		boCalcuDAO.destroyCalcu(vo);
		return "Branch/LastCalcu";
	}
}
