package com.reaplm.vendorapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reaplm.vendorapi.model.Vendor;
import com.reaplm.vendorapi.service.VendorService;

@RestController
public class VendorController{
	
	@Autowired
	private VendorService vendorService;
	
	public VendorController(VendorService vendorService) {
		this.vendorService = vendorService;
	}
	@GetMapping(value = "/")
	public List<Vendor> getVendors(){
		return vendorService.getVendors();
	}
	
}
