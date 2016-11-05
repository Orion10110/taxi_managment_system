package com.orion10110.training.managertaxi.services;

import java.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orion10110.taximanager.datamodel.Order;
import com.orion10110.training.managertaxi.daodb.OrderDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class OrderServiceTest {
	@Inject
	private OrderService orderService;

	@Inject
	private OrderDao orderDao;
	
	@Test
	public void saveOrderTest() throws ParseException {
//		Order order = new Order();
//		order.setDateOrder(new Date("03/10/2016"));
//		order.setEndValue(200);
//		order.setStartValue(100);
//		order.setIdApplicationUser(2l);
//		order.setIdClient(2l);
//		order.setIdDriver(2l);
//		order.setIdStatus(2l);
//		order.setIdStreetFrom(2l);
//		order.setIdStreetTo(2l);
//		order.setPhoneNumber("10-10-10");
//		Long id = orderService.save(order);
//
//		Assert.assertNotNull(id);
//
//		Order orderFromDb = orderService.get(id);
//
//		Assert.assertEquals(DateUtils.truncate(order.getDateOrder(),Calendar.SECOND), DateUtils.truncate(orderFromDb.getDateOrder(),Calendar.SECOND));
//		Assert.assertEquals(order.getEndValue(), orderFromDb.getEndValue());
//		Assert.assertEquals(order.getStartValue(), orderFromDb.getStartValue());
//		Assert.assertEquals(order.getIdApplicationUser(), orderFromDb.getIdApplicationUser());
//		Assert.assertEquals(order.getIdClient(), orderFromDb.getIdClient());
//		Assert.assertEquals(order.getIdDriver(), orderFromDb.getIdDriver());
//		Assert.assertEquals(order.getIdStatus(), orderFromDb.getIdStatus());
//		Assert.assertEquals(order.getIdStreetFrom(), orderFromDb.getIdStreetFrom());
//		Assert.assertEquals(order.getIdStreetTo(), orderFromDb.getIdStreetTo());
//		Assert.assertEquals(order.getPhoneNumber(), orderFromDb.getPhoneNumber());
	Order order = new Order();
	Time time = new Time();
	Date dat =new Date();
		System.out.println(dat.getYear());
//	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); 
//	Date dtime = dateFormat.parse("1133-11-11 11:11:11.0");
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
//		Date date = format.parse("2015-12-10T02:59:00.000Z");
		Timestamp timestamp = new Timestamp(dat.getTime());
		System.out.println(timestamp);
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
	   Long id =orderDao.InsertToMap(order);
		System.out.println(id);
		Order ord = orderDao.get(id);
		Date dt = ord.getDateOrder();
		System.out.println(dt);
		
	}
}