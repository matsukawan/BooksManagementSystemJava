package com.example.demo.service.impl;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employees;
import com.example.demo.entity.Reviews;
import com.example.demo.repository.EmployeesMapper;
import com.example.demo.repository.ReviewsMapper;
import com.example.demo.service.ReviewsService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewsServiceImpl implements ReviewsService {

	private final ReviewsMapper reviewsMapper;
	private final EmployeesMapper employeesMapper;

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
	public void deleteReviews(Integer id, String emp_id) {
		reviewsMapper.delete(id, emp_id);
	}

	@Override
	public void deleteAllReviews(Integer id) {
		reviewsMapper.deleteAll(id);
	}

	@Override
	public Reviews getReviewsForLoggedInUserAndBook(Integer bookId) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = null;

		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			username = userDetails.getUsername();
		}

		Employees loginUser = employeesMapper.selectByEmpId(username);
		return reviewsMapper.selectReviewsByUserIdAndBookId(loginUser.getEmp_id(), bookId);
	}

}
