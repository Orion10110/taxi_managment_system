package com.orion10110.training.managertaxi.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orion10110.taximanager.datamodel.District;
import com.orion10110.taximanager.datamodel.Status;
import com.orion10110.taximanager.datamodel.TypeCar;

public class StatusServiceTest extends CrudTest<Status> {
	@Inject
	private StatusService statusServices;

	@Override
	public void delete(Status testObject) {
		statusServices.delete(testObject.getId());
	}

	@Override
	public Status select(Long id) {
		return statusServices.get(id);
	}

	@Override
	public void update(Status testObject) {
		statusServices.save(testObject);
	}

	@Override
	public void insert(Status testObject) {
		statusServices.save(testObject);
	}

	@Override
	public void changeTestObject(Status testObject) {
		Random random = new Random();
		testObject.setStatus(random.nextInt() + "");
	}

	@Override
	public void compare(Status selected, Status testObject) {
		assertNotNull("selected is null", selected);
		assertEquals(selected.getStatus(), testObject.getStatus());

	}

	@Autowired
	public void setStatus(Status status) {
		setTestObject(status);
	}

	@Override
	protected void saveAll(List<Status> testObject) {
		statusServices.saveAll(testObject);
	}

}
