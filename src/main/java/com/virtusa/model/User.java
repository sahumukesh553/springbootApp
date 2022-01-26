package com.virtusa.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.domain.AbstractPersistable;


import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User extends AbstractPersistable<Long>{
	@NotEmpty(message = "userId can not be Empty")
    private String userId;
	@NotEmpty(message = "userName can not be Empty")
	private String userName;
	@NotEmpty(message = "Password can not be Empty")
	private String password;
	@OneToMany(targetEntity = Address.class,mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Address> address;
	
	public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



}
