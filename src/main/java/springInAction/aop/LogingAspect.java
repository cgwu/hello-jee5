package springInAction.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
// @Order整数越小,越先执行
public class LogingAspect {
	private static final Logger log = LoggerFactory.getLogger(LogingAspect.class);

	@Around("execution(* struts2InAction.services.*Service.*(..))")
	public Object logService(ProceedingJoinPoint pjp) throws Throwable {
		log.info("开始");
		Object retVal = null;
		Object[] args = pjp.getArgs();
		if (args != null && args.length > 0 && "五五".equals(args[0])) {
			retVal = "伍伍";
		} else {
			retVal = pjp.proceed();
		}
		// Object retVal = pjp.proceed();
		log.info("结束");
		return "[Logging开始]" + retVal + "[Logging结束]";
	}

}
