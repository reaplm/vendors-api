package com.reaplm.vendorapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reaplm.vendorapi.model.Vendor;
import com.reaplm.vendorapi.repository.VendorRepository;

@Service
public class VendorService {
	
	private VendorRepository vendorRepository;
	
	public VendorService(VendorRepository vendorRepository) {
		this.vendorRepository = vendorRepository;
	}
	
	public List<Vendor> getVendors(){
		 
		return vendorRepository.findAll();
	}

}
