package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dto.Review;

public interface ReviewService {

	List<Review> getAllReviews(int videoId);

	void addReview(Review review);

	void updateReview(Review review);

	Review getReviewByReviewId(int reviewId);

	void increaseViewCount(int reviewId);

	void deleteReview(int reviewId);
	

}
