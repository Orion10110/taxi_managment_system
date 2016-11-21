package com.orion10110.training.managertaxi.daoapi;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <T>  {
	Long insert(T newInstance);

	void delete(Long id);

	T get(Long id);

	void update(T transientObject);
	
	List<T> getAll();

	
}
