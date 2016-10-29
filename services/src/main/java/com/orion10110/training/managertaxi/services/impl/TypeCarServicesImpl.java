package com.orion10110.training.managertaxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.TypeCar;
import com.orion10110.training.managertaxi.daodb.GenericDao;
import com.orion10110.training.managertaxi.daodb.TypeCarDao;
import com.orion10110.training.managertaxi.services.TypeCarServices;

@Service
public class TypeCarServicesImpl extends GenericServiceImpl<TypeCar, Long> implements TypeCarServices {

	private TypeCarDao typeCarDao;
	
		public TypeCarServicesImpl(){
			
		}

	    @Autowired
	    public TypeCarServicesImpl(
	            @Qualifier("typeCarDaoImpl") GenericDao<TypeCar, Long> genericDao) {
	        super(genericDao);
	        this.typeCarDao = (TypeCarDao) genericDao;
	    }

	

	

}
