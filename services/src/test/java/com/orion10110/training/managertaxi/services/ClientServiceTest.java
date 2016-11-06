package com.orion10110.training.managertaxi.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Random;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.orion10110.taximanager.datamodel.Client;

public class ClientServiceTest extends CrudTest<Client>{
	@Inject
	private ClientService clientServices;

	@Override
	public void delete(Client testObject) {
		clientServices.delete(testObject.getId());
	}

	@Override
	public Client select(Long id) {
		return clientServices.get(id);
	}

	@Override
	public void update(Client testObject) {
		clientServices.save(testObject);		
	}

	@Override
	public void insert(Client testObject) {
		clientServices.save(testObject);		
	}

	@Override
	public void changeTestObject(Client testObject) {
		Random random = new Random();
		testObject.setSecondName(random.nextInt() +"");
		testObject.setFirstName("TestFName");
		testObject.setPatronymic("TestPatr");
		testObject.setPhoneNumber("11-11-11");
	}
	
	@Override
	public void compare(Client selected, Client testObject) {
		assertNotNull("selected is null", selected);
		assertEquals(selected.getSecondName(), testObject.getSecondName());
		assertEquals(selected.getFirstName(), testObject.getFirstName());
		assertEquals(selected.getPatronymic(), testObject.getPatronymic());
		assertEquals(selected.getPhoneNumber(), testObject.getPhoneNumber());
		assertEquals(selected.getIdDiscount(), testObject.getIdDiscount());
	}

	@Autowired
	public void setClient(Client client) {
		setTestObject(client);
	}
}
