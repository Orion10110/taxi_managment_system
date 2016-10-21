package com.orion10110.training.managertaxi.daodb;

import java.util.List;
import com.orion10110.taximanager.datamodel.Brand;


public interface BrandDao {
	 	Brand get(Long id);

	    void insert(Brand entity);

	    void update(Brand entity);

	    void delete(Long id);

	    List<Brand> getAll();
}
