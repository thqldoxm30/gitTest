package kr.co.daters.service;

import java.util.List;

import kr.co.daters.domain.BranchOfficeVO;

public interface BranchOfficeService {
	BranchOfficeVO selectBranch(String id);
	void insertBranch(BranchOfficeVO vo);
	List<BranchOfficeVO> selectBoCode();
	void userCnt(BranchOfficeVO vo);
	BranchOfficeVO selectBranchCode(int boCode);
	void adminTotalUpdate(BranchOfficeVO vo);
	void calcuTotalUpdate(int boCode);
	void netProfitUpdate(int boCode);
	BranchOfficeVO selectAdmin();
}
