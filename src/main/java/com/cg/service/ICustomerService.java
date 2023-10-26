package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entities.Customer;

@Service
public interface ICustomerService {
	Customer saveCustomer(Customer customer);
	List<Customer> getAllCustomers();
	Customer getCustomerById(int customerId);
	Customer updateCustomer(Customer customer);
	void deleteById(int customerId);
	
}
