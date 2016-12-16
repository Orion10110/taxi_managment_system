package com.orion10110.training.managertaxi.daoapi;

import com.orion10110.taximanager.datamodel.ApplicationUser;;

public interface ApplicationUserDao extends GenericDao<ApplicationUser>{

	ApplicationUser getByName(String name);
	
}
