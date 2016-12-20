package com.orion10110.training.managertaxi.services;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import com.orion10110.taximanager.datamodel.AbstractModel;
import com.orion10110.training.managertaxi.services.aspect.CacheList;
import com.orion10110.training.managertaxi.services.aspect.ListCacheEvict;
import com.orion10110.training.managertaxi.services.aspect.ListCachePut;

public interface GenericService<T extends AbstractModel> {
	@Transactional
	void saveAll(List<T> entities);
	
	/**
	 * Получение всех объектов
	 * @return список объектов
	 */
	@CacheList(value="dbCache", keyGenerator="entityKeyGenerator")
	List<T> getAll();
	
	/**
	 * Сохранение изменений объекта
	 * @param entity объект
	 * @return объект
	 */
	@ListCachePut(value="dbCache")
	@CachePut(value="dbCache", keyGenerator="entityKeyGenerator")
	T save(T entity);
	
	/**
	 * Получение объекта по id
	 * @param id объекта
	 * @return Объект
	 */
	@Cacheable(value="dbCache", keyGenerator="namedKeyGenerator")
	T get(Long id);
	
	/**
	 * Удаление объекта из хранилища
	 * @param id объекта
	 * @return id объекта
	 */
	@ListCacheEvict("dbCache")
	@CacheEvict(value="dbCache", keyGenerator="namedKeyGenerator")
	Long delete(Long id);
}
