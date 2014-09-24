package com.cg.test.spring;

import java.util.Date;

import org.hibernate.tutorial.domain.Event;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.test.annotation.Repeat;

public class SpringHibernate3Test extends TestConfig {
	private static final Logger log = LoggerFactory.getLogger(SpringHibernate3Test.class);

	@Autowired
	private LocalSessionFactoryBean sessionFactory;

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	private static int cnt = 0;

	@Repeat(10)
	@Test
	public void testSessionFactory() {
		Event theEvent = new Event();
		theEvent.setTitle("这是事件标题" + cnt++);
		theEvent.setDate(new Date());
		hibernateTemplate.save(theEvent);
		System.out.println("------------------");
	}
	
}

