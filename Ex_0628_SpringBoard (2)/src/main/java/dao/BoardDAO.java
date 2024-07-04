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
	
	public int update_readhit(int idx) {
		int res = sqlSession.update("b.update_readhit",idx);
		return res;
	}
	
	public int insert(BoardVO vo) {
		int res = sqlSession.insert("b.board_insert",vo);
		return res;
	}
	
	public int del_update(BoardVO vo) {
		int res = sqlSession.update("b.del_update",vo);
		return res;
	}
	
	public int update_step(BoardVO vo) {
		int res = sqlSession.update("b.board_update_step",vo);
		return res;
	}
	
	public int reply(BoardVO vo) {
		int res = sqlSession.insert("b.board_reply",vo);
		return res;
	}
}






