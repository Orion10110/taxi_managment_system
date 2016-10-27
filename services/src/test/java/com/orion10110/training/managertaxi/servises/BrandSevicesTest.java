package com.orion10110.training.managertaxi.servises;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orion10110.taximanager.datamodel.Brand;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class BrandSevicesTest {
	
	@Inject
	private BrandSevices brandSevices;
	
	@Test
    public void getByIdTest() {
        Brand brand = brandSevices.get(1l);

        Assert.assertNotNull("brand for id=1 should not be null", brand);
        Assert.assertEquals(new Long(1), brand.getId());
    }
	
	@Test
    public void saveBrendTest() {
        Brand brand = new Brand();
        brand.setName("test title");

        Long id = brandSevices.save(brand);

        Assert.assertNotNull(id);

        Brand  brandFromDb = brandSevices.get(id);

        Assert.assertEquals(brand.getName(), brandFromDb.getName());
    }
	
}
