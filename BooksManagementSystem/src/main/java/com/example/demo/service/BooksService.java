package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Books;

public interface BooksService {
	List<Books> findAllBooks();

	Books findByIdBooks(Integer id);

	Optional<Books> findByIsbn(String isbn);

	void insertBooks(Books books);

	void deleteBooks(Integer id);
}
