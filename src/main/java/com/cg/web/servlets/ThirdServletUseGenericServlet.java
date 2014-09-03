package com.cg.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ThirdServletUseGenericServlet extends GenericServlet {
	private static final long serialVersionUID = 4735102061394526844L;

	@Override
	public void service(ServletRequest req, ServletResponse rsp) throws ServletException,
			IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) rsp;
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		if ("set".equals(method)) {
			String value = request.getParameter("value");
			session.setAttribute("value", value);
			out.write("set session value:" + value);
		} else if ("get".equals(method)) {
			String value = session.getAttribute("value").toString();
			out.write("session value:" + value);
		}
		out.write("<br>Hello, This is my 3rd servlet use generic servlet!");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("第三个Servlet Inited...");
		super.init();
	}
}
