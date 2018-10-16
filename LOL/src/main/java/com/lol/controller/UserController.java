package com.lol.controller;

import com.lol.domain.JsonBean;
import com.lol.domain.User;
import com.lol.service.MUserService;
import com.lol.utils.JsonBeanUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private MUserService userService;

    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    @ResponseBody
    public JsonBean addUser(User user){
        Md5Hash md5 = new Md5Hash(user.getPwd(),user.getNo(),1);
        user.setPwd(md5.toString());
        try {
            userService.addUser(user);
            return JsonBeanUtil.w(200,"注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonBeanUtil.w(0,"注册失败");
        }
    }

    @RequestMapping(value = "loginUser", method = RequestMethod.POST)
    @ResponseBody
    public JsonBean loginUser(String no, String pwd, HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken(no,pwd);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            session.setAttribute("no",no);
            return JsonBeanUtil.w(200,null);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return JsonBeanUtil.w(0,"登录失败");
        }

    }

}
