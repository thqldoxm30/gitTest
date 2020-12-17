package kr.co.daters.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.daters.dao.BoCalcuDAO;
import kr.co.daters.domain.BoCalcuVO;

@Repository
public class BoCalcuDAOImpl implements BoCalcuDAO {
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public void defaultCalcu(BoCalcuVO vo) {
		sqlSession.insert("boCalcuNS.defaultCalcu", vo);
	}

	@Override
	public void updateCalcu(BoCalcuVO vo) {
		sqlSession.update("boCalcuNS.updateCalcu", vo);
	}

	@Override
	public BoCalcuVO selectCalcuInfo(int boCode) {
		return sqlSession.selectOne("boCalcuNS.selectCalcuInfo", boCode);
	}

	@Override
	public void destroyCalcu(BoCalcuVO vo) {
		sqlSession.update("boCalcuNS.destroyCalcu", vo);
	}
	
}
