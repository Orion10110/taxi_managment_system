package com.orion10110.training.managertaxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.Client;
import com.orion10110.training.managertaxi.daodb.ClientDao;
import com.orion10110.training.managertaxi.services.ClientService;

@Service
public class ClientServiceImpl extends GenericServiceImpl<Client, Long> implements ClientService {
	@Autowired
	private void setDao(ClientDao сlientDao) {
		setGenericDao(сlientDao);
	}
}
