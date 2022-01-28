package com.mukeshsoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukeshsoft.dao.UserRepository;
import com.mukeshsoft.exception.NoDataFoundException;
import com.mukeshsoft.exception.UserNotFoundException;
import com.mukeshsoft.model.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public List<User> getAllUsers() {
		List<User> users=userRepository.findAll();
		if(users.isEmpty())
			throw new NoDataFoundException("User");
		return users;
	}
	@Override
	public User getUser(Long id) {
		
		return userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
	}
	@Override
	public User addUser(User user) {
		User savedUser = userRepository.save(user);
		return savedUser;
	}
	@Override
	public String deleteUser(Long id) {
		userRepository.deleteById(id);
		return "{'message':'user deleted successfully'}" ;
	}

}
