package com.reaplm.vendorapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
public class VendorControllerAcceptanceTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void testGetVendors() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("Vendor 1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.[1].name").value("Vendor 2"))
				.andExpect(MockMvcResultMatchers.status().isOk());

			
	}

}
