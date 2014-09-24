package com.cg.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import struts2InAction.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
@WebAppConfiguration
public class TestConfig extends AbstractJUnit4SpringContextTests {

//	private static final Logger log = LoggerFactory.getLogger(TestConfig.class);
	
	@Autowired
	protected WebApplicationContext wac;
	
	/*
	@Autowired
	private UserService userService;
	
	@Test
	public void testUserService(){
		log.info(userService.sayHi("赵xx"));
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	*/
}
