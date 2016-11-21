package com.orion10110.training.managertaxi.daodb.impl;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.ApplicationUser;
import com.orion10110.training.managertaxi.daoapi.ApplicationUserDao;

@Repository
public class ApplicationUserDaoImpl extends GenericDaoImpl<ApplicationUser> implements ApplicationUserDao {


}
