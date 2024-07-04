package context;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import advice.Advice;
import dao.TestDAO;


//스프링한테 설정파일임을 알려주는 어노테이션
@Configuration
@EnableAspectJAutoProxy
public class Context_2_dao {
	@Bean
	public TestDAO testDAO() {
		return new TestDAO();
	}
	@Bean Advice advice() {
		return new Advice();
	}
}






