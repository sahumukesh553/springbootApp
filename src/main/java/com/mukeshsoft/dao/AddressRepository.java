package com.mukeshsoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mukeshsoft.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
