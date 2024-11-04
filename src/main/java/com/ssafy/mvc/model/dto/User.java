package com.ssafy.mvc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class User {
	private int id;
	@NonNull private String userId;
	@NonNull private String password;
	private String userName;
	private int isAdmin;

}
