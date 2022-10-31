package com.reaplm.vendorapi.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.reaplm.vendorapi.model.Vendor;
import com.reaplm.vendorapi.service.VendorService;


public class VendorControllerTest{

	@Test
	void testGetVendors() {
		VendorService vendorService = Mockito.mock(VendorService.class);
		when(vendorService.getVendors()).thenReturn(getVendors());
		
		VendorController vendorController = new VendorController(vendorService);
		List<Vendor> vendors = vendorController.getVendors();
		
		assertThat(vendors.isEmpty()).isFalse();
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
