package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Depertmants {
	private Integer id;
	private String dep_name;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
