package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import vo.DeptVO;

@Component
@RequiredArgsConstructor
public class DeptDAO {
	final SqlSession sqlSession;
	
	// 조회하기 메서드 기능 만들기
	// 메서드 이름 : selectList
	// namespace : dept
	// id : dept_list
	
	public List<DeptVO> selectList() {
		return sqlSession.selectList("dept.dept_list");
	}
}
