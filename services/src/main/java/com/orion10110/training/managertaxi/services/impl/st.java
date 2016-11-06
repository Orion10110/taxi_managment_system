package com.orion10110.training.managertaxi.services.impl;


import javax.inject.Inject;

import com.orion10110.taximanager.datamodel.TypeCar;
import com.orion10110.training.managertaxi.daodb.OrderDao;

public class st {
	@Inject
	private static OrderDao orderDao;
	
	public static void main(String[] args) {
//		ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("service-context.xml");
//
//        String[] beanDefinitionNames = springContext.getBeanDefinitionNames();
//        for (String beanName : beanDefinitionNames) {
//            System.out.println(beanName);
//        }
//      
	TypeCar typecar = new TypeCar();
	TypeCar typecarT = new TypeCar();
	typecar.setType("AS");
	System.out.println(typecar);
	
	System.out.println(typecarT);
	}

	
	
}
