package com.virtusa.service;

import java.util.List;

import com.virtusa.model.Address;

public interface AddressService {
List<Address> getAllAddress();
Address getAddress(Long id);
Address addAdress(Address address);
String deleteAddress(Long id);
}
