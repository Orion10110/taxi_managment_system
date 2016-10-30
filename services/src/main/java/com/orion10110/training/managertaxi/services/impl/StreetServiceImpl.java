package com.orion10110.training.managertaxi.services.impl;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.Street;
import com.orion10110.taximanager.datamodel.TypeCar;
import com.orion10110.training.managertaxi.daodb.GenericDao;
import com.orion10110.training.managertaxi.daodb.StreetDao;
import com.orion10110.training.managertaxi.daodb.TypeCarDao;
import com.orion10110.training.managertaxi.services.StreetService;

@Service
public class StreetServiceImpl extends GenericServiceImpl<Street, Long> implements StreetService {
	@Inject
	private StreetDao streetDao;

	

	public StreetServiceImpl(){
		
	}

    @Autowired
    public StreetServiceImpl(
            @Qualifier("streetDaoImpl") GenericDao<Street, Long> genericDao) {
        super(genericDao);
        this.streetDao = (StreetDao) genericDao;
    }

}
