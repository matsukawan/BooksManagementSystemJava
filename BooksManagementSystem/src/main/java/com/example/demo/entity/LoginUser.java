package com.example.demo.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


public class LoginUser extends User{
	public LoginUser(String empId, String password, Collection<? extends GrantedAuthority> authorities) {
		super(empId,password,authorities);
	}

}
