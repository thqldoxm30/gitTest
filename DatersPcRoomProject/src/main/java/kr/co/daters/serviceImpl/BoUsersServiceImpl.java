package kr.co.daters.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.daters.dao.BoUsersDAO;
import kr.co.daters.domain.BoUsersVO;
import kr.co.daters.service.BoUsersService;

@Service
public class BoUsersServiceImpl implements BoUsersService {
	
	@Autowired
	BoUsersDAO boUsersDAO;
	
	@Override
	public BoUsersVO selectOneUser(String id) {
		return boUsersDAO.selectOneUser(id);
	}

	@Override
	public List<BoUsersVO> selectUserAll(int boCode) {
		return boUsersDAO.selectUserAll(boCode);
	}

	@Override
	public void insertUser(BoUsersVO vo) {
		boUsersDAO.insertUser(vo);
	}

	@Override
	public void useTime(BoUsersVO vo) {
		boUsersDAO.useTime(vo);
	}

	@Override
	public void insertTime(BoUsersVO vo) {
		boUsersDAO.insertTime(vo);
	}

	@Override
	public void updateUser(BoUsersVO vo) {
		boUsersDAO.updateUser(vo);
	}

	@Override
	public void updateSeatUser(BoUsersVO vo) {
		boUsersDAO.updateSeatUser(vo);
	}

	@Override
	public List<BoUsersVO> usingSeat(int boCode) {
		return boUsersDAO.usingSeat(boCode);
	}

}
