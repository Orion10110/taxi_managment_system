package com.orion10110.training.managertaxi.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.orion10110.taximanager.datamodel.TypeCar;

public class TypeCarServiceTest extends CrudTest<TypeCar> {
	@Inject
	private TypeCarService typeCarServices;

	@Override
	public void delete(TypeCar testObject) {
		typeCarServices.delete(testObject.getId());
	}

	@Override
	public TypeCar select(Long id) {
		return typeCarServices.get(id);
	}

	@Override
	public void update(TypeCar testObject) {
		typeCarServices.save(testObject);

	}

	@Override
	public void insert(TypeCar testObject) {
		typeCarServices.save(testObject);
	}

	@Override
	public void changeTestObject(TypeCar testObject) {
		Random random = new Random();
		testObject.setType(random.nextLong() + "");

	}
	
	@Override
	public void compare(TypeCar selected, TypeCar testObject) {
        assertNotNull("selected is null", selected);
        assertEquals(selected.getType(), testObject.getType());
       
    }

	@Autowired
	public void setTypeCar(TypeCar typeCar) {
		setTestObject(typeCar);
	}
}
