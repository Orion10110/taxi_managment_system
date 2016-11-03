package com.orion10110.training.managertaxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.TypeCar;
import com.orion10110.training.managertaxi.daodb.GenericDao;
import com.orion10110.training.managertaxi.daodb.TypeCarDao;
import com.orion10110.training.managertaxi.services.TypeCarService;

@Service
public class TypeCarServiceImpl extends GenericServiceImpl<TypeCar, Long> implements TypeCarService {

	private TypeCarDao typeCarDao;
	
		public TypeCarServiceImpl(){
			
		}

	    @Autowired
	    public TypeCarServiceImpl(
	            @Qualifier("typeCarDaoImpl") GenericDao<TypeCar, Long> genericDao) {
	        super(genericDao);
	        this.typeCarDao = (TypeCarDao) genericDao;
	    }

	

	

}