package com.github.wesleyav.customercrudservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.wesleyav.customercrudservice.entities.Customer;
import com.github.wesleyav.customercrudservice.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	public CustomerRepository customerRepository;

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public Customer findById(Long id) {
		return customerRepository.findById(id).orElse(null);
	}

	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void deleteById(@PathVariable Long id) {
		customerRepository.deleteById(id);
	}

}
