package com.orion10110.training.managertaxi.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.taximanager.datamodel.Car;

public class CarServiceTest extends CrudTest<Car> {
	@Inject
	private CarService carServices;

	@Override
	public void delete(Car testObject) {
		carServices.delete(testObject.getId());
	}

	@Override
	public Car select(Long id) {
		return carServices.get(id);
	}

	@Override
	public void update(Car testObject) {
		carServices.save(testObject);
	}

	@Override
	public void insert(Car testObject) {
		carServices.save(testObject);
	}

	@Override
	public void changeTestObject(Car testObject) {
		Car cr = context.getBean(Car.class);
		testObject.setName(cr.getName());
		testObject.setPlace(cr.getPlace());
		testObject.setStars(cr.getStars());
		testObject.setActive(cr.getActive());
		testObject.setGosNumber(cr.getGosNumber());

	}

	@Override
	public void compare(Car selected, Car testObject) {
		assertNotNull("selected is null", selected);
		assertEquals(selected.getName(), testObject.getName());
		assertEquals(selected.getIdBrand(), testObject.getIdBrand());
		assertEquals(selected.getIdType(), testObject.getIdType());
		assertEquals(selected.getPlace(), testObject.getPlace());
		assertEquals(selected.getStars(), testObject.getStars());
		assertEquals(selected.getActive(), testObject.getActive());
		assertEquals(selected.getGosNumber(), testObject.getGosNumber());
	}

	@Autowired
	public void setCar(Car car) {
		setTestObject(car);
	}

	@Override
	protected void saveAll(List<Car> testObject) {
		carServices.saveAll(testObject);
	}

}
