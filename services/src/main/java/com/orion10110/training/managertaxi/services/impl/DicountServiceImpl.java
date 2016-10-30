package com.orion10110.training.managertaxi.services.impl;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.Discount;
import com.orion10110.training.managertaxi.daodb.DiscountDao;
import com.orion10110.training.managertaxi.daodb.GenericDao;
import com.orion10110.training.managertaxi.services.DiscountService;
@Service
public class DicountServiceImpl extends GenericServiceImpl<Discount,Long> implements DiscountService{
	@Inject
	private DiscountDao discountDao;

	

	public DicountServiceImpl(){
		
	}

    @Autowired
    public DicountServiceImpl(
            @Qualifier("discountDaoImpl") GenericDao<Discount, Long> genericDao) {
        super(genericDao);
        this.discountDao = (DiscountDao) genericDao;
    }

}
