package com.orion10110.training.managertaxi.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orion10110.taximanager.datamodel.Brand;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class BrandServiceTest {
	@Inject
	private BrandService brandServices;

	@Test
	public void saveBrandTest() {
		Brand brand = new Brand();
		brand.setName("test name");
		Long id = brandServices.save(brand);

		Assert.assertNotNull(id);

		Brand brandFromDb = brandServices.get(id);

		Assert.assertEquals(brand.getName(), brandFromDb.getName());
	}
}
