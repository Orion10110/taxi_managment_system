package com.orion10110.training.managertaxi.services.impl;

import org.springframework.stereotype.Service;

import com.orion10110.training.managertaxi.services.AuthenticationService;
@Service
public class AuthenticationServiceImpl implements AuthenticationService{
	
	@Override
    public boolean validateUserPassword(String username,
            String password) {
        // TODO DAO query
        return username.equals("validuser")
                && password.equals("validpassword");
    }
}
