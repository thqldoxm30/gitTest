package kr.co.daters.service;

import kr.co.daters.domain.BoCalcuVO;

public interface BoCalcuService {
	void defaultCalcu(BoCalcuVO vo);
	void updateCalcu(BoCalcuVO vo);
	BoCalcuVO selectCalcuInfo(int boCode);
	void destroyCalcu(BoCalcuVO vo);
}
