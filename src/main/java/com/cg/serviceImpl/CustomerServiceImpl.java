package com.cg.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Customer;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.ICustomerRepository;
import com.cg.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository repository;

	@Override
	public Customer saveCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return repository.findAll();
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return repository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Record not found with customerId: ", customerId));
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer customerNew = repository.findById(customer.getCustomerId()).orElseThrow(
				() -> new ResourceNotFoundException("Record not found with customerId: ", customer.getCustomerId()));
		customerNew = Customer.builder().customerId(customer.getCustomerId())
				.customerAddress(customer.getCustomerAddress()).customerName(customer.getCustomerName())
				.phoneNo(customer.getPhoneNo()).pinCode(customer.getPinCode()).landlineNo(customer.getLandlineNo())
				.build();
		repository.save(customerNew);
		return null;
	}

	@Override
	public void deleteById(int customerId) {
		repository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found with customerId: ", customerId));
		repository.deleteById(customerId);

	}

}
