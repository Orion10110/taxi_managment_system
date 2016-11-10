package com.orion10110.training.managertaxi.daodb.impl;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.ApplicationUser;
import com.orion10110.training.managertaxi.daodb.ApplicationUserDao;

@Repository
public class ApplicationUserDaoImpl extends GenericDaoImpl<ApplicationUser, Long> implements ApplicationUserDao {

	@Override
	protected String getSqlInsert() {
		String insert = String.format("insert into application_user (%s)  values(%s) ",
				"email,email_confirmed,password_hash,phone_number,phone_number_confirmed,user_name",
				":email,:emailConfirmed,:passwordHash,:phoneNumber,:phoneNumberConfirmed,:userName");
		return insert;
	}

	@Override
	protected String getSqlUpdate() {
		String update = String.format("update application_user set %s %s",
				"email=:email,email_confirmed=:emailConfirmed,password_hash=:passwordHash,phone_number=:phoneNumber,",
				"phone_number_confirmed=:phoneNumberConfirmed,user_name=:userName where id=:id");
		return update;
	}

	@Override
	protected String getTable() {
		return "application_user";
	}

}
