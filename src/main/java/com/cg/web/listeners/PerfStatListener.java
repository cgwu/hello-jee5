package com.cg.web.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class PerfStatListener implements ServletRequestListener {

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
		String url = request.getRequestURI();
		System.out.println("PerfStat.requestInitialized():" + url);
		event.getServletContext().setAttribute("start", System.nanoTime());
	}

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
		String url = request.getRequestURI();
		
		ServletContext ctx = event.getServletContext();
		Long start = (Long) ctx.getAttribute("start");
		Long duration = System.nanoTime() - start;

		System.out.format("PerfStat.requestDestroyed(); url:[%s],duration:[%d]微秒\n", url, duration/1000);
	}

}
