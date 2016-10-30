package com.orion10110.training.managertaxi.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orion10110.taximanager.datamodel.Discount;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class DiscountServiceTest {
	@Inject
	private DiscountService discountServices;

	@Test
	public void saveDiscountTest() {
		Discount discount = new Discount();
		discount.setName("test name");
		discount.setDiscountPercent(10);
		Long id = discountServices.save(discount);

		Assert.assertNotNull(id);

		Discount discountFromDb = discountServices.get(id);

		Assert.assertEquals(discount.getName(), discountFromDb.getName());
	}
}
