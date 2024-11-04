package com.ssafy.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
@Slf4j
public class UserController {
	
	private UserService uService;
	public UserController(UserService uService) {
		this.uService = uService;
	}
	
	@PostMapping("/regist")
	public ResponseEntity<?> regist(@ModelAttribute User user) {
		
		uService.regist(user);
		return new ResponseEntity<String>("회원가입에 성공했습니다.", HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@ModelAttribute User user) {
		
		uService.login(user);
		return new ResponseEntity<String>("로그인에 성공했습니다.", HttpStatus.OK);
		
	}
	
	@DeleteMapping("/logout")
	public ResponseEntity<?> logout() {
		
		uService.logout();
		return new ResponseEntity<String>("로그아웃에 성공했습니다.", HttpStatus.OK);
	}

}
