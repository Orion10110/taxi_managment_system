package com.orion10110.training.managertaxi.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class st {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(st.class);
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("service-context.xml");

		String[] beanDefinitionNames = springContext.getBeanDefinitionNames();
		for (String beanName : beanDefinitionNames) {
			System.out.println(beanName);
		}
		
		LOGGER.error("test error");
		LOGGER.debug("debug st");
		
	}

}
