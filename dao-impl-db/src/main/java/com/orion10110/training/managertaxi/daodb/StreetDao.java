package com.orion10110.training.managertaxi.daodb;

import java.util.List;

import com.orion10110.taximanager.datamodel.Street;

public interface StreetDao {
	Street get(Long id);

    void insert(Street entity);

    void update(Street entity);

    void delete(Long id);

    List<Street> getAll();
}
