package com.orion10110.training.managertaxi.web.conversion;

import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.Car;
import com.orion10110.training.managertaxi.web.anotation.AutoRegistered;
import com.orion10110.training.managertaxi.web.model.CarModel;

@AutoRegistered
@Component
public class CarConverter extends TwoWayConverter<Car, CarModel> {

}
