package com.orion10110.training.managertaxi.services;

import com.orion10110.taximanager.datamodel.ApplicationUser;
import com.orion10110.taximanager.datamodel.UserModel;

public interface ApplicationUserService extends GenericService<ApplicationUser> {

	ApplicationUser validateUserPassword(String username, String password);

}
