package com.orion10110.training.managertaxi.daodb;

import java.util.List;

import com.orion10110.taximanager.datamodel.ApplicationUser;;

public interface ApplicationUserDao {
	ApplicationUser get(Long id);

    void insert(ApplicationUser entity);

    void update(ApplicationUser entity);

    void delete(Long id);

    List<ApplicationUser> getAll();
}
