package com.orion10110.training.managertaxi.daodb.impl;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.ApplicationUser;
import com.orion10110.training.managertaxi.daoapi.ApplicationUserDao;
import com.orion10110.training.managertaxi.daodb.util.GenerateSql;

@Repository
public class ApplicationUserDaoImpl extends GenericDaoImpl<ApplicationUser> implements ApplicationUserDao {
	@Override
	public ApplicationUser getByName(String name) {
		return (ApplicationUser)jdbcTemplate.queryForObject("Select * from application_user where user_name=?",
				new Object[] { name },
				getRowMapper());
	}


}
