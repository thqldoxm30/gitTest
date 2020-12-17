package kr.co.daters.service;

import java.util.List;

import kr.co.daters.domain.BoInfoVO;

public interface BoInfoService {
	void insertBoInfo(BoInfoVO  vo);
	BoInfoVO selectOneBoInfo(int boCode);
	void ownerUpdate(BoInfoVO vo);
	List<BoInfoVO> selectAllBoOrder();
}
