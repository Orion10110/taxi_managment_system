package com.orion10110.training.managertaxi.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orion10110.taximanager.datamodel.Street;
import com.orion10110.training.managertaxi.services.StreetService;
import com.orion10110.training.managertaxi.web.model.StreetModel;
@RestController
@RequestMapping("/streets")
public class StreetController extends GenericController<StreetService,Street,StreetModel> {

}
