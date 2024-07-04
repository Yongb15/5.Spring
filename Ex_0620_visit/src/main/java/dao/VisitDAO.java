package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import lombok.RequiredArgsConstructor;
import vo.VisitVO;

@RequiredArgsConstructor
public class VisitDAO {

	final SqlSession sqlSession;
	
	//방명록 전체 조회
	public List<VisitVO> selectList(){
		return sqlSession.selectList("v.visit_list");
	}
}





