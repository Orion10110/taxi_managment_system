package com.orion10110.training.managertaxi.services;

import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.taximanager.datamodel.Booking;

public class BookingServiceTest extends CrudTest<Booking> {
	@Inject
	private BookingService bookingService;

	@Override
	public void delete(Booking testObject) {
		bookingService.delete(testObject.getId());
	}

	@Override
	public Booking select(Long id) {
		return bookingService.get(id);
	}

	@Override
	public void update(Booking testObject) {
		bookingService.save(testObject);
	}

	@Override
	public void insert(Booking testObject) {
		bookingService.save(testObject);
	}

	@Override
	public void changeTestObject(Booking testObject) {
		LocalDateTime loc = LocalDateTime.of(2015,03,13,18,30,30);
		Timestamp timestamp = Timestamp.valueOf(loc);
		testObject.setDateOrder(timestamp);
		testObject.setEndValue(111);
		testObject.setStartValue(222);
		testObject.setPhoneNumber("10-11-11");

	}

	@Override
	public void compare(Booking selected, Booking testObject) {
		assertNotNull("selected is null", selected);
		Assert.assertEquals(selected.getDateOrder(), testObject.getDateOrder());
		Assert.assertEquals(selected.getEndValue(), testObject.getEndValue());
		Assert.assertEquals(selected.getStartValue(), testObject.getStartValue());
		Assert.assertEquals(selected.getIdApplicationUser(), testObject.getIdApplicationUser());
		Assert.assertEquals(selected.getIdClient(), testObject.getIdClient());
		Assert.assertEquals(selected.getIdDriver(), testObject.getIdDriver());
		Assert.assertEquals(selected.getIdStatus(), testObject.getIdStatus());
		Assert.assertEquals(selected.getIdStreetFrom(), testObject.getIdStreetFrom());
		Assert.assertEquals(selected.getIdStreetTo(), testObject.getIdStreetTo());
		Assert.assertEquals(selected.getPhoneNumber(), testObject.getPhoneNumber());

	}

	@Autowired
	public void setOrder(Booking order) {
		setTestObject(order);
	}
}