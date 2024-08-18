package com.example.demo.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class LoginUser extends User {
	private Integer id;
	private String emp_name;
	private String emp_id;

	public LoginUser(String empId, String password, Collection<? extends GrantedAuthority> authorities, String emp_name,
			Integer id) {
		super(empId, password, authorities);
		this.emp_name = emp_name;
		this.id = id;
		emp_id = empId;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public Integer getId() {

		return id;
	}

	public String getEmp_id() {
		return emp_id;
	}
}
