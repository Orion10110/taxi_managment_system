package com.orion10110.training.managertaxi.web.conversion;

import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.TypeCar;
import com.orion10110.training.managertaxi.web.anotation.AutoRegistered;
import com.orion10110.training.managertaxi.web.model.TypeCarModel;

@AutoRegistered
@Component
public class TypeCarConverter extends TwoWayConverter<TypeCar, TypeCarModel> {

}
