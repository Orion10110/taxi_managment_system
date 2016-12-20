package com.orion10110.training.managertaxi.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orion10110.taximanager.datamodel.Car;
import com.orion10110.training.managertaxi.services.CarService;
import com.orion10110.training.managertaxi.web.model.CarModel;
@RestController
@RequestMapping("/cars")
public class CarController extends GenericController<CarService,Car,CarModel> {

}
