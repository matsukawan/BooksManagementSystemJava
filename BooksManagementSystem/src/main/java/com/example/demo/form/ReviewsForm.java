package com.example.demo.form;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewsForm {
	private Integer id;
	@NotNull(message = "おすすめ度を入力してください")
	private Integer rating;
	@NotBlank(message = "コメントを入力してください")
	private String comment;
	private String emp_id;
	private Integer book_id;
	private LocalDateTime reviewsCreatedAt;
	private LocalDateTime reviewsUpdatedAt;
	private Boolean isNew;
}
