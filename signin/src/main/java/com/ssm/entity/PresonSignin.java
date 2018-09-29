package com.ssm.entity;

import java.util.List;

public class PresonSignin {
	private Integer id;
	private String uname;
	private String date;
	private List<Signin> sl;
	private String state;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Signin> getSl() {
		return sl;
	}

	public void setSl(List<Signin> sl) {
		this.sl = sl;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
