package com.cg.web.servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.LocaleResolver;

public class SetLocaleServlet extends HttpServlet {
	private static final long serialVersionUID = 8416820892345347674L;
	private static final Log logger = LogFactory.getLog(SetLocaleServlet.class);
	
	private static final String PARAM_TYPE = "type";
	private static final String PARAM_RETURN_URL = "returnUrl";
	private static final String DEFAULT_PARAM_NAME = "locale";
	private String paramName;
	
	private Set<String> supportLocales;
	private static final String DEFAULT_LOCAL = "en";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	public void init() throws ServletException {
		this.paramName = getInitParameter("paramName");
		if (StringUtils.isEmpty(this.paramName)) {
			this.paramName = DEFAULT_PARAM_NAME;
		}
		if (logger.isInfoEnabled())
			logger.info("parameter name: " + this.paramName);
		
		//支持的语言集合
		String locales = getInitParameter("supportLocales");
		if(!StringUtils.isEmpty(locales)){
			String [] arrLocale = locales.split(",");
			supportLocales = new HashSet<String>();
			for (String locale : arrLocale) {
				supportLocales.add(StringUtils.trim(locale));
			}
		}
		this.getServletContext().setAttribute("supportLocales", supportLocales);
		if (logger.isInfoEnabled())
			logger.info("support locales: " + locales);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String strLocale = request.getParameter(this.paramName);
		if(!this.supportLocales.contains(strLocale)){
			strLocale = DEFAULT_LOCAL;
		}
		Locale locale = new Locale(strLocale);
		if (logger.isDebugEnabled()) {
			logger.debug("locale to be set: " + locale);
		}

		LocaleResolver resolver = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext())
				.getBean("localeResolver",LocaleResolver.class);
		resolver.setLocale(request, response, locale);
		
		String refUrl = request.getParameter(PARAM_RETURN_URL);
		if (!StringUtils.isEmpty(refUrl)) {
			response.sendRedirect(refUrl);
		} else {
			String type = request.getParameter(PARAM_TYPE);
			if ("json".equals(type))
				response.getWriter().write("{\"code\": 0, \"msg\": \"success\"}");
			else {
				response.getWriter().write("success");
			}
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "-1");
			response.flushBuffer();
		}
	}
}
