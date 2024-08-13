package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Books;
import com.example.demo.entity.Reviews;
import com.example.demo.form.BooksRegistrationForm;
import com.example.demo.form.ReviewsForm;
import com.example.demo.helper.BooksRegistrationHelper;
import com.example.demo.helper.ReviewsHelper;
import com.example.demo.service.BooksService;
import com.example.demo.service.ReviewsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/mainMenu")
@RequiredArgsConstructor
public class BooksController {
	private final BooksService booksService;
	private final ReviewsService reviewsService;
	
	@GetMapping
	public String list(Model model) {	
		model.addAttribute("books",booksService.findAllBooks());
		return "books/mainMenu";
	}
	
	@GetMapping("/{id}")
	public String detail(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
		Books books = booksService.findByIdBooks(id);
		if(books != null) {
			model.addAttribute("books", books);
			model.addAttribute("reviews",books.getReviews());
			return "books/detail";
		}else {
			attributes.addFlashAttribute("errorMessage","対象データがありません");
			return "redirect:/mainMenu";
		}
	}
	
	@GetMapping("/registration")
	public String newBooks(@ModelAttribute BooksRegistrationForm form) {
		return "/books/registrationform";
	}
	
	@PostMapping("/save")
	public String registration(BooksRegistrationForm form,RedirectAttributes attributes) {
		Books Books = BooksRegistrationHelper.convertBooks(form);
		booksService.insertBooks(Books);
		attributes.addFlashAttribute("message","新規書籍情報を登録しました。");
		return "redirect:/mainMenu";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
		Books target = booksService.findByIdBooks(id);
		if(target != null) {
			BooksRegistrationForm form = BooksRegistrationHelper.convertBooksRegistrationForm(target);
			model.addAttribute("booksRegistrationForm",form);
			return "books/registrationform";
		}else {
			attributes.addFlashAttribute("errorMessage","対象データがありません。");
			return "redirect:/mainMenu";
		}
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, RedirectAttributes attributes) {
		booksService.deleteBooks(id);
		attributes.addFlashAttribute("message", "書籍情報を削除しました。");
		return "redirect:/mainMenu";
	}
	
	@GetMapping("/review-form")
	public String newReview(@ModelAttribute ReviewsForm form) {
		form.setIsNew(true);
		return "books/reviewform";
	}
	
	@PostMapping("/review-create")
	public String reviewCreate(ReviewsForm form, RedirectAttributes attributes) {
		Reviews reviews = ReviewsHelper.convertReviews(form);
		reviewsService.insertReviews(reviews);
		attributes.addFlashAttribute("message","レビューを投稿しました。");
		return "redirect:/mainMenu";
	}
	
	@GetMapping("/review-edit/{id}")
	public String reviewEdit(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
		Reviews target = reviewsService.findByIdReviews(id);
		if(target != null) {
			ReviewsForm form = ReviewsHelper.convertReviewsForm(target);
			model.addAttribute("reviewsForm",form);
			return "books/reviewform";
		}else {
			attributes.addFlashAttribute("errorMessage","対象データがありません");
			return "redirect:/mainMenu";
		}
	}
	
	@PostMapping("/update")
	public String update(ReviewsForm form,RedirectAttributes attributes) {
		Reviews reviews = ReviewsHelper.convertReviews(form);
		reviewsService.updateReviews(reviews);
		attributes.addFlashAttribute("message","レビューを変更しました");
		return "redirect:/mainMenu";
	}
}
