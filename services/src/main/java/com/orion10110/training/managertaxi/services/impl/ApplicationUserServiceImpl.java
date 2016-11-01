package com.orion10110.training.managertaxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.ApplicationUser;
import com.orion10110.training.managertaxi.daodb.ApplicationUserDao;
import com.orion10110.training.managertaxi.daodb.GenericDao;
import com.orion10110.training.managertaxi.services.ApplicationUserService;

@Service
public class ApplicationUserServiceImpl extends GenericServiceImpl<ApplicationUser, Long>
		implements ApplicationUserService {
	private ApplicationUserDao applicationUserDao;

	public ApplicationUserServiceImpl() {

	}

	@Autowired
	public ApplicationUserServiceImpl(
			@Qualifier("applicationUserDaoImpl") GenericDao<ApplicationUser, Long> genericDao) {
		super(genericDao);
		this.applicationUserDao = (ApplicationUserDao) genericDao;
	}
}
