package com.mukeshsoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mukeshsoft.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
