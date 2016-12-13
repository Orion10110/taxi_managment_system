package com.orion10110.training.managertaxi.web.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.training.managertaxi.services.BrandService;
import com.orion10110.training.managertaxi.services.components.UserDataStorage;
import com.orion10110.training.managertaxi.web.model.BrandModel;

@RestController
@RequestMapping("/brands")
public class BrandController {
	@Inject
	private ApplicationContext context;
	@Inject
	private BrandService service;
	@Inject
	private ConversionService conversionService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<BrandModel>> getAll() {
		List<Brand> source = service.getAll();
		TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Brand.class));
		TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(BrandModel.class));
		List<BrandModel> target = (List<BrandModel>) conversionService.convert(source, sourceType, targetType);
		UserDataStorage userDataStorage = context.getBean(UserDataStorage.class);
        System.out.println("AuthorControllerP:" + userDataStorage);
		return new ResponseEntity<List<BrandModel>>(target, HttpStatus.OK);
	}

	@RequestMapping(value = "/{brandId}", method = RequestMethod.GET)
	public ResponseEntity<BrandModel> getById(@PathVariable Long brandId) {

		Brand brand = service.get(brandId);
		boolean bool = conversionService.canConvert(Brand.class, BrandModel.class);
		return new ResponseEntity<BrandModel>(conversionService.convert(brand, BrandModel.class), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createNewAuthor(@RequestBody BrandModel brandModel) {
		service.save(conversionService.convert(brandModel, Brand.class));
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{brandId}", method = RequestMethod.POST)
	public ResponseEntity<Void> updateAuthor(@RequestBody BrandModel brandModel, @PathVariable Long brandId) {

		Brand brand = conversionService.convert(brandModel, Brand.class);
		brand.setId(brandId);
		service.save(brand);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "/{brandId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long brandId) {
		service.delete(brandId);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
