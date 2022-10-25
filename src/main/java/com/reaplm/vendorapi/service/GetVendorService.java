package com.reaplm.vendorapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reaplm.vendorapi.repository.VendorRepository;

@Service
public class GetVendorService {
	
	
	private final VendorRepository vendorRepository;
	
	@Autowired
	public GetVendorService(VendorRepository vendorRepository) {
		this.vendorRepository = vendorRepository;
	}

}
