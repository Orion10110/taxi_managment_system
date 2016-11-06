package com.orion10110.training.managertaxi.services.impl;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.Driver;
import com.orion10110.training.managertaxi.daodb.DriverDao;
import com.orion10110.training.managertaxi.daodb.GenericDao;
import com.orion10110.training.managertaxi.daodb.StatusDao;
import com.orion10110.training.managertaxi.services.DriverService;
@Service
public class DriverServiceImpl extends GenericServiceImpl<Driver, Long> implements DriverService {
    @Autowired
    public void setDao(DriverDao driverDao){
    	setGenericDao(driverDao);
    }
}
