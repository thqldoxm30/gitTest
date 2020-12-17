package kr.co.daters.service;

import java.util.List;

import kr.co.daters.domain.UHistoryVO;

public interface UHistoryService {
	void usersHistory(UHistoryVO vo);
	List<UHistoryVO> usersHistorySelectAll(int boCode);
}
