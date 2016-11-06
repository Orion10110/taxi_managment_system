package com.orion10110.training.managertaxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.Car;
import com.orion10110.training.managertaxi.daodb.CarDao;
import com.orion10110.training.managertaxi.services.CarService;

@Service
public class CarServiceImpl extends GenericServiceImpl<Car,Long> implements CarService{
    @Autowired
    public void setDao(CarDao сarDao){
    	setGenericDao(сarDao);
    }
}
