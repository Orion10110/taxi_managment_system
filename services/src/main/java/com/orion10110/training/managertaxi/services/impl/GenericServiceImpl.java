package com.orion10110.training.managertaxi.services.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.AbstractModel;
import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.training.managertaxi.daodb.GenericDao;
import com.orion10110.training.managertaxi.services.GenericService;

@Service
public class GenericServiceImpl<T extends AbstractModel, PK extends Serializable> implements GenericService<T, PK> {

	protected GenericDao<T, PK> genericDao;

	@Override
	public void saveAll(List<T> entity) {
		for (T t : entity) {
			save(t);
		}
	}

	@Override
	public PK save(T entity) {
		if (entity.getId() == null) {
			return (PK) genericDao.insert(entity);
		} else {
			genericDao.update(entity);
			return (PK) entity.getId();
		}
	}

	@Override
	public T get(PK id) {
		return genericDao.get(id);
	}

	@Override
	public PK delete(PK id) {
		genericDao.delete(id);
		return id;
	}

	public GenericDao<T, PK> getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao<T, PK> genericDao) {
		this.genericDao = genericDao;
	}

}
