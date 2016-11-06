package com.orion10110.training.managertaxi.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Random;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orion10110.taximanager.datamodel.District;
import com.orion10110.taximanager.datamodel.Street;

public class DistrictServiceTest extends CrudTest<District> {
	@Inject
	private DistrictService districtServices;

	@Override
	public void delete(District testObject) {
		districtServices.delete(testObject.getId());
	}

	@Override
	public District select(Long id) {
		return districtServices.get(id);
	}

	@Override
	public void update(District testObject) {
		districtServices.save(testObject);		
	}

	@Override
	public void insert(District testObject) {
		districtServices.save(testObject);		
	}

	@Override
	public void changeTestObject(District testObject) {
		Random random = new Random();
		testObject.setName(random.nextInt()+"");
	}
	
	@Override
	public void compare(District selected, District testObject) {
		assertNotNull("selected is null", selected);
		assertEquals(selected.getName(), testObject.getName());
	}

	@Autowired
	public void setDistrict(District district) {
		setTestObject(district);
	}
	
	
}
