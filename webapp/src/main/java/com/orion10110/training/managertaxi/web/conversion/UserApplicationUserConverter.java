package com.orion10110.training.managertaxi.web.conversion;

import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.ApplicationUser;
import com.orion10110.taximanager.datamodel.UserModel;
import com.orion10110.training.managertaxi.web.anotation.AutoRegistered;

@AutoRegistered
@Component
public class UserApplicationUserConverter  extends TwoWayConverter<ApplicationUser, UserModel>{

}
