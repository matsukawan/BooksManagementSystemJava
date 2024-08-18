package com.example.demo.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class LoginUser extends User {
	private Integer id;
	private String emp_name;

	public LoginUser(String empId, String password, Collection<? extends GrantedAuthority> authorities,String emp_name,Integer id) {
		super(empId, password, authorities);
		this.emp_name = emp_name;
		this.id = id;

	}

	public String getEmp_name() {
		return emp_name;
	}
	
	public Integer getId() {
		
		return id;
	}
}
