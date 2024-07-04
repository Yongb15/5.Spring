package context;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.DeptDAO;
import dao.GogekDAO;
import dao.SawonDAO;

//스프링한테 설정파일임을 알려주는 어노테이션
@Configuration
public class Context_2_dao {
	
	@Bean
	public DeptDAO deptDAO(SqlSession sqlSession) {
		return new DeptDAO(sqlSession);
	}
	
	@Bean
	public SawonDAO sawonDAO(SqlSession sqlSession) {
		return new SawonDAO(sqlSession);
	}
	
	@Bean
	public GogekDAO gogekDAO(SqlSession sqlSession) {
		return new GogekDAO(sqlSession);
	}
}






