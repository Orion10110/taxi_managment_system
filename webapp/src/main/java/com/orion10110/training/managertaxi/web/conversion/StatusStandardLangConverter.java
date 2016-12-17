package com.orion10110.training.managertaxi.web.conversion;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.Status;
import com.orion10110.training.managertaxi.web.anotation.AutoRegistered;
import com.orion10110.training.managertaxi.web.model.StatusEnModel;
import com.orion10110.training.managertaxi.web.model.StatusStandardLangModel;

@AutoRegistered
@Component
public class StatusStandardLangConverter implements Converter<Status, StatusStandardLangModel> {

	@Override
	public StatusStandardLangModel convert(Status status) {
		StatusStandardLangModel stModel = new StatusStandardLangModel();
		stModel.setId(status.getId());
		stModel.setStatus(status.getStatus());
		return stModel;
	}

}
