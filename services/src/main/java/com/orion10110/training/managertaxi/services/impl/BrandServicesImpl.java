package com.orion10110.training.managertaxi.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.training.managertaxi.daodb.BrandDao;
import com.orion10110.training.managertaxi.services.BrandSevices;


@Service
public class BrandServicesImpl implements BrandSevices {
	@Inject
	private BrandDao brandDao;

	@Override
	public Brand get(Long id) {
		return brandDao.get(id);
	}

	@Override
	public void saveAll(List<Brand> brands) {
		for (Brand brand : brands) {
			save(brand);
		}

	}

	@Override
	public Long save(Brand brand) {

		if (brand.getId() == null) {
			return brandDao.insert(brand);
		} else {
			brandDao.update(brand);
			return brand.getId();
		}
	}

	@Override
	public Long delete(Long id) {
		brandDao.delete(id);
		return id;
	}
}
