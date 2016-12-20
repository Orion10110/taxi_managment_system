package com.orion10110.training.managertaxi.services.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.UserModel;
/**
 * Хранение токена
 * 
 * @author Калач Артур
 *
 */
@Component
@Scope(value = "request")
public class UserDataToken {
	    private UserModel userModel;
	    public boolean isLoggedIn() {
	        return userModel!=null;
	    }

		public UserModel getUserModel() {
			return userModel;
		}

		public void setUserModel(UserModel userModel) {
			this.userModel = userModel;
		}

}
