package com.ssafy.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mvc.model.dto.Review;

@Mapper
public interface ReviewDao {

	public List<Review> selectAllByVideoId(int videoId);

	public int insertReview(Review review);

	public int updateReview(Review review);

	public Review selectOneByReviewId(int reviewId);

	public void updateViewCount(int reviewId);

	public int deleteReview(int reviewId);

}
