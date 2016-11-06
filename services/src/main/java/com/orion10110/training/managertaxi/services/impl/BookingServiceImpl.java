package com.orion10110.training.managertaxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.Booking;
import com.orion10110.training.managertaxi.daodb.BookingDao;
import com.orion10110.training.managertaxi.services.BookingService;
@Service
public class BookingServiceImpl extends GenericServiceImpl<Booking,Long> implements BookingService{
    @Autowired
    public void setDao(BookingDao bookingDao){
    	setGenericDao(bookingDao);
    }

}
