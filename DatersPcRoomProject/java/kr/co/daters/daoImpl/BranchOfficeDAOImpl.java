package kr.co.daters.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.daters.dao.BranchOfficeDAO;
import kr.co.daters.domain.BranchOfficeVO;

@Repository
public class BranchOfficeDAOImpl implements BranchOfficeDAO {
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public BranchOfficeVO selectBranch(String id) {
		return sqlSession.selectOne("branchNS.selectBranch", id);
	}

	@Override
	public void insertBranch(BranchOfficeVO vo) {
		sqlSession.insert("branchNS.insertBranch", vo);
	}
	
	@Override
	public List<BranchOfficeVO> selectBoCode() {
		return sqlSession.selectList("branchNS.selectBoCode");
	}

	@Override
	public void userCnt(BranchOfficeVO vo) {
		sqlSession.update("branchNS.userCnt", vo);
		
	}

	@Override
	public BranchOfficeVO selectBranchCode(int boCode) {
		return sqlSession.selectOne("branchNS.selectBranchCode", boCode);
	}

	@Override
	public void calcuTotalUpdate(int boCode) {
		sqlSession.update("branchNS.calcuTotalUpdate", boCode);
	}

	@Override
	public BranchOfficeVO selectAdmin() {
		return sqlSession.selectOne("branchNS.selectAdmin");
	}

	@Override
	public void netProfitUpdate(int boCode) {
		sqlSession.update("branchNS.netProfitUpdate", boCode);
	}

	@Override
	public void adminTotalUpdate(BranchOfficeVO vo) {
		sqlSession.update("branchNS.adminTotalUpdate", vo);
	}
	
}
