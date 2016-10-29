package com.orion10110.training.managertaxi.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orion10110.taximanager.datamodel.TypeCar;
import com.orion10110.training.managertaxi.services.TypeCarServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class TypeCarServicesTest {
	@Inject
	private TypeCarServices typeCarServices;

	@Test
	public void getByIdTest() {
		TypeCar typeCar = typeCarServices.get(1l);

		Assert.assertNotNull("typeCar for id=1 should not be null", typeCar);
		Assert.assertEquals(new Long(1), typeCar.getId());
	}

	@Test
	public void saveBrendTest() {
		TypeCar typeCar = new TypeCar();
		typeCar.setType("test type");

		Long id = typeCarServices.save(typeCar);

		Assert.assertNotNull(id);

		TypeCar typeCarFromDb = typeCarServices.get(id);

		Assert.assertEquals(typeCarFromDb.getType(), typeCarFromDb.getType());
	}
}
