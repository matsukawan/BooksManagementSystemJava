package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Books;

public interface BooksService {
	List<Books> findAllBooks();
	Books findByIdBooks(Integer id);
	void insertBooks(Books books);
	void deleteBooks(Integer id);
}
