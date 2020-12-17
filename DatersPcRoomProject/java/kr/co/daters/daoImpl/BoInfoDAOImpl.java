package kr.co.daters.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.daters.dao.BoInfoDAO;
import kr.co.daters.domain.BoInfoVO;

@Repository
public class BoInfoDAOImpl implements BoInfoDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public void insertBoInfo(BoInfoVO vo) {
		sqlSession.insert("boInfoNS.insertBoInfo", vo);
	}

	@Override
	public BoInfoVO selectOneBoInfo(int boCode) {
		return sqlSession.selectOne("boInfoNS.selectOneBoInfo", boCode);
	}

	@Override
	public void ownerUpdate(BoInfoVO vo) {
		sqlSession.update("boInfoNS.ownerUpdate", vo);
	}

	@Override
	public List<BoInfoVO> selectAllBoOrder() {
		return sqlSession.selectList("boInfoNS.selectAllBoOrder");
	}
	
}
