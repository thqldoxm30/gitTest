package kr.co.daters.dao;

import java.util.List;

import kr.co.daters.domain.BranchOfficeVO;

public interface BranchOfficeDAO {
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
