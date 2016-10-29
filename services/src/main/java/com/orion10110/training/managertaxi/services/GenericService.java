package com.orion10110.training.managertaxi.services;

import java.io.Serializable;
import java.util.List;

import com.orion10110.taximanager.datamodel.AbstractModel;
import com.orion10110.taximanager.datamodel.Brand;

public interface GenericService<T  extends AbstractModel,PK extends Serializable> {
	void saveAll(List<T> entity);

	PK save(T entity);

	T get(PK id);

	PK delete(PK id);
}
