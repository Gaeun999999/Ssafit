package com.ssafy.mvc.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.UserDao;
import com.ssafy.mvc.model.dto.User;

@Service
public class UserServiceImpl implements UserService{
	
	private UserDao uDao;
	public UserServiceImpl(UserDao uDao) {
		this.uDao = uDao;
	}

	@Override
	public void regist(User user) throws IllegalStateException{
		
		int result = uDao.insertUser(user);
		if(result != 1) throw new IllegalStateException("회원가입에 실패했습니다.");
		else return;
	}

	@Override
	public void login(User user) throws IllegalStateException{
		
		User find = uDao.selectOneByUserId(user.getUserId());
		if(find == null || !find.getPassword().equals(user.getPassword())) {
			throw new IllegalStateException("로그인에 실패했습니다");
			
		} else {
			int result = uDao.insertStatus(user);
			if(result != 1) throw new IllegalStateException("상태 추가에 실패했습니다");
			else return;
		}
		
	}

	@Override
	public String getUser() throws IllegalStateException{
		return uDao.selectUserIdFromStatus();
	}

	@Override
	public void logout() {
		int result = uDao.deleteUserStatus();
		if(result != 1) throw new IllegalStateException("상태 제거에 실패했습니다.");
		else return;
	}
	
	

}
