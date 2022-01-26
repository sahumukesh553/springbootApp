package com.virtusa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
