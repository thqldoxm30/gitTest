package kr.co.daters.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.daters.dao.BoInfoDAO;
import kr.co.daters.domain.BoInfoVO;
import kr.co.daters.service.BoInfoService;

@Service
public class BoInfoServiceImpl implements BoInfoService {
	
	@Autowired
	BoInfoDAO boInfoDAO;
	
	@Override
	public void insertBoInfo(BoInfoVO vo) {
		boInfoDAO.insertBoInfo(vo);
	}

	@Override
	public BoInfoVO selectOneBoInfo(int boCode) {
		return boInfoDAO.selectOneBoInfo(boCode);
	}

	@Override
	public void ownerUpdate(BoInfoVO vo) {
		boInfoDAO.ownerUpdate(vo);
	}

	@Override
	public List<BoInfoVO> selectAllBoOrder() {
		return boInfoDAO.selectAllBoOrder();
	}

}
