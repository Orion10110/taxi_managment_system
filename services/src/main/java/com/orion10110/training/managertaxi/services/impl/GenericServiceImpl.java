package com.orion10110.training.managertaxi.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.AbstractModel;
import com.orion10110.training.managertaxi.daoapi.GenericDao;
import com.orion10110.training.managertaxi.services.GenericService;
import com.orion10110.training.managertaxi.services.aspect.CacheList;
import com.orion10110.training.managertaxi.services.aspect.ListCacheEvict;
import com.orion10110.training.managertaxi.services.aspect.ListCachePut;

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
	@ListCachePut(value = "dbCache")
	public T save(T entity) {
		try {
			if (entity.getId() == null) {
				entity.setId((Long) genericDao.insert(entity));
				LOGGER.info("Create. id={}, class={}", entity.getId(), entity.getClass().getName());
				return entity;
			} else {
				genericDao.update(entity);
				LOGGER.info("Update. id={}, class={}", entity.getId(), entity.getClass().getName());
				return entity;
			}
		} catch (DuplicateKeyException e) {
			LOGGER.error("Exeption DuplicateKeyExeption. Message: {}", e.getMessage());
			return null;
		} catch (DataIntegrityViolationException e) {
			LOGGER.error("Exeption DataIntegrityViolationException. Message: {}", e.getMessage());
			return null;
		}

	}

	@Override
	public T get(Long id) {
		try {
		return genericDao.get(id);
		}catch(EmptyResultDataAccessException e)
		{
			LOGGER.error("Exeption EmptyResultDataAccessException. Message: {}", e.getMessage());
			return null;
		}
	}

	@Override
	@ListCacheEvict("dbCache")
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
	@CacheList(value = "dbCache", keyGenerator = "entityKeyGenerator")
	public List<T> getAll() {

		return genericDao.getAll();
	}

}
