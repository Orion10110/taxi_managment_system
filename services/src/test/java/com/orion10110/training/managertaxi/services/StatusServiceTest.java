package com.orion10110.training.managertaxi.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orion10110.taximanager.datamodel.District;
import com.orion10110.taximanager.datamodel.Status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class StatusServiceTest {
	@Inject
	private StatusService statusServices;

	@Test
	public void saveStatusTest() {
		Status status = new Status();
		status.setStatus("test Status");
		Long id =statusServices.save(status);

		Assert.assertNotNull(id);

		Status statusFromDb = statusServices.get(id);

		Assert.assertEquals(status.getStatus(), statusFromDb.getStatus());
	}
}

