package com.example.demo.helper;

import com.example.demo.entity.Books;
import com.example.demo.form.BooksRegistrationForm;

public class BooksRegistrationHelper {
	public static Books convertBooks(BooksRegistrationForm form) {
		Books books = new Books();
		books.setBook_name(form.getBook_name());
		books.setAuthor(form.getAuthor());
		books.setPublisher(form.getPublisher());
		books.setIsbn(form.getIsbn());
		books.setBook_image_url(form.getBook_image_url());
		return books;
	}

	public static BooksRegistrationForm convertBooksRegistrationForm(Books books) {
		BooksRegistrationForm form = new BooksRegistrationForm();
		form.setBook_name(books.getBook_name());
		form.setAuthor(books.getAuthor());
		form.setPublisher(books.getPublisher());
		form.setIsbn(books.getIsbn());
		form.setBook_image_url(books.getBook_image_url());
		return form;
	}
}
