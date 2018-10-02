package com.spring.client.board.vo;

import java.util.List;

public class BoardVO {

	private int b_no = 0;
	private String b_title = null;
	private String b_date = null;
	private String b_content = null;
	private String b_name = null;
	private String b_pwd = null;
	private List<ImageVO> image =null;
	
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_pwd() {
		return b_pwd;
	}
	public void setB_pwd(String b_pwd) {
		this.b_pwd = b_pwd;
	}
	public List<ImageVO> getImage() {
		return image;
	}
	public void setImage(List<ImageVO> image) {
		this.image = image;
	}
	
	
	
}
