package com.cg.web.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServletUseInterface implements Servlet {

	private transient ServletConfig servletConfig;

	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return this.servletConfig;
	}

	@Override
	public String getServletInfo() {
		return "My Second Servlet Info";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.servletConfig = config;
		System.out.println("第二个Servlet inited...");
	}

	@Override
	public void service(ServletRequest req, ServletResponse rsp) throws ServletException,
			IOException {
		ServletConfig cfg = getServletConfig();
		String admin = cfg.getInitParameter("admin");
		String email = cfg.getInitParameter("email");
		rsp.setContentType("text/html");
		rsp.getWriter().write(
				"<html><body>email:" + email + "<br>admin:" + admin + "</body></html>");

	}

}
