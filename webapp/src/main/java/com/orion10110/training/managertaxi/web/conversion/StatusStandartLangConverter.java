package com.orion10110.training.managertaxi.web.conversion;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.Status;
import com.orion10110.training.managertaxi.web.anotation.AutoRegistered;
import com.orion10110.training.managertaxi.web.model.StatusEnModel;
import com.orion10110.training.managertaxi.web.model.StatusStandartLangModel;

@AutoRegistered
@Component
public class StatusStandartLangConverter implements Converter<Status, StatusStandartLangModel> {

	@Override
	public StatusStandartLangModel convert(Status status) {
		StatusStandartLangModel stModel = new StatusStandartLangModel();
		stModel.setId(status.getId());
		stModel.setStatus(status.getStatus());
		return stModel;
	}

}
