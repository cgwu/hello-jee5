package springInAction.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
@Order(8)
public class AfterAspectExample {
	
	@After("execution(* struts2InAction.services.*Service.*(..))")
	public void doAccessCheck(){
		System.out.println("AfterAspectExample 访问后检查");
	}
	
}
