package com.orion10110.training.managertaxi.daoxml.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class st {

	public static void main(String[] args) {
		 ClassPathXmlApplicationContext springContext = new
		 ClassPathXmlApplicationContext("service-context.xml");
		
		 String[] beanDefinitionNames =
		 springContext.getBeanDefinitionNames();
		 for (String beanName : beanDefinitionNames) {
		 System.out.println(beanName);
	 }
//		UpdateFieldsReflectuin<Brand> refl = new UpdateFieldsReflectuin<Brand>();
//		Brand brand = new Brand();
//		refl.UpdateFields(brand, brand);
		
	}

}
