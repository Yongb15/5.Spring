package emp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import context.Context_3_aop;

public class EmpTest {
	public static void main(String[] args) {
		
		//AnnotationConfigApplicationContext
		//Spring의 ApplicationContext 인터페이스를 구현하여 애플리케이션 컨텍스트를 나타낸다.
		//주로 Java Config(자바 기반 설정)을 사용하여 Spring 애플리케이션 컨텍스트를 설정하는데 사용된다.
		ApplicationContext context = new AnnotationConfigApplicationContext(Context_3_aop.class);
		
		EmpManager manager=(EmpManager)context.getBean("empManager");
		
		manager.setEmp(new Emp("1", "홍길동"));
		manager.setEmp(new Emp("2", "김길동"));
		
		List<Emp> emps= manager.getAllEmps();
		System.out.println(emps);
	}
}
