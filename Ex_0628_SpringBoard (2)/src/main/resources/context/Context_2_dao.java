package context;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.BoardDAO;
import dao.MemberDAO;

//스프링한테 설정파일임을 알려주는 어노테이션
@Configuration
public class Context_2_dao {
	
	@Bean
	public BoardDAO boardDAO(SqlSession sqlSession) {
		return new BoardDAO(sqlSession);
	}
	
	@Bean
	public MemberDAO memberDAO(SqlSession sqlSession) {
		return new MemberDAO(sqlSession);
	}
}






