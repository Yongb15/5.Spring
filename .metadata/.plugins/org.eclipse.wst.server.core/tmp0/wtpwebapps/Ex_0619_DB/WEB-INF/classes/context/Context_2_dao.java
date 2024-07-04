package context;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.DeptDAO;

//스프링한테 설정파일임을 알려주는 어노테이션
@Configuration
public class Context_2_dao {
	
	@Bean
	public DeptDAO deptDAO(SqlSession sqlSession) {
		return new DeptDAO(sqlSession);
	}
}






