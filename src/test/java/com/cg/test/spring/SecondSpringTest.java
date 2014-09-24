package com.cg.test.spring;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;

import struts2InAction.services.UserService;

public class SecondSpringTest extends TestConfig {
	private static final Logger log = LoggerFactory.getLogger(SecondSpringTest.class);
	
	@Autowired
	private UserService userService;
	
	@Repeat(5)
	@Test
	public void testUserService() {
		log.info(userService.sayHi("五五"));
		System.out.println("------------------");
	}
}
