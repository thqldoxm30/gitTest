package kr.co.daters.dao;

import java.util.List;

import kr.co.daters.domain.BoInfoVO;

public interface BoInfoDAO {
	void insertBoInfo(BoInfoVO  vo);
	BoInfoVO selectOneBoInfo(int boCode);
	void ownerUpdate(BoInfoVO vo);
	List<BoInfoVO> selectAllBoOrder();
}
