package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reviews {
	private Integer id;
	private Integer emp_id;
	private Integer rating;
	private String comment;
	private Integer book_id;
	private LocalDateTime reviewsCreatedAt;
	private LocalDateTime reviewsUpdatedAt;
}
