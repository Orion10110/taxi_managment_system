package com.orion10110.training.managertaxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.Discount;
import com.orion10110.training.managertaxi.daoapi.DiscountDao;
import com.orion10110.training.managertaxi.services.DiscountService;
@Service
public class DicountServiceImpl extends GenericServiceImpl<Discount> implements DiscountService{
    @Autowired
    private void setDao(DiscountDao discountDao){
    	setGenericDao(discountDao);
    }
}
