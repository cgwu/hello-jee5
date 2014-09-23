package springInAction.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeAspectExample {
	
	@Before("execution(* struts2InAction.services.*Service.*(..))")
	public void doAccessCheck(){
		System.out.println("BeforeAspectExample 访问前检查");
	}
	
}
