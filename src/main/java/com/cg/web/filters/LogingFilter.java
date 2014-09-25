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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.LocaleResolver;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

public class LogingFilter implements Filter {
	/* 方法一: 使用commons.logging */
//	private static final Log log = LogFactory.getLog(LogingFilter.class);
	/* 方法二: 使用slf4j(更好,参数支持{}格式化) */
	private static final Logger log = LoggerFactory.getLogger( LogingFilter.class );
	
	@Autowired
	private LocaleResolver localeResolver;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
//		System.out.println("LogingFilter init");
		log.info("LogingFilter init");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain chain)
			throws IOException, ServletException {
		
//		LocaleResolver resolver = WebApplicationContextUtils.getWebApplicationContext(req.get this.getServletContext()).getBean("localeResolver",LocaleResolver.class);
		req.setAttribute(DispatcherServlet.LOCALE_RESOLVER_ATTRIBUTE,localeResolver);
		
		System.out.println("LogingFilter.doFilter");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) rsp;
		String url = request.getRequestURI();
		log.info("开始请求(slf4j):{}", url);
//		if (!url.endsWith(".jsp")) {
//			response.setContentType("text/html;charset=utf-8");
//			response.getWriter().write("暂时无法访问servlet,但可以访问jsp!");
//		} else {
			chain.doFilter(request, response);
			System.out.println("## Filter过后的代码 ##");
			response.setHeader("Server", "MyServer 1.0");
//		}
	}

	@Override
	public void destroy() {
		System.out.println("LogingFilter destroy");
	}
}
