package com.orion10110.training.managertaxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.ApplicationUser;
import com.orion10110.training.managertaxi.daodb.ApplicationUserDao;
import com.orion10110.training.managertaxi.services.ApplicationUserService;

@Service
public class ApplicationUserServiceImpl extends GenericServiceImpl<ApplicationUser, Long>
		implements ApplicationUserService {
	@Autowired
	private void setDao(ApplicationUserDao applicationUserDao) {
		setGenericDao(applicationUserDao);
	}
}
