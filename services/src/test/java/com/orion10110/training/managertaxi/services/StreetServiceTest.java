package com.orion10110.training.managertaxi.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Random;

import javax.inject.Inject;

import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;

import com.orion10110.taximanager.datamodel.District;
import com.orion10110.taximanager.datamodel.Street;

public class StreetServiceTest extends CrudTest<Street> {
	@Inject
	private StreetService streetService;

	@Inject
	private DistrictService districtService;

	@Override
	public void delete(Street testObject) {
		streetService.delete(testObject.getId());

	}

	@Override
	public Street select(Long id) {
		return streetService.get(id);
	}

	@Override
	public void update(Street testObject) {
		streetService.save(testObject);
	}

	@Override
	public void insert(Street testObject) {
		streetService.save(testObject);
	}

	@Override
	public void changeTestObject(Street testObject) {
		Random random = new Random();
		testObject.setName(random.nextInt() + "");
	}

	@Override
	public void compare(Street selected, Street testObject) {
		assertNotNull("selected is null", selected);
		assertEquals(selected.getName(), testObject.getName());
		assertEquals(selected.getIdDistrict(), testObject.getIdDistrict());
	}

	@Autowired
	public void setStret(District district, Street street) {
		Long districtId = districtService.save(district);
		street.setIdDistrict(districtId);
		setTestObject(street);
	}


}
