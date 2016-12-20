package com.orion10110.training.managertaxi.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orion10110.taximanager.datamodel.Booking;
import com.orion10110.training.managertaxi.services.BookingService;
import com.orion10110.training.managertaxi.web.model.BookingModel;
@RestController
@RequestMapping("/booking")
public class BookingController extends GenericController<BookingService,Booking,BookingModel> {

}
