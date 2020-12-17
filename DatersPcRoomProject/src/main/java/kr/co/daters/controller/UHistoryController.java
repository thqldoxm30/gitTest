package kr.co.daters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.co.daters.service.UHistoryService;

@Controller
public class UHistoryController {
	
	@Autowired
	UHistoryService uHistoryDAO;
	
}
