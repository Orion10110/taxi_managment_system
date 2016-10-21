package com.orion10110.training.managertaxi.daodb;

import java.util.List;

import com.orion10110.taximanager.datamodel.District;

public interface DistrictDao {
	District get(Long id);

    void insert(District entity);

    void update(District entity);

    void delete(Long id);

    List<District> getAll();
}
