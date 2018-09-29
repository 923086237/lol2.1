package com.ssm.service;

import java.util.List;

import com.ssm.entity.PresonSignin;
import com.ssm.entity.Signin;

public interface ISigninService {
	public void addSignin(Signin signin);
	
	public Signin findByDateAndNum(String date, int number);
	
	public List<PresonSignin> findPresonSignin(String name);
}
