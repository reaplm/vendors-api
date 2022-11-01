package com.reaplm.vendorapi.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.reaplm.vendorapi.model.Vendor;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VendorRepositoryTest {
	
	@Autowired
	VendorRepository repository;
	

	@Test
	@Order(1)
	@Rollback(value = false)
	void testSave() {
		Vendor vendor = Vendor.builder()
				.location("Gaborone")
				.name("Noname VEndor")
				.build();
				
		var savedVendor = repository.save(vendor);
	
		
		assertThat(savedVendor).isNotNull();
		assertThat(savedVendor.getLocation()).isEqualTo("Gaborone");
		assertThat(savedVendor.getName()).isEqualTo("Noname VEndor");
	}
	
	@Test
	@Order(2)
	@Rollback(value = false)
	void testGetById() {
		Vendor vendor = repository.findById(1).get();
		
		assertThat(vendor).isNotNull();
		assertThat(vendor.getId()).isEqualTo(1);
	}

	@Test
	@Order(3)
	@Rollback(value = false)
	void testUpdate() {
		Vendor vendor = repository.findById(1).get();
		
		vendor.setName("Vendor 3");
		var updatedVendor = repository.save(vendor);
		
		assertThat(updatedVendor.getName()).isEqualTo("Vendor 3");
		
	}
	
	@Test
	@Order(4)
	@Rollback(value = false)
	void testFindAll() {
		Vendor vendor = Vendor.builder()
				.name("vendor 2")
				.location("Mogoditshane")
				.build();
		
		Vendor savedVendor = repository.save(vendor);
		
		var vendors = repository.findAll();
		
		assertThat(vendors.size()).isEqualTo(2);
	}
	
	@Test
	@Order(5)
	@Rollback(value = false)
	void testDeleteById() {
		repository.deleteById(1);
		
		List<Vendor> vendors = repository.findAll();
		
		assertThat(vendors.size()).isEqualTo(1);
		assertThrows( NoSuchElementException.class, () -> repository.findById(1).get());
	}

	@Test
	@Order(6)
	@Rollback(value = false)
	void testDelete() {
		repository.deleteAll();
		
		List<Vendor> vendors = repository.findAll();
		
		assertThat(vendors.size()).isEqualTo(0);	
	}
	
	

}
