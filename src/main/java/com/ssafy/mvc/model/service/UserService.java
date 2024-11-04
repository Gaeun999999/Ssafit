package com.ssafy.mvc.model.service;

import com.ssafy.mvc.model.dto.User;

public interface UserService {

	void regist(User user);

	void login(User user);

	String getUser();

	void logout();

}
