package com.orion10110.training.managertaxi.web.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.PostConstruct;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orion10110.taximanager.datamodel.AbstractModel;
import com.orion10110.taximanager.datamodel.TypeCar;
import com.orion10110.training.managertaxi.services.GenericService;
import com.orion10110.training.managertaxi.services.components.UserDataLang;

@RestController
public abstract class GenericController<S extends GenericService, T extends AbstractModel, K extends AbstractModel> {
	@Inject
	protected ApplicationContext context;
	protected GenericService service;
	@Inject
	private ConversionService conversionService;

	private Class modelClass;

	private Class convertModelClass;

	private Class serviceClass;

	private UserDataLang userDataLang;

	public GenericController() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		serviceClass = (Class) pt.getActualTypeArguments()[0];
		modelClass = (Class) pt.getActualTypeArguments()[1];
		convertModelClass = (Class) pt.getActualTypeArguments()[2];
	}

	@PostConstruct
	public void init() {
		service = (GenericService) context.getBean(serviceClass);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		List<K> source = service.getAll();
		TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(modelClass));
		TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(convertModelClass));
		List<K> target = (List<K>) conversionService.convert(source, sourceType, targetType);
		return new ResponseEntity<List<K>>(target, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<K> getById(@PathVariable Long id) {
		K abstr = (K) service.get(id);
		if (abstr == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		K ret = (K) conversionService.convert(abstr,convertModelClass);
		return new ResponseEntity<K>(ret, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createNew(@RequestBody K absModel) {
		T aM = (T) service.save((AbstractModel) conversionService.convert(absModel, modelClass));
		if (aM == null)
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> update(@RequestBody K absModel, @PathVariable Long id) {
		T aM = (T) conversionService.convert(absModel, modelClass);
		aM.setId(id);
		T tc = (T) service.save(aM);
		if (tc == null)
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}
//
//	@RequestMapping("/**")
//	@ResponseBody
//	public ResponseEntity<Void> req() {
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}

}
