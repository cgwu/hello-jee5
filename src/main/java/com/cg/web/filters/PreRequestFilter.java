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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.LocaleResolver;

/**
 * @author spark
 * 1.增加响应头不缓存设置
 * 2.设置Spring国际化的LocalResolver
 */
public class PreRequestFilter implements Filter {
	
	@Autowired
	private LocaleResolver localeResolver;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain chain)
			throws IOException, ServletException {
//		HttpServletRequest httpRequest = (HttpServletRequest) req;
		HttpServletResponse httpResponse = (HttpServletResponse) rsp;
		
		addNoCacheHeader(httpResponse);
		// Spring LocalResolver
		req.setAttribute(DispatcherServlet.LOCALE_RESOLVER_ATTRIBUTE,localeResolver);
		
		chain.doFilter(req, rsp);
	}

	private void addNoCacheHeader(HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");
		
		response.setHeader("Server", "CgServer1.0");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public void destroy() {

	}
}
