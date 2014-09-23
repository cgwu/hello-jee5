package springInAction.tests;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springInAction.beans.ClientService;
import springInAction.beans.GreetingService;
import struts2InAction.services.UserService;

public class GreetingServiceTest {

	@SuppressWarnings("resource")
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext.xml",
				"classpath:springInAction/hello.xml");
		GreetingService service = ctx.getBean("nameGreetingService2", GreetingService.class);
		service.sayGreeting();

		System.out.println("----------------");
		
		ClientService client = ctx.getBean("clientService", ClientService.class);
		System.out.println(client);

		client = ctx.getBean("clientService", ClientService.class);
		System.out.println(client);
		
		System.out.println("----------------");
		UserService userService = ctx.getBean("userService",UserService.class);
		userService.Add("张三");
		
		System.out.println("----------------");

		BasicDataSource dataSource = ctx.getBean("dataSource",BasicDataSource.class);
		System.out.println(dataSource.getDriverClassName());
		System.out.println(dataSource.getUsername());
		System.out.println(dataSource.getPassword());
		
	}

}
