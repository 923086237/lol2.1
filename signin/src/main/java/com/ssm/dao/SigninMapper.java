package com.ssm.dao;

import java.util.List;

import com.ssm.entity.PresonSignin;
import com.ssm.entity.Signin;

public interface SigninMapper {
	public void addSignin(Signin signin);
	
	public Signin findByDateAndNum(String date, int number);
	
	public List<PresonSignin> findPresonSignin(String name);
	
	public List<Signin> nd(String uname, String date);
}
