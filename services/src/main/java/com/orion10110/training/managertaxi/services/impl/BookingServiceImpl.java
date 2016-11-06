package com.orion10110.training.managertaxi.services.impl;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.Booking;
import com.orion10110.taximanager.datamodel.Discount;
import com.orion10110.training.managertaxi.daodb.BookingDao;
import com.orion10110.training.managertaxi.daodb.DiscountDao;
import com.orion10110.training.managertaxi.daodb.GenericDao;
import com.orion10110.training.managertaxi.services.BookingService;
@Service
public class BookingServiceImpl extends GenericServiceImpl<Booking,Long> implements BookingService{
	@Inject
	private BookingDao bookingDao;

	

	public BookingServiceImpl(){
		
	}

    @Autowired
    public BookingServiceImpl(
            @Qualifier("bookingDaoImpl") GenericDao<Booking, Long> genericDao) {
        super(genericDao);
        this.bookingDao = (BookingDao) genericDao;
    }

}
