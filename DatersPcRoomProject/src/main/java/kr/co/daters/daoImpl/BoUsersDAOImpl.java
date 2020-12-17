package kr.co.daters.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.daters.dao.BoUsersDAO;
import kr.co.daters.domain.BoUsersVO;

@Repository
public class BoUsersDAOImpl implements BoUsersDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public BoUsersVO selectOneUser(String id) {
		return sqlSession.selectOne("boUsersNS.selectOneUser", id);
	}
	
	@Override
	public List<BoUsersVO> selectUserAll(int boCode) {
		return sqlSession.selectList("boUsersNS.selectAlluser", boCode);
	}
	
	@Override
	public void insertUser(BoUsersVO vo) {
		sqlSession.insert("boUsersNS.insertUser", vo);
	}

	@Override
	public void useTime(BoUsersVO vo) {
		sqlSession.update("boUsersNS.useTime", vo);
	}

	@Override
	public void insertTime(BoUsersVO vo) {
		sqlSession.update("boUsersNS.insertTime", vo);
	}

	@Override
	public void updateUser(BoUsersVO vo) {
		sqlSession.update("boUsersNS.updateUser", vo);
	}

	@Override
	public void updateSeatUser(BoUsersVO vo) {
		sqlSession.update("boUsersNS.updateSeatUser", vo);
	}

	@Override
	public List<BoUsersVO> usingSeat(int boCode) {
		return sqlSession.selectList("boUsersNS.usingSeat", boCode);
	}
	
	
}
