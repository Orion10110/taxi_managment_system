package com.orion10110.training.managertaxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.District;
import com.orion10110.training.managertaxi.daodb.DistrictDao;
import com.orion10110.training.managertaxi.services.DistrictService;

@Service
public class DistrictServiceImpl extends GenericServiceImpl<District, Long> implements DistrictService {
	@Autowired
	private void setDao(DistrictDao districtDao) {
		setGenericDao(districtDao);
	}
}
