package springInAction.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)	// 整数越小,越先执行
public class AroundAspectExample {

	@Around("execution(* struts2InAction.services.*Service.*(..))")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("AroundAspectExample [开始]");
		Object[] args = pjp.getArgs();
		if (args != null && args.length > 0) {
			System.out.println("Around args:" + Arrays.toString(args));
			if ("张三".equals(args[0])) {
				System.out.println("名字是张三,直接返回");
				return null;
			}
		}
		Object retVal = pjp.proceed();
		System.out.println("AroundAspectExample [结束]");
		return retVal;
	}

}
