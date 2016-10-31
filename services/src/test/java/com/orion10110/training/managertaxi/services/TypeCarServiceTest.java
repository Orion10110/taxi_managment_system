package com.orion10110.training.managertaxi.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orion10110.taximanager.datamodel.TypeCar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class TypeCarServiceTest {
	@Inject
	private TypeCarService typeCarServices;

	

	@Test
	public void createTypeTest() {
		TypeCar typeCar = new TypeCar();
		typeCar.setType("test type");

		Long id = typeCarServices.save(typeCar);

		Assert.assertNotNull(id);

		TypeCar typeCarFromDb = typeCarServices.get(id);

		Assert.assertEquals(typeCar.getType(), typeCarFromDb.getType());
	}
	
	@Test
	public void updateTypeTest() {
		

		TypeCar typeCar = typeCarServices.get(2l);
		typeCar.setType("внедарожник");
		Long id = typeCarServices.save(typeCar);
		TypeCar typeCarFromDb = typeCarServices.get(2l);
		Assert.assertEquals(typeCar.getType(), typeCarFromDb.getType());
	}
	
}
