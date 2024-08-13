package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {
	private Integer id;
	private String book_name;
	private String author;
	private String publisher;
	private Integer price;
	private String isbn;
	private Integer num_of_books;
	private String book_image_url;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private List<Reviews> reviews;
	
}
