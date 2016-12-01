package com.orion10110.training.managertaxi.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.training.managertaxi.services.BrandService;
import com.orion10110.training.managertaxi.services.TypeCarService;

public class st {

	private static final Logger LOGGER = LoggerFactory.getLogger(st.class);

	public static void main(String[] args) {
		ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("service-context.xml");

		String[] beanDefinitionNames = springContext.getBeanDefinitionNames();
		for (String beanName : beanDefinitionNames) {
			System.out.println(beanName);
		}

		BrandService bs = springContext.getBean(BrandService.class);
		TypeCarService tc = springContext.getBean(TypeCarService.class);
		bs.getAll();
		System.out.println(1);
		bs.getAll();
		System.out.println(1);
		System.out.println(bs.get(10l));

		System.out.println();
		System.out.println();
		System.out.println("<---------------------------------------->");
		List<Brand> brands = bs.getAll();
		for (Brand brand : brands) {
			System.out.println(brand);
		}
		
	}

}
