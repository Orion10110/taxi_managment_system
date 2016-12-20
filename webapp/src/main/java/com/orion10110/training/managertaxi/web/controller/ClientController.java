package com.orion10110.training.managertaxi.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orion10110.taximanager.datamodel.Client;
import com.orion10110.training.managertaxi.services.ClientService;
import com.orion10110.training.managertaxi.web.model.ClientModel;
@RestController
@RequestMapping("/clients")
public class ClientController extends GenericController<ClientService,Client,ClientModel> {

}
