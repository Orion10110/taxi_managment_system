package com.orion10110.training.managertaxi.servises;

import java.util.List;

import com.orion10110.taximanager.datamodel.Car;


public interface CarServices {
	 void saveAll(List<Car> car);

	    void save(Car car);

	    boolean isDaoExist();
}
