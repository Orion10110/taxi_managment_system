package com.orion10110.training.managertaxi.daoxml.impl;

import org.springframework.stereotype.Repository;

import com.orion10110.taximanager.datamodel.ApplicationUser;
import com.orion10110.training.managertaxi.daoapi.ApplicationUserDao;

@Repository
public class ApplicationUserDaoXmlImpl extends GenericDaoXmlImpl<ApplicationUser> implements ApplicationUserDao {

}
