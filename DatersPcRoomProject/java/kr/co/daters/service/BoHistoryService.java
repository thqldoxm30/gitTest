package kr.co.daters.service;

import java.util.List;

import kr.co.daters.domain.BoHistoryVO;

public interface BoHistoryService {
	void insertBoHistory(BoHistoryVO vo);
	List<BoHistoryVO> selectBoHistoryList(int boCode);
}
