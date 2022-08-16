package com.example.springboot1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot1.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
