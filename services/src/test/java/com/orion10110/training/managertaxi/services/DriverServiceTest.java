package com.orion10110.training.managertaxi.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.orion10110.taximanager.datamodel.Car;
import com.orion10110.taximanager.datamodel.District;
import com.orion10110.taximanager.datamodel.Driver;

public class DriverServiceTest extends CrudTest<Driver> {
	@Inject
	private DriverService driverServices;

	@Inject
	private CarService carServices;

	@Inject
	private DistrictService districtServices;

	
	@Override
	public void delete(Driver testObject) {
		driverServices.delete(testObject.getId());
	}

	@Override
	public Driver select(Long id) {
		return driverServices.get(id);
	}

	@Override
	public void update(Driver testObject) {
		driverServices.save(testObject);
	}

	@Override
	public void insert(Driver testObject) {
		driverServices.save(testObject);
	}

	@Override
	public void changeTestObject(Driver testObject) {
		Random random = new Random();
		testObject.setSecondName(random.nextInt()+"");
		testObject.setFirstName(random.nextInt()+"");
		testObject.setPatronymic(random.nextInt()+"");
		testObject.setPhoneNumber(random.nextInt()+"");
		LocalDateTime timeBirth = LocalDateTime.of(1990, 10, 12, 23, 33, 10);
		Timestamp timestampBirth = Timestamp.valueOf(timeBirth);
		testObject.setDateOfBirth(timestampBirth);
		LocalDateTime timeEmploye = LocalDateTime.of(2015, 10, 12, 23, 33, 10);
		Timestamp timestampEmploye = Timestamp.valueOf(timeEmploye);
		testObject.setDateOfEmployment(timestampEmploye);
		testObject.setCategory(random.nextInt());
	}

	@Override
	public void compare(Driver selected, Driver testObject) {
		assertNotNull("selected is null", selected);
		assertEquals(selected.getSecondName(),testObject.getSecondName());
		assertEquals(selected.getFirstName(), testObject.getFirstName());
		assertEquals(selected.getPatronymic(), testObject.getPatronymic());
		assertEquals(selected.getPhoneNumber(), testObject.getPhoneNumber());
		assertEquals(selected.getIdCar(), testObject.getIdCar());
		assertEquals(selected.getIdDistrict(), testObject.getIdDistrict());
		assertEquals(selected.getDateOfBirth(), testObject.getDateOfBirth());
		assertEquals(selected.getDateOfEmployment(), testObject.getDateOfEmployment());
		assertEquals(selected.getCategory(), testObject.getCategory());
	}

	@Autowired
	public void setDriver(Driver driver) {
		setTestObject(driver);
	}
	
}