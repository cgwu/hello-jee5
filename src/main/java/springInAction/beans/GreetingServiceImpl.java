package springInAction.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

public class GreetingServiceImpl implements GreetingService, InitializingBean, BeanNameAware {
	private String greeting;
	private String springBeanName;

	public void init() {
		System.out.println("GreetingServiceImpl init()");
	}

	public void cleanup() {
		System.out.println("GreetingServiceImpl cleanup()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("GreetingServiceImpl afterPropertiesSet()");
	}

	@Override
	public void sayGreeting() {
		System.out.println(greeting + "@SpringBeanName[" + this.springBeanName + "]");
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public void setBeanName(String name) {
		springBeanName = name;
	}

}
