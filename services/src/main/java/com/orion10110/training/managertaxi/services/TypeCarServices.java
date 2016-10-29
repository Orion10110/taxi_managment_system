package com.orion10110.training.managertaxi.services;

import java.util.List;

import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.taximanager.datamodel.TypeCar;


public interface TypeCarServices {
	void saveAll(List<TypeCar> typeCar);

	Long save(TypeCar TypeCar);

	TypeCar get(Long id);

	Long delete(Long id);
}
