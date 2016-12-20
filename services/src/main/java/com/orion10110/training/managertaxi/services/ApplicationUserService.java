package com.orion10110.training.managertaxi.services;

import com.orion10110.taximanager.datamodel.ApplicationUser;

public interface ApplicationUserService extends GenericService<ApplicationUser> {
	/**
	 * Авторизация и получение данных пользователя
	 * @param username имя пользователя
	 * @param password пароль
	 * @return экземпляр пользователя
	 */
	ApplicationUser validateUserPassword(String username, String password);

	boolean accessToChange(String appM);

}
