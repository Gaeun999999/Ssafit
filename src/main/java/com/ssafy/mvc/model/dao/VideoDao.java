package com.ssafy.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mvc.model.dto.Video;

@Mapper
public interface VideoDao {
	
	List<Video> getVideoList();
	
	Video getVideo(int videoId);
	
	List<Video> getVideoListByPart(String part);
	
	boolean increaseView(int videoId);
	
	boolean createVideo(Video video);
	
	boolean updateVideo(Video video);
	
	boolean deleteVideo(int videoId);
}
