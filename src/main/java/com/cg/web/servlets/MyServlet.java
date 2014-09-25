package com.cg.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String strLocale = request.getParameter("locale");
		Locale locale = new Locale(strLocale);
		/*
	  	Servlet中获得Spring容器，将LocaleResolver设为相应local
		灵感来源： http://stackoverflow.com/questions/16810886/spring-internationalization-how-to-dynamically-set-locale-value
		Able to change the locale using below 
		RequestContextUtils.getLocaleResolver(request).setLocale(request, response,  Locale.FRANCE);
		*/
//		RequestContextUtils.getLocaleResolver(request).setLocale(request, response,  Locale.CHINA);
		LocaleResolver resolver = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext()).getBean("localeResolver",LocaleResolver.class);
		resolver.setLocale(request, response, locale);
		
		out.println(strLocale);
		/*
		Cookie cookie = new Cookie("locale", "en");
		cookie.setPath("/");
		cookie.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(cookie);
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
