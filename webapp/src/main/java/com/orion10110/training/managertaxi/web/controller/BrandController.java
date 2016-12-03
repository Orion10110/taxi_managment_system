package com.orion10110.training.managertaxi.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.training.managertaxi.services.BrandService;
import com.orion10110.training.managertaxi.web.model.BrandModel;

@RestController
@RequestMapping("/brands")
public class BrandController {
	@Inject
	private BrandService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<BrandModel>> getAll(){
		List<Brand> all = service.getAll();
		ArrayList<BrandModel> converted = new ArrayList<>();
		for (Brand brand : all) {
			converted.add(entity2model(brand));
		}
		
		  return new ResponseEntity<List<BrandModel>>(converted,
	                HttpStatus.OK);
	}
	
	
	 @RequestMapping(value = "/{brandId}", method = RequestMethod.GET)
	    public ResponseEntity<BrandModel> getById(@PathVariable Long brandId) {
	        Brand brand = service.get(brandId);
	        return new ResponseEntity<BrandModel>(entity2model(brand), HttpStatus.OK);
	    }

	    @RequestMapping(method = RequestMethod.POST)
	    public ResponseEntity<Void> createNewAuthor(@RequestBody BrandModel brandModel) {
	        service.save(model2entity(brandModel));
	        return new ResponseEntity<Void>(HttpStatus.CREATED);

	    }

	    @RequestMapping(value = "/{brandId}", method = RequestMethod.POST)
	    public ResponseEntity<Void> updateAuthor(@RequestBody BrandModel brandModel, @PathVariable Long brandId) {
	        Brand brand = model2entity(brandModel);
	        brand.setId(brandId);
	        service.save(brand);
	        return new ResponseEntity<Void>(HttpStatus.OK);

	    }

	    @RequestMapping(value = "/{brandId}", method = RequestMethod.DELETE)
	    public ResponseEntity<Void> delete(@PathVariable Long brandId) {
	        service.delete(brandId);
	        return new ResponseEntity<Void>(HttpStatus.OK);

	    }
	
	    private Brand model2entity(BrandModel brandModel) {
	        Brand e = new Brand();
	        e.setName(brandModel.getName());
	        e.setId(brandModel.getId());
	        return e;
	    }
	    
	private BrandModel entity2model(Brand brand) {
		BrandModel e = new BrandModel();
		e.setId(brand.getId());
        e.setName(brand.getName());
        return e;
    }

	

}


