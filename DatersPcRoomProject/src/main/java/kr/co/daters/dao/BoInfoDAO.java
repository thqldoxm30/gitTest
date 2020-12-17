package kr.co.daters.dao;

import kr.co.daters.domain.BoInfoVO;

public interface BoInfoDAO {
	void insertBoInfo(BoInfoVO  vo);
	BoInfoVO selectOneBoInfo(int boCode);
	void ownerUpdate(BoInfoVO vo);
}
