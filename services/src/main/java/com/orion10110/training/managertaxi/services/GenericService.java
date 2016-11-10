package com.orion10110.training.managertaxi.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.orion10110.taximanager.datamodel.AbstractModel;

public interface GenericService<T extends AbstractModel, PK extends Serializable> {
	@Transactional
	void saveAll(List<T> entity);

	PK save(T entity);

	T get(PK id);

	List<T> getAll();

	PK delete(PK id);
}
