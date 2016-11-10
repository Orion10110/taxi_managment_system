package com.orion10110.training.managertaxi.services;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.orion10110.taximanager.datamodel.Brand;

public class BrandServiceTest extends CrudTest<Brand> {
	@Inject
	private BrandService brandService;

	@Override
	public void delete(Brand testObject) {
		brandService.delete(testObject.getId());
	}

	@Override
	public Brand select(Long id) {
		return brandService.get(id);
	}

	@Override
	public void update(Brand testObject) {
		brandService.save(testObject);
	}

	@Override
	public void insert(Brand testObject) {
		brandService.save(testObject);
	}

	@Override
	public void changeTestObject(Brand testObject) {
		Random random = new Random();
		testObject.setName(random.nextLong() + "");
	}

	@Override
	public void compare(Brand selected, Brand testObject) {
		assertNotNull("selected is null", selected);
		Assert.assertEquals(selected.getName(), testObject.getName());

	}

	@Autowired
	public void setBrand(Brand brand) {
		setTestObject(brand);
	}

	@Override
	protected void saveAll(List<Brand> testObject) {
		brandService.saveAll(testObject);
	}
}
