package com.orion10110.training.managertaxi.services.impl;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.District;
import com.orion10110.training.managertaxi.daodb.DistrictDao;
import com.orion10110.training.managertaxi.daodb.DriverDao;
import com.orion10110.training.managertaxi.daodb.GenericDao;
import com.orion10110.training.managertaxi.daodb.StreetDao;
import com.orion10110.training.managertaxi.services.DistrictService;
@Service
public class DistrictServiceImpl extends GenericServiceImpl<District, Long> implements DistrictService {
    @Autowired
    public void setDao(DistrictDao districtDao){
    	setGenericDao(districtDao);
    }
}
