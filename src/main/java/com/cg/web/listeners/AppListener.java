package com.cg.web.listeners;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Servlet Context 停止!");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		System.out.println("Servlet Context 启动!");
		
		Map<String,String> countries = new HashMap<String,String>();
		countries.put("ca", "Cananda");
		countries.put("us", "United States");
		countries.put("cn", "中国");
		ctx.setAttribute("countries", countries);
	}

}
