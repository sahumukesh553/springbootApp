package com.virtusa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
