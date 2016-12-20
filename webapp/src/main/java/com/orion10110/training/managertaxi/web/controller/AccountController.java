package com.orion10110.training.managertaxi.web.controller;

import javax.inject.Inject;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orion10110.taximanager.datamodel.ApplicationUser;
import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.taximanager.datamodel.UserModel;
import com.orion10110.training.managertaxi.services.ApplicationUserService;
import com.orion10110.training.managertaxi.services.security.TokenAuthentication;
import com.orion10110.training.managertaxi.web.model.ApplicationUserModel;
import com.orion10110.training.managertaxi.web.model.LoginModel;
import com.orion10110.training.managertaxi.web.security.aspect.AllowAnonymous;
import com.orion10110.training.managertaxi.web.security.aspect.AuthAccess;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Inject
	private ConversionService conversionService;
	
	@Inject
	private ApplicationUserService service;

	@Inject
	private TokenAuthentication tokenAuthentication;
	
	@AllowAnonymous
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> login(@RequestBody LoginModel loginModel) {
		ApplicationUser user=service.validateUserPassword(loginModel.getUserName(), loginModel.getPassword());
		if(user==null){
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		UserModel us =conversionService.convert(user,UserModel.class);
		String usToken = tokenAuthentication.create( us, 3600*60*5);
		responseHeaders.set("Authorization", "Bearer " + usToken);
		return new ResponseEntity<Void>(responseHeaders,HttpStatus.OK);
	}
	
	
	
	
	@AuthAccess
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody ApplicationUserModel appM) {
		if(!service.accessToChange(appM.getUserName())) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		ApplicationUser aM = service.save(conversionService.convert(appM, ApplicationUser.class));
		if (aM == null)
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	@AuthAccess
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> update(@RequestBody ApplicationUserModel appM, @PathVariable Long id) {
		if(!service.accessToChange(appM.getUserName())) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		ApplicationUser aM = conversionService.convert(appM, ApplicationUser.class);
		aM.setId(id);
		ApplicationUser tc = service.save(aM);
		if (tc == null)
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}
	
	
}
