package com.orion10110.training.managertaxi.services.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.orion10110.taximanager.datamodel.ApplicationUser;
import com.orion10110.training.managertaxi.daoapi.ApplicationUserDao;
import com.orion10110.training.managertaxi.services.ApplicationUserService;
import com.orion10110.training.managertaxi.services.aspect.ListCachePut;
import com.orion10110.training.managertaxi.services.components.UserDataToken;

@Service
public class ApplicationUserServiceImpl extends GenericServiceImpl<ApplicationUser>
		implements ApplicationUserService {
	
	@Value("${key.auth}")
	private String key;
	@Inject
	private ApplicationContext context;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationUserServiceImpl.class);
	
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
		ApplicationUser appUser;
		try{
			appUser = applicationUserDao.getByName(userName); //Получение пользователя по имени
		}catch(EmptyResultDataAccessException e){
			LOGGER.error("Exeption EmptyResultDataAccessException. Message: {}", e.getMessage());
			return null;
		}
		if(appUser!=null && password.equals(appUser.getPasswordHash())){
			return appUser;
		}
		return null;
    }
	
	@Override
	public boolean accessToChange(String appM){
		UserDataToken userDataToken = context.getBean(UserDataToken.class);
		if (appM.equals(userDataToken.getUserModel().getUserName()) || userDataToken.getUserModel().getRole()=="Admin") {
			return true;
		}
		return false;
		
	}
	
	
	private String hashKey(String pass){
		byte[] bytesOfMessage = null;
		pass+=key;
		try {
			bytesOfMessage = pass.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] thedigest = md.digest(bytesOfMessage);
		return thedigest.toString();
	}
	
	
	
	@Override
	@ListCachePut(value = "dbCache")
	public ApplicationUser save(ApplicationUser entity) {
		try {
			if (entity.getId() == null) {
				entity.setId((Long) genericDao.insert(entity));
				String pass=this.hashKey(entity.getPasswordHash());
				entity.setPasswordHash(pass);
				LOGGER.info("Create. id={}, class={}", entity.getId(), entity.getClass().getName());
				return entity;
			} else {
				String pass=this.hashKey(entity.getPasswordHash());
				entity.setPasswordHash(pass);
				genericDao.update(entity);
				LOGGER.info("Update. id={}, class={}", entity.getId(), entity.getClass().getName());
				return entity;
			}
		} catch (DuplicateKeyException e) {
			LOGGER.error("Exeption DuplicateKeyExeption. Message: {}", e.getMessage());
			return null;
		} catch (DataIntegrityViolationException e) {
			LOGGER.error("Exeption DataIntegrityViolationException. Message: {}", e.getMessage());
			return null;
		}

	}
	
}
