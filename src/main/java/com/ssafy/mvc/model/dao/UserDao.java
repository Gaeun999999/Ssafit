package com.ssafy.mvc.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mvc.model.dto.User;

@Mapper
public interface UserDao {

	public int insertUser(User user);

	public User selectOneByUserId(String string);

	public int insertStatus(User user);

	public String selectUserIdFromStatus();

	public int deleteUserStatus();

}
