package com.orion10110.training.managertaxi.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.orion10110.taximanager.datamodel.Client;

public class ClientServiceTest extends CrudTest<Client> {
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
		Client cl = context.getBean(Client.class);
		testObject.setSecondName(cl.getSecondName());
		testObject.setFirstName(cl.getFirstName());
		testObject.setPatronymic(cl.getPatronymic());
		testObject.setPhoneNumber(cl.getPhoneNumber());
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

	@Override
	protected void saveAll(List<Client> testObject) {
		clientServices.saveAll(testObject);
	}
}
