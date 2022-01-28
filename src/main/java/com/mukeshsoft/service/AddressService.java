package com.mukeshsoft.service;

import java.util.List;

import com.mukeshsoft.model.Address;

public interface AddressService {
List<Address> getAllAddress();
Address getAddress(Long id);
Address addAdress(Address address);
String deleteAddress(Long id);
}
