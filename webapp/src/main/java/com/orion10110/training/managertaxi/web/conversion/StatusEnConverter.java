package com.orion10110.training.managertaxi.web.conversion;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.Status;
import com.orion10110.training.managertaxi.web.anotation.AutoRegistered;
import com.orion10110.training.managertaxi.web.model.StatusEnModel;

@AutoRegistered
@Component
public class StatusEnConverter implements Converter<Status, StatusEnModel> {

	@Override
	public StatusEnModel convert(Status status) {
		StatusEnModel enModel = new StatusEnModel();
		enModel.setId(status.getId());
		enModel.setStatus(status.getStatusEn());
		return enModel;
	}

}
