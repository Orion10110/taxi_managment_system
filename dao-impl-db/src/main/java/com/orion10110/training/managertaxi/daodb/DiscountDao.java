package com.orion10110.training.managertaxi.daodb;

import java.util.List;

import com.orion10110.taximanager.datamodel.Discount;

public interface DiscountDao {
	Discount get(Long id);

    void insert(Discount entity);

    void update(Discount entity);

    void delete(Long id);

    List<Discount> getAll();
}
