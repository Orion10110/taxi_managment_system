package com.orion10110.training.managertaxi.services;

import java.util.List;

import com.orion10110.taximanager.datamodel.Brand;

public interface BrandSevices {
	void saveAll(List<Brand> brand);

	Long save(Brand brand);

	Brand get(Long id);

	Long delete(Long id);
}
