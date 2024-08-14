package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Reviews;

public interface ReviewsService {
	List<Reviews> findAllReviews();
	Reviews findByIdReviews(Integer id);
	void insertReviews(Reviews reviews);
	void updateReviews(Reviews reviews);
	void deleteReviews(Integer id);
	void deleteAllReviews(Integer id);
}
