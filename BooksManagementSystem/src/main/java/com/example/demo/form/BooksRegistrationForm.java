package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;

import com.example.demo.annotation.Registered;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BooksRegistrationForm {
	//	private Integer id;
	@NotBlank(message = "書籍名を入力してください")
	private String book_name;
	@NotBlank(message = "著者名を入力してください")
	private String author;
	@NotBlank(message = "出版社名を入力してください")
	private String publisher;
	@NotBlank(message = "ISBNを入力してください")
	@Registered
	private String isbn;
	private String book_image_url;
	private Boolean isNew;
}
