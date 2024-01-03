package com.ait.service;

import java.util.List;

import com.ait.entity.Customer;

public interface CustomerService {

	public Customer getById(Integer customerId);
	
	public List<Customer> getAllCustomers();
	
	public String deleteById(Integer customerId);
	
	//for insert n update, 2 operations using one method
	public String upsert(Customer customer);
}
