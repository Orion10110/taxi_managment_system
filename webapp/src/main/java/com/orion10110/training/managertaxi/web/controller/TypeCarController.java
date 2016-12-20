package com.orion10110.training.managertaxi.web.controller;

import java.util.List;
import java.util.Locale;

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

import com.orion10110.taximanager.datamodel.TypeCar;
import com.orion10110.training.managertaxi.services.TypeCarService;
import com.orion10110.training.managertaxi.services.components.UserDataLang;
import com.orion10110.training.managertaxi.web.model.TypeCarAbstractModel;
import com.orion10110.training.managertaxi.web.model.TypeCarEnModel;
import com.orion10110.training.managertaxi.web.model.TypeCarModel;
import com.orion10110.training.managertaxi.web.model.TypeCarStandardLangModel;

@RestController
@RequestMapping("/type_cars")
public class TypeCarController {
	@Inject
	private ApplicationContext context;
	@Inject
	private TypeCarService service;
	@Inject
	private ConversionService conversionService;

	private UserDataLang userDataLang;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TypeCarAbstractModel>> getAll() {
		List<TypeCar> source = service.getAll();
		TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(TypeCar.class));
		TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(getLangClass()));
		List<TypeCarAbstractModel> target = (List<TypeCarAbstractModel>) conversionService.convert(source, sourceType,
				targetType);
		return new ResponseEntity<List<TypeCarAbstractModel>>(target, HttpStatus.OK);
	}

	private Class getLangClass() {
		Class langClass = TypeCarStandardLangModel.class;
		userDataLang = context.getBean(UserDataLang.class);
		if (!userDataLang.hasUserLocales()) {
			return langClass;
		}
		List<Locale> userLocales = userDataLang.getUserLocales();
		for (Locale locale : userLocales) {
			switch (locale.getLanguage()) {
			case "en":
				langClass = TypeCarEnModel.class;
				return langClass;
			default:
				break;
			}
		}

		return langClass;

	}

	@RequestMapping(value = "/{typeCarId}", method = RequestMethod.GET)
	public ResponseEntity<TypeCarAbstractModel> getById(@PathVariable Long typeCarId) {
		TypeCar typeCar = service.get(typeCarId);
		if(typeCar==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		TypeCarAbstractModel ret = (TypeCarAbstractModel) conversionService.convert(typeCar, getLangClass());
		return new ResponseEntity<TypeCarAbstractModel>(ret, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createNew(@RequestBody TypeCarModel typeCarModel) {
		TypeCar tc=service.save(conversionService.convert(typeCarModel, TypeCar.class));
		if(tc==null) return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{typeCarId}", method = RequestMethod.POST)
	public ResponseEntity<Void> update(@RequestBody TypeCarModel typeCarModel, @PathVariable Long typeCarId) {
		TypeCar typeCar = conversionService.convert(typeCarModel, TypeCar.class);
		typeCar.setId(typeCarId);
		TypeCar tc=service.save(typeCar);
		if(tc==null) return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "/{typeCarId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long typeCarId) {
		service.delete(typeCarId);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
