package kr.co.daters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping(value = "/index.do")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/LoginOwnerGo.do") 
	public String LoginOwner() {
		return "Branch/LoginOwner";
	}
	
	@RequestMapping(value = "/LoginMain.do") //바뀜
	public String LoginMain() {
		return "Users/ChoiceBoCode";
	}
	
	@RequestMapping(value = "/OwnerJoinGo.do")
	public String OwnerJoin() {
		return "Branch/OwnerJoin";
	}
	
	@RequestMapping(value = "/BranchLoginGo.do")
	public String BranchLogin() {
		return "Branch/BranchLogin";
	}
	
	@RequestMapping(value = "/OwnerInfoGo.do")
	public String OwnerInfoGo() {
		return "Branch/OwnerInfo";
	}
	@RequestMapping(value = "/CashInsertGO.do")
	public String CashInsertGO() {
		return "Users/CashInsert";
	}
	
	@RequestMapping(value = "/MyUserPage.do")
	public String MyUserPage() {
		return "Users/MyUserPage";
	}
	
	
}
