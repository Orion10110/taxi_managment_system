package com.orion10110.training.managertaxi.daodb.impl;

import org.apache.commons.dbcp.ConnectionFactory;

import com.orion10110.taximanager.datamodel.Car;
import com.orion10110.training.managertaxi.daodb.util.GenerateSql;

public class st {

	public static void main(String[] args) {
		// ClassPathXmlApplicationContext springContext = new
		// ClassPathXmlApplicationContext("service-context.xml");
		//
		// String[] beanDefinitionNames =
		// springContext.getBeanDefinitionNames();
		// for (String beanName : beanDefinitionNames) {
		// System.out.println(beanName);
		// }
		
		System.out.println(GenerateSql.generateSqlInsert(Car.class));

		System.out.println(GenerateSql.generateSqlGetId(Car.class));

		System.out.println(GenerateSql.generateSqlUpdate(Car.class));

		System.out.println(GenerateSql.generateSqlSelect(Car.class));

		System.out.println(GenerateSql.generateSqlDelete(Car.class));
		
	}

}
