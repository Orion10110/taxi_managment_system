package com.orion10110.training.managertaxi.testobject;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
import com.orion10110.training.managertaxi.services.DiscountService;
import com.orion10110.training.managertaxi.services.DistrictService;
import com.orion10110.training.managertaxi.services.DriverService;
import com.orion10110.training.managertaxi.services.StatusService;
import com.orion10110.training.managertaxi.services.StreetService;
import com.orion10110.training.managertaxi.services.TypeCarService;

@Component
public class TestApplicationContext {

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

	@Bean
	@Scope("prototype")
	public TypeCar typeCar() {
		TypeCar type = new TypeCar();
		type.setType(String.format("TypeTest %s", random.nextInt(512)));
		return type;
	}

	@Bean
	@Scope("prototype")
	public Brand brand() {
		Brand br = new Brand();
		br.setName(String.format("TestBrandName %s", random.nextInt(512)));
		return br;
	}

	@Bean
	@Autowired
	@Scope("prototype")
	public Street street(District district) {
		Long idDistrict = districtService.save(district).getId();
		Street st = new Street();
		st.setName(String.format("TestStreetName %s", random.nextInt(512)));
		st.setIdDistrict(idDistrict);
		return st;
	}

	@Bean
	@Scope("prototype")
	public District district() {
		District ds = new District();
		ds.setName(String.format("TestDistrictName %s",random.nextInt(512)));
		return ds;
	}

	@Bean
	@Scope("prototype")
	public Status status() {
		Status st = new Status();
		st.setStatus(String.format("TestStatus %s",random.nextInt(512)));
		return st;
	}

	@Bean
	@Scope("prototype")
	public Discount discount() {
		Discount ds = new Discount();
		ds.setName(String.format("TestDiscount %s",random.nextInt(512)));
		ds.setDiscountPercent(random.nextInt(99));
		return ds;
	}

	@Bean
	@Autowired
	@Scope("prototype")
	public Car car(TypeCar typeCar, Brand brand) {
		Long idTypeCar = typeCarService.save(typeCar).getId();
		Long idBrand = brandService.save(brand).getId();
		Car cr = new Car();
		cr.setName(String.format("TestNameCar ",random.nextInt(512)));
		cr.setIdBrand(idBrand);
		cr.setIdType(idTypeCar);
		cr.setPlace(random.nextInt(512));
		cr.setStars(random.nextInt(512));
		cr.setActive(random.nextBoolean());
		cr.setGosNumber(String.format("TestNumber ",random.nextInt(512)));
		return cr;
	}

	@Bean
	@Scope("prototype")
	@Autowired
	public Driver driver(Car car, District district) {
		Long idCar = carService.save(car).getId();
		Long idDistrict = districtService.save(district).getId();
		Driver dr = new Driver();
		dr.setSecondName(String.format("TestSName %s",random.nextInt(512)));
		dr.setFirstName(String.format("TestFName %s",random.nextInt(512)));
		dr.setPatronymic(String.format("TestPatr %s",random.nextInt(512)));
		dr.setPhoneNumber(String.format("11-11-11-%s",random.nextInt(512)));
		dr.setIdCar(idCar);
		dr.setIdDistrict(idDistrict);
		LocalDateTime timeL = LocalDateTime.of(2000, random.nextInt(11)+1, random.nextInt(20)+1, random.nextInt(23),
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
		cl.setSecondName(String.format("TestSName %s",random.nextInt(512)));
		cl.setFirstName(String.format("TestFName %s",random.nextInt(512)));
		cl.setPatronymic(String.format("TestPatr %s",random.nextInt(512)));
		cl.setPhoneNumber(String.format("11-11-11-%s",random.nextInt(512)));
		cl.setIdDiscount(idDiscount);
		return cl;
	}

	@Bean
	@Scope("prototype")
	@Autowired
	public Booking booking(ApplicationUser applicationUser, Street street, Client client, Driver driver, Status status) {
		Long idAppUser = applicationUserService.save(applicationUser).getId();
		Long idClient = clientService.save(client).getId();
		Long idDriver = driverService.save(driver).getId();
		Long idStatus = statusService.save(status).getId();
		Long idStreet = streetService.save(street).getId();
		Booking ord = new Booking();
		LocalDateTime timeL = LocalDateTime.of(2000, random.nextInt(11)+1, random.nextInt(20)+1, random.nextInt(23),
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
		ord.setPhoneNumber(String.format("%s10-10-10-",random.nextInt(512)));
		return ord;
	}

	@Bean
	@Scope("prototype")
	@Autowired
	public ApplicationUser applicationUser() {
		ApplicationUser aU = new ApplicationUser();
		aU.setEmail(String.format("%sest@test.com",random.nextInt(1000000)));
		aU.setPasswordHash(String.format("testpassword%s",random.nextInt(1000000)));
		aU.setPhoneNumber(String.format("111-11-11-%s",random.nextInt(1000000)));
		aU.setUserName(String.format("test%s ",random.nextInt(1000000)));
		return aU;
	}

}
