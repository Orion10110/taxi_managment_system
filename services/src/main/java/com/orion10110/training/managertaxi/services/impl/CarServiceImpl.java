package com.orion10110.training.managertaxi.services.impl;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.Car;
import com.orion10110.training.managertaxi.daodb.CarDao;
import com.orion10110.training.managertaxi.daodb.GenericDao;
import com.orion10110.training.managertaxi.services.CarService;

@Service
public class CarServiceImpl extends GenericServiceImpl<Car,Long> implements CarService{
	@Inject
	private CarDao carDao;

	

	public CarServiceImpl(){
		
	}

    @Autowired
    public CarServiceImpl(
            @Qualifier("carDaoImpl") GenericDao<Car, Long> genericDao) {
        super(genericDao);
        this.carDao = (CarDao) genericDao;
    }
}
