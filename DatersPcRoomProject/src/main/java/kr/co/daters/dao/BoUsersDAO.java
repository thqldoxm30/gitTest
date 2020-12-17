package kr.co.daters.dao;

import java.util.List;

import kr.co.daters.domain.BoUsersVO;
import kr.co.daters.domain.BranchOfficeVO;

public interface BoUsersDAO {
	BoUsersVO selectOneUser(String id);
	List<BoUsersVO> selectUserAll(int boCode);
	void insertUser(BoUsersVO vo);
	void useTime(BoUsersVO vo);
	void insertTime(BoUsersVO vo);
	void updateUser(BoUsersVO vo);
	void updateSeatUser(BoUsersVO vo);
	List<BoUsersVO> usingSeat(int boCode);
}
