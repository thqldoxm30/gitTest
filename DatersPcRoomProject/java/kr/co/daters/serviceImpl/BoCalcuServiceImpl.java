package kr.co.daters.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.daters.dao.BoCalcuDAO;
import kr.co.daters.domain.BoCalcuVO;
import kr.co.daters.service.BoCalcuService;

@Service
public class BoCalcuServiceImpl implements BoCalcuService {
	
	@Autowired
	BoCalcuDAO boCalcuDAO;
	
	@Override
	public void defaultCalcu(BoCalcuVO vo) {
		boCalcuDAO.defaultCalcu(vo);
	}

	@Override
	public void updateCalcu(BoCalcuVO vo) {
		boCalcuDAO.updateCalcu(vo);
	}

	@Override
	public BoCalcuVO selectCalcuInfo(int boCode) {
		return boCalcuDAO.selectCalcuInfo(boCode);
	}

	@Override
	public void destroyCalcu(BoCalcuVO vo) {
		boCalcuDAO.destroyCalcu(vo);
	}

}
