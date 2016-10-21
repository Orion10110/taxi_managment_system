package com.orion10110.training.managertaxi.daodb;

import java.util.List;

import com.orion10110.taximanager.datamodel.TypeCar;

public interface TypeCarDao {
	TypeCar get(Long id);

    void insert(TypeCar entity);

    void update(TypeCar entity);

    void delete(Long id);

    List<TypeCar> getAll();
}
