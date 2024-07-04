package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import lombok.RequiredArgsConstructor;
import vo.DeptVO;

@RequiredArgsConstructor
public class DeptDAO {
	
	final SqlSession sqlSession;
	
	//전체부서를 조회
	public List<DeptVO> selectList(){
		return sqlSession.selectList("dept.dept_list");
	}
	
	
	
	
	
	
	
	
}
