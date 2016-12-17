package com.orion10110.training.managertaxi.web.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.TypeCar;
import com.orion10110.training.managertaxi.web.anotation.AutoRegistered;
import com.orion10110.training.managertaxi.web.model.TypeCarEnModel;

@AutoRegistered
@Component
public class TypeCarEnConverter implements Converter<TypeCar, TypeCarEnModel> {

	@Override
	public TypeCarEnModel convert(TypeCar typeCar) {
		TypeCarEnModel enModel = new TypeCarEnModel();
		enModel.setId(typeCar.getId());
		enModel.setType(typeCar.getTypeEn());
		return enModel;
	}

}
