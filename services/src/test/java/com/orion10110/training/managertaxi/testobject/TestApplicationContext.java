package com.orion10110.training.managertaxi.testobject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.taximanager.datamodel.District;
import com.orion10110.taximanager.datamodel.Street;
import com.orion10110.taximanager.datamodel.TypeCar;

@Configuration
public class TestApplicationContext {
	@Bean
	public TypeCar typeCar() {
		TypeCar type = new TypeCar();
		type.setType("TypeTest");
		return type;
	}
	@Bean
	public Brand brand(){
		Brand br = new Brand();
		br.setName("TestBrandName");
		return br;
	}
	
	@Bean
	public Street street(){
		Street st = new Street();
		st.setName("TestStreetName");
		return st;
	}
	
	@Bean
	public District district(){
		District ds = new District();
		ds.setName("TestDistrictName");
		return ds;
	}

}
