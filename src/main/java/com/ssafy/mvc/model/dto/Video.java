package com.ssafy.mvc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class Video {	

	private int id;
	@NonNull private String title;
	@NonNull private String part;
	@NonNull private String url;
	private int viewCount;

}
