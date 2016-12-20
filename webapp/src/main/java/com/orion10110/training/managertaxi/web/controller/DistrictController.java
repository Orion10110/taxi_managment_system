package com.orion10110.training.managertaxi.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orion10110.taximanager.datamodel.District;
import com.orion10110.training.managertaxi.services.DistrictService;
import com.orion10110.training.managertaxi.web.model.DistrictModel;
@RestController
@RequestMapping("/districts")
public class DistrictController extends GenericController<DistrictService,District,DistrictModel> {

}
