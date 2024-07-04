package mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.korea.board.BoardController;

import dao.BoardDAO;
import dao.MemberDAO;

@Configuration
@EnableWebMvc
//@ComponentScan
//@Component 어노테이션 및 streotype(@Controller, @Service, @Repository)어노테이션이
//부여된 class들을 자동으로 스캔하여 Bean으로 등록해주는 역할을 하는 어노테이션
//@ComponentScan(basePackages= {"controller", "dao"})
public class ServletContext implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
//	@Bean
//	public InternalResourceViewResolver resolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setViewClass(JstlView.class);
//		resolver.setPrefix("/WEB-INF/views/");
//		resolver.setSuffix(".jsp");
//		return resolver;
//	}
	
	@Bean
	public BoardController boardController(BoardDAO boardDAO, MemberDAO memberDAO) {
		return new BoardController(boardDAO,memberDAO);
	}
}








