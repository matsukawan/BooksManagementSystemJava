package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Reviews;
import com.example.demo.form.ReviewsForm;
import com.example.demo.helper.ReviewsHelper;
import com.example.demo.service.ReviewsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewsController {
	private final ReviewsService reviewsService;
	
	@GetMapping
	public String reviewList(Model model) {
		model.addAttribute("review",reviewsService.findAllReviews());
		return "books/review";
	}
	
	@GetMapping("/{id}")
	public String reviewDetail(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
		Reviews Reviews = reviewsService.findByIdReviews(id);
		if(Reviews != null) {
			model.addAttribute("reviews", reviewsService.findByIdReviews(id));
			return "books/detail";
		}else {
			attributes.addAttribute("errorMessage","対象データがありません");
			return "redirect:/mainMenu";
		}
	}
	@GetMapping("/review-form")
	public String newReview(@ModelAttribute ReviewsForm form) {
		form.setIsNew(true);
		return "books/reviewform";
	}
	
	@PostMapping("/registration-create")
	public String reviewCreate(ReviewsForm form, RedirectAttributes attributes) {
		Reviews reviews = ReviewsHelper.convertReviews(form);
		reviewsService.insertReviews(reviews);
		attributes.addFlashAttribute("message","レビューを投稿しました。");
		return "redirect:/mainMenu";
	}
}
