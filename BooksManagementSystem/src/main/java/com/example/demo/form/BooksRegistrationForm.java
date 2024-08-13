package com.example.demo.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BooksRegistrationForm {
//	private Integer id;
	private String book_name;
	private String author;
	private String publisher;
	private String isbn;
//	private String book_image_url;
}
