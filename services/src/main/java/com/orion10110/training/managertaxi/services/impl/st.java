package com.orion10110.training.managertaxi.services.impl;

import java.security.Provider.Service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class st {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("service-context.xml");

        String[] beanDefinitionNames = springContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }

       

	}

}
