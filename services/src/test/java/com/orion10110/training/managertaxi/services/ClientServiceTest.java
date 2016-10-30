package com.orion10110.training.managertaxi.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orion10110.taximanager.datamodel.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class ClientServiceTest {
	@Inject
	private ClientService clientServices;

	@Test
	public void saveClientTest() {
		Client client = new Client();
		client.setSecondName("NameS");
		client.setFirstName("NameF");
		client.setPatronymic("patronymic");
		client.setPhoneNumber("90-90-90");
		client.setIdDiscount(1l);
		Long id = clientServices.save(client);

		Assert.assertNotNull(id);

		Client clientFromDb = clientServices.get(id);

		Assert.assertEquals(client.getSecondName(), clientFromDb.getSecondName());
		Assert.assertEquals(client.getFirstName(), clientFromDb.getFirstName());
		Assert.assertEquals(client.getPatronymic(), clientFromDb.getPatronymic());
		Assert.assertEquals(client.getPhoneNumber(), clientFromDb.getPhoneNumber());
		Assert.assertEquals(client.getIdDiscount(), clientFromDb.getIdDiscount());
	}
}
