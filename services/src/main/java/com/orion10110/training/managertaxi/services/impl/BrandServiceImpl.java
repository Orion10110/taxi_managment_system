package com.orion10110.training.managertaxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.training.managertaxi.daodb.BrandDao;
import com.orion10110.training.managertaxi.services.BrandService;

@Service
public class BrandServiceImpl extends GenericServiceImpl<Brand, Long> implements BrandService {
	@Autowired
	public void setDao(BrandDao brandDao) {
		setGenericDao(brandDao);
	}
}
