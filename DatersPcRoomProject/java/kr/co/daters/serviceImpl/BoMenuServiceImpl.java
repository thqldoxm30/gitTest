package kr.co.daters.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.daters.dao.BoMenuDAO;
import kr.co.daters.domain.BoMenuVO;
import kr.co.daters.service.BoMenuService;

@Service
public class BoMenuServiceImpl implements BoMenuService {
	
	@Autowired
	BoMenuDAO boMenuDAO;

	@Override
	public List<BoMenuVO> selectMenu(int boCode) {
		return boMenuDAO.selectMenu(boCode);
	}

	@Override
	public List<BoMenuVO> choiceMenuInfo(int mNo) {
		return boMenuDAO.choiceMenuInfo(mNo);
	}

	@Override
	public void updateQuantity(int mNo) {
		boMenuDAO.updateQuantity(mNo);
	}

}
