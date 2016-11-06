package com.orion10110.training.managertaxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.Street;
import com.orion10110.training.managertaxi.daodb.StreetDao;
import com.orion10110.training.managertaxi.services.StreetService;

@Service
public class StreetServiceImpl extends GenericServiceImpl<Street, Long> implements StreetService {
    @Autowired
    public void setDao(StreetDao streetDao){
    	setGenericDao(streetDao);
    }
}
