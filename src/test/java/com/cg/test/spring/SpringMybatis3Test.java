package com.cg.test.spring;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.mybatis3.dao.UserMyBatis3Service;

public class SpringMybatis3Test extends TestConfig {

private static final Logger log = LoggerFactory.getLogger(SpringMybatis3Test.class);
	
	@Autowired
	private UserMyBatis3Service userMyBatis3Service;
	
	@Test
	public void testUserMyBatis3Service() {
		System.out.println("-----------------------");
		userMyBatis3Service.showCount();
		System.out.println("-----------------------");
		userMyBatis3Service.listUsers();
		System.out.println("-----------------------");
		userMyBatis3Service.showUser();
		System.out.println("-----------------------");
	}
}
