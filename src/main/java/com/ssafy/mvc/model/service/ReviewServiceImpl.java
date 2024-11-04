package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.model.dao.ReviewDao;
import com.ssafy.mvc.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	private ReviewDao rDao;
	public ReviewServiceImpl(ReviewDao rDao) {
		this.rDao = rDao;
	}

	@Override
	public List<Review> getAllReviews(int videoId) throws IllegalStateException{
	    List<Review> list = rDao.selectAllByVideoId(videoId);
	    if (list == null || list.isEmpty()) {
	        throw new IllegalStateException("리뷰 목록이 비어 있습니다.");
	    }
	    return list;
	}

	@Override
	@Transactional
	public void addReview(Review review) throws IllegalStateException {
		
		int result = rDao.insertReview(review);
		if(result != 1) {
			throw new IllegalStateException("리뷰 작성에 실패했습니다.");
		} else return;
	}

	@Override
	@Transactional
	public void updateReview(Review review) throws IllegalStateException {
		int result = rDao.updateReview(review);
		if(result != 1) {
			throw new IllegalStateException("리뷰 수정에 실패했습니다.");
		}
		else return;
	}

	@Override
	public Review getReviewByReviewId(int reviewId) throws IllegalStateException{
		Review result = rDao.selectOneByReviewId(reviewId);
		if(result != null) return result;
		else throw new IllegalStateException("해당 리뷰가 없습니다.");
	}

	@Override
	@Transactional
	public void increaseViewCount(int reviewId) {
		rDao.updateViewCount(reviewId);
		
	}

	@Override
	@Transactional
	public void deleteReview(int reviewId) throws IllegalStateException{
		int result = rDao.deleteReview(reviewId);
		if(result != 1) {
			throw new IllegalStateException("리뷰 삭제에 실패했습니다.");
		} else return;
	}

	

}
