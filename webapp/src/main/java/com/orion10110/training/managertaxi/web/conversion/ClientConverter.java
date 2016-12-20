package com.orion10110.training.managertaxi.web.conversion;

import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.Client;
import com.orion10110.training.managertaxi.web.anotation.AutoRegistered;
import com.orion10110.training.managertaxi.web.model.ClientModel;

@AutoRegistered
@Component
public class ClientConverter extends TwoWayConverter<Client, ClientModel> {

}
