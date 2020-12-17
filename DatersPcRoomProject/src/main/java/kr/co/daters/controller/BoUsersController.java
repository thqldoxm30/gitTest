package kr.co.daters.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.daters.domain.BoCalcuVO;
import kr.co.daters.domain.BoInfoVO;
import kr.co.daters.domain.BoMenuVO;
import kr.co.daters.domain.BoUsersVO;
import kr.co.daters.domain.BranchOfficeVO;
import kr.co.daters.domain.UHistoryVO;
import kr.co.daters.security.SecurityMain;
import kr.co.daters.service.BoCalcuService;
import kr.co.daters.service.BoInfoService;
import kr.co.daters.service.BoMenuService;
import kr.co.daters.service.BoUsersService;
import kr.co.daters.service.BranchOfficeService;
import kr.co.daters.service.UHistoryService;

@Controller
public class BoUsersController {

	@Autowired
	BoUsersService boUsersDAO;
	@Autowired
	BranchOfficeService branchOfficeDAO;
	@Autowired
	BoInfoService boInfoDAO;
	@Autowired
	UHistoryService uHistoryDAO;
	@Autowired
	BoCalcuService boCalcuDAO;
	@Autowired
	BoMenuService boMenuDAO;
	@Autowired
	SecurityMain security;

	@RequestMapping(value = "/UserJoin.do")
	public String insertUser(BoUsersVO vo) {
		System.out.println("==회원가입메소드==");
		vo.setuPwd(security.insertPassword(vo.getuPwd()));
		boUsersDAO.insertUser(vo);
		BranchOfficeVO branvo = branchOfficeDAO.selectBranchCode(vo.getBoCode());
		branvo.setBoUsers(branvo.getBoUsers() + 1);
		branchOfficeDAO.userCnt(branvo);
		return "index";
	}

	@RequestMapping(value = "/UserCreate.do")
	public String UserCreate(HttpSession ses, BranchOfficeVO vo) {
		List<BranchOfficeVO> branch = branchOfficeDAO.selectBoCode();
		ses.setAttribute("BoCodeList", branch);
		return "Users/UserJoin";
	}
	
	@RequestMapping(value = "/MainGo.do")
	public String MainGo(HttpSession ses) {
		List<BranchOfficeVO> branch = branchOfficeDAO.selectBoCode();
		ses.setAttribute("BoCodeList", branch);
		
		return "Users/ChoiceBoCode";
	}
	
	@RequestMapping(value = "/ChoiceSeat.do")
	public String ChoiceSeat(HttpServletRequest sr, Model model) {
		int boCode = Integer.parseInt(sr.getParameter("boCode"));
		BoInfoVO branchInfo = boInfoDAO.selectOneBoInfo(boCode);
		
		List<BoUsersVO> usingSeat = boUsersDAO.usingSeat(boCode);
		
		int size = usingSeat.size();
		int[] useSeat = new int[(int) branchInfo.getBoTotalseat()];
		
		for(int i = 0; i<size; i++) {
			System.out.println(usingSeat.get(i).getuUseSeat()-1);
			useSeat[usingSeat.get(i).getuUseSeat()-1] = 1;
		}
		
		model.addAttribute("useSeatTest", useSeat); //사용중인 자리 표현 배열
		model.addAttribute("usingSeat", usingSeat);
		model.addAttribute("boCode", branchInfo.getBoCode());
		model.addAttribute("boTotalseat", branchInfo.getBoTotalseat());
		return "Users/ChoiceSeat";
	}
	
	@RequestMapping(value = "/LoginGo.do")
	public String Login(HttpSession ses, HttpServletRequest sr, Model model) {
		ses.setAttribute("useSeat", sr.getParameter("seat"));
		ses.setAttribute("useBoCode", sr.getParameter("boCode"));
		return "Users/Login";
	}
	
	@RequestMapping(value = "/Login.do")
	public String LoginUser(BoUsersVO vo, HttpSession ses) {
		System.out.println("==로그인메소드==");
		try {
			BoUsersVO user = boUsersDAO.selectOneUser(vo.getuId());
			user.setuPwd(security.restorationPassword(user.getuPwd()));
			if (user.getuId().equals(vo.getuId()) && user.getuPwd().equals(vo.getuPwd()) && user.getuState() == 1
					&& user.getuSavetime() != 0) {
				user.setuUseSeat(Integer.valueOf((String) ses.getAttribute("useSeat"))); //사용중인 좌석 설정
				user.setuUseBoCode(Integer.valueOf( (String) ses.getAttribute("useBoCode"))); //사용중인 업소 설정
				
				boUsersDAO.updateSeatUser(user);
				ses.setAttribute("UserInfo", user);
				ses.setAttribute("uSaveTimeH", user.getuSavetime() / 3600);
				ses.setAttribute("uSaveTimeM", (user.getuSavetime() % 3600) / 60);
				System.out.println("로그인 성공");
				return "index";
			} else if (user.getuId().equals(vo.getuId()) && user.getuPwd().equals(vo.getuPwd()) && user.getuState() == 1
					&& user.getuSavetime() == 0) {
				user.setuUseSeat(Integer.valueOf((String) ses.getAttribute("useSeat"))); //사용중인 좌석 설정
				user.setuUseBoCode(Integer.valueOf( (String) ses.getAttribute("useBoCode"))); //사용중인 업소 설정
				List<BoMenuVO> menuList = boMenuDAO.selectMenu(user.getuUseBoCode());
				ses.setAttribute("menuList", menuList);
				ses.setAttribute("UserInfo", user);
				System.out.println("저장된 시간이 없어서 충전페이지로 갑니다.");
				return "Users/CashInsert";
			} else {
				System.out.println("로그인 실패");
				return "index";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("아이디가 존재하지않음");
			return "Users/Login";
		}
	}

	@RequestMapping(value = "/Logout.do")
	public String LogoutMet(HttpSession ses) {
		System.out.println("==로그아웃==");
		try {
			BoUsersVO users = (BoUsersVO) ses.getAttribute("UserInfo");
			users.setuUseBoCode(0);
			users.setuUseSeat(0);
			boUsersDAO.updateSeatUser(users);
		} catch (Exception e) {
			
		}
		
		ses.invalidate();
		return "redirect:index.do";
	}
	
	@RequestMapping(value = "/UsersUpdate.do")
	public String UpdateUser(BoUsersVO vo, HttpSession ses) {
		System.out.println("==유저정보수정==");
		BoUsersVO user = boUsersDAO.selectOneUser(vo.getuId());
		if(vo.getuBirth() == null) {
			vo.setuBirth(user.getuBirth());
		}
		vo.setuPwd(security.insertPassword(vo.getuPwd()));
		boUsersDAO.updateUser(vo);
		user.setuPwd(security.restorationPassword(user.getuPwd()));
		ses.setAttribute("UserInfo", user);
		return "index";
	}

	@RequestMapping(value = "/UsersPrivate.do")
	public String UsersPrivate(BoUsersVO vo, HttpSession ses, Model model) {
		BoUsersVO users = boUsersDAO.selectOneUser(vo.getuId());
		users.setuPwd(security.restorationPassword(users.getuPwd()));
		model.addAttribute("UserPrivate", users);
		long saveH = users.getuSavetime()/3600;
		long saveM = (users.getuSavetime() % 3600) /60;
		
		
		model.addAttribute("uSaveTimeH", saveH);
		model.addAttribute("uSaveTimeM",saveM);
		return "Branch/UserPrivateInfo";
	}

	@RequestMapping(value = "/InsertUserCash.do")
	public String InsertUserCash(BoUsersVO vo, HttpSession ses, Model model) {
		BoUsersVO users = (BoUsersVO) ses.getAttribute("UserInfo");

		// 시간충전 구간
		Calendar insertTime = Calendar.getInstance();
		insertTime.setTimeInMillis(3600 * vo.getuSavetime());

		long saveTime = insertTime.getTimeInMillis();
		long savedTime = users.getuSavetime(); // 원래 저장된 시간

		users.setuSavetime(savedTime + saveTime);
		users.setuPoint(users.getuPoint() + (int) (50 * vo.getuSavetime())); // 한시간당 10원의 포인트 적립
		users.setuAllTime(users.getuAllTime() + saveTime);

		ses.setAttribute("uSaveTimeH", users.getuSavetime() / 3600); // 시간을 저장하여 세션에 뿌려줌
		ses.setAttribute("uSaveTimeM", (users.getuSavetime() % 3600) / 60); // 분을 저장

		boUsersDAO.insertTime(users);


		return "index";
	}

	@RequestMapping(value = "/UseCashTime.do")
	public String UseCashTime(BoUsersVO vo, HttpSession ses) {
		long oldTime = vo.getuSavetime(); // 초
		BoUsersVO vvo = (BoUsersVO) ses.getAttribute("UserInfo");
		BoUsersVO users = boUsersDAO.selectOneUser(vvo.getuId());
		users.setuSavetime(users.getuSavetime() - oldTime);
		boUsersDAO.useTime(users);
		// 유저의 업데이트 작업 끝
		
		// 유저의 히스토리 작업 시작
	
		String[] test = (String[]) ses.getAttribute("ChoiceMenu");
		List<BoMenuVO> ChoiceMenu = new ArrayList<BoMenuVO>();
		
		for(String list:test) {
			ChoiceMenu.addAll(boMenuDAO.choiceMenuInfo(Integer.parseInt(list)));
		}
		int ChoiceSize = ChoiceMenu.size();
		int count = 0;
		
		for(int i = 0; i<ChoiceSize; i++) {
			count += ChoiceMenu.get(i).getmPrice();
		}
		
		for(String list:test) {
			boMenuDAO.updateQuantity(Integer.parseInt(list));
		}
		
		System.out.println(count);
		
		
		
		int nowseat = Integer.valueOf((String) ses.getAttribute("useSeat")); // 예비좌석 나중에 변경 ※
		int usePay = (int) (oldTime * 0.277777778); // 초당 완벽한 계산법
		String useInfo = "오늘 '" + users.getuName() + "' 회원님께서 " + users.getBoCode() + "코드에 해당되는 피시방 " + nowseat
				+ "번 좌석에서 " + oldTime + "초를 사용하였고 요금은 " + usePay + "원, 기타금액으로는 "+count+"원이 결제되었습니다.";
		UHistoryVO uHis = new UHistoryVO(users.getuCode(), users.getBoCode(), vo.getuSavetime(), usePay, count, useInfo,
				nowseat);
		uHistoryDAO.usersHistory(uHis);
		// 유저의 히스토리 작업 끝

		// 업소의 결산작업 시작
		BoCalcuVO cvo = boCalcuDAO.selectCalcuInfo(vvo.getBoCode());
		vvo.getBoCode();
		long totalTime = usePay + cvo.getcTotalTime();
		cvo.setcTotalTime(totalTime);
		int totalCalcu = (int) ((cvo.getcTotalTime() + cvo.getcTotalOther()) * 0.85);
		int companySnadPay = (int) ((cvo.getcTotalTime() + cvo.getcTotalOther()) * 0.15); // 본사의 줄돈
		cvo.setcCost(companySnadPay); // 지출은 본사의 보낼돈 하나
		cvo.setcInsen((long) (companySnadPay * 0.2)); // 본사의 보내는돈의 20%를 인센으로
		cvo.setcNetProfit(totalCalcu + cvo.getcInsen()); // 순 수익 85%의 수익과 인센티브를 합산
		cvo.setcTotalOther(cvo.getcTotalOther()+count);
		boCalcuDAO.updateCalcu(cvo);
		// 업소의 결산작업 끝

		// 본사의 결제내역을 보내는 작업
		BranchOfficeVO adminPay = branchOfficeDAO.selectAdmin();
		adminPay.setBoTotalRevenue(adminPay.getBoTotalRevenue() + companySnadPay);
		adminPay.setBoCost((long) (adminPay.getBoCost() + companySnadPay * 0.2));
		adminPay.setBoNetProfit(adminPay.getBoNetProfit() + (adminPay.getBoTotalRevenue() - adminPay.getBoCost()));
		branchOfficeDAO.adminTotalUpdate(adminPay);
		// 본사의 결제내역을 보내는 작업 끝

		// 각 매장별로 벌어들인 정보 작업
		BranchOfficeVO branPay = branchOfficeDAO.selectBranchCode(vvo.getBoCode());
		branchOfficeDAO.calcuTotalUpdate(branPay.getBoCode());
		branchOfficeDAO.netProfitUpdate(branPay.getBoCode());
		// 각 매장별로 벌어들인 정보 작업 끝

		users.setuUseSeat(0);
		users.setuUseBoCode(0);
		boUsersDAO.updateSeatUser(users); //자리 초기화 사용종료를 의미
		ses.invalidate(); // 모든 작업이 끝나고 세션을 종료함 즉 로그아웃 처리
		return "redirect:index.do";
	}

}
