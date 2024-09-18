package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.AddressClient;
import com.employee.entity.Employee;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {

	
	@Autowired
	private AddressClient addressClient; 

	@GetMapping("/detail")
	public ResponseEntity<Employee> getEmployeeDetails(){
		Employee e = new Employee();
		e.setId(1);
		e.setFirstName("Dnyaneshwar");
		e.setLastName("Narwade");
		e.setAddress(addressClient.getAddressDetail().getBody());
		return new ResponseEntity<Employee>( e, HttpStatusCode.valueOf(200));
	}
}
