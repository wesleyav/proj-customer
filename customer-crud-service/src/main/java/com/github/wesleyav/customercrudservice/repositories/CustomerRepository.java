package com.github.wesleyav.customercrudservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.wesleyav.customercrudservice.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
