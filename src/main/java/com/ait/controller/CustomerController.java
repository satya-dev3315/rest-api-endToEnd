package com.ait.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ait.entity.Customer;
import com.ait.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	
	//get a record
	@GetMapping(value = "/getCustomer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer customerId){
		Customer customer = customerService.getById(customerId);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		
	}
	
	//create a record
	@PostMapping(value = "/addCustomer", produces = MediaType.TEXT_PLAIN_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)//we r sending return as string,and we r consuming data in json because frm postman we test it using json format for POST
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
		System.out.println(customer);
		String upsert = customerService.upsert(customer);
		return new ResponseEntity<>(upsert, HttpStatus.CREATED);
		
	}
	
	//update a record
		@PutMapping(value = "/updateCustomer", produces = MediaType.TEXT_PLAIN_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> updateCustomer(@RequestBody Customer customer){
			String update = customerService.upsert(customer);
			return new ResponseEntity<>(update, HttpStatus.OK);
			
		}
	
	//delete a record
	@DeleteMapping(value = "/deleteCustomer/{customerId}",produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId){
		String deleteById = customerService.deleteById(customerId);
		return new ResponseEntity<String>(deleteById, HttpStatus.OK);
		
	}
	
	//get all records
	@GetMapping(value = "/getAllCustomers", produces = MediaType.APPLICATION_JSON_VALUE) //consumes nt here as it dont has body so we cant test usin jsom data in postman
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers = customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
		
	}
	
}
