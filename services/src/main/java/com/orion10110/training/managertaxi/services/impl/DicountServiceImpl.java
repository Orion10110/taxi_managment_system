package com.orion10110.training.managertaxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.Discount;
import com.orion10110.training.managertaxi.daodb.DiscountDao;
import com.orion10110.training.managertaxi.services.DiscountService;
@Service
public class DicountServiceImpl extends GenericServiceImpl<Discount,Long> implements DiscountService{
    @Autowired
    public void setDao(DiscountDao discountDao){
    	setGenericDao(discountDao);
    }
}
