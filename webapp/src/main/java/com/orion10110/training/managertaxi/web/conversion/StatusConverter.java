package com.orion10110.training.managertaxi.web.conversion;

import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.taximanager.datamodel.Status;
import com.orion10110.training.managertaxi.web.anotation.AutoRegistered;
import com.orion10110.training.managertaxi.web.model.BrandModel;
import com.orion10110.training.managertaxi.web.model.StatusModel;

@AutoRegistered
@Component
public class StatusConverter extends TwoWayConverter<Status, StatusModel> {

}
