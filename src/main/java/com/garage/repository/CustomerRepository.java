package com.garage.garagemanagementsystem.repository;

import com.garage.garagemanagementsystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}