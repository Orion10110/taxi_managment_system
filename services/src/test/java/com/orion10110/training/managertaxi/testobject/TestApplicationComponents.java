package com.orion10110.training.managertaxi.testobject;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.AbstractModel;
import com.orion10110.taximanager.datamodel.ApplicationUser;
import com.orion10110.taximanager.datamodel.Booking;
import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.taximanager.datamodel.Car;
import com.orion10110.taximanager.datamodel.Client;
import com.orion10110.taximanager.datamodel.Discount;
import com.orion10110.taximanager.datamodel.District;
import com.orion10110.taximanager.datamodel.Driver;
import com.orion10110.taximanager.datamodel.Status;
import com.orion10110.taximanager.datamodel.Street;
import com.orion10110.taximanager.datamodel.TypeCar;
import com.orion10110.training.managertaxi.services.ApplicationUserService;
import com.orion10110.training.managertaxi.services.BrandService;
import com.orion10110.training.managertaxi.services.CarService;
import com.orion10110.training.managertaxi.services.ClientService;
import com.orion10110.training.managertaxi.services.CrudTest;
import com.orion10110.training.managertaxi.services.DiscountService;
import com.orion10110.training.managertaxi.services.DistrictService;
import com.orion10110.training.managertaxi.services.DriverService;
import com.orion10110.training.managertaxi.services.StatusService;
import com.orion10110.training.managertaxi.services.StreetService;
import com.orion10110.training.managertaxi.services.TypeCarService;

@Component
public class TestApplicationComponents {

	private Random random = new Random();

	@Inject
	private DistrictService districtService;

	@Inject
	private TypeCarService typeCarService;

	@Inject
	private BrandService brandService;

	@Inject
	private CarService carService;

	@Inject
	private DiscountService discountService;

	@Inject
	private StreetService streetService;

	@Inject
	private ClientService clientService;

	@Inject
	private ApplicationUserService applicationUserService;

	@Inject
	private DriverService driverService;

	@Inject
	private StatusService statusService;

	private long getLastId(List list){
		Long k=1l;
		if (list.size() != 0) {
			AbstractModel item = (AbstractModel) list.get(list.size() - 1);
			k = item.getId() + 1;
		}
		return k;
	}
	
	
	@Bean
	@Scope("prototype")
	public TypeCar typeCar() {
		Long k=getLastId(typeCarService.getAll());
		TypeCar type = new TypeCar();
		type.setType(String.format("TypeTest %st%s", k,CrudTest.getAddValue()));
		return type;
	}

	@Bean
	@Scope("prototype")
	public Brand brand() {
		Long k=getLastId(brandService.getAll());
		Brand br = new Brand();
		br.setName(String.format("TestBrandName %st%s", k,CrudTest.getAddValue()));
		return br;
	}

	@Bean
	@Autowired
	@Scope("prototype")
	public Street street(District district) {
		Long k=getLastId(streetService.getAll());
		Long idDistrict = districtService.save(district).getId();
		Street st = new Street();
		st.setName(String.format("TestStreetName %st%s", k,CrudTest.getAddValue()));
		st.setIdDistrict(idDistrict);
		return st;
	}

	@Bean
	@Scope("prototype")
	public District district() {
		Long k=getLastId(districtService.getAll());
		District ds = new District();
		ds.setName(String.format("TestDistrictName %st%s", k,CrudTest.getAddValue()));
		return ds;
	}

	@Bean
	@Scope("prototype")
	public Status status() {
		Long k=getLastId(statusService.getAll());
		Status st = new Status();
		st.setStatus(String.format("TestStatus %st%s", k,CrudTest.getAddValue()));
		return st;
	}

	@Bean
	@Scope("prototype")
	public Discount discount() {
		Long k=getLastId(discountService.getAll());
		Discount ds = new Discount();
		ds.setName(String.format("TestDiscount %st%s", k,CrudTest.getAddValue()));
		ds.setDiscountPercent(random.nextInt(99));
		return ds;
	}

	@Bean
	@Autowired
	@Scope("prototype")
	public Car car(TypeCar typeCar, Brand brand) {
		Long k=getLastId(carService.getAll());
		Long idTypeCar = typeCarService.save(typeCar).getId();
		Long idBrand = brandService.save(brand).getId();
		Car cr = new Car();
		cr.setName(String.format("TestNameCar ", k));
		cr.setIdBrand(idBrand);
		cr.setIdType(idTypeCar);
		cr.setPlace(k.intValue());
		cr.setStars(k.intValue());
		cr.setActive(random.nextBoolean());
		cr.setGosNumber(String.format("TestNumber %st%s", k,CrudTest.getAddValue()));
		return cr;
	}

	@Bean
	@Scope("prototype")
	@Autowired
	public Driver driver(Car car, District district) {
		Long k=getLastId(driverService.getAll());
		Long idCar = carService.save(car).getId();
		Long idDistrict = districtService.save(district).getId();
		Driver dr = new Driver();
		dr.setSecondName(String.format("TestSName %s", k));
		dr.setFirstName(String.format("TestFName %s", k));
		dr.setPatronymic(String.format("TestPatr %s", k));
		dr.setPhoneNumber(String.format("11-11-11-%s", k));
		dr.setIdCar(idCar);
		dr.setIdDistrict(idDistrict);
		LocalDateTime timeL = LocalDateTime.of(2000, random.nextInt(11) + 1, random.nextInt(20) + 1, random.nextInt(23),
				random.nextInt(59), 10);
		Timestamp timestamp = Timestamp.valueOf(timeL);
		dr.setDateOfBirth(timestamp);
		dr.setDateOfEmployment(timestamp);
		dr.setCategory(random.nextInt(10));
		return dr;
	}

	@Bean
	@Scope("prototype")
	@Autowired
	public Client client(Discount discount) {
		Long idDiscount = discountService.save(discount).getId();
		Client cl = new Client();
		cl.setSecondName(String.format("TestSName %s", random.nextInt(512)));
		cl.setFirstName(String.format("TestFName %s", random.nextInt(512)));
		cl.setPatronymic(String.format("TestPatr %s", random.nextInt(512)));
		cl.setPhoneNumber(String.format("11-11-11-%s", random.nextInt(512)));
		cl.setIdDiscount(idDiscount);
		return cl;
	}

	@Bean
	@Scope("prototype")
	@Autowired
	public Booking booking(ApplicationUser applicationUser, Street street, Client client, Driver driver,
			Status status) {
		Long idAppUser = applicationUserService.save(applicationUser).getId();
		Long idClient = clientService.save(client).getId();
		Long idDriver = driverService.save(driver).getId();
		Long idStatus = statusService.save(status).getId();
		Long idStreet = streetService.save(street).getId();
		Booking ord = new Booking();
		LocalDateTime timeL = LocalDateTime.of(2000, random.nextInt(11) + 1, random.nextInt(20) + 1, random.nextInt(23),
				random.nextInt(59), 10);
		Timestamp timestamp = Timestamp.valueOf(timeL);
		ord.setDateOrder(timestamp);
		ord.setEndValue(random.nextInt(512));
		ord.setStartValue(random.nextInt(512));
		ord.setIdApplicationUser(idAppUser);
		ord.setIdClient(idClient);
		ord.setIdDriver(idDriver);
		ord.setIdStatus(idStatus);
		ord.setIdStreetFrom(idStreet);
		ord.setIdStreetTo(idStreet);
		ord.setPhoneNumber(String.format("%s10-10-10-", random.nextInt(512)));
		return ord;
	}

	@Bean
	@Scope("prototype")
	public ApplicationUser applicationUser() {
		Long k=getLastId(applicationUserService.getAll());
		ApplicationUser aU = new ApplicationUser();
		aU.setEmail(String.format("%sest@test.com %s", k,CrudTest.getAddValue()));
		aU.setPasswordHash(String.format("testpassword%st%s", k,CrudTest.getAddValue()));
		aU.setPhoneNumber(String.format("111-11-11-%st%s", k,CrudTest.getAddValue()));
		aU.setUserName(String.format("test%s t%s", k, CrudTest.getAddValue()));
		return aU;
	}

}
