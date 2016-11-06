package com.orion10110.training.managertaxi.services.impl;

import javax.inject.Inject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.orion10110.taximanager.datamodel.TypeCar;
import com.orion10110.training.managertaxi.services.TypeCarService;

public class st {
	@Inject
	private static TypeCarService tp;

	public static void main(String[] args) {
		ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("service-context.xml");

		String[] beanDefinitionNames = springContext.getBeanDefinitionNames();
		for (String beanName : beanDefinitionNames) {
			System.out.println(beanName);
		}
		TypeCar tc =new TypeCar();
		tc.setType(23+"");
		tp.save(tc);
	}
	
	

}
