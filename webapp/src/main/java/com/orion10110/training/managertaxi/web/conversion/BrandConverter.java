package com.orion10110.training.managertaxi.web.conversion;

import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.training.managertaxi.web.anotation.AutoRegistered;
import com.orion10110.training.managertaxi.web.model.BrandModel;

@AutoRegistered
@Component
public class BrandConverter extends TwoWayConverter<Brand, BrandModel> {

}
