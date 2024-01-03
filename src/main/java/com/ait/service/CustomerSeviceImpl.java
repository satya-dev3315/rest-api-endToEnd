package com.ait.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.entity.Customer;
import com.ait.repo.CustomerRepo;

@Service
public class CustomerSeviceImpl implements CustomerService {

	@Autowired
	private CustomerRepo repo;

	@Override
	public Customer getById(Integer customerId) {
		Optional<Customer> findById = repo.findById(customerId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = repo.findAll();
		return customers;
	}

	@Override
	public String deleteById(Integer customerId) {
		if (repo.existsById(customerId)) {
			repo.deleteById(customerId);
			return "record deleted";
		} else {
			return "No records found ...";
		}

	}

	@Override
	public String upsert(Customer customer) {
		repo.save(customer);
		return "success";
	}



}
