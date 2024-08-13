package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Reviews;
import com.example.demo.repository.ReviewsMapper;
import com.example.demo.service.ReviewsService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewsServiceImpl implements ReviewsService {

	private final ReviewsMapper reviewsMapper;
	
	@Override
	public List<Reviews> findAllReviews() {
		return reviewsMapper.selectAll();
	}

	@Override
	public Reviews findByIdReviews(Integer id) {
		return reviewsMapper.selectById(id);
	}

	@Override
	public void insertReviews(Reviews reviews) {
		reviewsMapper.insert(reviews);
	}

	@Override
	public void updateReviews(Reviews reviews) {
		reviewsMapper.update(reviews);
	}

	@Override
	public void deleteReviews(Integer id) {
		reviewsMapper.delete(id);

	}

}
