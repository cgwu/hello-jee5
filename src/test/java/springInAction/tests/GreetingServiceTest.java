package springInAction.tests;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springInAction.beans.GreetingService;

public class GreetingServiceTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:springInAction/hello.xml");
		GreetingService service = ctx.getBean("greetingService", GreetingService.class);
		service.sayGreeting();

	}

}
