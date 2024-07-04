package context;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.VisitDAO;

//스프링한테 설정파일임을 알려주는 어노테이션
@Configuration
public class Context_2_dao {
	
	@Bean
	public VisitDAO visit_dao(SqlSession sqlSession) {
		return new VisitDAO(sqlSession);
	}
}






