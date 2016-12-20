package com.orion10110.training.managertaxi.web.conversion;

import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.Booking;
import com.orion10110.training.managertaxi.web.anotation.AutoRegistered;
import com.orion10110.training.managertaxi.web.model.BookingModel;

@AutoRegistered
@Component
public class BookingConverter extends TwoWayConverter<Booking, BookingModel> {

}
