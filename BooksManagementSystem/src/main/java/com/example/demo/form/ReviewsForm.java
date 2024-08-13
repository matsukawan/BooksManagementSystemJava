package com.example.demo.form;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewsForm {
	private Integer id;
	private Integer rating;
	private String comment;
	private Integer emp_id;
	private Integer book_id;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private Boolean isNew;
}
