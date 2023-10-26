package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Customer;
import com.cg.serviceImpl.CustomerServiceImpl;

@RestController
@RequestMapping(path="/Customer",produces="application/json")
public class CustomerController {

	@Autowired(required = true)
	private CustomerServiceImpl service;

	@PostMapping("/save")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<>(service.saveCustomer(customer), HttpStatus.CREATED);
	}

	@GetMapping("/allCustomers")
	public List<Customer> getAllCustomers() {
		return service.getAllCustomers();
	}

	@GetMapping("/getByCustomerId/{customerId}")
	public ResponseEntity<Customer> getByCustomerId(@PathVariable int customerId) {
		return new ResponseEntity<>(service.getCustomerById(customerId), HttpStatus.OK);
	}

	@DeleteMapping("/deleteByCustomerId/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int customerId) {
		service.deleteById(customerId);
		return new ResponseEntity<>("customer deleted succesfully", HttpStatus.OK);
	}

	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<>(service.updateCustomer(customer), HttpStatus.OK);
	}

}
