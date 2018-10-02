package com.spring.client.board.vo;

import org.springframework.web.multipart.MultipartFile;

public class ImageVO {
	private int image_num;
	private String image_i;
	private MultipartFile file;
	
	public int getImage_num() {
		return image_num;
	}


	public void setImage_num(int image_num) {
		this.image_num = image_num;
	}


	public String getImage_i() {
		return image_i;
	}


	public void setImage_i(String image_i) {
		this.image_i = image_i;
	}


	@Override
	public String toString() {
		return "ImageVO [image_num=" + image_num + ", image_i=" + image_i + "]";
	}
	
	
}
