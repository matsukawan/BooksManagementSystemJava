package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employees;
import com.example.demo.entity.LoginUser;
import com.example.demo.entity.Role;
import com.example.demo.repository.EmployeesMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginUserDetailsServiceImpl implements UserDetailsService {
	private final EmployeesMapper employeesMapper;

	@Override
	public UserDetails loadUserByUsername(String empId) throws UsernameNotFoundException {
		Employees employees = employeesMapper.selectByEmpId(empId);

		if (employees != null) {
			return new LoginUser(employees.getEmp_id(), employees.getPassword(),
					getAuthorityList(employees.getDep_id()), employees.getEmp_name(), employees.getId());
		} else {
			throw new UsernameNotFoundException(empId + " => 指定しているユーザ名は存在しません");
		}
	}

	private List<GrantedAuthority> getAuthorityList(Role role) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role.name()));
		if (role == Role.soumu) {
			authorities.add(new SimpleGrantedAuthority(role.jinji.name()));
			authorities.add(new SimpleGrantedAuthority(role.kaihatsu.name()));
		}
		return authorities;
	}
}
