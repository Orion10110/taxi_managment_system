package com.orion10110.training.managertaxi.daodb.impl;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.ApplicationUser;
import com.orion10110.training.managertaxi.daodb.ApplicationUserDao;

@Repository
public class ApplicationUserDaoImpl extends GenericDaoImpl<ApplicationUser,Long> implements ApplicationUserDao {

	@Override
	protected String getSqlInsert() {
		return "insert into application_user (email,email_confirmed,password_hash,phone_number,"
				+ "phone_number_confirmed,user_name) values(:email,:emailConfirmed,:passwordHash,:phoneNumber,"
				+ ":phoneNumberConfirmed,:userName)";
	}

	@Override
	protected String getSqlUpdate() {
		return "update application_user set email=:email,email_confirmed=:emailConfirmed,password_hash=:passwordHash,"
				+ "phoneNumber=:phoneNumber, phone_number_confirmed=:phoneNumberVonfirmed,user_name=:user_name where id=:id";
	}

	@Override
	protected String getTable() {
		return "application_user";
	}

	

}
