package com.orion10110.training.managertaxi.services.security;

import com.orion10110.taximanager.datamodel.UserModel;

public interface TokenAuthentication {
	public String create( UserModel user, long ttlMillis);
	
	public UserModel parse(String token);
}
