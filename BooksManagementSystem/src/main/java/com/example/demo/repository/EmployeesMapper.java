package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Employees;

@Mapper
public interface EmployeesMapper {
	Employees selectByEmpId(String empId);
	Employees selectById(Integer Id);
}
