package com.orion10110.training.managertaxi.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orion10110.taximanager.datamodel.Street;
import com.orion10110.taximanager.datamodel.TypeCar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class StreetServiceTest {
	@Inject
	private StreetService streetServices;

	@Test
	public void saveStreetTest() {
		Street street = new Street();
		street.setName("test name");
		street.setIdDistrict(1l);
		Long id = streetServices.save(street);
		
		Assert.assertNotNull(id);

		Street streetFromDb = streetServices.get(id);

		Assert.assertEquals(street.getName(), streetFromDb.getName());
	}
}
