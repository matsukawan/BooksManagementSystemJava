package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employees {
	private Integer id;
	private String emp_name;
	private String emp_id;
	private String password;
	private Integer dep_id;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
