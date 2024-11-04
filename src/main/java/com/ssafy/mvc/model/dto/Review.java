package com.ssafy.mvc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class Review {
	private int id;
	private int videoId;
	@NonNull private String title;
	@NonNull private String content;
	@NonNull private String author;
	private int viewCount;
	@NonNull private String createdTime;
}
