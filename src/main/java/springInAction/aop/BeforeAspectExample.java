package springInAction.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BeforeAspectExample {
	
	@Pointcut("execution(* struts2InAction.services.UserService.add(..))")
	public void doAccessCheck(){
		System.out.println("BeforeAspectExample 访问前检查");
	}
	
}
