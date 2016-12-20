package com.orion10110.training.managertaxi.web.conversion;

import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.Discount;
import com.orion10110.training.managertaxi.web.anotation.AutoRegistered;
import com.orion10110.training.managertaxi.web.model.DiscountModel;

@AutoRegistered
@Component
public class DiscountConverter extends TwoWayConverter<Discount, DiscountModel> {

}
