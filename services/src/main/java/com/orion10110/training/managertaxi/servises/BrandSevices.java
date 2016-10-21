package com.orion10110.training.managertaxi.servises;

import java.util.List;

import com.orion10110.taximanager.datamodel.Brand;

public interface BrandSevices {
	 void saveAll(List<Brand> brand);

	    void save(Brand brand);

	    boolean isDaoExist();
}
