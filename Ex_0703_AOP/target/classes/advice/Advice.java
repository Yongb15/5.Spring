package advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Advice {
	long start;
	@Pointcut("execution(* dao.*DAO.*(..))")
	public void myPoint() {};
	
	@Before("myPoint()")
	//JoinPoint : 포인트컷에 걸린 위치의 정보를 받는 클래스
	public void before(JoinPoint jp) {
		System.out.println("---before : " + jp.getSignature());
		start=System.currentTimeMillis();
	}
	
	@After("myPoint()")
	public void after(JoinPoint jp) {
		System.out.println("---after : " + jp.toLongString());
		long end = System.currentTimeMillis();
		System.out.printf("[수행시간] : %d(ms)\n",end-start );
	}
}
