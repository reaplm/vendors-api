package com.reaplm.vendorapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.reaplm.vendorapi.model.Vendor;

@Service
public class VendorService {
	
	public List<Vendor> getVendors(){
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
