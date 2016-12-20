package com.orion10110.training.managertaxi.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orion10110.taximanager.datamodel.Discount;
import com.orion10110.training.managertaxi.services.DiscountService;
import com.orion10110.training.managertaxi.web.model.DiscountModel;
@RestController
@RequestMapping("/discounts")
public class DiscountController extends GenericController<DiscountService,Discount,DiscountModel> {
	
}
