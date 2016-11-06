package com.orion10110.training.managertaxi.services;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orion10110.taximanager.datamodel.Driver;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class DriverServiceTest {
	@Inject
	private DriverService driverServices;

	
	@Test
	public void saveDriverTest() {
		Driver driver = new Driver();
		driver.setSecondName("NameS");
		driver.setFirstName("NameF");
		driver.setPatronymic("patronymic");
		driver.setPhoneNumber("90-90-90");
		driver.setIdCar(10l);
		driver.setIdDistrict(1l);
		driver.setDateOfBirth(new Date("10/10/2009"));
		driver.setDateOfEmployment(new Date("10/10/2009"));
		driver.setCategory(5);
		Long id = driverServices.save(driver);

		Assert.assertNotNull(id);

		Driver driverFromDb = driverServices.get(id);

		Assert.assertEquals(driver.getSecondName(), driverFromDb.getSecondName());
		Assert.assertEquals(driver.getFirstName(), driverFromDb.getFirstName());
		Assert.assertEquals(driver.getPatronymic(), driverFromDb.getPatronymic());
		Assert.assertEquals(driver.getPhoneNumber(), driverFromDb.getPhoneNumber());
		Assert.assertEquals(driver.getIdCar(), driverFromDb.getIdCar());
		Assert.assertEquals(driver.getIdDistrict(), driverFromDb.getIdDistrict());
		Assert.assertEquals(driver.getDateOfBirth(), driverFromDb.getDateOfBirth());
		Assert.assertEquals(driver.getDateOfEmployment(), driverFromDb.getDateOfEmployment());
		Assert.assertEquals(driver.getCategory(), driverFromDb.getCategory());
		
		
		

	}
}