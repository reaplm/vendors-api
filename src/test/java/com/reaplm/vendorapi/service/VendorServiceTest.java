package com.reaplm.vendorapi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.reaplm.vendorapi.model.Vendor;
import com.reaplm.vendorapi.repository.VendorRepository;

public class VendorServiceTest {
	
	@Test
	void testGetVendors() {
		VendorRepository vendorRepository = Mockito.mock(VendorRepository.class);
		when(vendorRepository.findAll()).thenReturn(getVendors());
		
		VendorService vendorService = new VendorService(vendorRepository);
		var vendors = vendorService.getVendors();
		
		assertThat(vendors.size()).isEqualTo(2);
	}
	private List<Vendor> getVendors(){
		List<Vendor> vendors = new ArrayList<>();
		vendors.add(
				Vendor.builder()
					.name("Vendor 1")
					.location("Gaborone")
					.build()
				);
		vendors.add(
				Vendor.builder()
					.name("Vendor 2")
					.location("Mogoditshane")
					.build()
				);
		return vendors;
	}

}
