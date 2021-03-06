package com.orion10110.training.managertaxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.training.managertaxi.daoapi.BrandDao;
import com.orion10110.training.managertaxi.services.BrandService;

@Service
public class BrandServiceImpl extends GenericServiceImpl<Brand> implements BrandService {
	@Autowired
	private void setDao(BrandDao brandDao) {
		setGenericDao(brandDao);
	}
}
