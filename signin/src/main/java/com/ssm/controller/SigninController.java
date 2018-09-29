package com.ssm.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.entity.PresonSignin;
import com.ssm.entity.Signin;
import com.ssm.service.ISigninService;
import com.ssm.vo.JsonBean;

@Controller
public class SigninController {
	@Autowired
	private ISigninService signinService;

	@RequestMapping(value = "addsignin", method = RequestMethod.GET)
	@ResponseBody
	public JsonBean addsignin(HttpSession session) {
		JsonBean bean = new JsonBean();
		String name = (String) session.getAttribute("name");
		Signin signin = new Signin();
		//添加用户名
		signin.setUname(name);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		//添加签到日期
		String date = sdf1.format(new Date());
		signin.setDate(date);
		//判断为早or晚签到，并添加信息
		Signin s1 = signinService.findByDateAndNum(date, 1);
		Signin s2 = signinService.findByDateAndNum(date, 2);
		if (s1 == null && s2 == null) {
			signin.setNumber(1);
		} else if (s1 != null && s2 == null) {
			signin.setNumber(2);
		} else if (s1 != null && s2 != null) {
			bean.setCode(1);
			bean.setMsg("今日签到次数已达上限");
			return bean;
		}
		//计算签到状态(正常or早退迟到)
		Date stime = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date ms = null;
		Date me = null;
		Date es = null;
		try {
			ms = dateFormat.parse(date + " 08:00:00");
			me = dateFormat.parse(date + " 09:00:00");
			es = dateFormat.parse(date + " 20:00:00");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (stime.before(ms)) {
			bean.setCode(1);
			bean.setMsg("未到签到时间！");
			return bean;
		}
		signin.setStime(stime);
		if (signin.getNumber() == 1) {
			if (stime.before(me) && ms.before(stime)) {
				signin.setFlag("正常");
			} else if (me.before(stime)) {
				signin.setFlag("迟到");
			}
		} else {
			if (es.before(stime)) {
				signin.setFlag("正常");
			} else if (stime.before(es)) {
				signin.setFlag("早退");
			}
		}
		signinService.addSignin(signin);
		bean.setCode(0);
		bean.setMsg("");
		return bean;
	}
	
	@RequestMapping(value = "signinlist", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> signinlist(HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		String uname = (String) session.getAttribute("name");
		List<PresonSignin> pl = null;
		try {
			pl = signinService.findPresonSignin(uname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", pl);
		return map;
	}	
}
