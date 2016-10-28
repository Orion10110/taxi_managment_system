package com.orion10110.training.managertaxi.daodb;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <T, PK extends Serializable>  {
	PK insert(T newInstance);

	void delete(T persistentObject);

	T get(PK id);

	T update(T transientObject);
	
	List<T> getAll();
}
