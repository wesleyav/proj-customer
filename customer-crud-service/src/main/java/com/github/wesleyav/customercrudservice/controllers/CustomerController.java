package com.github.wesleyav.customercrudservice.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.wesleyav.customercrudservice.entities.Customer;
import com.github.wesleyav.customercrudservice.services.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/customers")
@Tag(name = "Customer")
public class CustomerController {

	@Autowired
	public CustomerService customerService;

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Endpoint to list Customers")
	public List<Customer> findAll() {
		List<Customer> listCustomers = customerService.findAll();
		return listCustomers;
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Endpoint to list Customer by Id")
	public ResponseEntity<Customer> findById(@PathVariable Long id) {
		Customer customer = customerService.findById(id);
		if (customer != null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Endpoint to create Customer")
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		Customer newCustomer = customerService.save(customer);
		return new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Endpoint to delete Customer by Id")
	public ResponseEntity<Customer> deleteById(@PathVariable Long id) {
		Customer customer = customerService.findById(id);
		if (customer != null) {
			customerService.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Endpoint to update Customer by Id")
	public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer) {
		Customer oldCustomer = customerService.findById(id);
		if (oldCustomer != null) {
			Customer newCustomer = new Customer();
			newCustomer.setId(oldCustomer.getId());
			newCustomer.setFirstName(customer.getFirstName());
			newCustomer.setLastName(customer.getLastName());
			newCustomer.setEmail(customer.getEmail());
			newCustomer.setActive(customer.getActive());
			newCustomer.setCreateDate(customer.getCreateDate());
			newCustomer.setLastUpdate(customer.getLastUpdate());
			return new ResponseEntity<Customer>(customerService.save(newCustomer), HttpStatus.OK);
		} else {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}
}
