package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.Review;
import com.ssafy.mvc.model.service.ReviewService;
import com.ssafy.mvc.model.service.UserService;

@RestController
@RequestMapping("/video/review")
@CrossOrigin("*")
public class ReviewController {
	
	private ReviewService rService;
	private UserService uService;
	public ReviewController(ReviewService rService, UserService uService) {
		this.rService = rService;
		this.uService = uService;
	}
	
	
	@GetMapping("/list/{videoId}")
	public ResponseEntity<?> reviewList(@PathVariable("videoId") int videoId) {
		
		List<Review> list = rService.getAllReviews(videoId);
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
		
	}
	
	@PostMapping("/{videoId}")
	public ResponseEntity<?> reviewWrite(@PathVariable("videoId") int videoId, 
										@ModelAttribute Review review) {
		
		review.setVideoId(videoId);
		review.setAuthor(uService.getUser());
		rService.addReview(review);
		return new ResponseEntity<String>("리뷰 작성에 성공했습니다.", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> reviewUpdate(@PathVariable("id") int reviewId,
										@ModelAttribute Review review) {
		review.setId(reviewId);
		rService.updateReview(review);
		return new ResponseEntity<String>("리뷰 수정에 성공했습니다.", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> reviewDetail(@PathVariable("id") int reviewId) {
		
		Review review = rService.getReviewByReviewId(reviewId);
		int cnt = review.getViewCount() + 1;
		rService.increaseViewCount(reviewId);
		review.setViewCount(cnt);
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> reviewDelete(@PathVariable("id") int reviewId) {
		
		rService.deleteReview(reviewId);
		return new ResponseEntity<String>("리뷰 삭제에 성공했습니다.", HttpStatus.OK);
		
	}
	
}
