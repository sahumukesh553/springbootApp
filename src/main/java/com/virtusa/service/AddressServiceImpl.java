package com.virtusa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.dao.AddressRepository;
import com.virtusa.dao.UserRepository;
import com.virtusa.exception.AddressNotFoundException;
import com.virtusa.exception.NoDataFoundException;
import com.virtusa.model.Address;
@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Address> getAllAddress() {
		List<Address> list = addressRepository.findAll();
		
		if(list.isEmpty())
		{
			throw new NoDataFoundException("Address");
		}
		return list;
	}

	@Override
	public Address getAddress(Long id) {
	
		return addressRepository.findById(id).orElseThrow(()->new AddressNotFoundException(id));
	}

	@Override
	public Address addAdress(Address address) {
		address.setUser(userRepository.getById(address.getUserId()));
		Address save = addressRepository.save(address);
		
		return save;
	}

	@Override
	public String deleteAddress(Long id) {
		addressRepository.deleteById(id);
		return "{'message':'Address deleted successfully'}";
	}

}
