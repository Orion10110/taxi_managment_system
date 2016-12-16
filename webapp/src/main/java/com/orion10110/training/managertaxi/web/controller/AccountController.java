package com.orion10110.training.managertaxi.web.controller;

import javax.inject.Inject;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orion10110.taximanager.datamodel.ApplicationUser;
import com.orion10110.taximanager.datamodel.UserModel;
import com.orion10110.training.managertaxi.services.ApplicationUserService;
import com.orion10110.training.managertaxi.web.model.LoginModel;
import com.orion10110.training.managertaxi.web.security.JwtAuthentication;
import com.orion10110.training.managertaxi.web.security.aspect.AllowAnonymous;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Inject
	private ConversionService conversionService;
	
	@Inject
	private ApplicationUserService service;

	@Inject
	private JwtAuthentication jwtAuthentication;
	
	@AllowAnonymous
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> login(@RequestBody LoginModel loginModel) {
		ApplicationUser user=service.validateUserPassword(loginModel.getUserName(), loginModel.getPassword());
		if(user==null){
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		UserModel us =conversionService.convert(user,UserModel.class);
		String usToken = jwtAuthentication.createJWT( us, 3600*60*5);
		responseHeaders.set("Authorization", "Bearer " + usToken);
		return new ResponseEntity<Void>(responseHeaders,HttpStatus.OK);
	}
}
