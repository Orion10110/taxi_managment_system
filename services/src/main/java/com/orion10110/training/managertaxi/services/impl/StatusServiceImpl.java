package com.orion10110.training.managertaxi.services.impl;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.Status;
import com.orion10110.training.managertaxi.daodb.GenericDao;
import com.orion10110.training.managertaxi.daodb.StatusDao;
import com.orion10110.training.managertaxi.services.StatusService;
@Service
public class StatusServiceImpl extends GenericServiceImpl<Status, Long> implements StatusService{
	@Inject
	private StatusDao statusDao;

	

	public StatusServiceImpl(){
		
	}

    @Autowired
    public StatusServiceImpl(
            @Qualifier("statusDaoImpl") GenericDao<Status, Long> genericDao) {
        super(genericDao);
        this.statusDao = (StatusDao) genericDao;
    }

}
