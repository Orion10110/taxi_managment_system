package com.orion10110.training.managertaxi.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orion10110.training.managertaxi.services.components.UserDataStorage;
import com.orion10110.training.managertaxi.web.model.BrandModel;

@RestController
@RequestMapping("/basicAuthSecured")
public class SampleController {
    @Inject
    private ApplicationContext context;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<BrandModel>> getAll() {
        UserDataStorage userDataStorage = context.getBean(UserDataStorage.class);
        System.out.println("SampleController:" + userDataStorage);
        return new ResponseEntity<List<BrandModel>>(new ArrayList<>(), HttpStatus.OK);
    }

}