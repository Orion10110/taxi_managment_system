package com.orion10110.training.managertaxi.services.impl;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.Client;
import com.orion10110.training.managertaxi.daodb.ClientDao;
import com.orion10110.training.managertaxi.daodb.GenericDao;
import com.orion10110.training.managertaxi.services.ClientService;
@Service
public class ClientServiceImpl extends GenericServiceImpl<Client,Long> implements ClientService{
	@Inject
	private ClientDao clientDao;

	

	public ClientServiceImpl(){
		
	}

    @Autowired
    public ClientServiceImpl(
            @Qualifier("clientDaoImpl") GenericDao<Client, Long> genericDao) {
        super(genericDao);
        this.clientDao = (ClientDao) genericDao;
    }

}
