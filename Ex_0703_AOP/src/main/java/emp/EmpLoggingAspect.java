package emp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmpLoggingAspect {
	@Before("execution(* emp.EmpManager.get*(..))")
	public void before(JoinPoint joinPoint) {
		System.out.println(">>>>>>>>>>>>>> Before Advice : "+joinPoint.getSignature().getName());
	}
	@Around("execution(* emp.EmpManager.get*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(">>>>>>>>>>>>>> Around Advice[전] : "+ pjp.getSignature().getName());
		
		Object o = pjp.proceed();
		
		System.out.println(">>>>>>>>>>>>>> Around Advice[후] : "+ pjp.getSignature().getName());
		
		return o;
	}
	//returning : 타겟으로 지정된 메서드의 반환값을 받을 수 있다.
	@AfterReturning(pointcut = "execution(* emp.EmpManager.*(..))", returning = "retVal")
	public void afterReturning(JoinPoint joinPoint, Object retVal) {
		System.out.println(">>>>>>>>>>>>>>>> AfterReturning Advice : " + joinPoint.getSignature().getName());
		System.out.println(">>>>>>>>>>>>>>>> AfterReturning Advice return value is" + retVal);
	}
	
	@After("execution (* emp.EmpManager.get*(..))")
	public void after(JoinPoint joinPoint) {
		System.out.println(">>>>>>> After Advice : " + joinPoint.getSignature().getName());
	}
	
	@AfterThrowing(pointcut = "execution (* emp.EmpManager.*(..))", throwing = "ex")
	public void logAfterThrowing(Exception ex) throws Throwable{
		System.out.println(">>>>>>> @After Throwing Advice : " + ex);
	}
}
