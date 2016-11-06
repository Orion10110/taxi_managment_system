package com.orion10110.training.managertaxi.testobject;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.orion10110.taximanager.datamodel.ApplicationUser;
import com.orion10110.taximanager.datamodel.Brand;
import com.orion10110.taximanager.datamodel.Car;
import com.orion10110.taximanager.datamodel.Client;
import com.orion10110.taximanager.datamodel.Discount;
import com.orion10110.taximanager.datamodel.District;
import com.orion10110.taximanager.datamodel.Driver;
import com.orion10110.taximanager.datamodel.Booking;
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

@Configuration
public class TestApplicationContext {

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
	public TypeCar typeCar() {
		TypeCar type = new TypeCar();
		type.setType("TypeTest");
		return type;
	}

	@Bean
	public Brand brand() {
		Brand br = new Brand();
		br.setName("TestBrandName");
		return br;
	}

	@Bean
	@Autowired
	public Street street(District district) {
		Long idDistrict = districtService.save(district);
		Street st = new Street();
		st.setName("TestStreetName");
		st.setIdDistrict(idDistrict);
		return st;
	}

	@Bean
	public District district() {
		District ds = new District();
		ds.setName("TestDistrictName");
		return ds;
	}

	@Bean
	public Status status() {
		Status st = new Status();
		st.setStatus("TestStatus");
		return st;
	}

	@Bean
	public Discount discount() {
		Discount ds = new Discount();
		ds.setName("TestDiscount");
		ds.setDiscountPercent(10);
		return ds;
	}

	@Bean
	@Autowired
	public Car car(TypeCar typeCar, Brand brand) {
		Long idTypeCar = typeCarService.save(typeCar);
		Long idBrand = brandService.save(brand);
		Car cr = new Car();
		cr.setName("TestNameCar");
		cr.setIdBrand(idBrand);
		cr.setIdType(idTypeCar);
		cr.setPlace(5);
		cr.setStars(5);
		cr.setActive(true);
		cr.setGosNumber("TestNumber");
		return cr;
	}

	@Bean
	@Autowired
	public Driver driver(Car car, District district) {
		Long idCar = carService.save(car);
		Long idDistrict = districtService.save(district);
		Driver dr = new Driver();
		dr.setSecondName("TestSName");
		dr.setFirstName("TestFName");
		dr.setPatronymic("TestPatr");
		dr.setPhoneNumber("11-11-11");
		dr.setIdCar(idCar);
		dr.setIdDistrict(idDistrict);
		LocalDateTime timeL = LocalDateTime.of(1990, 10, 12, 23, 33, 10);
		Timestamp timestamp = Timestamp.valueOf(timeL);
		dr.setDateOfBirth(timestamp);
		dr.setDateOfEmployment(timestamp);
		dr.setCategory(5);
		return dr;
	}

	@Bean
	@Autowired
	public Client client(Discount discount) {
		Long idDiscount = discountService.save(discount);
		Client cl = new Client();
		cl.setSecondName("TestSName");
		cl.setFirstName("TestFName");
		cl.setPatronymic("TestPatr");
		cl.setPhoneNumber("11-11-11");
		cl.setIdDiscount(idDiscount);
		return cl;
	}

	@Bean
	@Autowired
	public Booking booking(ApplicationUser applicationUser, Street street, Client client, Driver driver, Status status) {
		Long idAppUser = applicationUserService.save(applicationUser);
		Long idClient = clientService.save(client);
		Long idDriver = driverService.save(driver);
		Long idStatus = statusService.save(status);
		Long idStreet = streetService.save(street);
		Booking ord = new Booking();
		LocalDateTime loc = LocalDateTime.of(2003,10,10,03,30,30);
		Timestamp timestamp = Timestamp.valueOf(loc);
		ord.setDateOrder(timestamp);
		ord.setEndValue(200);
		ord.setStartValue(100);
		ord.setIdApplicationUser(idAppUser);
		ord.setIdClient(idClient);
		ord.setIdDriver(idDriver);
		ord.setIdStatus(idStatus);
		ord.setIdStreetFrom(idStreet);
		ord.setIdStreetTo(idStreet);
		ord.setPhoneNumber("10-10-10");
		return ord;
	}

	@Bean
	@Autowired
	public ApplicationUser applicationUser() {
		ApplicationUser aU = new ApplicationUser();
		aU.setEmail("test@test.com");
		aU.setEmailConfirmed(true);
		aU.setPasswordHash("testpassword");
		aU.setPhoneNumber("111-11-11");
		aU.setPhoneNumberConfirmed(false);
		aU.setUserName("test");
		return aU;
	}

}
