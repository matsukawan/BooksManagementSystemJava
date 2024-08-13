package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Books;
import com.example.demo.service.BooksService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class BooksManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksManagementSystemApplication.class, args)
		.getBean(BooksManagementSystemApplication.class).exe();
	}
	
	private final BooksService service;
	
	public void exe() {
		System.out.println("=== 全件検索 ===");
		for(Books row : service.findAllBooks()) {
			System.out.println(row);
		}
		
		System.out.println("=== 一件検索 ===");
		System.out.println(service.findByIdBooks(1));
		
		Books books = new Books();
		books.setBook_name("4");
		books.setAuthor("DBへの登録処理");
//		books.setReviews(reviews);
		service.insertBooks(books);
		System.out.println("=== 登録確認 ===");
		System.out.println(service.findByIdBooks(4));
		
//		Reviews target = service.findByIdBooks(5);
//		target.setRating(5);
//		target.setComment("DBへの更新処理");
//		service.updateBooks(target);
//		System.out.println("=== 更新確認 ===");
//		System.out.println(service.findByIdBooks(5));
		
		service.deleteBooks(4);
		System.out.println("=== 削除確認 ===");
		for(Books row : service.findAllBooks()) {
			System.out.println(row);
		}
	}

}
