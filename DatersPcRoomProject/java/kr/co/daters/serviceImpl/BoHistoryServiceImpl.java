package kr.co.daters.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.daters.dao.BoHistoryDAO;
import kr.co.daters.domain.BoHistoryVO;
import kr.co.daters.service.BoHistoryService;

@Service
public class BoHistoryServiceImpl implements BoHistoryService{
	@Autowired
	BoHistoryDAO boHistory;

	@Override
	public void insertBoHistory(BoHistoryVO vo) {
		boHistory.insertBoHistory(vo);
	}

	@Override
	public List<BoHistoryVO> selectBoHistoryList(int boCode) {
		return boHistory.selectBoHistoryList(boCode);
	}
	
}
