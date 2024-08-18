package com.example.demo.helper;

import com.example.demo.entity.Reviews;
import com.example.demo.form.ReviewsForm;

public class ReviewsHelper {

	
	public static Reviews convertReviews(ReviewsForm form) {
		Reviews reviews = new Reviews();
		reviews.setId(form.getId());
		reviews.setRating(form.getRating());
		reviews.setComment(form.getComment());
		reviews.setBook_id(reviews.getBook_id());
		return reviews;
	}
	
	public static ReviewsForm convertReviewsForm(Reviews reviews) {
		ReviewsForm form = new ReviewsForm();
		form.setId(reviews.getId());
		form.setRating(reviews.getRating());
		form.setComment(reviews.getComment());
		form.setEmp_id(reviews.getEmp_id());
		form.setIsNew(false);
		return form;
	}
}
