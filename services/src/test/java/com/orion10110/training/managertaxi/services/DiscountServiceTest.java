package com.orion10110.training.managertaxi.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.orion10110.taximanager.datamodel.Discount;

public class DiscountServiceTest extends CrudTest<Discount> {
	@Inject
	private DiscountService discountServices;

	@Override
	public void delete(Discount testObject) {
		discountServices.delete(testObject.getId());
	}

	@Override
	public Discount select(Long id) {
		return discountServices.get(id);
	}

	@Override
	public void update(Discount testObject) {
		discountServices.save(testObject);
	}

	@Override
	public void insert(Discount testObject) {
		discountServices.save(testObject);
	}

	@Override
	public void changeTestObject(Discount testObject) {
		Random random = new Random();
		testObject.setName(random.nextInt() + "");
		testObject.setDiscountPercent(random.nextInt());
	}

	@Override
	public void compare(Discount selected, Discount testObject) {
		assertNotNull("selected is null", selected);
		assertEquals(selected.getName(), testObject.getName());
		assertEquals(selected.getDiscountPercent(), testObject.getDiscountPercent());
	}

	@Autowired
	public void setDiscount(Discount discount) {
		setTestObject(discount);
	}

	@Override
	protected void saveAll(List<Discount> testObject) {
		discountServices.saveAll(testObject);
	}
}
