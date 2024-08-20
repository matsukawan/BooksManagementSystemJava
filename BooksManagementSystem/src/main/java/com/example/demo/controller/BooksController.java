package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Books;
import com.example.demo.entity.LoginUser;
import com.example.demo.entity.Reviews;
import com.example.demo.form.BooksRegistrationForm;
import com.example.demo.form.ReviewsForm;
import com.example.demo.helper.BooksRegistrationHelper;
import com.example.demo.helper.ReviewsHelper;
import com.example.demo.service.BooksService;
import com.example.demo.service.ReviewsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class BooksController {
	private final BooksService booksService;
	private final ReviewsService reviewsService;

	@GetMapping
	public String list(Model model) {
		model.addAttribute("books", booksService.findAllBooks());
		return "books/mainMenu";
	}

	@GetMapping("/{id}")
	public String detail(@PathVariable Integer id, @AuthenticationPrincipal UserDetails userDetails, Model model,
			RedirectAttributes attributes) {
		Books books = booksService.findByIdBooks(id);

		//ログインユーザ情報からemp_idを取得
		Reviews loginUserReview = reviewsService.getReviewsForLoggedInUserAndBook(id);

		if (books != null) {
			model.addAttribute("books", books);
			model.addAttribute("reviews", books.getReviews());
			if (loginUserReview != null) {
				model.addAttribute("loginUserReview", loginUserReview);
			}
			return "books/detail";
		} else {
			attributes.addFlashAttribute("errorMessage", "対象データがありません");
			return "redirect:/mainMenu";
		}
	}

	@GetMapping("/registration")
	public String newBooks(@ModelAttribute BooksRegistrationForm form) {
		return "/books/registrationform";
	}

	@PostMapping("/save")
	public String registration(@Validated BooksRegistrationForm form, BindingResult bindingResult,
			RedirectAttributes attributes) {
		if (bindingResult.hasErrors()) {
			form.setIsNew(true);
			return "books/registrationform";
		}
		Books Books = BooksRegistrationHelper.convertBooks(form);
		System.out.println(form);
		booksService.insertBooks(Books);
		attributes.addFlashAttribute("message", "新規書籍情報を登録しました。");
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
		Books target = booksService.findByIdBooks(id);
		if (target != null) {
			BooksRegistrationForm form = BooksRegistrationHelper.convertBooksRegistrationForm(target);
			model.addAttribute("booksRegistrationForm", form);
			return "books/registrationform";
		} else {
			attributes.addFlashAttribute("errorMessage", "対象データがありません。");
			return "redirect:/";
		}
	}

	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, RedirectAttributes attributes) {
		reviewsService.deleteAllReviews(id);
		booksService.deleteBooks(id);
		attributes.addFlashAttribute("message", "書籍情報を削除しました。");
		return "redirect:/";
	}

	@GetMapping("/review-form/{id}")
	public String newReview(@ModelAttribute ReviewsForm form, Model model) {
		form.setIsNew(true);
		return "books/reviewform";
	}

	@PostMapping("/review-create/{id}")
	public String reviewCreate(@Validated ReviewsForm form, BindingResult bindingResult,
			RedirectAttributes attributes) {
		if (bindingResult.hasErrors()) {
			form.setIsNew(true);
			return "/books/reviewform";
		}

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String empId = null;

		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
			LoginUser loginUser = (LoginUser) authentication.getPrincipal();
			empId = loginUser.getEmp_id();
		}

		Reviews reviews = ReviewsHelper.convertReviews(form);
		reviews.setEmp_id(empId);
		reviewsService.insertReviews(reviews);
		attributes.addFlashAttribute("message", "レビューを投稿しました。");
		return "redirect:/";
	}

	@GetMapping("/review-edit/{id}")
	public String reviewEdit(@PathVariable Integer id, Model model, RedirectAttributes attributes) {

		Reviews loginUserReview = reviewsService.getReviewsForLoggedInUserAndBook(id);

		ReviewsForm form = ReviewsHelper.convertReviewsForm(loginUserReview);

		model.addAttribute("reviewsForm", form);

		return "/books/reviewform";

	}

	@PostMapping("/update")
	public String update(@Validated ReviewsForm form, BindingResult bindingResult, RedirectAttributes attributes) {

		if (bindingResult.hasErrors()) {
			form.setIsNew(false);
			return "/books/reviewform";
		}
		Reviews reviews = ReviewsHelper.convertReviews(form);
		reviewsService.updateReviews(reviews);
		attributes.addFlashAttribute("message", "レビューを変更しました");
		return "redirect:/";
	}

	@PostMapping("/review-delete/{id}")
	public String reviewDelete(@PathVariable Integer id, RedirectAttributes attributes) {
		Reviews review = reviewsService.getReviewsForLoggedInUserAndBook(id);
		Reviews reviews = reviewsService.findByIdReviews(review.getId());

		if (reviews != null) {
			reviewsService.deleteReviews(reviews.getBook_id(), review.getEmp_id());
		}

		attributes.addFlashAttribute("message", "レビューを削除しました");
		return "redirect:/";
	}
}
