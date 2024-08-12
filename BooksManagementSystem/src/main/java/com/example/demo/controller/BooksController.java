package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Books;
import com.example.demo.service.BooksService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/mainMenu")
@RequiredArgsConstructor
public class BooksController {
	private final BooksService booksService;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("books",booksService.findAllBooks());
		return "books/mainMenu";
	}
	
	@GetMapping("/{id}")
	public String detail(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
		Books Books = booksService.findByIdBooks(id);
		if(Books != null) {
			model.addAttribute("books",booksService.findByIdBooks(id));
			return "books/detail";
		}else {
			attributes.addFlashAttribute("errorMessage","対象データがありません");
			return "/redirect:/mainMenu";
		}
	}
}
