package com.address.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.address.entity.Address;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@GetMapping("/detail")
	public ResponseEntity<Address> getAddressDetail(){
		Address a = new Address();
		a.setId(100);
		a.setPinCode("320012");
		a.setStreet("pune");
		return new ResponseEntity<Address>(a, HttpStatusCode.valueOf(200));
	}

}
