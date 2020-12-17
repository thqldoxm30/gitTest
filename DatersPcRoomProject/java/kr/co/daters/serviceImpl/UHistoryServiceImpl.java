package kr.co.daters.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.daters.dao.UHistoryDAO;
import kr.co.daters.domain.UHistoryVO;
import kr.co.daters.service.UHistoryService;

@Service
public class UHistoryServiceImpl implements UHistoryService {
	
	@Autowired
	UHistoryDAO uHistoryDAO;
	
	@Override
	public void usersHistory(UHistoryVO vo) {
		uHistoryDAO.usersHistory(vo);
	}

	@Override
	public List<UHistoryVO> usersHistorySelectAll(int boCode) {
		return uHistoryDAO.usersHistorySelectAll(boCode);
	}



}
