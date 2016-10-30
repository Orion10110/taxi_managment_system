package com.orion10110.training.managertaxi.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orion10110.taximanager.datamodel.Car;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class CarServiceTest {
	@Inject
	private CarService carServices;

	@Test
	public void saveClientTest() {
		Car car = new Car();
		car.setName("NameS");
		car.setIdBrand(1l);
		car.setIdType(1l);
		car.setPlace(5);
		car.setStars(6);
		car.setActive(true);
		car.setGosNumber("LO10101");
		Long id = carServices.save(car);

		Assert.assertNotNull(id);

		Car carFromDb = carServices.get(id);

		Assert.assertEquals(car.getName(), carFromDb.getName());
		Assert.assertEquals(car.getIdBrand(), carFromDb.getIdBrand());
		Assert.assertEquals(car.getIdType(), carFromDb.getIdType());
		Assert.assertEquals(car.getPlace(), carFromDb.getPlace());
		Assert.assertEquals(car.getStars(), carFromDb.getStars());
		Assert.assertEquals(car.getActive(), carFromDb.getActive());
		Assert.assertEquals(car.getGosNumber(), carFromDb.getGosNumber());
	}
}
