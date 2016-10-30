package com.orion10110.training.managertaxi.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orion10110.taximanager.datamodel.District;
import com.orion10110.taximanager.datamodel.Street;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class DistrictServiceTest {
	@Inject
	private DistrictService districtServices;

	@Test
	public void saveDistrictTest() {
		District district = new District();
		district.setName("test name");
		Long id = districtServices.save(district);

		Assert.assertNotNull(id);

		District districtFromDb = districtServices.get(id);

		Assert.assertEquals(district.getName(), districtFromDb.getName());
	}
}
