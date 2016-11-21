package com.orion10110.training.managertaxi.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.AbstractModel;
import com.orion10110.training.managertaxi.daoapi.GenericDao;
import com.orion10110.training.managertaxi.services.GenericService;

@Service
public class GenericServiceImpl<T extends AbstractModel> implements GenericService<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(GenericServiceImpl.class);

	protected GenericDao<T> genericDao;

	@Override
	public void saveAll(List<T> entities) {
		for (T t : entities) {
			save(t);
		}
	}

	@Override
	public Long save(T entity) {
		if (entity.getId() == null) {
			LOGGER.info("Create. id={}, class={}", entity.getId(), entity.getClass().getName());
			return (Long) genericDao.insert(entity);
		} else {
			LOGGER.info("Update. id={}, class={}", entity.getId(), entity.getClass().getName());
			genericDao.update(entity);
			return (Long) entity.getId();
		}
	}

	@Override
	public T get(Long id) {
		  try {
	            long time = (long) (5000L);
	            Thread.sleep(time);
	        } catch (InterruptedException e) {
	            throw new IllegalStateException(e);
	        }
		return genericDao.get(id);
	}

	@Override
	public Long delete(Long id) {
		genericDao.delete(id);
		return id;
	}

	public GenericDao<T> getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao<T> genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public List<T> getAll() {
		return genericDao.getAll();
	}

}
