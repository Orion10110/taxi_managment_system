package com.orion10110.training.managertaxi.servises;

import java.util.List;

import com.orion10110.taximanager.datamodel.TypeCar;


public interface TypeCarServices {
	 void saveAll(List<TypeCar> typrCar);

	    void save(TypeCar typrCar);

	    boolean isDaoExist();
}
