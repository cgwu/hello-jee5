package com.cg.web.listeners;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionListener implements HttpSessionListener, ServletContextListener {
	private static final Logger log = LoggerFactory.getLogger( SessionListener.class );
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("contextInitialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed");
	}

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		String id = event.getSession().getId();
		//保存开始时间，用于测试
		event.getSession().setAttribute("startTime", new Date());
		log.trace("sessionCreated:", id);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		String id = event.getSession().getId();
		System.out.println("sessionDestroyed:" + id);
	}
}
