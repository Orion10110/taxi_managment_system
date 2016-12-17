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

import com.orion10110.taximanager.datamodel.Status;
import com.orion10110.training.managertaxi.services.StatusService;
import com.orion10110.training.managertaxi.services.components.UserDataLang;
import com.orion10110.training.managertaxi.web.model.StatusAbstractModel;
import com.orion10110.training.managertaxi.web.model.StatusEnModel;
import com.orion10110.training.managertaxi.web.model.StatusModel;
import com.orion10110.training.managertaxi.web.model.StatusStandardLangModel;

@RestController
@RequestMapping("/status")
public class StatusController {
	@Inject
	private ApplicationContext context;
	@Inject
	private StatusService service;
	@Inject
	private ConversionService conversionService;
	
	private UserDataLang userDataLang;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StatusAbstractModel>> getAll() {
		List<Status> source = service.getAll();
		TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Status.class));
		TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(getLangClass()));
		List<StatusAbstractModel> target = (List<StatusAbstractModel>) conversionService.convert(source, sourceType, targetType);
		return new ResponseEntity<List<StatusAbstractModel>>(target, HttpStatus.OK);
	}

	private Class getLangClass(){
		Class langClass = StatusStandardLangModel.class;
		userDataLang = context.getBean(UserDataLang.class);
		if(!userDataLang.hasUserLocales()){
			return langClass;
		}
		List<Locale> userLocales =userDataLang.getUserLocales();
		for (Locale locale : userLocales) {
			switch (locale.getLanguage()) {
			case "en":  langClass = StatusEnModel.class;
				return langClass;
			default:
				break;
			}
		}
		
		return langClass;
		
	}
	
	
	@RequestMapping(value = "/{statusId}", method = RequestMethod.GET)
	public ResponseEntity<StatusAbstractModel> getById(@PathVariable Long statusId) {

		Status status = service.get(statusId);
		StatusAbstractModel ret =(StatusAbstractModel) conversionService.convert(status, getLangClass());
		return new ResponseEntity<StatusAbstractModel>(ret, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createNew(@RequestBody StatusModel statusModel) {
		service.save(conversionService.convert(statusModel, Status.class));
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{statusId}", method = RequestMethod.POST)
	public ResponseEntity<Void> update(@RequestBody StatusModel statusModel, @PathVariable Long statusId) {

		Status status = conversionService.convert(statusModel, Status.class);
		status.setId(statusId);
		service.save(status);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "/{statusId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long statusId) {
		service.delete(statusId);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
