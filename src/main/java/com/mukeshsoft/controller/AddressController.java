package com.mukeshsoft.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukeshsoft.model.Address;
import com.mukeshsoft.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	@GetMapping("/")
	public ResponseEntity<List<Address>> getAllAddress()
	{
		List<Address> allAddress = addressService.getAllAddress();

		return new ResponseEntity<List<Address>>(allAddress, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable Long id)
	{
		Address address = addressService.getAddress(id);
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Address> addAddress(@Valid @RequestBody Address address)
	{
		Address addAdress = addressService.addAdress(address);
		return new ResponseEntity<Address>(addAdress, HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable Long id)
	{
		String deleteAddress = addressService.deleteAddress(id);
		return new ResponseEntity<String>(deleteAddress, HttpStatus.ACCEPTED);
	}



}
