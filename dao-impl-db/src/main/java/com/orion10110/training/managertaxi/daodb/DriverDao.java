package com.orion10110.training.managertaxi.daodb;

import java.util.List;

import com.orion10110.taximanager.datamodel.Driver;

public interface DriverDao {
	Driver get(Long id);

    void insert(Driver entity);

    void update(Driver entity);

    void delete(Long id);

    List<Driver> getAll();
}
