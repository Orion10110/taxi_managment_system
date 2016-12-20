package com.orion10110.training.managertaxi.web.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.training.managertaxi.services.ApplicationUserService;
import com.orion10110.training.managertaxi.services.BrandService;
import com.orion10110.training.managertaxi.web.model.BrandModel;
import com.orion10110.training.managertaxi.web.security.aspect.AuthAccess;
import com.orion10110.training.managertaxi.web.security.aspect.RoleAccess;

@RestController
@RequestMapping("/brands")
public class BrandController extends GenericController<BrandService,Brand,BrandModel> {
	@Inject
	private ApplicationContext context;
	@Inject
	private BrandService service;
	@Inject
	private ApplicationUserService userService;
	@Inject
	private ConversionService conversionService;

	@Override
	@RoleAccess("Admin")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<BrandModel>> getAll() {
		return (ResponseEntity<List<BrandModel>>) super.getAll();
	}

//	@Override
//	@RequestMapping(value = "/{brandId}", method = RequestMethod.GET)
//	public ResponseEntity<BrandModel> getById(@PathVariable Long brandId) {
//		return super.getById(brandId);
//		Brand brand = service.get(brandId);
//		boolean bool = conversionService.canConvert(Brand.class, BrandModel.class);
//		return new ResponseEntity<BrandModel>(conversionService.convert(brand, BrandModel.class), HttpStatus.OK);
//	}
	
	@Override
	@AuthAccess
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createNew(@RequestBody BrandModel brandModel) {
		return super.createNew(brandModel);
	}
//	@Override
//	@RequestMapping(value = "/{brandId}", method = RequestMethod.POST)
//	public ResponseEntity<Void> update(@RequestBody BrandModel brandModel, @PathVariable Long brandId) {
//
//		Brand brand = conversionService.convert(brandModel, Brand.class);
//		brand.setId(brandId);
//		service.save(brand);
//		return new ResponseEntity<Void>(HttpStatus.OK);
//
//	}
//	@Override
//	@RequestMapping(value = "/{brandId}", method = RequestMethod.DELETE)
//	public ResponseEntity<Void> delete(@PathVariable Long brandId) {
//		service.delete(brandId);
//		return new ResponseEntity<Void>(HttpStatus.OK);
//
//	}

}
