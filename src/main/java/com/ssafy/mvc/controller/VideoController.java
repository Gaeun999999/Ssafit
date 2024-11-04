package com.ssafy.mvc.controller;

import java.util.List;

import org.apache.coyote.BadRequestException;
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

import com.ssafy.mvc.model.dto.Video;
import com.ssafy.mvc.model.service.VideoService;

@RestController
@RequestMapping("/video")
@CrossOrigin("*")
public class VideoController {

	private VideoService videoService;
	
	public VideoController(VideoService videoService) {
		
		this.videoService = videoService;
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getVideoList(){
		
		try {
		
			List<Video> videoList = videoService.getVideoList();
			
			return new ResponseEntity<List<Video>>(videoList, HttpStatus.OK);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		   
			return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
		}
		
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getVideo(@PathVariable ("id") int id){
		
		try {
			
			Video video = videoService.getVideo(id);
			
			return new ResponseEntity<Video>(video, HttpStatus.OK);
			
		}catch(BadRequestException e) {
			
			System.out.println(e.getMessage());
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
			return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
		}
	}
	
	@GetMapping("/list/{part}")
	public ResponseEntity<?> getVideoListByPart(@PathVariable("part") String part){
		
		try {
			
			List<Video> videoList = videoService.getVideoListByPart(part);
			
			return new ResponseEntity<List<Video>>(videoList, HttpStatus.OK);
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		   
			return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
		}
	
	}
	
	@PostMapping("/write")
	public ResponseEntity<?> createVideo(@ModelAttribute Video video){
		
		try {
			
			boolean valid = videoService.createVideo(video);
			
			if(valid) {
				
				return new ResponseEntity<Boolean>(valid, HttpStatus.OK);
				
			}else {
				
				return new ResponseEntity<Boolean>(valid, HttpStatus.BAD_REQUEST);
				
			}
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
			return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
		}
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateVideo(@ModelAttribute Video video){
		
		Video data = new Video();
		
		data.setId(video.getId());
		data.setTitle(video.getTitle());
		data.setPart(video.getPart());
		data.setUrl(video.getUrl());
		
		try {
			
			boolean valid = videoService.updateVideo(data);
			
			if(valid) {
				
				return new ResponseEntity<Boolean>(valid, HttpStatus.OK);
				
			}else {
				
				return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
				
			}
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
			return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
			
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteVideo(@PathVariable("id") int id){
		
		try {
			
			boolean valid = videoService.deleteVideo(id);
			
			if(valid) {
				
				return new ResponseEntity<Boolean>(valid, HttpStatus.OK);
				
			}else {
				
				return new ResponseEntity<Boolean>(valid, HttpStatus.BAD_REQUEST);
				
			}
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
			return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
		}
	}
}
