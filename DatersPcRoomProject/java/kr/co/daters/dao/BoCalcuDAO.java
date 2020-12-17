package kr.co.daters.dao;

import kr.co.daters.domain.BoCalcuVO;

public interface BoCalcuDAO {
	void defaultCalcu(BoCalcuVO vo);
	void updateCalcu(BoCalcuVO vo);
	BoCalcuVO selectCalcuInfo(int boCode);
	void destroyCalcu(BoCalcuVO vo);
}
