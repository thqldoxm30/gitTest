package kr.co.daters.dao;

import java.util.List;

import kr.co.daters.domain.BoHistoryVO;

public interface BoHistoryDAO {
	void insertBoHistory(BoHistoryVO vo);
	List<BoHistoryVO> selectBoHistoryList(int boCode);
}
