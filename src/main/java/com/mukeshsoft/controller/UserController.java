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

import com.mukeshsoft.model.User;
import com.mukeshsoft.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping("/")
	public  ResponseEntity<List<User>> getAllUsers()
	{
		List<User> users=userService.getAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}
	
	@PostMapping("/")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user)
	{ User addUser = userService.addUser(user);
		return new ResponseEntity<User>(addUser, HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id)
	{
		User user = userService.getUser(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id)
	{
		String message = userService.deleteUser(id);
		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}

}
