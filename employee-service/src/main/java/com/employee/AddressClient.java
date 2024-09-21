package com.employee;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.employee.entity.Address;

@FeignClient(name = "address-detail", url = "http://localhost:1000")
@RibbonClient(name = "address-service")
public interface AddressClient {
	@GetMapping("/address/detail")
	public ResponseEntity<Address> getAddressDetail();
}
