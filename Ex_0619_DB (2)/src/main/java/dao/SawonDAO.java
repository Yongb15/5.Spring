package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import lombok.RequiredArgsConstructor;
import vo.SawonVO;

@RequiredArgsConstructor
public class SawonDAO {

	final SqlSession sqlSession;
	
	//전체 사원조회
	public List<SawonVO> selectList(){
		return sqlSession.selectList("s.sawon_list");
	}
}
