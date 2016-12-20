package com.orion10110.training.managertaxi.web.conversion;

import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.District;
import com.orion10110.training.managertaxi.web.anotation.AutoRegistered;
import com.orion10110.training.managertaxi.web.model.DistrictModel;

@AutoRegistered
@Component
public class DistrictConverter extends TwoWayConverter<District, DistrictModel> {

}
