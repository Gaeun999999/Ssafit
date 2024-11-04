package com.ssafy.mvc.model.service;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.model.dao.VideoDao;
import com.ssafy.mvc.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService{

	private VideoDao videoDao;
	
	public VideoServiceImpl(VideoDao videoDao) {
		this.videoDao = videoDao;
	}
	
	@Override
	@Transactional
	public List<Video> getVideoList(){
		
		List<Video> videos = videoDao.getVideoList();
		
		return videos;
	}

	@Override
	@Transactional
	public Video getVideo(int videoId)throws Exception {
		
		videoDao.increaseView(videoId);
		
		Video video = videoDao.getVideo(videoId);
		
		if(video == null) {
			throw new BadRequestException("없는 ID 값을 입력하셨습니다.");
		}
		
		return video;
	}
	
	@Override
	public List<Video> getVideoListByPart(String part){
		
		return videoDao.getVideoListByPart(part);
		
	}

	@Override
	@Transactional
	public boolean increaseView(int videoId) {
		
		return videoDao.increaseView(videoId);
	}

	@Override
	@Transactional
	public boolean createVideo(Video video) {
		
		return videoDao.createVideo(video);
	}

	@Override
	@Transactional
	public boolean updateVideo(Video video) {
		
		return videoDao.updateVideo(video);
	}
	
	@Override
	@Transactional
	public boolean deleteVideo(int videoId) {
		
		return videoDao.deleteVideo(videoId);
	}
}
