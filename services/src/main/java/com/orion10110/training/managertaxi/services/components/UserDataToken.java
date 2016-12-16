package com.orion10110.training.managertaxi.services.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.UserModel;

@Component
@Scope(value = "request")
public class UserDataToken {
	    private boolean isLoggedIn;
	 	
	    private UserModel userModel;
	    public boolean isLoggedIn() {
	        return isLoggedIn;
	    }

	    public void setLoggedIn(boolean isLoggedIn) {
	        this.isLoggedIn = isLoggedIn;
	    }

		public UserModel getUserModel() {
			return userModel;
		}

		public void setUserModel(UserModel userModel) {
			this.userModel = userModel;
		}

}
