package springInAction.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
@Order(7)
public class BeforeAspectExample {

	@Before("execution(* struts2InAction.services.*Service.*(..)) && args(name,..)")
	public void doAccessCheck(String name) {
		System.out.println("BeforeAspectExample 访问前检查:" + name);
	}

}
