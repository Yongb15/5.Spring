package dao;

import org.apache.ibatis.session.SqlSession;

import lombok.RequiredArgsConstructor;
import vo.MemberVO;

@RequiredArgsConstructor
public class MemberDAO {

	final SqlSession sqlSession;
	
	public MemberVO loginCheck(String id) {
		return sqlSession.selectOne("m.loginCheck",id);
	}
	
	public MemberVO selectOne(String id) {
		return sqlSession.selectOne("m.idCheck",id);
	}
}
