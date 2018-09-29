package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.SigninMapper;
import com.ssm.entity.PresonSignin;
import com.ssm.entity.Signin;
import com.ssm.service.ISigninService;
@Service
public class SigninService implements ISigninService{
	@Autowired
	private SigninMapper signinMapper;
	@Override
	public void addSignin(Signin signin) {
		try {
			signinMapper.addSignin(signin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Signin findByDateAndNum(String date, int number) {
		Signin signin = null;
		try {
			signin = signinMapper.findByDateAndNum(date, number);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return signin ;
	}
	@Override
	public List<PresonSignin> findPresonSignin(String name) {
		List<PresonSignin> pl = null;
		try {
			pl = signinMapper.findPresonSignin(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = 1;
		for (PresonSignin presonSignin : pl) {
			presonSignin.setId(count++);
			List<Signin> sl = presonSignin.getSl();
			if (sl.size() != 2) {
				presonSignin.setState("有异常");
			} else {
				presonSignin.setState("正常");
			}
		}
		return pl;
	}

}
