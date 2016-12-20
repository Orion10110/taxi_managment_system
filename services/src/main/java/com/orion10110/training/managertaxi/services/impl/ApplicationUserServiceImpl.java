package com.orion10110.training.managertaxi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.ApplicationUser;
import com.orion10110.taximanager.datamodel.UserModel;
import com.orion10110.training.managertaxi.daoapi.ApplicationUserDao;
import com.orion10110.training.managertaxi.services.ApplicationUserService;

@Service
public class ApplicationUserServiceImpl extends GenericServiceImpl<ApplicationUser>
		implements ApplicationUserService {
	
	@Autowired
	private void setDao(ApplicationUserDao applicationUserDao) {
		setGenericDao(applicationUserDao);
	}

	/**
	 *  Авторизация пользоавтел
	 *  @see com.orion10110.training.managertaxi.services.ApplicationUserService#validateUserPassword(java.lang.String, java.lang.String)
	 */
	@Override
    public ApplicationUser validateUserPassword(String userName,
            String password) {
		ApplicationUserDao applicationUserDao =(ApplicationUserDao)genericDao;
		ApplicationUser appUser = applicationUserDao.getByName(userName); //Получение пользователя по имени
		if(appUser!=null && password.equals(appUser.getPasswordHash())){
			return appUser;
		}
		return null;
    }
}
