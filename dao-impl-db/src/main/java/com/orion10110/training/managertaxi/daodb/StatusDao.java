package com.orion10110.training.managertaxi.daodb;

import java.util.List;

import com.orion10110.taximanager.datamodel.Status;

public interface StatusDao {
	Status get(Long id);

    void insert(Status entity);

    void update(Status entity);

    void delete(Long id);

    List<Status> getAll();
}
