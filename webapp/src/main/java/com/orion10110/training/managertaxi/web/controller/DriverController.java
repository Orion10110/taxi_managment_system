package com.orion10110.training.managertaxi.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orion10110.taximanager.datamodel.Driver;
import com.orion10110.training.managertaxi.services.DriverService;
import com.orion10110.training.managertaxi.web.model.DriverModel;
@RestController
@RequestMapping("/drivers")
public class DriverController extends GenericController<DriverService,Driver,DriverModel> {
	
}
