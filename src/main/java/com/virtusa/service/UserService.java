package com.virtusa.service;
import java.util.List;

import com.virtusa.model.User;
public interface UserService {
	List<User> getAllUsers();
	User getUser(Long id);
	User addUser(User user);
	String deleteUser(Long id);
	
}
