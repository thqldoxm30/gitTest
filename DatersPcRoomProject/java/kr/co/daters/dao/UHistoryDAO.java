package kr.co.daters.dao;

import java.util.List;

import kr.co.daters.domain.UHistoryVO;

public interface UHistoryDAO {
	void usersHistory(UHistoryVO vo);
	List<UHistoryVO> usersHistorySelectAll(int boCode);
}
