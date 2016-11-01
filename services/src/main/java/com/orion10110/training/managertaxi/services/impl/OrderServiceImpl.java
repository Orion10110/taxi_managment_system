package com.orion10110.training.managertaxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.Order;
import com.orion10110.training.managertaxi.daodb.GenericDao;
import com.orion10110.training.managertaxi.daodb.OrderDao;
import com.orion10110.training.managertaxi.services.OrderService;
@Service
public class OrderServiceImpl extends GenericServiceImpl<Order,Long> implements OrderService{

	private OrderDao orderDao;

	public OrderServiceImpl(){
		
	}

    @Autowired
    public OrderServiceImpl(
            @Qualifier("orderDaoImpl") GenericDao<Order, Long> genericDao) {
        super(genericDao);
        this.orderDao = (OrderDao) genericDao;
    }
}
