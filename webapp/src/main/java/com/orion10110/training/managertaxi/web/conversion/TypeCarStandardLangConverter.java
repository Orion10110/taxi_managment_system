package com.orion10110.training.managertaxi.web.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.Status;
import com.orion10110.taximanager.datamodel.TypeCar;
import com.orion10110.training.managertaxi.web.anotation.AutoRegistered;
import com.orion10110.training.managertaxi.web.model.StatusStandardLangModel;
import com.orion10110.training.managertaxi.web.model.TypeCarStandardLangModel;

@AutoRegistered
@Component
public class TypeCarStandardLangConverter implements Converter<TypeCar, TypeCarStandardLangModel> {

	@Override
	public TypeCarStandardLangModel convert(TypeCar typeCar) {
		TypeCarStandardLangModel stModel = new TypeCarStandardLangModel();
		stModel.setId(typeCar.getId());
		stModel.setType(typeCar.getType());
		return stModel;
	}

}
