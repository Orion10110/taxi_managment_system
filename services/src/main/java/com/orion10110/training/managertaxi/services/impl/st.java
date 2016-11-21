package com.orion10110.training.managertaxi.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

			System.out.println(bs.get(10l));

			System.out.println(bs.get(10l));
			System.out.println(tc.get(10l));
		
		LOGGER.error("errrror");
//		UpdateFieldsReflectuin<Brand> refl = new UpdateFieldsReflectuin<Brand>();
//		Brand brand = new Brand();
//		Brand br2 = new Brand();
//		brand.setId(4l);
//		brand.setName("BMW");
//		refl.UpdateFields(brand, br2);
//		System.out.println(String.format("id=%s type=%s", brand.getId(),brand.getName()));
//
//		System.out.println(String.format("id=%s type=%s", br2.getId(),br2.getName()));
	}

}
