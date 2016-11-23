package com.orion10110.training.managertaxi.services;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import com.orion10110.taximanager.datamodel.AbstractModel;
import com.orion10110.training.managertaxi.services.aspect.CacheList;

public interface GenericService<T extends AbstractModel> {
	@Transactional
	void saveAll(List<T> entities);
	
	@CacheList(value="dbCache", keyGenerator="entityKeyGenerator")
	List<T> getAll();
	
	@CachePut(value="dbCache", keyGenerator="entityKeyGenerator")
	Long save(T entity);
	
	@Cacheable(value="dbCache", keyGenerator="namedKeyGenerator")
	T get(Long id);
	
	@CacheEvict(value="dbCache", keyGenerator="namedKeyGenerator")
	Long delete(Long id);
}
