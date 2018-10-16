package com.lol.manager;

import com.lol.dao.UserMapper;
import com.lol.domain.User;
import com.lol.service.MUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements MUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByNo(String no) {
        User user = null;
        try {
            user = userMapper.findUserByNo(no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        if ( userMapper.findUserByNo(user.getNo()) != null) {
            throw new RuntimeException("账户已存在，请更换");
        }else{
            try {
                userMapper.addUser(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
