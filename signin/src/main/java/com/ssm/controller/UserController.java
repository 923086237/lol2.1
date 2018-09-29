package com.ssm.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.entity.User;
import com.ssm.service.IUserService;
import com.ssm.vo.JsonBean;

@Controller
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="adduser", method=RequestMethod.POST)
	@ResponseBody
	public JsonBean addUser(User user) {
		JsonBean bean = new JsonBean();
		String result = new Md5Hash(user.getPassword(),user.getName(),1).toString();
		user.setPassword(result);
		try {
			User old = userService.findByName(user.getName());
			if (old != null) {
				throw new RuntimeException("用户名已存在！");
			}
			userService.addUser(user);
			bean.setCode(0);
			bean.setMsg("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(1);
			bean.setMsg(e.getMessage());
		}
		return bean;
	}
	
	@RequestMapping(value="userlogin", method=RequestMethod.POST)
	@ResponseBody
	public JsonBean userLogin(User user, HttpSession session) {
		JsonBean bean = new JsonBean();
		try {
			if (session.getAttribute("name").equals(user.getName())) {
				bean.setCode(1);
				bean.setMsg("当前用户已登录！");
				return bean;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		User old = userService.findByName(user.getName());
		if (old.getFlag() == 2) {
			bean.setCode(2);
			bean.setMsg("当前用户已冻结！");
			return bean;
		}
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			session.setAttribute("name", user.getName());
			bean.setCode(0);
			bean.setMsg("");
		} catch (IncorrectCredentialsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(1);
			bean.setMsg("密码错误！");
		} catch (UnknownAccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(1);
			bean.setMsg(e.getMessage());
		}
		return bean;
	}
	
	@RequestMapping(value="forgetp", method=RequestMethod.POST)
	@ResponseBody
	public JsonBean forget(User user) {
		JsonBean bean = new JsonBean();
		try {
			User old = userService.findByName(user.getName());
			if (old == null) {
				throw new RuntimeException("用户不存在！");
			}
			if (old.getIssue() != user.getIssue() || !old.getAnswer().equals(user.getAnswer())) {
				throw new RuntimeException("验证信息错误！");
			}
			bean.setCode(0);
			bean.setMsg("验证成功！您的密码为: " + old.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(1);
			bean.setMsg(e.getMessage());
		}
		return bean;
	}
	
	@RequestMapping(value="verifyd", method=RequestMethod.POST)
	@ResponseBody
	public JsonBean verify(User user) {
		JsonBean bean = new JsonBean();
		try {
			User old = userService.findByName(user.getName());
			if (old == null) {
				throw new RuntimeException("用户不存在！");
			}
			if (old.getIssue() != user.getIssue() || !old.getAnswer().equals(user.getAnswer())) {
				throw new RuntimeException("验证信息错误！");
			}
			old.setFlag(1);
			userService.updateUser(old);
			bean.setCode(0);
			bean.setMsg("验证成功,已解除冻结状态!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(1);
			bean.setMsg(e.getMessage());
		}
		return bean;
	}
}
