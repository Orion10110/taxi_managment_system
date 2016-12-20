package com.orion10110.training.managertaxi.services;

import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

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
		Booking bk =context.getBean(Booking.class);
		testObject.setDateOrder(bk.getDateOrder());
		testObject.setEndValue(bk.getStartValue());
		testObject.setStartValue(bk.getEndValue());
		testObject.setPhoneNumber(bk.getPhoneNumber());

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

	@Override
	protected void saveAll(List<Booking> testObject) {
		bookingService.saveAll(testObject);
	}
}