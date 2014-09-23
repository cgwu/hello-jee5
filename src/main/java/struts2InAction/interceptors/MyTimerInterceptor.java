package struts2InAction.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyTimerInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 859956045352775660L;
	private static final Logger log = LoggerFactory.getLogger(MyTimerInterceptor.class);

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		long startTime = System.currentTimeMillis();
		String result = invocation.invoke();
		long executionTime = System.currentTimeMillis() - startTime;
		log.trace("执行Action时间: {} 毫秒", executionTime);
		return result;
	}

}
