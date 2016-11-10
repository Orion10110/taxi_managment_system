package com.orion10110.training.managertaxi.services.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.AbstractModel;
import com.orion10110.training.managertaxi.daodb.GenericDao;
import com.orion10110.training.managertaxi.services.GenericService;

@Service
public class GenericServiceImpl<T extends AbstractModel, PK extends Serializable> implements GenericService<T, PK> {

	private static final Logger LOGGER = LoggerFactory.getLogger(GenericServiceImpl.class);

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
			LOGGER.info("Create. id={}, class={}", entity.getId(), entity.getClass().getName());
			return (PK) genericDao.insert(entity);
		} else {
			LOGGER.info("Update. id={}, class={}", entity.getId(), entity.getClass().getName());
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

	@Override
	public List<T> getAll() {
		return genericDao.getAll();
	}

}
