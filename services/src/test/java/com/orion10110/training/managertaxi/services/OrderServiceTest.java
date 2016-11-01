package com.orion10110.training.managertaxi.services;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orion10110.taximanager.datamodel.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class OrderServiceTest {
	@Inject
	private OrderService orderService;

	@Test
	public void saveOrderTest() {
		Order order = new Order();
		order.setDateOrder(new Date("03/10/2016"));
		order.setEndValue(200);
		order.setStartValue(100);
		order.setIdApplicationUser(2l);
		order.setIdClient(2l);
		order.setIdDriver(2l);
		order.setIdStatus(2l);
		order.setIdStreetFrom(2l);
		order.setIdStreetTo(2l);
		order.setPhoneNumber("10-10-10");
		Long id = orderService.save(order);

		Assert.assertNotNull(id);

		Order orderFromDb = orderService.get(id);

		Assert.assertEquals(DateUtils.truncate(order.getDateOrder(),Calendar.SECOND), DateUtils.truncate(orderFromDb.getDateOrder(),Calendar.SECOND));
		Assert.assertEquals(order.getEndValue(), orderFromDb.getEndValue());
		Assert.assertEquals(order.getStartValue(), orderFromDb.getStartValue());
		Assert.assertEquals(order.getIdApplicationUser(), orderFromDb.getIdApplicationUser());
		Assert.assertEquals(order.getIdClient(), orderFromDb.getIdClient());
		Assert.assertEquals(order.getIdDriver(), orderFromDb.getIdDriver());
		Assert.assertEquals(order.getIdStatus(), orderFromDb.getIdStatus());
		Assert.assertEquals(order.getIdStreetFrom(), orderFromDb.getIdStreetFrom());
		Assert.assertEquals(order.getIdStreetTo(), orderFromDb.getIdStreetTo());
		Assert.assertEquals(order.getPhoneNumber(), orderFromDb.getPhoneNumber());
		
		
		
		
	}
}