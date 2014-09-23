package com.cg.support.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

public class ActionBeanNameGenerator implements BeanNameGenerator {
	private static final Log logger = LogFactory.getLog(ActionBeanNameGenerator.class);

	public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
		String fullName = definition.getBeanClassName();

		String beanName = generateBeanName(fullName);
		if (logger.isTraceEnabled()) {
			logger.trace("generate bean name: " + beanName);
		}
		return beanName;
	}

	/*
	 * springInAction.actions.system.AdminLoginAction
	 * =>
	 * system.adminLoginAction
	 * */
	public String generateBeanName(String fullName) {
		int index = fullName.lastIndexOf('.');

		String packageName = fullName.substring(0, index);
		String className = fullName.substring(index + 1);

		String prefix = packageName.substring(packageName.lastIndexOf('.') + 1);
		String actionName = Character.toLowerCase(className.charAt(0)) + className.substring(1);

		return String.format("%s.%s", new Object[] { prefix, actionName });
	}
}