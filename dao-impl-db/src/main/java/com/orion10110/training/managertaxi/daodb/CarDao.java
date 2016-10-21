package com.orion10110.training.managertaxi.daodb;

import java.util.List;

import com.orion10110.taximanager.datamodel.Car;

public interface CarDao {
	Car get(Long id);

    void insert(Car entity);

    void update(Car entity);

    void delete(Long id);

    List<Car> getAll();
}
