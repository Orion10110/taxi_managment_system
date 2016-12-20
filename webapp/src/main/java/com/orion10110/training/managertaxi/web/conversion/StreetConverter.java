package com.orion10110.training.managertaxi.web.conversion;

import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.Street;
import com.orion10110.training.managertaxi.web.anotation.AutoRegistered;
import com.orion10110.training.managertaxi.web.model.StreetModel;

@AutoRegistered
@Component
public class StreetConverter extends TwoWayConverter<Street, StreetModel> {

}
