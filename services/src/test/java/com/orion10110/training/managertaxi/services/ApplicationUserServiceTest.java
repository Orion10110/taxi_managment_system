package com.orion10110.training.managertaxi.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orion10110.taximanager.datamodel.ApplicationUser;
import com.orion10110.taximanager.datamodel.Brand;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class ApplicationUserServiceTest {
	@Inject
	private ApplicationUserService applicationUserServices;

	@Test
	public void saveBrandTest() {
		ApplicationUser appUser = new ApplicationUser();
		appUser.setEmail("you@test.com");
		appUser.setEmailConfirmed(true); 
		appUser.setPasswordHash("pswordhash");
		appUser.setPhoneNumber("788-78-78");
		appUser.setPhoneNumberConfirmed(false);
		appUser.setUserName("test");
		Long id = applicationUserServices.save(appUser);

		Assert.assertNotNull(id);

		ApplicationUser appUserFromDb = applicationUserServices.get(id);

		Assert.assertEquals(appUser.getUserName(), appUserFromDb.getUserName());
	}
}
