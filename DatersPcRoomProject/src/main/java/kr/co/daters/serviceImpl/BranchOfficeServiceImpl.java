package kr.co.daters.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.daters.dao.BranchOfficeDAO;
import kr.co.daters.domain.BranchOfficeVO;
import kr.co.daters.service.BranchOfficeService;

@Service
public class BranchOfficeServiceImpl implements BranchOfficeService {
	
	@Autowired
	BranchOfficeDAO branchOfficeDAO;
	
	@Override
	public BranchOfficeVO selectBranch(String id) {
		return branchOfficeDAO.selectBranch(id);
	}

	@Override
	public void insertBranch(BranchOfficeVO vo) {
		branchOfficeDAO.insertBranch(vo);
	}

	@Override
	public List<BranchOfficeVO> selectBoCode() {
		return branchOfficeDAO.selectBoCode();
	}

	@Override
	public void userCnt(BranchOfficeVO vo) {
		branchOfficeDAO.userCnt(vo);
	}

	@Override
	public BranchOfficeVO selectBranchCode(int boCode) {
		return branchOfficeDAO.selectBranchCode(boCode);
	}

	@Override
	public void calcuTotalUpdate(int boCode) {
		branchOfficeDAO.calcuTotalUpdate(boCode);
	}

	@Override
	public BranchOfficeVO selectAdmin() {
		return branchOfficeDAO.selectAdmin();
	}

	@Override
	public void netProfitUpdate(int boCode) {
		branchOfficeDAO.netProfitUpdate(boCode);
	}

	@Override
	public void adminTotalUpdate(BranchOfficeVO vo) {
		branchOfficeDAO.adminTotalUpdate(vo);
	}

}
