package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dto.Video;

public interface VideoService {

	List<Video> getVideoList();
	
	Video getVideo(int videoId)throws Exception;
	
	List<Video> getVideoListByPart(String part);
	
	boolean increaseView(int videoId);
	
	boolean createVideo(Video video);
	
	boolean updateVideo(Video video);
	
	boolean deleteVideo(int videoId);
}
