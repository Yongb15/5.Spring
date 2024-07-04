package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import lombok.RequiredArgsConstructor;
import vo.BoardVO;

@RequiredArgsConstructor
public class BoardDAO {

	final SqlSession sqlSession;
	
	//전체 게시물 수 조회
	public int getRowTotal() {
		return sqlSession.selectOne("b.board_count");
	}
	
	//번호에 따른 게시글 조회
	public List<BoardVO> selectList(HashMap<String, Integer> map){
		return sqlSession.selectList("b.board_list",map);
	}
	
	//게시글 한 건 조회하기
	public BoardVO selectOne(int idx) {
		BoardVO vo = sqlSession.selectOne("b.board_one",idx);
		return vo;
	}
	
}






