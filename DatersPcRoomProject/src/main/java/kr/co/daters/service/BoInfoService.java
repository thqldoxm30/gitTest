package kr.co.daters.service;

import kr.co.daters.domain.BoInfoVO;

public interface BoInfoService {
	void insertBoInfo(BoInfoVO  vo);
	BoInfoVO selectOneBoInfo(int boCode);
	void ownerUpdate(BoInfoVO vo);
}
