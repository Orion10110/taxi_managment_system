package com.orion10110.training.managertaxi.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.orion10110.taximanager.datamodel.ApplicationUser;

public class ApplicationUserServiceTest {
//extends CrudTest<ApplicationUser> {
//	@Inject
//	private ApplicationUserService applicationUserServices;
//
//	@Override
//	public void delete(ApplicationUser testObject) {
//		applicationUserServices.delete(testObject.getId());
//	}
//
//	@Override
//	public ApplicationUser select(Long id) {
//		return applicationUserServices.get(id);
//	}
//
//	@Override
//	public void update(ApplicationUser testObject) {
//		applicationUserServices.save(testObject);
//	}
//
//	@Override
//	public void insert(ApplicationUser testObject) {
//		applicationUserServices.save(testObject);
//	}
//
//	@Override
//	public void changeTestObject(ApplicationUser testObject) {
//		ApplicationUser ap =context.getBean(ApplicationUser.class);
//		testObject.setEmail(ap.getEmail()+"t"+getAddValue());
//		testObject.setPasswordHash(ap.getPasswordHash()+"t"+getAddValue());
//		testObject.setPhoneNumber(ap.getPhoneNumber()+"t"+getAddValue());
//		testObject.setUserName(ap.getUserName()+"t"+getAddValue());
//	}
//
//	@Override
//	public void compare(ApplicationUser selected, ApplicationUser testObject) {
//		assertNotNull("selected is null", selected);
//		assertEquals(selected.getEmail(), testObject.getEmail());
//		assertEquals(selected.getPasswordHash(), testObject.getPasswordHash());
//		assertEquals(selected.getPhoneNumber(), testObject.getPhoneNumber());
//		assertEquals(selected.getUserName(), testObject.getUserName());
//
//	}
//
//	@Autowired
//	public void setApplicationUser(ApplicationUser appUser) {
//		setTestObject(appUser);
//	}
//
//	@Override
//	protected void saveAll(List<ApplicationUser> testObject) {
//		applicationUserServices.saveAll(testObject);
//	}
}
