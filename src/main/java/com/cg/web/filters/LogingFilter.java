package com.cg.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogingFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("LogingFilter init");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LogingFilter.doFilter");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) rsp;
		String url = request.getRequestURI();
		if (!url.endsWith(".jsp")) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("暂时无法访问servlet,但可以访问jsp!");
		} else {
			chain.doFilter(request, response);
			System.out.println("## Filter过后的代码 ##");
			response.setHeader("Server", "MyServer 1.0");
		}
	}

	@Override
	public void destroy() {
		System.out.println("LogingFilter destroy");
	}
}
