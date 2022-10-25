package com.reaplm.vendorapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reaplm.vendorapi.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
	List<Vendor> findAllByCategory(String category);
}
