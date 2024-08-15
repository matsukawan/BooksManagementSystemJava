package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Books;
import com.example.demo.repository.BooksMapper;
import com.example.demo.service.BooksService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BooksServiceImpl implements BooksService{
	
	private final BooksMapper booksMapper;
	
	@Override
	public List<Books> findAllBooks(){
		return booksMapper.selectAll();
	}
	
	@Override
	public Books findByIdBooks(Integer id) {
		return booksMapper.selectById(id);
	}
	
	@Override
	public Optional<Books> findByIsbn(String isbn) {
		return booksMapper.selectByIsbn(isbn);
	}
	
	@Override
	public void insertBooks(Books books) {
		booksMapper.insert(books);
	}
	
	@Override
	public void deleteBooks(Integer id) {
		booksMapper.delete(id);
	}
}
