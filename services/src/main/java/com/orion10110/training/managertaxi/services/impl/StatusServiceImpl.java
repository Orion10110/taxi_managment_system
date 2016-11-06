package com.orion10110.training.managertaxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.Status;
import com.orion10110.training.managertaxi.daodb.StatusDao;
import com.orion10110.training.managertaxi.services.StatusService;
@Service
public class StatusServiceImpl extends GenericServiceImpl<Status, Long> implements StatusService{
    @Autowired
    public void setDao(StatusDao statusDao){
    	setGenericDao(statusDao);
    }
}
