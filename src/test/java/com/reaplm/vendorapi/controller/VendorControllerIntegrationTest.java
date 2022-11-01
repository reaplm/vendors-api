package com.reaplm.vendorapi.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.reaplm.vendorapi.model.Vendor;
import com.reaplm.vendorapi.service.VendorService;


@WebMvcTest(excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class VendorControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private VendorService vendorService;
	
	@Test
	void testGetVendors() throws Exception {
		when(vendorService.getVendors())
			.thenReturn(getVendors());
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("Vendor 1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.[1].name").value("Vendor 2"))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
		verify(vendorService).getVendors();
			
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
