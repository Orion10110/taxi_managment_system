package com.orion10110.training.managertaxi.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.training.managertaxi.services.BrandService;
import com.orion10110.training.managertaxi.web.model.BrandModel;

@RestController
@RequestMapping("/brands")
public class BrandController {
	@Inject
	private BrandService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<BrandModel>> getAll(){
		List<Brand> all = service.getAll();
		ArrayList<BrandModel> converted = new ArrayList<>();
		for (Brand brand : all) {
			converted.add(entity2model(brand));
		}
		
		  return new ResponseEntity<List<BrandModel>>(converted,
	                HttpStatus.OK);
	}
	
	private BrandModel entity2model(Brand brand) {
		BrandModel e = new BrandModel();
        e.setName(brand.getName());
        return e;
    }

	

}


