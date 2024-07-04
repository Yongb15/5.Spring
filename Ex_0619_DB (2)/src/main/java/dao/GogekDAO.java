package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import lombok.RequiredArgsConstructor;
import vo.GogekVO;

@RequiredArgsConstructor
public class GogekDAO {

	final SqlSession sqlSession;
	
	//전체조회
	public List<GogekVO> selectList(){
		return sqlSession.selectList("gogek.gogek_list");
	}
	
	
}
