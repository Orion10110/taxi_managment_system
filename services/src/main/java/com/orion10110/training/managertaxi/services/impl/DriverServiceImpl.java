package com.orion10110.training.managertaxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.Driver;
import com.orion10110.training.managertaxi.daodb.DriverDao;
import com.orion10110.training.managertaxi.services.DriverService;

@Service
public class DriverServiceImpl extends GenericServiceImpl<Driver, Long> implements DriverService {
	@Autowired
	private void setDao(DriverDao driverDao) {
		setGenericDao(driverDao);
	}
}
