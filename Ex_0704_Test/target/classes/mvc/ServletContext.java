package mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
//@ComponentScan
//@Component �뼱�끂�뀒�씠�뀡 諛� streotype(@Controller, @Service, @Repository)�뼱�끂�뀒�씠�뀡�씠
//遺��뿬�맂 class�뱾�쓣 �옄�룞�쑝濡� �뒪罹뷀븯�뿬 Bean�쑝濡� �벑濡앺빐二쇰뒗 �뿭�븷�쓣 �븯�뒗 �뼱�끂�뀒�씠�뀡
//@ComponentScan(basePackages = {"controller", "dao"})
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
	
}








