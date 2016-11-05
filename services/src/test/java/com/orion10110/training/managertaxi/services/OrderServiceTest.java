package com.orion10110.training.managertaxi.services;

import java.time.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orion10110.taximanager.datamodel.Driver;
import com.orion10110.taximanager.datamodel.Order;
import com.orion10110.training.managertaxi.daodb.OrderDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class OrderServiceTest {
	@Inject
	private OrderService orderServices;

	@Test
	public void saveOrderTest() throws ParseException {
		Order order = new Order();
		LocalDateTime loc = LocalDateTime.of(2000, 10, 12, 23, 33, 10);
		Timestamp timestamp = Timestamp.valueOf(loc);
		order.setDateOrder(timestamp);
		order.setEndValue(200);
		order.setStartValue(100);
		order.setIdApplicationUser(2l);
		order.setIdClient(2l);
		order.setIdDriver(2l);
		order.setIdStatus(2l);
		order.setIdStreetFrom(2l);
		order.setIdStreetTo(2l);
		order.setPhoneNumber("10-10-10");
		Long id = orderServices.save(order);
		Assert.assertNotNull(id);
		Order orderFromDb = orderServices.get(id);
		Assert.assertEquals(order.getDateOrder(), orderFromDb.getDateOrder());
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